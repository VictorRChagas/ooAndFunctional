package ooImplementation;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class SellerOrderValidation implements OrderValidations {

    @Override
    public boolean isValid(Order order) {
        return Objects.nonNull(order.getSeller());
    }

    @Override
    public List<String> getValidation(Order order) {
        return Objects.nonNull(order.getSeller()) ? Collections.emptyList() : List.of("Seller must not be null");
    }
}
