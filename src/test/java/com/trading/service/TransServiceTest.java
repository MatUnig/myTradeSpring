package com.trading.service;

import com.trading.dao.TransDao;
import com.trading.entity.Transaction;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TransServiceTest {

    private TransService transService;
    private TransDao transDao;


    @Before
    public void setUp() {
        transDao = mock(TransDao.class);
        transService = new TransServiceImpl(transDao);
    }
    @Test
    public void whenFindTransactionIdThenReturnObject() {
// given
        Transaction john = new Transaction();
        john.setId(5);
        john.setProfit(50);
        when(transDao.findById(5)).thenReturn(john);
// when
        Transaction profitable = transDao.findById(5);
// then
        assertEquals(profitable.getProfit(),
                50,0);

    }
}