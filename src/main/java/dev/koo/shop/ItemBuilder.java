package dev.koo.shop;

public class ItemBuilder {

    long id;
    long price;
    String name;
    String image_url;
    String description;

    public ItemBuilder(long id, long price, String name, String image_url, String description) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.image_url = image_url;
        this.description = description;
    }

    public ItemBuilder() {

    }

    public ItemBuilder setId(long id) {
        this.id = id;
        return this;
    }

    public ItemBuilder setPrice(long price) {
        this.price = price;
        return this;
    }

    public ItemBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ItemBuilder setImage_url(String image_url) {
        this.image_url = image_url;
        return this;
    }

    public ItemBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public Item build() {
        return new Item(id, name, image_url, price, description);
    }

}
