package ooImplementation;

import java.util.List;

public interface OrderValidations {

    boolean isValid(Order order);

    List<String> getValidation(Order order);
}
