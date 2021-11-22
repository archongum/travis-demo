package springweb.domain;

import java.util.Objects;


/**
 * BaseResponse.
 *
 * @author Archon  2019/9/2
 * @since 0.1
 */
public class BaseResponse<T> {

    private BaseStatus status = BaseStatus.OK;

    private T data;

    public BaseResponse() {
    }

    public BaseResponse(BaseStatus status, T data) {
        this.status = status;
        this.data = data;
    }

    public BaseStatus getStatus() {
        return status;
    }

    public void setStatus(BaseStatus status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BaseResponse<?> that = (BaseResponse<?>) o;
        return status == that.status && Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, data);
    }

    /**
     * BaseStatus.
     */
    public enum BaseStatus {
        OK, NOT_FOUND, INTERNAL_SERVER_ERROR
    }
}
