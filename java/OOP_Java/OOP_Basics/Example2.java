

// program to demonstrate use of classes and objects

class Employee {

    // properties
    static String employeeName;
    static float employeeSalary;

    // methods declared - setter
    public static void set(String n, float s) {
        employeeName = n;
        employeeSalary = s;
    }

    public static void get() {
        System.out.println("Employee Name is: " + employeeName);
        System.out.println("Employee Salary is " + employeeSalary);
    }

    // main method
    public static void main(String[] args) {
        // we dont need to make an object because all methods and properties are static

        Employee.set("Mahesh", 5000.f);
        Employee.get();
    }
}