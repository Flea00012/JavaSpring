package se.kth.sda8.todo.tasks;

import javax.persistence.*;

@Entity
@Table(name = "task")
public class Task {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "date")
    private String date;

    public Task(){

    }

    public Task(Long id, String name, String date){
         this.id = id;
         this.date = date;
         this.name = name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }


}
