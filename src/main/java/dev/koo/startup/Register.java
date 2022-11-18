package dev.koo.startup;

import dev.koo.admin.AdminCommands;
import dev.koo.fun.CalculateCmd;
import dev.koo.servers.JoinListener;
import dev.koo.servers.PrefixSlash;
import dev.koo.shop.ItemCmd;
import org.javacord.api.DiscordApi;

/**
 * @author Shyqu
 * @created 26/03/2022 - 15:44
 * @project Luffy
 */
public class Register {

    public static void register(DiscordApi api)  {

        api.addListener(new JoinListener());
        api.addListener(new PrefixSlash());
        api.addListener(new ItemCmd());
        api.addListener(new AdminCommands());
        api.addListener(new CalculateCmd());

    }

}
