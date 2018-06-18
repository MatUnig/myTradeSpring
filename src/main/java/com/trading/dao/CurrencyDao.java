package com.trading.dao;

import com.trading.entity.Currency;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class CurrencyDao {

    @PersistenceContext
    EntityManager entityManager;

    public List<Currency> getAll() {
        Query q = entityManager.createQuery("SELECT shortName from Currency x");
        return q.getResultList();
    }

    public void save(Currency currency) {
        entityManager.persist(currency);
    }

    public Currency findById(long id) {
        return entityManager.find(Currency.class, id);
    }

    public void update(Currency entity) {
        entityManager.merge(entity);
    }

    public void delete(Currency entity) {
        entityManager.remove(entityManager.contains(entity) ?
                entity : entityManager.merge(entity));
    }

}
