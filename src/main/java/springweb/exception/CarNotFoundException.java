package springweb.exception;

/**
 * @author Archon  2019/8/28
 * @since 0.1
 */
public final class CarNotFoundException extends Exception {

    public CarNotFoundException() {
        super("Car Not Found");
    }
}
