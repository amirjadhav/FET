package assignment1;

public class AnimalTest {
    public static void main(String[] args) {
        Animal m[] = new Animal[3];
        m[0] = new Cat();
        m[0].respirate();
        m[0].talk();

        m[1] = new Dog();
        m[1].respirate();
        m[1].talk();

        m[2] = new Lion();
        m[2].respirate();
        m[2].talk();

    }
}
