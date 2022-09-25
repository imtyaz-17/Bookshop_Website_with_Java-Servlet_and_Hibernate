package com.bookshop.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CategoryTest {
	public static void main(String[] args) {

	Category newCategory = new Category("C++");
	
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookShopWebsite");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    
    entityManager.getTransaction().begin();
    entityManager.persist(newCategory);
    
    entityManager.getTransaction().commit();
   entityManager.close();
   entityManagerFactory.close();
    System.out.println("Category objets was Persisted");

}
}
