

// Class Method and Method Passing

class Student {
    
    // properties
    String name;
    int id;

    // method to print student information
    public void printInfo() {
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + id);
    }

    
}

public class Example3{
    public static void main(String[] args) {
        Student student = new Student();
        student.id = 34;
        student.name = "Samarth";

        student.printInfo();
    }
}

