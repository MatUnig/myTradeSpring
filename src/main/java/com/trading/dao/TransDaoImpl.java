package com.trading.dao;


import com.trading.entity.Transaction;
import com.trading.entity.User;
import com.trading.repository.TransactionRepository;
import com.trading.service.CurrentUser;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class TransDaoImpl implements TransDao {

    public TransDaoImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    private final TransactionRepository transactionRepository;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void buy(@AuthenticationPrincipal CurrentUser customUser, Transaction transaction, HttpServletRequest request) {
        User currentUser = customUser.getUser();
        Transaction trans = new Transaction();
        trans.setDate(trans.getDate());
        trans.setFromCurrency(request.getParameter("fromCurrency"));
        trans.setToCurrency(request.getParameter("toCurrency"));
        trans.setProduct(request.getParameter("product"));
        trans.setType("Buy");
        trans.setStatus("Open");
//        trans.setDate(LocalDateTime.now());
        trans.setQuantity(Double.parseDouble(request.getParameter("quantity")));
        trans.setPrice(Double.parseDouble(request.getParameter("price")));
        trans.setUser(currentUser);
        System.out.println(currentUser.getName());
        System.out.println(currentUser.getBalance());
        System.out.println(currentUser.getId());
        transactionRepository.save(trans);
    }

    @Override
    public void sell(Transaction transaction, HttpServletRequest request) {

    }

    @Override
    public Transaction findById(int id) {
        return entityManager.find(Transaction.class, id);

    }

    public List<Transaction> getTrans(@AuthenticationPrincipal CurrentUser customUser) {
        User currentUser = customUser.getUser();
        return transactionRepository.findByUserId(currentUser.getId());
    }

    @Override
    public Transaction applyChanges(Transaction transaction) {
        return entityManager.merge(transaction);
    }

}
