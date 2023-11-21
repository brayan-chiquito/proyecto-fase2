package dm.bigqueryconsult.service;


import dm.bigqueryconsult.model.User;
import dm.bigqueryconsult.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public User findById(Integer id) {
        return null;
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }
}
