package dev.koo;

import dev.koo.servers.PrefixUtil;
import dev.koo.startup.StartUtil;
import dev.koo.utils.Messages;
import dev.koo.utils.MySQL;
import org.javacord.api.entity.server.Server;
import org.javacord.api.interaction.SlashCommand;

import java.io.*;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * @author Shyqu
 * @created 26/03/2022 - 14:46
 * @project Luffy
 */

public class Luffy {

    private static Connection connection;
    private static HashMap<String, String> map;

    public static void main(String[] args) throws IOException {
        connection = MySQL.connect();
        StartUtil.startBot();
        map = StartUtil.getMap();
        MySQL.deleteDatabse("items");
        //MySQL.setup();
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

    public static HashMap<String, String> getMap() {
        return map;
    }

    public static void updateMap(String id, String newPrefix) {
        if(map.containsKey(id)) { map.remove(id); }
        map.put(id, newPrefix);
    }

    public static String getPrefix(Server server) {
        return new PrefixUtil(server).getPrefix();
    }

    public static String getPrefix(String server_id) {
        if(StartUtil.getApi().getServerById(server_id).isEmpty()) return Messages.DEFAULT_PREFIX;
        return new PrefixUtil(StartUtil.getApi().getServerById(server_id).get()).getPrefix();
    }

}
