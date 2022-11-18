package dev.koo.shop;

import dev.koo.Luffy;
import dev.koo.utils.MySQLForItems;
import org.javacord.api.entity.message.embed.Embed;
import org.javacord.api.entity.message.embed.EmbedBuilder;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemUtil {

    public static void addItemToDatabase(Item item) {

    }

    public static Item getItemFromDatabase(long id) {
        return new Item(0, "", "", 0, "");
    }

    public static List<Item> getItems() {
        return new ArrayList<>();
    }

    public static EmbedBuilder parseItemToEmbedBuilder(Item item) {
        return new EmbedBuilder()
                .setTitle(item.getName())
                .setDescription(item.getDescription())
                .setImage(item.getImage_url())
                .addField("Price", String.valueOf(item.getPrice()))
                .setFooter("ID - " + item.getId());
    }

}
