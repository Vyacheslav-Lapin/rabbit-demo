package ru.vlapin.demo.rabbitdemo.model;

import static lombok.AccessLevel.PRIVATE;

import java.util.Objects;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

@Getter
@Entity
@ToString
@Setter(PRIVATE)
@NoArgsConstructor
@RequiredArgsConstructor
public class ToDo {

  @Id
  @Include
  @GeneratedValue
  @Column(updatable = false, nullable = false)
  UUID id;

  @Version int version;

  @NonNull String name;
  @NonNull String description;
  @NonNull Boolean completed;

  @Override
  public boolean equals(Object o) {
    return this == o || o != null
                            && Hibernate.getClass(this) == Hibernate.getClass(o)
                            && o instanceof ToDo toDo
                            && Objects.equals(id, toDo.id);
  }

  @Override
  public int hashCode() {
    return 657408436;
  }
}
