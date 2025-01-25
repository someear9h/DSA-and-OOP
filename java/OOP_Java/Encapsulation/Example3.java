package OOP_Java.Encapsulation;

class Encapsulate {

    private String name;
    private int rollNo;
    private int age;

    // getter functions
    public String getName() {
        return name;
    }

    public int getRoll() {
        return rollNo;
    }

    public int getAge() {
        return age;
    }

    // setter functions
    public void setName(String newName) {
        name = newName;
    }

    public void setRoll(int roll) {
        rollNo = roll;
    }

    public void setAge(int newAge) {
        age = newAge;
    }
}

public class Example3 {
    public static void main(String[] args) {
        Encapsulate o = new Encapsulate();

        o.setName("Samarth");
        o.setRoll(34);
        o.setAge(19);

        System.out.println("Name: "+o.getName());
        System.out.println("Roll No: "+o.getRoll());
        System.out.println("Age: "+o.getAge());
    }
}