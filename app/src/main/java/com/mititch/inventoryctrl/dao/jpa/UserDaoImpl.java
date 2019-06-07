package com.mititch.inventoryctrl.dao.jpa;

import com.mititch.inventoryctrl.dao.repository.UserRepository;
import com.mititch.inventoryctrl.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository("UserDaoImpl")
public class UserDaoImpl extends AbstractDao<User, Long> implements UserDao {

    @Autowired
    @Qualifier("UserRepository")
    private UserRepository userRepository;

    @Override
    public Class<User> getEntityClass() {
        return User.class;
    }


    @Override
    public User save(User entity) {
        return userRepository.save(entity);
    }

    @Override
    public User findUser(String login) {
        return userRepository.findTopByLogin(login);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
