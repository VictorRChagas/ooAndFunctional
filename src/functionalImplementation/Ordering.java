package functionalImplementation;

public class Ordering {
    public static void main(String[] args) {
        var john = new Person("John", 20);
        var victor = new Person("Victor", 25);

        var item = new Item("Beer", true);

        var order = new Order(john, null);
        order.addNewItem(2, item);
        order.finishOrder();
    }
}
