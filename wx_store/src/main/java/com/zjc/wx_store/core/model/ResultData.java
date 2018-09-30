package com.zjc.wx_store.core.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ResultData {

    private String message;

    private String responseCode;

    private boolean success;

    private Object data;

    private List list;

    private int total;

    public static ResultData initSuccess(Object o) {
        ResultDataBuilder builder = ResultData.builder()
                .message("success")
                .success(true);

        if (o instanceof List) {
            List tmp = (List) o;
            builder.list(tmp);
        } else {
            builder.data(o);
        }

        return builder.build();

    }

    public static ResultData initFailed(String message) {
        ResultDataBuilder builder = ResultData.builder()
                .message(message)
                .success(false);

        return builder.build();

    }
}
