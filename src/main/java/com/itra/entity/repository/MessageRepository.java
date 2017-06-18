package com.itra.entity.repository;

import com.itra.entity.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> getAllByProject(long id_project);
}
