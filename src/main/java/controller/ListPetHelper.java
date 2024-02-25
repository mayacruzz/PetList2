package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListPet;


public class ListPetHelper {
static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("PetList");
	
	public void insertPet(ListPet pet) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(pet);
        em.getTransaction().commit();
        em.close();
    }
	
	public List<ListPet> showAllPets() {
        EntityManager em = emfactory.createEntityManager();
        List<ListPet> allPets = em.createQuery("SELECT p FROM ListPet p").getResultList();
        em.close();
        return allPets;
    }
	
	public void deletePet(ListPet toDelete) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<ListPet> typedQuery = em.createQuery(
                "SELECT p FROM ListPet p WHERE p.species = :selectedSpecies AND p.gender = :selectedGender",
                ListPet.class);

        typedQuery.setParameter("selectedSpecies", toDelete.getSpecies());
        typedQuery.setParameter("selectedGender", toDelete.getGender());

        typedQuery.setMaxResults(1);

        ListPet result = typedQuery.getSingleResult();
        em.remove(result);
        em.getTransaction().commit();
        em.close();
    }

    public void updatePet(ListPet toEdit) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        em.merge(toEdit);
        em.getTransaction().commit();
        em.close();
    }

    public List<ListPet> searchForPetBySpecies(String species) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<ListPet> typedQuery = em.createQuery(
                "SELECT p FROM ListPet p WHERE p.species = :selectedSpecies", ListPet.class);
        typedQuery.setParameter("selectedSpecies", species);
        List<ListPet> foundPets = typedQuery.getResultList();
        em.close();
        return foundPets;
    }

    public List<ListPet> searchForPetByGender(String gender) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<ListPet> typedQuery = em.createQuery(
                "SELECT p FROM ListPet p WHERE p.gender = :selectedGender", ListPet.class);
        typedQuery.setParameter("selectedGender", gender);
        List<ListPet> foundPets = typedQuery.getResultList();
        em.close();
        return foundPets;
    }

    public List<ListPet> searchForPetByAge(int age) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<ListPet> typedQuery = em.createQuery(
                "SELECT p FROM ListPet p WHERE p.age = :selectedAge", ListPet.class);
        typedQuery.setParameter("selectedAge", age);
        List<ListPet> foundPets = typedQuery.getResultList();
        em.close();
        return foundPets;
    }

    public ListPet searchForPetById(int idToEdit) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        ListPet found = em.find(ListPet.class, idToEdit);
        em.close();
        return found;
    }

    public void cleanUp() {
        emfactory.close();
    }
}
