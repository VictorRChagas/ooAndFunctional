package functionalImplementation;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OrderValidator {

    private final List<Function<Order, Boolean>> validations = List.of(this.sellerValidation, this.buyerValidation);
    private final List<Function<Order, List<String>>> validationList = List.of(this.getSellerValidation, this.getBuyerValidation);
    private final Order order;

    public OrderValidator(Order order) {
        this.order = order;
    }

    public boolean isValid() {
        return this.validations.stream().noneMatch(validation -> validation.apply(order));
    }

    public List<String> getValidations() {
        return this.validationList.stream()
                .map(orderListFunction -> orderListFunction.apply(order))
                .flatMap(strings -> strings.stream().sequential())
                .collect(Collectors.toList());
    }

    private final Function<Order, Boolean> sellerValidation = order -> Objects.nonNull(order.getSeller());
    private final Function<Order, Boolean> buyerValidation = order -> Objects.nonNull(order.getBuyer());

    private final Function<Order, List<String>> getSellerValidation = order ->
            Objects.nonNull(order.getBuyer()) ? Collections.emptyList() : List.of("");

    private final Function<Order, List<String>> getBuyerValidation = order ->
            Objects.nonNull(order.getBuyer()) ? Collections.emptyList() : List.of();
}
