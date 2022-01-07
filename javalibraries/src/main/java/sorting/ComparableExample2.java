package sorting;

public class ComparableExample2  {
    public static void main(String[] args) {
        Animal animal1 = new Animal(1);
        Animal animal2 = new Animal(2);
        Animal animal3 = new Animal(3);

        System.out.println(animal1.compareTo(animal1)); // equal
        System.out.println(animal1.compareTo(animal2)); // animal1 < animal2
        System.out.println(animal3.compareTo(animal2)); // animal3 > animal2
    }
}

class Animal implements Comparable<Animal> {

    public final int id;

    Animal(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(Animal otherAnimal) {
        return id - otherAnimal.id;
    }
}