package com.trading.utils;


import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.trading.entity.Transaction;
import com.trading.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


public class Function {
    @PersistenceContext
    private static EntityManager entityManager;

    static public String apiParser(String textUrl, String valueOf) throws IOException {
        URL url = new URL(textUrl);
        URLConnection request = url.openConnection();
        request.connect();
        JsonParser jp = new JsonParser(); //from gson
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonArray array = root.getAsJsonArray();
        JsonObject obj = array.get(0).getAsJsonObject();
        String currencyCode =obj.get(valueOf).toString();
        return currencyCode;
    }
    static public double parsePrice(String param1, String param2) throws IOException {
       return Double.parseDouble(apiParser("https://forex.1forge.com/1.0.3/quotes?pairs="+param1 + param2 + "&api_key=EQkqgXVnmOO1DyOOrtil33fuNdZFFaUS","price"));
    }
    static public String parseNames(String param1, String param2) throws IOException {
        String fromCurrencyName = apiParser("https://forex.1forge.com/1.0.3/quotes?pairs="+param1 + param2 + "&api_key=EQkqgXVnmOO1DyOOrtil33fuNdZFFaUS", "symbol");
        String toCurrencyName = apiParser("https://forex.1forge.com/1.0.3/quotes?pairs="+param1 + param2 + "&api_key=EQkqgXVnmOO1DyOOrtil33fuNdZFFaUS", "symbol");
        return param1 + " / " + param2;
    }
    static public void setCurrentPrice(Transaction transaction) throws IOException {
        String fromCurrency = transaction.getFromCurrency();
        String toCurrency = transaction.getToCurrency();
        transaction.setCurrentPrice(parsePrice(fromCurrency,toCurrency));
    }
    static public void setProfit(Transaction transaction) {
        double profit = Math.round((transaction.getCurrentPrice() - transaction.getPrice()) * transaction.getQuantity()*100.0)/100.0;
        transaction.setProfit(profit);
    }
    static public void setProfitResult(Transaction transaction) throws IOException {
        String fromCurrency = transaction.getFromCurrency();
        String toCurrency = transaction.getToCurrency();
        double profit = Math.round((parsePrice(fromCurrency,toCurrency) - transaction.getPrice()) * transaction.getQuantity()*100.0)/100.0;
        transaction.setBookedProfit(profit);
        transaction.setProfit(0.00);
    }
    static public void applyChanges(User user) {
        entityManager.merge(user);
    }

    static public void showCurrentTrans(User user) {
        entityManager.merge(user);
    }
}
