package com.trading.service;

import org.junit.Before;
import org.junit.Test;
import com.trading.dao.TransDao;

import static org.mockito.Mockito.mock;

public class TransServiceTest {

    private TransService transService;
    private TransDao transDao;

    public TransServiceTest(TransService transService, TransDao transDao) {
        this.transService = transService;
        this.transDao = transDao;
    }
    @Before
    public void setUp() {
        transDao = mock(TransDao.class);
        transService = new TransServiceImpl(transDao);
    }
//    @Test
//    public void when_searching_john_then_return_object() {
//// given
//        Student john = new Student("John");
//        when(repository.findOneByFirstName("John")).thenReturn(john);
//// when
//        Student student = service.findByFirstName("John");
//// then
//        assertEquals(student.getFirstName(),
//                "John");
//    }
    @Test
    public void buy() {
    }

    @Test
    public void sell() {
    }

    @Test
    public void getTrans() {
    }

    @Test
    public void applyChanges() {
    }

    @Test
    public void findById() {
    }
}