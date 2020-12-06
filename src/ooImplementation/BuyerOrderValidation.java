package ooImplementation;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class BuyerOrderValidation implements OrderValidations {

    @Override
    public boolean isValid(Order order) {
        return Objects.nonNull(order.getBuyer());
    }

    @Override
    public List<String> getValidation(Order order) {
        return Objects.nonNull(order.getBuyer()) ? Collections.emptyList() : List.of("Buyer must not be null");
    }
}
