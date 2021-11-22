package springweb.domain;

import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * BaseResponse.
 *
 * @author Archon  2019/9/2
 * @since 0.1
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BaseResponse<T> {

    private BaseStatus status = BaseStatus.OK;

    private T data;

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

    /**
     * BaseStatus.
     */
    public enum BaseStatus {
        OK, NOT_FOUND, INTERNAL_SERVER_ERROR
    }
}
