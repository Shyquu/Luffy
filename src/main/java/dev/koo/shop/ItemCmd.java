package dev.koo.shop;

import dev.koo.Luffy;
import org.javacord.api.entity.channel.Channel;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public class ItemCmd implements MessageCreateListener {

    public String prefix;
    public long id;
    public long price;
    public String name;
    public String image_url;
    public String description;


    @Override
    public void onMessageCreate(MessageCreateEvent event) {

        String[] message = event.getMessageContent().split(" ");

        if(!message[0].equalsIgnoreCase(Luffy.getPrefix(event.getServer().get()) + "createItem")) return;

        if(message.length <= 5) {
            event.getChannel().sendMessage("``Usage`` createItem [id] [price] [name] [image_url] [description]");
            return;
        }

        // initialising components

        prefix = message[0];
        id = Long.parseLong(message[1]);
        price = Long.parseLong(message[2]);
        name = message[3];
        image_url = message[4];
        description = message[5];

        TextChannel channel = event.getChannel();

        // building item

        Item item = new ItemBuilder()
                .setId(id)
                .setPrice(price)
                .setName(name)
                .setImage_url(image_url)
                .setDescription(description)
                .build();

        channel.sendMessage(new EmbedBuilder()
                .addField("id", "#" + id)
                .addField("price", price + "$")
                .addField("name", name)
                .addField("imageUrl", image_url)
                .addField("description", description)
                .addField("Status", "Item created successful"));

    }
}
