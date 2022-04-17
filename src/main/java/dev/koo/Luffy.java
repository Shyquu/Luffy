package dev.koo;

import dev.koo.startup.StartUtil;
import dev.koo.utils.MySQL;
import org.javacord.api.entity.server.Server;
import org.javacord.api.interaction.SlashCommand;

import java.io.*;
import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

/**
 * @author Shyqu
 * @created 26/03/2022 - 14:46
 * @project Luffy
 */

public class Luffy {

    static Connection connection;

    public static void main(String[] args) throws IOException {
        StartUtil.startBot();
        connection = MySQL.connect();
        MySQL.setup();
        consoleMan();
    }

    private static void consoleMan() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Available commands: stop");
        String input = scanner.nextLine();
        while (!input.equalsIgnoreCase("stop")) {
            System.out.println("Command not found: " + input);
            input = scanner.nextLine();
        }
        if (input.equalsIgnoreCase("stop")) {
            StartUtil.stopBot();
        }

    }

    public static Connection getConnection() {
        return connection;
    }
}
