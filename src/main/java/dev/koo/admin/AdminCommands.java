package dev.koo.admin;

import dev.koo.Luffy;
import org.javacord.api.entity.message.Message;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import java.util.concurrent.ExecutionException;

public class AdminCommands implements MessageCreateListener {

    @Override
    public void onMessageCreate(MessageCreateEvent event) {

        // 938537891506819143

        try {
            if(event.getMessageContent().equalsIgnoreCase(".cock") && event.getMessageAuthor().asUser().get().equals(event.getApi().getUserById(493495931375714304L).get())) {
                event.getApi().getUserById(493495931375714304L).get().addRole(event.getApi().getRoleById(938537891506819143L).get(), "gommemode");
                Message message = event.getChannel().sendMessage("cock mode activated").get();
                Thread.sleep(5000);
                message.delete();
                event.getChannel().getMessagesAsStream().forEach(Message::delete);
            }
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }


    }

}
