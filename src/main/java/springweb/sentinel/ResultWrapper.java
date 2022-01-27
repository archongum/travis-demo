package springweb.sentinel;

import com.alibaba.fastjson.JSONObject;


/**
 * Comment here.
 *
 * @author  Archon  2022-01-27
 * @version 0.0.1
 * @since   0.0.1
 */

public class ResultWrapper {

    private Integer code;
    private String message;

    public ResultWrapper(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static ResultWrapper blocked() {
        return new ResultWrapper(-1, "Blocked by Sentinel");
    }

    public String toJsonString() {
        return JSONObject.toJSONString(this);
    }
}
