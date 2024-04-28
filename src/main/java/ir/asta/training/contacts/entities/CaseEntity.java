package ir.asta.training.contacts.entities;

import javax.persistence.*;


@Entity
@NamedQueries({@NamedQuery(name = "findCaseById",
        query = "select c from CaseEntity c where c.title = :title"),
        @NamedQuery(name = "selectStudents" ,
                query = "select c from CaseEntity c where c.student.username = :username")
})
public class CaseEntity {

    @Id
    @Column
    String title;

    @Basic
    @Column
    String date;

    @Enumerated(EnumType.STRING)
    @Column
    Subject subject;

    @Enumerated(EnumType.STRING)
    @Column
    Status status;

    @Enumerated(EnumType.STRING)
    @Column
    Satisfaction satisfaction;

    @Basic
    @Column
    String description="";

    @ManyToOne(cascade = CascadeType.MERGE)
    StudentEntity student;

    @ManyToOne(cascade = CascadeType.MERGE)
    ActorEntity actor;


    public StudentEntity getStudent() { return student; }

    public void setStudent(StudentEntity student) { this.student = student; }

    public ActorEntity getActor() { return actor; }

    public void setActor(ActorEntity actor) { this.actor = actor; }

    public String getDate() {
        return date;
    }

    public Subject getSubject() {
        return subject;
    }

    public Status getStatus() {
        return status;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        description = actor.getName() + " : " + description + "\n";
        this.description += description;
    }

    public Satisfaction getSatisfaction() {
        return satisfaction;
    }

    public void setSatisfaction(Satisfaction satisfaction) {
        this.satisfaction = satisfaction;
    }
}