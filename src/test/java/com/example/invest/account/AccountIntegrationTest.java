package com.example.invest.account;

import com.example.invest.DefaultSpringBootTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import ru.tinkoff.piapi.contract.v1.MoneyValue;

@Slf4j
public class AccountIntegrationTest extends DefaultSpringBootTest {

    @Test
    public void a() {
        var portfolio = sandBoxApi.getOperationsService().getPortfolioSync(mainAccount.getId());
        portfolio.getTotalAmountCurrencies();
        sandBoxApi.getSandboxService()
                .payIn(mainAccount.getId(),
                        MoneyValue.newBuilder()
                                .setUnits(10_000)
                                .setCurrency("RUB")
                                .build());

        sandBoxApi.getSandboxService()
                .payIn(mainAccount.getId(),
                        MoneyValue.newBuilder()
                                .setUnits(10_000)
                                .setCurrency("USD")
                                .build());


//        //Остальные методы - доступны. При вызове из sandbox режима запрос идет в песочницу, например, получим портфолио
//        getPortfolioExample(sandboxApi);
//        //Или список позиций
//        getPositionsExample(sandboxApi);
//        //Выставляем ордер
//        ordersServiceExample(sandboxApi, figi);
    }
}
