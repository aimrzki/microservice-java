package com.java.micro.service.responseV1;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseApiV1<T> {
    private int code;
    private String message;
    private T data;

    // Static factory methods for common responses
    public static <T> ResponseApiV1<T> success(T data) {
        return ResponseApiV1.<T>builder()
                .code(ResponseStatus.SUCCESS.getCode())
                .message(ResponseStatus.SUCCESS.getMessage())
                .data(data)
                .build();
    }

    public static <T> ResponseApiV1<T> error(ResponseStatus status) {
        return ResponseApiV1.<T>builder()
                .code(status.getCode())
                .message(status.getMessage())
                .build();
    }
}