package dev.koo.fun;

import com.fathzer.soft.javaluator.DoubleEvaluator;
import dev.koo.Luffy;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public class CalculateCmd implements MessageCreateListener {
    @Override
    public void onMessageCreate(MessageCreateEvent event) {

        String[] message = event.getMessageContent().split(" ");

        if(!message[0].equalsIgnoreCase(Luffy.getPrefix(event.getServer().get()) + "calculate")) { return; }

        String calc_part = event.getMessageContent().replaceAll(Luffy.getPrefix(event.getServer().get()) + "calculate", "").replaceAll(" ", "");

        event.getChannel().sendMessage(String.valueOf(new DoubleEvaluator().evaluate(calc_part)));

    }
}
