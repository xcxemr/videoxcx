package com.github.xcxemr.videoxcx.config;

import com.github.xcxemr.videoxcx.common.result.ObjectResult;
import com.github.xcxemr.videoxcx.exception.SignErrorException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(value = SignErrorException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    public ObjectResult<Object> signErrorHandler(SignErrorException e) {
        return ObjectResult.error(null, "token异常");
    }

}
