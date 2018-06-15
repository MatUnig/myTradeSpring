package com.trading.dao;


import com.trading.entity.Transaction;
import com.trading.service.CurrentUser;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface TransDao {
    void buy(@AuthenticationPrincipal CurrentUser customUser, Transaction transaction, HttpServletRequest request);
    void sell(Transaction transaction, HttpServletRequest request);
    List getTrans(CurrentUser customUser);
    Transaction applyChanges(Transaction transaction);
    Transaction findById(int id);
    }

