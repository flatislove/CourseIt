package com.itra.database.dao;


import com.itra.database.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

//    /**
//     * Return the user having the passed email or null if no user is found.
//     *
//     * @param email the user email.
//     */
   // public User findByEmail(String email);
    //@Override
    public ArrayList<User> findAll();
    public User findOneByName(String name);
    public User getByAccountNonExpiredBetweenAndAccountNonExpiredContainsAndNameAndAccountNonExpiredIsFalseAndEmail();

}
