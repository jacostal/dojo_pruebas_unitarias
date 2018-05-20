package domain.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity(name = "Dog")
@NamedQueries({
	@NamedQuery(name = "Dog.findByName", query = "SELECT dog FROM Dog dog WHERE dog.name = :name"),
	@NamedQuery(name = "Dog.findAll", query = "SELECT dog FROM Dog dog")
})
public class DogEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String breed;

	@Column(nullable = false, name = "DATE_OF_BIRTH")
	private String dateOfBirth;
	
	
	public DogEntity(Long id, String name, String breed, String dateOfBirth) {
		super();
		this.id = id;
		this.name = name;
		this.breed = breed;
		this.dateOfBirth = dateOfBirth;
	}

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

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

}
