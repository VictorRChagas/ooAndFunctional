package ooImplementation;

import ooImplementation.util.StringUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Order {
    private Person seller;
    private Person buyer;
    private Set<ItemOrder> itemOrderSet = new HashSet<>();

    private final List<OrderValidations> orderValidationsList = List.of(new SellerOrderValidation(), new BuyerOrderValidation());

    public Order(Person seller, Person buyer) {
        this.seller = seller;
        this.buyer = buyer;
    }

    /***
     * In this case I had chosen to use a primitive type
     * because I am not doing any kind of operation
     * so it's preferable to use something that occupies less
     * memory, thinking of a perfomance gain when it comes to memory managment,
     * as this method has a side effect we can return a boolean, because it's
     * editing the state of an object
     */
    public boolean addNewItem(int quantity, Item item) {
        /***
         * we could have some validation here that returns false if something
         * is wrong, and consequently we would have to handle with this
         */
        var itemOrder = new ItemOrder(quantity, item);
        return itemOrderSet.add(itemOrder);
    }

    public void finishOrder() {
        /***
         * it's important to keep the validations before any other processing, this way you will
         * avoid unnecessary processing!
         */
        executeValidations();
        /***
         * do something else if it's valid
         */
    }

    private void executeValidations() {
        var isNotValid = orderValidationsList.stream()
                .anyMatch(orderValidations -> !orderValidations.isValid(this));

        if (isNotValid) {
            var invalidations = orderValidationsList.stream()
                    .map(orderValidations -> orderValidations.getValidation(this))
                    .flatMap(strings -> strings.stream().sequential())
                    .collect(Collectors.toList());

            throw new IllegalArgumentException(StringUtils.join(invalidations, ","));
        }
    }

    public Person getSeller() {
        return seller;
    }

    public Person getBuyer() {
        return buyer;
    }
}
