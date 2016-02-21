package com.dukal.database;

/**
 * Created by dukal on 21.02.2016.
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Shops {
    DBEditor editor = new DBEditor();

    void setNewProduct(String title, int price, int status_id, int category_id) { // метод добавления нового продукта

        try {
            Statement statement = editor.getConnection().createStatement();
            statement.execute("INSERT INTO products (title, price, status_id,category_id) VALUES ('" + title + "'," + price + "," + status_id + "," + category_id + ");");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void setProductPrice(int product_id, int price) {   // метод назначения цены продукта

        try {
            Statement statement = editor.getConnection().createStatement();
            statement.executeUpdate("update products  set price = " + price + " where product_id =" + product_id + ";");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    void setProductStatus(int status_id, int product_id) { // метод назначения статуса продукта

        try {
            Statement statement = editor.getConnection().createStatement();
            statement.executeUpdate("update products  set status_id = " + status_id + " where product_id =" + product_id + ";");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    float getProductPrice(String product_name) {  // метод получения цены товара
        String query = "select price from products where title = '" + product_name + "';";
        float price = 0;
        try {
            Statement statement = editor.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                price = resultSet.getFloat("price");
                System.out.println(price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return price;
    }

    void incrementAvailableProductPrice() { // метод увеличения цены доступных товаров на 20 %
        try {
            Statement statement = editor.getConnection().createStatement();
            statement.executeUpdate("update products set price = price+price*0.2 where status_id = 1;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void changeStatusOfSomeoneCategory(int category_id) {// данный метод выполняет изменение статуса всех товаров одной категории на 2(absent), остальные товары делит  пополам по количеству и одной  половинe изменяет статус на 3(expected)
        String query = "select * from products;";
        try {
            Statement statement = editor.getConnection().createStatement();
            statement.executeUpdate("update products  set status_id = 2 where category_id =" + category_id + ";");
            statement.executeUpdate("update products set status_id = 3 where product_id in (SELECT product_id " +
                    " FROM ( " +
                    " SELECT products.*, @counter := @counter +1 AS counter " +
                    " FROM (select @counter:=0) AS initvar, products where category_id <> " + category_id +
                    " ) AS X " +
                    " where counter <= (50/100 * @counter)); ");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
