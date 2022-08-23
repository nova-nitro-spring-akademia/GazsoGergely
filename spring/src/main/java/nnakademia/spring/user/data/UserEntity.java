package nnakademia.spring.user.data;

import nnakademia.spring.data.TodoEntity;

import javax.persistence.*;
import java.util.List;

@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    // ha nincs onetomany
    // - idea: basic attribute type should not be a container
    // - stacktrace: org.hibernate.MappingException: Could not determine type for: java.util.List, at table: user_entity, for columns: [org.hibernate.mapping.Column(todos)]
    @OneToMany
    private List<TodoEntity> todos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TodoEntity> getTodos() {
        return todos;
    }

    public void setTodos(List<TodoEntity> todos) {
        this.todos = todos;
    }
}
