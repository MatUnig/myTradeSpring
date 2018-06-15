package com.trading.repository;

import com.trading.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurrencyRespository extends JpaRepository<Currency, Integer> {

    Currency findOneByShortName(String shortname);

    @Query("select c from Currency c where c.shortName like ?1%")
    List<Currency> findBySome(String some);
}