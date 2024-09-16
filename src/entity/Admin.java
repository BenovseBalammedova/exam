package entity;

import model.Position;

public class Admin {
    private int id;
    private String fullName;
    private String email;
    private Position position;

    public Admin() {
    }

    public Admin(int id, String fullName, String email,Position position) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.position=position;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", position=" + position +
                '}';
    }
}
