package com.example.invest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import ru.tinkoff.piapi.contract.v1.Account;
import ru.tinkoff.piapi.core.InvestApi;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
@RequiredArgsConstructor
public class BaseTest extends DefaultSpringBootTest{

    @Test
    public void checkingSandBoxModeActivated_Test() {
        assertThat(sandBoxApi.getUserService().getInfoSync().getTariff())
                .isEqualTo("sandbox");
    }

    @Test
    public void creatingNewAccount_Test() {
        var accountId = sandBoxApi.getSandboxService().openAccountSync();
        log.info("Open new account in sandbox {}", accountId);

        List<String> accounts = sandBoxApi.getUserService().getAccountsSync()
                .stream()
                .map(Account::getId)
                .toList();

        assertTrue(accounts.contains(accountId));
        sandBoxApi.getSandboxService().closeAccount(accountId);
    }
}
