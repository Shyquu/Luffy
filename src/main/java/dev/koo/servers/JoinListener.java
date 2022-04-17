package dev.koo.servers;

import dev.koo.Luffy;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.server.ServerJoinEvent;
import org.javacord.api.listener.server.ServerJoinListener;

/**
 * @author Shyqu
 * @created 26/03/2022 - 15:43
 * @project Luffy
 */
public class JoinListener implements ServerJoinListener {

    @Override
    public void onServerJoin(ServerJoinEvent event) {
        if(event.getServer().getSystemChannel().isPresent()) {
            event.getServer().getSystemChannel().get().sendMessage(joinMessage());
        } else event.getServer().getTextChannels().get(0).sendMessage(joinMessage());

        if(!Luffy.getMap().containsKey(event.getServer().getIdAsString())) { new PrefixUtil(event.getServer()).newServer(); }

    }

    public EmbedBuilder joinMessage() {
        return new EmbedBuilder()
                .setTitle("Thanks for inviting me!")
                .setDescription("I'm a multi-purpose discord bot with many functionalities to make your server a wonderful place to be in.")
                .addField("Try me out!", "Use: L!help")
                .addField("You can also change my prefix.", "Use: L!prefix ``prefix``")
                .setFooter("Made by Shanks")
                .setAuthor("Shanks", "https://onepiece.fandom.com/de/wiki/Shanks", "https://pbs.twimg.com/profile_images/1366432244970086400/Th6Riair_400x400.jpg")
                .setImage("https://i.imgur.com/vFQ78jH.png");
    }

}
