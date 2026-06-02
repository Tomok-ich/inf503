package fruits;

public class Fruit {
    private String name;
    private Integer price;

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Fruit(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

}
