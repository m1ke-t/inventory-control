package com.mititch.inventoryctrl.dao.repository;

import com.mititch.inventoryctrl.model.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

@Service("UserRepository")
public interface UserRepository extends PagingAndSortingRepository<User, Long>, JpaSpecificationExecutor {

    User findTopByLogin(String login);

}
