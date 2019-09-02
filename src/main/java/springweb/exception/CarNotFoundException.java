package springweb.exception;

/**
 * @author Archon  2019/8/28
 * @since
 */
public final class CarNotFoundException extends Exception {

    public CarNotFoundException() {
        super("Car not found");
    }
}
