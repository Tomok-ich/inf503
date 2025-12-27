package ozon;
import Customer;

public class Order {
    int CAPACITY = 10; // макс количество товаров в заказе
    int productsCount = 0;

    int number;
    Customer customer;
    String deliveryPoint;
    String orderDate;
    double summ;
    Product[] products = new Product[CAPACITY];
    /*
        Формируется, Оплачен, Закрыт
     */
    String status;

Order(int number, Customer customer, String deliveryPoint, String orderDate){
    this.number = number;
    this.customer = customer;
    this.deliveryPoint = deliveryPoint;
    this.orderDate = orderDate;

}

    void payment(){
        for (int i = 0; i < productsCount; i++) {
            products[i].setStatus("Оплачен");
        }
        setStatus("Оплачен");
    }

    void changeProductCount(Product product, int count){
        for (int i = 0; i < productsCount; i++) {
            if (products[i].articule.equals(product.articule)) {
                if (count > 0) { // изменяем товар
                    products[i].count = count;
                    return;
                }
                else{ // удаляем товар
                    products[i] = products[productsCount - 1];
                    products[productsCount - 1] = null; // нужно для очистки оперативки
                    productsCount--;
                }
                return;
            }
        }
        // товар не нашелся, добавляем
        products[productsCount] = product;
        products[productsCount].count = count;
        productsCount++;
    }

    void getProduct(Product product, String gettingDate){
        product.getProduct(gettingDate);
        boolean isAllGetting = true;
        for (int i = 0; i < productsCount; i++){
            if (products[i].status.equals("Получен")) {
                isAllGetting = false;
                break;
            }
        }
        if (isAllGetting){
            this.status = "Закрыт";
        }
    }

    public String toString() {
        return "Заказ №" + number + ", покупатель: " + customer.name;
    }
}
// . это оператор доступа к содержимому класса