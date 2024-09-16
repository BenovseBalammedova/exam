package service;

import entity.User;

import java.util.List;

public interface UserService {

    List<User> getAllAdres(String Adres);
    List<User>getAllPhoneNumber(String phoneNumber);
    List<User>getAllRegistrationdate(int registrationdate);
    void UpdateAdress(int id,String address);
    void UpdatePhoneNumber(int id,String phoneNumber);
    void UpdateRegistrationdate(int id,int registrationdate);
    void UpdateParol(int id,String parol);



}
