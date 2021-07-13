package ru.vlapin.demo.rabbitdemo.service;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.scheduling.annotation.Scheduled;
import ru.vlapin.demo.rabbitdemo.model.ToDo;

public interface ToDoProducer {
  void sendTo(String queue, ToDo toDo);
}

@Slf4j
@Setter
@RequiredArgsConstructor
@ConfigurationProperties("todo.amqp")
class ToDoProducerImpl implements ToDoProducer {

  RabbitTemplate rabbitTemplate;

  @NonFinal String queue = "demo";

  @NonFinal String message = "Lorem ipsum dolor sit amet";

  @Scheduled(
      fixedRate = 2 * 1_000,
      initialDelay = 2 * 1_000)
  public void sendTestMessage() {
    sendTo(queue, new ToDo(message, "todo description", true));
  }

  @Override
  public void sendTo(String queue, ToDo toDo) {
    rabbitTemplate.convertAndSend(queue, toDo);
    log.info("Producer > Message Sent ({})", toDo);
  }
}
