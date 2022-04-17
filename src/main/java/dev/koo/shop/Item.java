package dev.koo.shop;

public class Item {

    long id;
    long price;
    String name;
    String image_url;
    String description;

    public Item(long id, String name, String image_url, long price, String description) {
        this.id = id;
        this.name = name;
        this.image_url = image_url;
        this.price = price;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public long getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getImage_url() {
        return image_url;
    }

    public String getDescription() {
        return description;
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
}
