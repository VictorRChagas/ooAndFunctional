package functionalImplementation;

import java.math.BigDecimal;

public class ItemOrder {
    private Integer quantity;
    private BigDecimal price;
    private Item item;

    public ItemOrder(Integer quantity, Item item) {
        this.quantity = quantity;
        this.item = item;
        this.price = BigDecimal.TEN;
        /***
         * suppose this price comes from some where else
         */
    }
}
