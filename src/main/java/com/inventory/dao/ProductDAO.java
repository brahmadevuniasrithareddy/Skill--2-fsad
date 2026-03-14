package com.inventory.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.inventory.entity.Product;
import com.inventory.util.HibernateUtil;

public class ProductDAO {

    public void saveProduct(Product product) {

        Transaction transaction = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.persist(product);

            transaction.commit();

            System.out.println("Product saved successfully!");

        } catch(Exception e) {

            if(transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }
}