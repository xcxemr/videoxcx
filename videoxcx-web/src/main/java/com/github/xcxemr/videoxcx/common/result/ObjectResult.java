package com.github.xcxemr.videoxcx.common.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ObjectResult<T> {

    private int code;
    private T Data;
    private String message;

    public static <T> ObjectResult<T> success(T data) {
        return new ObjectResult<T>(200, data, null);
    }

    public static <T> ObjectResult<T> error(T data, String message){
        return new ObjectResult<>(500, data, message);
    }

}
