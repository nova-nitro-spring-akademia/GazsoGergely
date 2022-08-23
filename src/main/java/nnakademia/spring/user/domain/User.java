package nnakademia.spring.user.domain;

public class User {
    private Long id;
    private String name;

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

    public String changeName(String newName) {
        this.name = newName;
        return newName;
    }

    public String gainPhd() {
        this.name = this.name + " PhD" ;
        return this.name;
    }
}
