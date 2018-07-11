package com.trading.web;

import com.trading.entity.Currency;
import com.trading.repository.CurrencyRespository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
import	static	org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import	static	org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import	static	org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;


@RunWith(SpringRunner.class)
@WebMvcTest(controllers = CurrencyController.class)
public class CurrencyControllerTest {
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private CurrencyRespository currencyRespository;

    @Before
    public void setUp() {

        mockMvc = webAppContextSetup(webApplicationContext).build();
            Currency a = new Currency();
            Currency b = new Currency();
            Currency c = new Currency();
            a.setShortName("USD");
            b.setShortName("PLN");
            c.setShortName("EUR");
            List<Currency> currencies = Arrays.asList(a,b,c);
        when(this.currencyRespository.findAll()).thenReturn(currencies);
    }

    private final String CURRENCIES_VIEW = "admin/currencies";

    @Test
    public void test_listAction_contains_model_list() throws Exception {
        assertThat(this.currencyRespository).isNotNull();

        mockMvc.perform(get("/currencies"))
                .andExpect(model().attributeExists("currencies"))
                .andExpect(model().attribute("currencies", hasSize(3)))
                .andExpect(model().attribute("currencies",
                        hasItem(anyOf(hasProperty("shortName"), is("USD")))))
                .andExpect(status().isOk())
                .andExpect(view().name(CURRENCIES_VIEW))
                .andDo(print());
    }

}