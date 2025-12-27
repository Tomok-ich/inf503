import Customer;
import Seller;

public class OzonMain {
    public static void main(String[] args) {
        Customer customer = new Customer("1756h57", "Kamil");
        Seller nike = new Seller("Nike");
        Seller abibas = new Seller("Abibas");

        Product p0 = new Product(nike, "0234h", "Кроссовки nike", 13000);
        Product p1 = new Product(nike, "5634h", "Кроссовки nike размер 42", 13000);
        Product p2 = new Product(abibas, "976h", "Кроссовки abibas размер 42", 13000);
        Product p3 = new Product(abibas, "006h", "Футболка abibas размер M", 2000);

        Order order = new Order(1, customer, "Казань, Кремлевская 35", "08.11.2025");

        order.changeProductCount(p0, 2);
        order.changeProductCount(p1, 13);
        order.changeProductCount(p2, 4);
        order.changeProductCount(p3, 6);

        order.changeProductCount(p1, 0);

        order.changeProductCount(p2, 6);
        order.changeProductCount(p3, 4);

        order.changeProductCount(p1, 7);

        order.payment();



    }
}
