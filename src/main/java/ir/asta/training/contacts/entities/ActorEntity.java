package ir.asta.training.contacts.entities;


import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table
@NamedQueries({@NamedQuery(name = "findActorById",
        query = "select a from ActorEntity a where a.username = :username")
})
public class ActorEntity extends Human{

    boolean isAccepted = false;

    @OneToMany(mappedBy = "actor")
    List<CaseEntity> cases;

    public boolean isAccepted() {
        return isAccepted;
    }

    public void setAccepted(boolean accepted) {
        isAccepted = accepted;
    }

    public List getCases() {

        List<String> l = new LinkedList<>();
        for (CaseEntity aCase : cases) {
            l.add(aCase.title);
        }
        return l;
    }

    public void setCases(List<CaseEntity> cases) {
        this.cases = cases;
    }

}
