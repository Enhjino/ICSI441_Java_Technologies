abstract class Pet {
    private String name;
    private int age;
    private String sound;

    public Pet(String name, int age, String sound) {
        this.name = name;
        this.age = age;
        this.sound = sound;
    }
    public abstract String getType();
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSound() {
        return sound;
    }
}

// Child classes
class Dog extends Pet {
    public Dog(String name, int age) {
        super(name, age, "~хов хов~");
    }
    @Override
    public String getType() {
        return "Нохой";
    }
}

class Cat extends Pet {
    public Cat(String name, int age) {
        super(name, age, "~Миав миов~");
    }

    @Override
    public String getType() {
        return "Муур";
    }
}

class Parrot extends Pet {
    public Parrot(String name, int age) {
        super(name, age, "~шшш ггүг грүг~");
    }

    @Override
    public String getType() {
        return "Тоть";
    }
}

public class bodlogo2 {
    public static void main(String[] args) {
        Pet dog = new Dog("Банхар", 3);
        Pet cat = new Cat("Ногооноо", 2);
        Pet parrot = new Parrot("Koko", 5);

        System.out.println("Амьтны төрөл: " + dog.getType());
        System.out.println("Нэр: " + dog.getName());
        System.out.println("Нас: " + dog.getAge());
        System.out.println("Дуу: " + dog.getSound() + "\n");

        System.out.println("Амьтны төрөл: " + cat.getType());
        System.out.println("Нэр: " + cat.getName());
        System.out.println("Нас: " + cat.getAge());
        System.out.println("Дуу: " + cat.getSound() + "\n");

        System.out.println("Амьтны төрөл: " + parrot.getType());
        System.out.println("Нэр: " + parrot.getName());
        System.out.println("Нас: " + parrot.getAge());
        System.out.println("Дуу: " + parrot.getSound() + "\n");
    }
}
