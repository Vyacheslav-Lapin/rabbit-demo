package ru.vlapin.demo.rabbitdemo.dao;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.vlapin.demo.rabbitdemo.model.ToDo;

public interface ToDoRepository extends JpaRepository<ToDo, UUID> {
}
