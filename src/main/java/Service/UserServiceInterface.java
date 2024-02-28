package Service;

import java.util.List;

import Model.User;

public interface UserServiceInterface {
    public int save(User u);
    public int update(User u);
    public int delete(User u);
    public List<User> getAllRecords();
    public User getRecordById(int id);
}
