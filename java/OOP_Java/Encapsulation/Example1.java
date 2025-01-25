package OOP_Java.Encapsulation;

// encapsulation example (private variables and public methods to access variables)

class Employee {

    // private properties/variables
    private int id;
    private String name;

    // setter methods    
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    // getter methods
    public void getInfo() {
        System.out.println("Employee Id: " + id);
        System.out.println("Employee name is: " + name);
    }
}

public class Example1 {
    public static void main(String[] args) {
        Employee e1 = new Employee();

        e1.setId(78);
        e1.setName("Samarth");

        e1.getInfo();
    }
}

