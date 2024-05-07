package co.edu.usco.pw.springboot_crud01.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Size(max = 30, message = "El nombre de la asignatura no puede superar los 30 caracteres.")
    private String subjectName;

    @Size(max = 100, message = "La descripción debe tener máximo 100 caracteres.")
    private String description;

    private int classroom;

    private Date startTime;

    private Date endTime;

    public Todo() {
        super();
    }

    public Todo(String subjectName, String description, int classroom, Date startTime, Date endTime) {
        super();
        this.subjectName = subjectName;
        this.description = description;
        this.classroom = classroom;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getClassroom() {
        return classroom;
    }

    public void setClassroom(int classroom) {
        this.classroom = classroom;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
