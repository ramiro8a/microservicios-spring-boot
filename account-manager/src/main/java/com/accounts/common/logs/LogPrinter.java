package com.accounts.common.logs;

import com.accounts.common.api.ApiRequestLog;
import com.accounts.common.constants.Const;
import com.accounts.common.utils.Utils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
public class LogPrinter {
    @Autowired
    private HttpServletRequest request;

    public void write(ApiRequestLog requestLog){
        requestLog.setOutData(LocalDateTime.now());
        requestLog.setRequestId(getRequestId());
        log.info(Utils.objectToString(requestLog, true));
    }

    private String getRequestId(){
        return (String) request.getAttribute(Const.REQUEST_ID);
    }
}
