package serviceImpl;

import entity.Announcement;
import exception.AnnouncemenSystemProblem;
import exception.AnnouncementIllegalArgument;
import exception.AnnouncementNotFoundException;
import model.Position;
import service.AnnouncementService;
import service.CommonService;

import java.util.ArrayList;

import java.util.List;

public class AnnouncementServiceImpl implements CommonService<Announcement>, AnnouncementService {
    static ArrayList<Announcement> announcementlist = new ArrayList<>();

    static {
        announcementlist.add(new Announcement(1, "John Doe", "johndoe@example.com", Position.ARCHIVED, 101, "Used car in good condition", 15000, "Car for Sale"));
        announcementlist.add(new Announcement(2, "Jane Doe", "janedoe@example.com",Position.DRAFT ,102, "Brand new laptop for sale", 800, "Laptop for Sale"));
        announcementlist.add(new Announcement(3, "Jim Beam", "jimbeam@example.com",Position.PUBLISHED,103, "Offering freelance graphic design services", 300, "Freelance Graphic Designer"));
        announcementlist.add(new Announcement(4, "Julia Banks", "juliabanks@example.com",Position.PREMIUM ,104, "Looking for a roommate", 0, "Roommate Needed"));
    }

    @Override
    public List<Announcement> getAllUserId(int UserId) {
        try {
            return announcementlist.stream().map(announcement -> new Announcement(announcement.getUserId(), announcement.getFullName(), announcement.getEmail(), Position.DRAFT,announcement.getId(), announcement.getDescription(), announcement.getPrice(), announcement.getTitle()))
                    .filter(announcement -> announcement.getUserId() == UserId).toList();
        }
        catch (AnnouncementNotFoundException ex){
            ex.printStackTrace();
            throw new AnnouncementNotFoundException("bele bir userid yoxdur");
        }




    }

    @Override
    public List<Announcement> getAllDescription(String Description) {
        try{
            return announcementlist.stream().filter(announcement ->announcement.getDescription().equals(Description)).toList();
        }

        catch (AnnouncemenSystemProblem ex){
            ex.printStackTrace();
            throw new AnnouncemenSystemProblem("uzurlu sayin sistemle bagli problem yasandi");
        }
    }

    @Override
    public List<Announcement> getAllPrice(int Price) {
        try {


            return announcementlist.stream().map(announcement -> new Announcement(announcement.getUserId(), announcement.getFullName(), announcement.getEmail(), Position.ARCHIVED,announcement.getId(), announcement.getDescription(), announcement.getPrice(), announcement.getTitle()))
                    .filter(announcement -> announcement.getPrice() == Price).toList();
        }
        catch (AnnouncemenSystemProblem ex) {
            ex.printStackTrace();
            throw new AnnouncemenSystemProblem("uzurlu sayin sistemle bagli problem yasandi");


        }
    }

    @Override
    public List<Announcement> getAllTitle(String title) {
        try {


            return announcementlist.stream().filter(announcement -> announcement.getTitle().equals(title)).toList();
        } catch (AnnouncemenSystemProblem ex) {
            ex.printStackTrace();
            throw new AnnouncemenSystemProblem("uzurlu sayin sistemle bagli problem yasandi");
        }
    }
    @Override
    public void UpdateTitle(int id, String title) {
        try{
            Announcement announcement=announcementlist.get(id-1);
            announcement.setTitle(title);
            announcementlist.add(announcement);
        }
        catch (AnnouncementNotFoundException ex){
            ex.printStackTrace();
            throw new AnnouncementNotFoundException("id tapilmadi");
        }

    }

    @Override
    public void UpdateDescription(int id, String description) {
        try{
            Announcement announcement=announcementlist.get(id-1);
            announcement.setDescription(description);
            announcementlist.add(announcement);
        }
        catch (AnnouncementNotFoundException ex){
            ex.printStackTrace();
            throw new AnnouncementNotFoundException("id tapilmadi");
        }


    }

    @Override
    public void UpdatePrice(int id, int Price) {
        try{
            Announcement announcement=announcementlist.get(id-1);
            announcement.setPrice(Price);
            announcementlist.add(announcement);
        }
        catch (AnnouncementNotFoundException ex){
            ex.printStackTrace();
            throw new AnnouncementNotFoundException("bele bir id yoxdu");
        }



    }

    @Override
    public void UpdateUserId(int id, int UserId) {
        try {
            Announcement announcement=announcementlist.get(id-1);
            announcement.setUserId(UserId);
            announcementlist.add(announcement);
        }
        catch (AnnouncementNotFoundException ex){
            ex.printStackTrace();
            throw  new AnnouncementNotFoundException("bele bir id tapilmadi");
        }

    }

    @Override
    public void add(Announcement object) {
        try {
            announcementlist.add(object);
        }
        catch(AnnouncementIllegalArgument ex){
            ex.printStackTrace();
            throw new AnnouncementIllegalArgument("Verilenleri duzgun daxil edin illegal bir sey daxil etmeyin");
        }
        finally {
            System.out.println(" ");
        }



    }

    @Override
    public void update(int id, String fullname) {
        try {
            Announcement announcement=announcementlist.get(id-1);
            announcement.setFullName(fullname);
            announcementlist.add(announcement);
        }
        catch (AnnouncementNotFoundException ex){
            ex.printStackTrace();
            throw new AnnouncementNotFoundException("id duzgun daxil ediniz");
        }
        finally {
            System.out.println(" ");
        }

    }


    @Override
    public Announcement getById(int id) {
        try {
            return announcementlist.get(id-1);

        }

        catch (AnnouncementNotFoundException ex){
            ex.printStackTrace();
            throw new AnnouncementNotFoundException("bele bir elan yoxdur ");
        }
        finally {
            System.out.println(" ");
        }

    }

    @Override
    public List<Announcement> getAll() {
        try {
            return announcementlist;
        } catch (AnnouncemenSystemProblem ex) {
            ex.printStackTrace();
            throw new AnnouncemenSystemProblem("uzurlu sayin sistemle bagli problem yasandi");
        }
    }


    @Override

    public void delete(int id) {
        try {
            announcementlist.remove(id-1);
        }
        catch (AnnouncementNotFoundException ex){
            ex.printStackTrace();
            throw new AnnouncementNotFoundException("bele bir id li elan yoxdur");
        }
        finally {
            System.out.println(" ");
        }

    }
}
