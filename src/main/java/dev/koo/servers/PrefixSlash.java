package dev.koo.servers;

import org.javacord.api.event.interaction.SlashCommandCreateEvent;
import org.javacord.api.interaction.SlashCommandInteractionOption;
import org.javacord.api.listener.interaction.SlashCommandCreateListener;

public class PrefixSlash implements SlashCommandCreateListener {

    @Override
    public void onSlashCommandCreate(SlashCommandCreateEvent event) {

        if(event.getSlashCommandInteraction().getCommandIdAsString().equalsIgnoreCase("964676968282980423")) {
            event.getSlashCommandInteraction().createImmediateResponder()
                    .setContent("Prefix updated to: " + event.getSlashCommandInteraction()
                            .getOptionByName("prefix").get().getStringValue().get().replace("Optional[", "").replace("]", ""))
                    .respond();
        }

    }
}
