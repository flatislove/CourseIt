package com.itra.entity.repository;

import com.itra.entity.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import javax.transaction.Transactional;

@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select b from User b where b.nickname = :nickname")
    User findByNickname(@Param("nickname") String name);
}