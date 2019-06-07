package com.mititch.inventoryctrl.dao.jpa;


import com.mititch.inventoryctrl.model.User;

public interface UserDao extends Dao<User, Long> {

    User findUser(String login);

    void deleteById(Long id);
}
