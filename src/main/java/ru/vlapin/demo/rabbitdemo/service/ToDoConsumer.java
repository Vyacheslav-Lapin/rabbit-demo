package ru.vlapin.demo.rabbitdemo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import ru.vlapin.demo.rabbitdemo.dao.ToDoRepository;
import ru.vlapin.demo.rabbitdemo.model.ToDo;

@Slf4j
@Component
@RequiredArgsConstructor
public class ToDoConsumer {

  ToDoRepository toDoRepository;

  @RabbitListener(queues = "${todo.amqp.queue}")
  public void processToDo(ToDo todo) {
    log.info("Consumer> {}", todo);
    log.info("ToDo created> {}", toDoRepository.save(todo));
  }
}
