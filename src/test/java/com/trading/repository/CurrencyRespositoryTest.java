package com.trading.repository;

import com.trading.entity.Currency;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@DataJpaTest
public class CurrencyRespositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CurrencyRespository currencyRespository;

    @Test
    public void find_by_short_name_then_return_currency(){
        //given
        Currency currency = new Currency();
        currency.setShortName("Bin");
        entityManager.persist(currency);
        //when
        Currency result = currencyRespository.findOneByShortName("Bin");
        //then
        assertEquals(result.getShortName(),currency.getShortName());
    }
    @Test
    public void add_one_to_database_then_find_all_and_result_equals_one(){
        //given
        Currency currency = new Currency();
        currency.setName("Pounds");
        currency.setShortName("GBP");
        //then
        entityManager.persist(currency);
        //then
        List<Currency> currencies = currencyRespository.findAll();
        //then
        assertEquals(1,currencies.size());
    }
    @Test
    public void add_one_to_database_then_find_eur(){
        //given
        Currency currency = new Currency();
        currency.setShortName("eur");
        Currency curr2 = new Currency();
        curr2.setShortName("euu");
        Currency curr3 = new Currency();
        curr3.setShortName("dol");
        //then
        entityManager.persistAndFlush(currency);
        entityManager.persistAndFlush(curr2);
        entityManager.persistAndFlush(curr3);
        //then
        List<Currency> curr = currencyRespository.findBySome("e");
        //then
        assertEquals(2,curr.size());

    }
}