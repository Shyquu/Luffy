package dev.koo.utils;

import dev.koo.Luffy;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Shyqu
 * @created 27/07/2021 - 16:20
 * @project 1vs1
 */

public class MySQL {
    public static Connection connect() {
        final Connection connection;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/database", "user", "test");
        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
        return connection;
    }

    public static void setup() {
        try {
            Luffy.getConnection().createStatement().execute(
                    ("CREATE TABLE IF NOT EXISTS servers(ID INTEGER primary key AUTO_INCREMENT, server_id text not null, prefix text not null, premium_status text not null)"));
            Luffy.getConnection().createStatement().execute(
                    ("CREATE TABLE IF NOT EXISTS items(ID INTEGER primary key AUTO_INCREMENT, item_id text not null, item json not null)"));
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

}
