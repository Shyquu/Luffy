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

    public void setId(long id) {
        this.id = id;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Item build() {
        return new Item(id, name, image_url, price, description);
    }

}
