package ir.asta.training.contacts.entities;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table
@NamedQueries({@NamedQuery(name = "findStudentById",
        query = "select s from StudentEntity s where s.username = :username"),
        @NamedQuery(name = "findAll" , query = "select c from StudentEntity c")
})
public class StudentEntity extends Human{

    @OneToMany(mappedBy = "student")
    List<CaseEntity> cases;


    public void setCases(List<CaseEntity> cases) {
        this.cases = cases;
    }

    public List getCases() {
        List<String> l = new LinkedList<>();
        for (CaseEntity aCase : cases) {
            l.add(aCase.title);
        }
        return l;
    }
}
