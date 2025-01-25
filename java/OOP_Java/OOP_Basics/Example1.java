

// Use of Object and Classes in Java

class Numbers {
    // Properties (private)
    private int a;
    private int b;

    // Setter methods
    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    // Methods
    public void sum() {
        System.out.println(a + b);
    }

    public void sub() {
        System.out.println(a - b);
    }

    // Main method
    public static void main(String[] args) {
        // Creating an instance of the class
        Numbers obj = new Numbers();

        // Using setter methods to assign values
        obj.setA(1);
        obj.setB(2);

        // Using the methods
        obj.sum();
        obj.sub();
    }
}
