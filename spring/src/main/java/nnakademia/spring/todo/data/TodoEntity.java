package nnakademia.spring.todo.data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TodoEntity {
    @Id
    private String id;
    private String text;
    private boolean isDone;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }
}
