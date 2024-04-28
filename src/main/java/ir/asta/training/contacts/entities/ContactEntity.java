package ir.asta.training.contacts.entities;

import javax.persistence.*;

@Entity
@Table
@NamedQuery(name = "findByID" ,
		query = "select c from ContactEntity c where c.id = :id")
public class ContactEntity {
	
	Long id;
	String name;
	
    @Id
    @Column
    //@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Basic
	@Column
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}