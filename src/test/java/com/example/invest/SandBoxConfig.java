package com.example.invest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import ru.tinkoff.piapi.contract.v1.Account;
import ru.tinkoff.piapi.core.InvestApi;

@TestConfiguration
public class SandBoxConfig {
    //В режиме песочницы недоступны следующие методы:
    //UsersService.GetMarginAttributes
    //Все методы сервиса StopOrdersService.*
    //OperationsService.GetBrokerReport
    //OperationsService.GetDividendsForeignIssuer
    //OperationsService.GetWithdrawLimits
    //OperationsService.GetOperationsByCursor
    //OperationsStreamService.PortfolioStream
    //OrdersStreamService.TradesStream
    @Bean
    public InvestApi investApi(final @Value("${test-token}")
                               String sandBoxToken) {
        return InvestApi.createSandbox(sandBoxToken);
    }

    @Bean
    @DependsOn("investApi")
    public Account account(final InvestApi investApi) {
        var accountId = investApi.getSandboxService().openAccountSync();

    }
}
