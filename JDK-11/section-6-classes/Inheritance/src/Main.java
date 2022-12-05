public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal("animal", 1, 1,5, 5);

        Dog dog = new Dog("husky", 8, 20, 2, 4, 1, 20, "black and white");
        dog.eat();
        dog.move(1);
        dog.walk();
        dog.run();
    }
}