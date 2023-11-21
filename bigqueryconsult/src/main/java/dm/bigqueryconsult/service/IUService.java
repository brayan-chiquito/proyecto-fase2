package dm.bigqueryconsult.service;



import dm.bigqueryconsult.model.User;

import java.util.List;

public interface IUService {
    public List<User> findAll();
    public User findById(Integer id);
    public User save(User user);
    public void deleteById(Integer id);
}
