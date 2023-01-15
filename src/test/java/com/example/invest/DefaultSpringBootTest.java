package com.example.invest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import ru.tinkoff.piapi.contract.v1.Account;
import ru.tinkoff.piapi.core.InvestApi;

@SpringBootTest
@ActiveProfiles("test")
@Import(SandBoxConfig.class)
public class DefaultSpringBootTest {
    @Autowired
    protected InvestApi sandBoxApi;

    @Autowired
    protected Account mainAccount;
}
