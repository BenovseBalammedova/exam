package service;

import entity.Announcement;

import java.util.List;

public interface AnnouncementService {
    List<Announcement>getAllUserId(int UserId);
    List<Announcement>getAllDescription(String Description);
    List<Announcement>getAllPrice(int Price);
    List<Announcement>getAllTitle(String title);
    void UpdateTitle(int id,String title);
    void UpdateDescription(int id,String description);
    void UpdatePrice(int id,int Price);
    void UpdateUserId(int id,int UserId);


}
