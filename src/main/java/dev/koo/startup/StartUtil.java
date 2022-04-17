package dev.koo.startup;

import dev.koo.servers.PrefixUtil;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.activity.ActivityType;
import org.javacord.api.entity.intent.Intent;
import org.javacord.api.entity.permission.Permissions;
import org.javacord.api.entity.server.Server;
import org.javacord.api.interaction.SlashCommand;
import org.javacord.api.interaction.SlashCommandBuilder;
import org.javacord.api.interaction.SlashCommandOption;
import org.javacord.api.interaction.SlashCommandOptionType;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @author Shyqu
 * @created 26/03/2022 - 14:48
 * @project Luffy
 */
public class StartUtil {

    static DiscordApi api;
    static List<SlashCommand> commands;
    private static HashMap<String, String> map = new HashMap<String, String>();
    public static void startBot() throws IOException {

        api = new DiscordApiBuilder().setToken(getToken()).login().join();
        api.updateActivity(ActivityType.LISTENING, api.getServers().size() + " Servers");

        //Test server
        Server server = api.getServerById("957281986878251028").get();

        // Slash Commands

        // SlashCommand cmd = SlashCommand.with("prefix", "set prefix for your server", List.of(SlashCommandOption.create(SlashCommandOptionType.STRING, "prefix", "new prefix", true))).createForServer(server).join();


        commands = api.getServerSlashCommands(server).join();

        StringBuilder builder = new StringBuilder();
        builder.append("--------Command-List--------\n");
        for (SlashCommand command : commands) {
            builder.append(command.getName()).append(" - ").append(command.getIdAsString()).append("\n");
        }
        builder.append("----------------------------");

        System.out.println(builder.toString());

        System.out.println("https://discord.com/api/oauth2/authorize?client_id=957281336735989820&permissions=8&scope=bot%20applications.commands");
        Register.register(api);

        // hash prefixes

        for (Server selectedServer : api.getServers()) {
            map.put(selectedServer.getIdAsString(), new PrefixUtil(selectedServer).getPrefix());
        }

    }

    public static void stopBot() {
        api.disconnect();
    }

    private static String getToken() throws IOException {
        return new BufferedReader(new FileReader(new File("secret.txt"))).readLine().replace(":luffy:A:", "");
    }

    public static DiscordApi getApi() {
        return api;
    }

    public static List<SlashCommand> getCommands() {
        return commands;
    }

    public static HashMap<String, String> getMap() {
        return map;
    }
}
