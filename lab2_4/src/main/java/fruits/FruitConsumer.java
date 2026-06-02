package fruits;

import java.util.function.Consumer;

public class FruitConsumer implements Consumer<Fruit> {

    @Override
    public void accept(Fruit fruit) {
        System.out.println(fruit.getName() + ": " + fruit.getPrice());
    }
}