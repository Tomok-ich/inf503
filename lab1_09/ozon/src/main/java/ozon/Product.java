package ozon;
import Seller;

public class Product {
    Seller seller;
    String deliveryDate;
    String gettingDate;
    String articule;
    String name;
    double price;
    int count;
    /*
     * Формируется, Оплачен, Доставлен, Получен
     */
    String status;

    Product(Seller seller, String articule, String name, double price) {
        this.seller = seller;
        this.articule = articule;
        this.name = name;
        this.price = price;
        this.deliveryDate = "";
        this.count = 0;
    }

    void setStatus(String status){
        this.status = status;
    }

    void getProduct(String gettingDate){
        this.gettingDate = gettingDate;
        setStatus("Получен");
    }
}
// класс это новый тип данных