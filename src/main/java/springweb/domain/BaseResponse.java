package springweb.domain;

/**
 * @author Archon  2019/9/2
 * @since
 */
public class BaseResponse<T> {

    public static <T> BaseResponse<T> newInstance(Code code, T data) {
        return new BaseResponse<>(code.getCode(), data);
    }

    private int code;

    private T data;

    public BaseResponse() {}

    private BaseResponse(int code, T data) {
        this.code = code;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BaseResponse{" + "code=" + code + ", data=" + data + '}';
    }

    public static enum Code {
        OK(200),
        NO_FOUND(404),
        SERVER_ERROR(500);

        private int code;

        Code(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }
    }
}
