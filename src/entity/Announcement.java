package entity;

import model.Position;

public class Announcement extends Admin{

    private int userId;
    private String description;
    private int price;
    private String title;


    public Announcement() {
    }

    public Announcement(int id, String fullName, String email, Position position, int userId, String description, int price, String title) {
        super(id, fullName, email,position);
        this.userId = userId;
        this.description = description;
        this.price = price;
        this.title = title;

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Announcement{" +
                "userId=" + userId +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", title='" + title + '\'' +
                "} " + super.toString();
    }
}
