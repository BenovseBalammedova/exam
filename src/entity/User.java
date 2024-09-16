package entity;

import model.Position;

public class User extends Admin {
private String parol;
private int registrationdate;
private String phoneNumber;
private String address;

    public User() {
    }

    public User(int id, String fullName, String email, Position position, String parol, int registrationdate, String phoneNumber, String address) {
        super(id, fullName, email,position);
        this.parol = parol;
        this.registrationdate = registrationdate;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getParol() {
        return parol;
    }

    public void setParol(String parol) {
        this.parol = parol;
    }

    public int getRegistrationdate() {
        return registrationdate;
    }

    public void setRegistrationdate(int registrationdate) {
        this.registrationdate = registrationdate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "parol='" + parol + '\'' +
                ", registrationdate=" + registrationdate +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                "} " + super.toString();
    }
}
