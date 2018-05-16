package domain;

public class Dog {

	private Long id;
	private String name;
	private String breed;
	private String dateOfBirth;

	/**
	 * Full Constructor
	 * @param id
	 * @param name
	 * @param breed
	 * @param dateOfBirth
	 */
	public Dog(Long id, String name, String breed, String dateOfBirth) {
		super();
		this.id = id;
		this.name = name;
		this.breed = breed;
		this.dateOfBirth = dateOfBirth;
	}
	
	

	@Override
	public String toString() {
		return id + name + breed + dateOfBirth;
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
