import java.util.ArrayList;
import java.util.List;



class Fruit {
}

class Apple extends Fruit {
}

class Orange extends Fruit {
}

class Box<T extends Fruit> {
    private List<T> fruits;

    public Box() {
        fruits = new ArrayList<>();
    }

    public void addFruit(T fruit) {
        if (fruits.isEmpty() || fruits.get(0).getClass().equals(fruit.getClass())) {
            fruits.add(fruit);
        } else {
            System.out.println("Неприпустима комбінація фруктів у коробці.");
        }
    }

    public void addFruits(List<T> fruitsToAdd) {
        for (T fruit : fruitsToAdd) {
            addFruit(fruit);
        }
    }

    public float getWeight() {
        if (fruits.isEmpty()) {
            return 0.0f;
        }
        float weight = 0.0f;
        for (T fruit : fruits) {
            if (fruit instanceof Apple) {
                weight += 1.0f;
            } else if (fruit instanceof Orange) {
                weight += 1.5f;
            }
        }
        return weight;
    }

    public boolean compare(Box<?> otherBox) {
        return Math.abs(getWeight() - otherBox.getWeight()) < 0.0001;
    }

    public void merge(Box<T> otherBox) {
        if (otherBox == this) {
            return;
        }
        if (fruits.isEmpty() || fruits.get(0).getClass().equals(otherBox.fruits.get(0).getClass())) {
            fruits.addAll(otherBox.fruits);
            otherBox.fruits.clear();
        } else {
            System.out.println("Неприпустима комбінація фруктів для злиття.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Приклад використання коду

        // Приклад 1: Метод toList
        Integer[] numbersArray = {1, 2, 3, 4, 5};
        List<Integer> numbersList = ArrayToListConverter.toList(numbersArray);
        System.out.println("Список чисел: " + numbersList);

        // Приклад 2: Скриньки-фрукти
        Box<Apple> appleBox = new Box<>();
        Box<Orange> orangeBox = new Box<>();
        Box<Fruit> mixedBox = new Box<>();

        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());

        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());

        mixedBox.addFruit(new Apple());
        mixedBox.addFruit(new Orange());

        System.out.println("Вага коробки з яблуками: " + appleBox.getWeight());
        System.out.println("Вага коробки з апельсинами: " + orangeBox.getWeight());
        System.out.println("Вага змішаної коробки: " + mixedBox.getWeight());

        System.out.println("Порівняння коробок appleBox і orangeBox: " + appleBox.compare(orangeBox));
        System.out.println("Порівняння коробок appleBox і mixedBox: " + appleBox.compare(mixedBox));

        Box<Apple> anotherAppleBox = new Box<>();
        anotherAppleBox.addFruit(new Apple());
        anotherAppleBox.addFruit(new Apple());

        appleBox.merge(anotherAppleBox);

        System.out.println("Вага об'єднаної коробки з яблуками: " + appleBox.getWeight());
        System.out.println("Вага порожньої коробки: " + anotherAppleBox.getWeight());
    }
}

