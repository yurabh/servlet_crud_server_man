package com.dao;

import com.domain.Man;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ManDao implements CrudDao<Man> {

    private EntityManagerFactory factory = Persistence.createEntityManagerFactory(
            "my-persistence-unit");

    private EntityManager entityManager = factory.createEntityManager();

    @Override
    public void save(Man man) {

        entityManager.getTransaction().begin();

        entityManager.persist(man);

        entityManager.getTransaction().commit();

        closeResourceForDataBase();
    }

    @Override
    public Man getById(int id) {

        entityManager.getTransaction().begin();

        Man man = entityManager.find(Man.class, id);

        entityManager.getTransaction().commit();

        closeResourceForDataBase();

        return man;
    }

    @Override
    public void update(Man man) {

        entityManager.getTransaction().begin();

        Man manMerged = entityManager.merge(man);

        entityManager.persist(manMerged);

        entityManager.getTransaction().commit();

        closeResourceForDataBase();
    }

    @Override
    public Man deleteById(int id) {

        entityManager.getTransaction().begin();

        Man man = entityManager.find(Man.class, id);

        entityManager.remove(man);

        entityManager.getTransaction().commit();

        closeResourceForDataBase();

        return man;
    }

    private void closeResourceForDataBase() {
        entityManager.close();

        factory.close();
    }
}
