package serviceImpl;

import entity.User;
import exception.UserIllegalArgument;
import exception.UserNotFoundException;
import exception.UserSystemProblem;
import model.Position;
import service.CommonService;
import service.UserService;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements CommonService<User>,UserService {
    static ArrayList<User>userArrayList = new ArrayList<>();
    static {
        userArrayList.add(new User(1, "Bənövşə Məmmədova", "benovse@example.com", Position.PUBLISHED ,"12345", 20220101, "+994501234567", "Bakı, Azərbaycan"));
        userArrayList.add(new User(2, "Anar Əliyev", "anar@example.com",Position.ADMIN ,"parol123", 20220315, "+994552345678", "Gəncə, Azərbaycan"));
        userArrayList.add(new User(3, "Zəhra Həsənova", "zehra@example.com",Position.STANDARD ,"pass456", 20220612, "+994701111222", "Sumqayıt, Azərbaycan"));
        userArrayList.add(new User(4, "Elnur Quliyev", "elnur@example.com",Position.ADMIN, "abc123", 20220923, "+994777654321", "Şəki, Azərbaycan"));
    }

    @Override
    public void add(User object) {
        try{
            userArrayList.add(object);
        }
        catch (UserIllegalArgument ex){
            ex.printStackTrace();
            throw new UserIllegalArgument("siz illgal bir seyler daxil edirsiz");
        }

    }

    @Override
    public void update(int id, String fullname) {
        try{
            User user=userArrayList.get(id-1);
            user.setFullName(fullname);
            userArrayList.add(user);
        }
        catch (UserNotFoundException ex){
            ex.printStackTrace();
            throw new UserNotFoundException("id tapilmadi");
        }


    }

    @Override
    public User getById(int id) {
        try{
            return userArrayList.get(id-1);
        }
        catch (UserNotFoundException ex){
            ex.printStackTrace();
            throw new UserNotFoundException("id tapilmadi");
        }

    }

    @Override
    public List<User> getAll() {
        try {
            return userArrayList;
        }
        catch (UserSystemProblem ex){
            ex.printStackTrace();
            throw new UserSystemProblem("uzurlu sayin sistemizde problem yasandi");
        }
    }

    @Override
    public void delete(int id) {
        try {
            userArrayList.remove(id-1);
        }
        catch (UserNotFoundException ex){
            ex.printStackTrace();
            throw new UserNotFoundException("id tapilmadi");
        }

    }

    @Override
    public List<User> getAllAdres(String Adres) {
        try {
            return userArrayList.stream().filter(user -> user.getAddress().equals(Adres)).toList();
        }
        catch (UserSystemProblem ex){
            ex.printStackTrace();
            throw new UserSystemProblem("uzurlu sayin sistemizde problem yasandi");
        }
    }

    @Override
    public List<User> getAllPhoneNumber(String phoneNumber) {
        try {
            return userArrayList.stream().filter(user -> user.getPhoneNumber().equals(phoneNumber)).toList();
        }
        catch (UserSystemProblem ex){
            ex.printStackTrace();
            throw new UserSystemProblem("uzurlu sayin sistemizde problem yasandi");
        }
    }

    @Override
    public List<User> getAllRegistrationdate(int registrationdate) {
        try {
            return userArrayList.stream().map(user -> new User(user.getId(), user.getFullName(), user.getEmail(),Position.ADMIN ,user.getParol(), user.getRegistrationdate(), user.getPhoneNumber(), user.getAddress()))
                    .filter(user -> user.getRegistrationdate() == registrationdate).toList();
        }
        catch (UserSystemProblem ex){
            ex.printStackTrace();
            throw new UserSystemProblem("uzurlu sayin sistemizde problem yasandi");
        }
        }

    @Override
    public void UpdateAdress(int id, String address) {
        try{
     User user=userArrayList.get(id-1);
     user.setAddress(address);
     userArrayList.add(user);}
        catch (UserNotFoundException ex){
            ex.printStackTrace();
            throw new UserNotFoundException("id tapilmadi");
        }
    }

    @Override
    public void UpdatePhoneNumber(int id, String phoneNumber) {
        try {
            User user = userArrayList.get(id - 1);
            user.setPhoneNumber(phoneNumber);
            userArrayList.add(user);
        }
        catch (UserNotFoundException ex){
            ex.printStackTrace();
            throw new UserNotFoundException("id tapilmadi");
        }
    }

    @Override
    public void UpdateRegistrationdate(int id, int registrationdate) {
        try {
            User user = userArrayList.get(id - 1);
            user.setRegistrationdate(registrationdate);
            userArrayList.add(user);
        }
        catch (UserNotFoundException ex){
            ex.printStackTrace();
            throw new UserNotFoundException("id tapilmadi");
        }
    }

    @Override
    public void UpdateParol(int id, String parol) {
        try {
            User user = userArrayList.get(id - 1);
            user.setParol(parol);
            userArrayList.add(user);
        }
        catch (UserNotFoundException ex){
            ex.printStackTrace();
            throw new UserNotFoundException("id tapilmadi");
        }
    }
}
