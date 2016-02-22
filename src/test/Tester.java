/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entity.Book;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author pagh
 */
public class Tester
{

    public static void main(String[] args)
    {
        Persistence.generateSchema("PU", null);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
        EntityManager em = emf.createEntityManager();

        Book b1 = new Book("bog1");
        Book b2 = new Book("bog2");
        Book b3 = new Book("bog3");
        Book b4 = new Book("bog4");
        Book b5 = new Book("bog5");

        try
        {
            em.getTransaction().begin();
            em.persist(b1);
            em.persist(b2);
            em.persist(b3);
            em.persist(b4);
            em.persist(b5);
            em.getTransaction().commit();
            
            int id = b1.getId();
            Book found = em.find(Book.class, id);
            
            System.out.println("her er den bog der er fundet v. em.find(). Navn: " +found.getTitle() + " and the id is: " + found.getId());

        } finally
        {
            em.close();
        }
    }
}
