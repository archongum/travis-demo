package springweb.util;

import springweb.domain.BaseResponse;
import springweb.domain.BaseResponse.BaseStatus;


/**
 * BaseResponses.
 *
 * @author Archon  2019/9/5
 * @since
 */
public final class BaseResponses {

    public static <T> BaseResponse ok(T data) {
        return newInstance0(BaseStatus.OK, data);
    }

    public static <T> BaseResponse notFound(T data) {
        return newInstance0(BaseStatus.NOT_FOUND, data);
    }

    public static <T> BaseResponse internalServerError(T data) {
        return newInstance0(BaseStatus.INTERNAL_SERVER_ERROR, data);
    }

    private static <T> BaseResponse newInstance0(BaseStatus status, T data) {
        return new BaseResponse<>(status, data);
    }
}
