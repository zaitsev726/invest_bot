package com.example.invest.core.account;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ru.tinkoff.piapi.core.InvestApi;

@Slf4j
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final InvestApi investApi;

    @Override
    public String createAccount() {
        log.debug("createAccount: starting");
        return "";
    }
}
