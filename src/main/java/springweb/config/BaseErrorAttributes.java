package springweb.config;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.web.context.request.WebRequest;
import springweb.domain.BaseResponse;

import java.util.Map;


/**
 * Handle in each Controller separately.
 *
 * @author Archon  2019/8/28
 * @since 0.1
 */
@Deprecated
//@Component
public class BaseErrorAttributes extends DefaultErrorAttributes {
 
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> map = super.getErrorAttributes(webRequest, includeStackTrace);
        return new BaseResponse<>((int) map.get("status"), map.get("message")).toMap();
    }
}
