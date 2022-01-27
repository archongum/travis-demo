package springweb.sentinel;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Comment here.
 *
 * @author  Archon  2022-01-27
 * @version 0.0.1
 * @since   0.0.1
 */

@ControllerAdvice
@Order(0)
@Slf4j
public class SentinelSpringMvcBlockHandlerConfig {

    /**
     * sentinelBlockHandler.
     *
     * @param e error
     * @return global block response
     */
    @ExceptionHandler(BlockException.class)
    @ResponseBody
    public ResultWrapper sentinelBlockHandler(BlockException e) {
        log.warn("Blocked by Sentinel: {}", e.getRule());
        // Return the customized result.
        return ResultWrapper.blocked();
    }
}
