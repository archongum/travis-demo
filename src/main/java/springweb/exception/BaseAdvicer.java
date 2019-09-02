package springweb.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import springweb.domain.BaseResponse;

import static springweb.domain.BaseResponse.Code.SERVER_ERROR;


/**
 * @author Archon  2019/9/2
 * @since
 */
@ControllerAdvice(basePackages ="springweb.controller")
public class BaseAdvicer {

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public BaseResponse exceptionHandler(Exception e){
        return BaseResponse.newInstance(SERVER_ERROR, e.getMessage());
    }
}
