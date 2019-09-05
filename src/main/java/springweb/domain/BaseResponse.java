package springweb.domain;

import java.util.LinkedHashMap;
import java.util.Map;


/**
 * @author Archon  2019/9/2
 * @since 0.1
 */
public class BaseResponse<T> {

    private int status = 200;

    private T data;

    public BaseResponse() {}

    public BaseResponse(int status, T data) {
        this.status = status;
        this.data = data;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> rs = new LinkedHashMap<>(2);
        rs.put("status", status);
        rs.put("data", data);
        return rs;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
