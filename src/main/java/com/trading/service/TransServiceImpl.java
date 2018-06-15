package com.trading.service;


import com.trading.entity.Transaction;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import com.trading.dao.TransDao;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class TransServiceImpl implements TransService {
//    @Autowired
//    public TransDao transDao;
    private TransDao transDao;

    public TransServiceImpl(TransDao transDao) {
        this.transDao = transDao;
    }

    @Override
    public void buy(@AuthenticationPrincipal CurrentUser customUser, Transaction transaction, HttpServletRequest request) {
        transDao.buy(customUser, transaction, request);
    }

    @Override
    public void sell(Transaction transaction, HttpServletRequest request) {
        transDao.sell(transaction, request);
    }

    @Override
    public List<Transaction> getTrans(CurrentUser customUser) {
        return transDao.getTrans(customUser);
    }

    @Override
    public Transaction applyChanges(Transaction transaction){ return transDao.applyChanges(transaction);}

    @Override
    public Transaction findById(int id){ return transDao.findById(id);  }

}
