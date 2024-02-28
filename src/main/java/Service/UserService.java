package Service;

import java.util.List;

import Model.User;
import Repository.UserDao;

public class UserService implements UserServiceInterface {
    @Override
    public int save(User u) {
        return UserDao.save(u);
    }

    @Override
    public int update(User u) {
        return UserDao.update(u);
    }

    @Override
    public int delete(User u) {
       return UserDao.delete(u);

    }

    @Override
    public List<User> getAllRecords() {
        return UserDao.getAllRecords();
    }

    @Override
    public User getRecordById(int id) {
        return UserDao.getRecordById(id);
    }
    
}
