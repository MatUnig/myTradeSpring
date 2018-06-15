package com.trading.service;

import com.trading.entity.Transaction;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface TransService {

    void buy(@AuthenticationPrincipal CurrentUser customUser, Transaction transaction, HttpServletRequest request);

    void sell(Transaction transaction, HttpServletRequest request);

    List<Transaction> getTrans(CurrentUser customUser);

    Transaction applyChanges(Transaction transaction);

    Transaction findById(int id);
}
