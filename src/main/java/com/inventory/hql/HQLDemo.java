package com.inventory.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.inventory.entity.Product;
import com.inventory.util.HibernateUtil;

public class HQLDemo {

    public static void main(String[] args) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        // Insert sample products (RUN ONLY ONCE)
        ProductDataLoader.loadSampleProducts(session);

        // Sorting ASC
        sortProductsByPriceAscending(session);

        // Sorting DESC
        sortProductsByPriceDescending(session);

        // Quantity sorting
        sortProductsByQuantityDescending(session);

        session.close();
        factory.close();
    }

    public static void sortProductsByPriceAscending(Session session) {

        String hql = "FROM Product p ORDER BY p.price ASC";

        Query<Product> query = session.createQuery(hql, Product.class);

        List<Product> products = query.list();

        System.out.println("\nProducts Sorted by Price ASC");

        for(Product p : products)
            System.out.println(p);
    }

    public static void sortProductsByPriceDescending(Session session) {

        String hql = "FROM Product p ORDER BY p.price DESC";

        Query<Product> query = session.createQuery(hql, Product.class);

        List<Product> products = query.list();

        System.out.println("\nProducts Sorted by Price DESC");

        for(Product p : products)
            System.out.println(p);
    }

    public static void sortProductsByQuantityDescending(Session session) {

        String hql = "FROM Product p ORDER BY p.quantity DESC";

        Query<Product> query = session.createQuery(hql, Product.class);

        List<Product> products = query.list();

        System.out.println("\nProducts Sorted by Quantity");

        for(Product p : products)
            System.out.println(p.getName() + " - Quantity: " + p.getQuantity());
    }
}