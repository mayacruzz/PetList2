package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "pets")
public class ListPet {
	@Id
    @GeneratedValue
    @Column(name = "ID")
	private int id;
	@Column(name = "SPECIES")
    private String species;
	@Column(name = "GENDER")
	private String gender;
	@Column(name = "AGE")
    private int age;
	/**
	 * 
	 */
	public ListPet() {
		super();
	}
	/**
	 * @param species
	 * @param gender
	 * @param age
	 */
	public ListPet(String species, String gender, int age) {
		super();
		this.species = species;
		this.gender = gender;
		this.age = age;
	}
	
	//Getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	// Helper method - print details
    public String returnCarDetails() {
        return this.species + " " + this.gender + " " + this.age;
    }
	@Override
	public String toString() {
		return "ListPet [species=" + species + ", gender=" + gender + ", age=" + age + "]";
	}	       
}
