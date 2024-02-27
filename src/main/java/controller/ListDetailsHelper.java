package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.ListDetails;

public class ListDetailsHelper {
	
	static EntityManagerFactory emfactory =
			Persistence.createEntityManagerFactory("PetList");

     public void insertNewListDetails(ListDetails p) {
          EntityManager em = emfactory.createEntityManager();
          em.getTransaction().begin();
          em.persist(p);
          em.getTransaction().commit();
          em.close();
     }
     public List<ListDetails> getLists() {
          EntityManager em = emfactory.createEntityManager();
          List<ListDetails> allDetails = em.createQuery("SELECT d FROM ListDetails d").getResultList();
          return allDetails;
} 
     }
