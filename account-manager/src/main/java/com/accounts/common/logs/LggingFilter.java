package com.accounts.common.logs;

import com.accounts.common.api.ApiRequestLog;
import com.accounts.common.constants.Const;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Enumeration;
import java.util.UUID;

//@Order(Ordered.HIGHEST_PRECEDENCE)
@Component
public class LggingFilter implements Filter {
    @Autowired
    private LogPrinter logPrinter;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        String requestId = httpServletRequest.getHeader(Const.REQUEST_ID);
        if(requestId==null)
            requestId = UUID.randomUUID().toString();
        httpServletRequest.setAttribute(Const.REQUEST_ID, requestId);
        ApiRequestLog apiRequestLog = ApiRequestLog.builder()
                .requestId(requestId)
                .inData(LocalDateTime.now())
                .path(httpServletRequest.getRequestURI())
                .method(httpServletRequest.getMethod())
                .headers(getHeaders(httpServletRequest))
                .build();
        chain.doFilter(request, response);
        logPrinter.write(apiRequestLog);
    }

    public static String getHeaders(HttpServletRequest httpServletRequest){
        Enumeration<String> headerNames = httpServletRequest.getHeaderNames();
        StringBuilder headers = new StringBuilder();
        while (headerNames.hasMoreElements()){
            String key = headerNames.nextElement();
            headers.append("[");
            headers.append(key);
            headers.append(":");
            headers.append(httpServletRequest.getHeaders(key));
            headers.append("]");
        }
        return headers.toString();
    }

    public static String getQueryParams(HttpServletRequest httpServletRequest){
        Enumeration<String> queryPamatersNames = httpServletRequest.getParameterNames();
        StringBuilder headers = new StringBuilder();
        while (queryPamatersNames.hasMoreElements()){
            String key = queryPamatersNames.nextElement();
            headers.append("[");
            headers.append(key);
            headers.append(":");
            headers.append(httpServletRequest.getParameter(key));
            headers.append("]");
        }
        return headers.toString();
    }
}
