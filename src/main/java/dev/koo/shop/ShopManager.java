package dev.koo.shop;

import org.javacord.api.entity.message.embed.EmbedBuilder;

import javax.crypto.ExemptionMechanismException;
import java.util.Date;

public class ShopManager {

    public EmbedBuilder getShop() {



        return new EmbedBuilder()
                .setTitle("Shop");
    }

}
