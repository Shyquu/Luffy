package dev.koo.servers;

import dev.koo.Luffy;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.entity.server.Server;
import org.javacord.api.event.interaction.SlashCommandCreateEvent;
import org.javacord.api.interaction.SlashCommandInteractionOption;
import org.javacord.api.listener.interaction.SlashCommandCreateListener;

import java.awt.*;

public class PrefixSlash implements SlashCommandCreateListener {

    @Override
    public void onSlashCommandCreate(SlashCommandCreateEvent event) {

        if(event.getSlashCommandInteraction().getCommandIdAsString().equalsIgnoreCase("1004467904055623851")) {

            Server server = event.getSlashCommandInteraction().getServer().get();
            String old_prefix = Luffy.getPrefix(server);

            String value = event.getSlashCommandInteraction()
                    .getOptionByName("prefix").get()
                    .getStringValue().get()
                    .replace("Optional[", "")
                    .replace("]", "");

            event.getSlashCommandInteraction().createImmediateResponder()
                    .addEmbed(new EmbedBuilder()
                            .addField("Updated prefix successfully", "``" + old_prefix + "`` → ``" + value + "``")
                            .setColor(Color.GREEN)
                            .setTimestampToNow())
                    .respond();

            new PrefixUtil(server).updatePrefix(value);
        }

    }
}
