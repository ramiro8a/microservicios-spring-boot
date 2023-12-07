package com.clients.commons.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({"requestId","path","method","inData","outData","headers","queryParams"})
public class ApiRequestLog {
    private LocalDateTime inData;
    private LocalDateTime outData;
    private String path;
    private String method;
    private String headers;
    private String queryParams;
    private String requestId;
}
