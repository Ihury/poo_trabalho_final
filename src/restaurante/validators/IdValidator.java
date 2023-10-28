package restaurante.validators;

import restaurante.exceptions.InvalidIdException;

public class IdValidator {
    private static final String VALID_FORMAT = "AA111";
    private static final String VALID_FORMAT_REGEX = "^[A-Za-z]{2}\\d{3}$";
    public static void validate(String id) throws InvalidIdException {        
        if (!id.matches(VALID_FORMAT_REGEX)) {
            throw new InvalidIdException("O ID informado não segue o padrão esperado!", VALID_FORMAT);
        }
    }
}
