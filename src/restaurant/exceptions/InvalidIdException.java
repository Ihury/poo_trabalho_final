package restaurant.exceptions;

public class InvalidIdException extends Exception {
    private String validFormat;

    public InvalidIdException(String message) {
        super(message);
    }
    public InvalidIdException(String message, String validFormat) {
        super(message);
        this.validFormat = validFormat;
    }

    public String getValidFormat() {
        return validFormat;
    }

    @Override
    public String getMessage() {
        if (validFormat != null) return super.getMessage() + "\nFormato esperado: " + validFormat;
        else return super.getMessage();
    }
}
