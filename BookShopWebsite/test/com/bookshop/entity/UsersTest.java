package com.bookshop.entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class UsersTest {
	public static void main(String[] args) {
		
		Users user1 = new Users();
        user1.setEmail("i@gmail.com");
        user1.setFullName("Imt yaz");
        user1.setPassword("123");
        
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookShopWebsite");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        entityManager.getTransaction().begin();
        entityManager.persist(user1);
        
        entityManager.getTransaction().commit();
       entityManager.close();
       entityManagerFactory.close();
        System.out.println("An User objets was Persisted");
	}
	
}
