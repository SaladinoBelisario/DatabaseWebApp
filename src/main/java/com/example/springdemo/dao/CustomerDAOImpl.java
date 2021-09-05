package com.example.springdemo.dao;

import com.example.springdemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

    //need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {
        // get the current Hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query
        Query<Customer> query =
                currentSession.createQuery("from Customer", Customer.class);

        // execute query and get results AND return the results
        return query.getResultList();
    }

    @Override
    public void saveCustomer(Customer customer) {
        // get the current Hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // save the customer
        currentSession.saveOrUpdate(customer);
    }

    @Override
    public Customer getCustomer(int id) {
        // get the current Hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // get the customer
        return currentSession.get(Customer.class, id);
    }

    @Override
    public void deleteCustomer(int id) {
        // get the current Hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // delete the customer
        Query query =
                currentSession.createQuery("delete from Customer where id=:customerId");
        query.setParameter("customerId", id);
    }
}
