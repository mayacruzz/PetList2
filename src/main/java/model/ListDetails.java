package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Maya Cruz - Gcruz6
 * CIS175 -Spring 2024
 * Feb 26, 2024
 */
@Entity
public class ListDetails {
	
	@Id
	@GeneratedValue
	private int id;
	private String listName;
	private LocalDate date;
    @ManyToOne (cascade=CascadeType.PERSIST)   
	private Shopper shopper;
    @OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)

	private List<ListPet> listOfListPets;

	private List<ListPet> listOfPet;
	
	//Default constructor
	public ListDetails() {
		super();
	}

	//Getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}


	public List<ListPet> getListOfListPets() {
		return listOfListPets;
	}

	public void setListOfListPets(List<ListPet> listOfListPets) {
		this.listOfListPets = listOfListPets;
	public List<ListPet> getListOfPet() {
		return listOfPet;
	}

	public void setListOfPet(List<ListPet> listOfPet) {
		this.listOfPet = listOfPet;
	}

	public Shopper getShopper() {
		return shopper;
	}

	public void setShopper(Shopper shopper) {
		this.shopper = shopper;
	}
	

	@Override
	public String toString() {
		return "ListDetails [id=" + id + ", listName=" + listName + ", date=" + date + ", shopper=" + shopper
				+ ", listOfListPets=" + listOfListPets + "]";
	}

	public ListDetails(int id, String listName, LocalDate date, Shopper shopper, List<ListPet> listOfListPets) {
				+ ", listOfPet=" + listOfPet + "]";
	}

	public ListDetails(int id, String listName, LocalDate date, Shopper shopper, List<ListPet> listOfPet) {
		   this.id = id;
	       this.listName = listName;
	       this.date = date;
	       this.shopper = shopper;
	       this.listOfListPets = listOfListPets; 
	}
	public ListDetails(String listName, LocalDate date, Shopper shopper, List<ListPet> listOfListPets) {
		   this.listName = listName;
	       this.date = date;
	       this.shopper = shopper;
	       this.listOfListPets = listOfListPets; 
	       this.listOfPet = listOfPet; 
	}
	public ListDetails(String listName, LocalDate date, Shopper shopper, List<ListPet> listOfPet) {
		   this.listName = listName;
	       this.date = date;
	       this.shopper = shopper;
	       this.listOfPet = listOfPet; 
			         
	}
	public ListDetails(String listName, LocalDate date, Shopper shopper) {
		this.listName = listName;
        this.date = date;
        this.shopper = shopper;
	}
	
  
}
