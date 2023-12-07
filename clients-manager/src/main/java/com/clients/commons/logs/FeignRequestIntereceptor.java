package com.clients.commons.logs;

import com.clients.commons.api.ApiRequestLog;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class FeignRequestIntereceptor implements RequestInterceptor {
    @Autowired
    private LogPrinter logPrinter;

    @Override
    public void apply(RequestTemplate requestTemplate) {
        StringBuilder headers = new StringBuilder();
        requestTemplate.headers().forEach((key, value) -> {
            String valor = String.join(",", value);
            headers.append("[").append(key).append(":").append(valor).append("]");
        });
        StringBuilder queryParams = new StringBuilder();
        requestTemplate.queries().forEach((key, value) -> {
            String valor = String.join(",", value);
            queryParams.append("[").append(key).append(":").append(valor).append("]");
        });
        ApiRequestLog requestLog = ApiRequestLog.builder()
                .inData(LocalDateTime.now())
                .path(requestTemplate.feignTarget().url()+requestTemplate.path())
                .method(requestTemplate.method())
                .headers(headers.toString())
                .queryParams(queryParams.toString())
                .build();
        logPrinter.write(requestLog);
    }
}
