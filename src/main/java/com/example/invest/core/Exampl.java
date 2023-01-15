package com.example.invest.core;

import org.springframework.stereotype.Component;
import ru.tinkoff.piapi.core.InvestApi;

@Component
public class Exampl {
    private final String token = "";

    public void a() {
        var api = InvestApi.createSandbox(token);
    }

}
