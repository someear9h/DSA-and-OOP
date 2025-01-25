

// demonstrating abstraction in java

abstract class Televison {
    abstract void turnOn();
    abstract void turnOff();

}

// concrete class implementing the abstract methods
class TVRemote extends Televison {
    @Override
    void turnOn() {
        System.out.println("TV is turned on");
    }

    @Override
    void turnOff() {
        System.out.println("TV is turned off");
    }
}

// main class to demonstrate abstraction
public class Example1 {
    public static void main(String[] args) {
        TVRemote remote = new TVRemote();
        remote.turnOn();
        remote.turnOff();
    }
}
