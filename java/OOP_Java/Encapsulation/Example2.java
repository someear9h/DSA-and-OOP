package OOP_Java.Encapsulation;

class Programmer {
    private String lang;
    private int typeSpeed;

    // setter methods
    public void setter(String lang, int typeSpeed) {
        this.lang = lang;
        this.typeSpeed = typeSpeed;
    }

    // getter methods
    public String getLang() {
        return lang;
    }

    public int getSpeed() {
        return typeSpeed;
    }

    // main method
    public static void main(String[] args) {
        // make an object
        Programmer pro1 = new Programmer();
        Programmer pro2 = new Programmer();

        pro1.setter("Java", 130);
        pro2.setter("Python",126);

        // getter methods
        System.out.println("Info about pro1: ");
        System.out.println("Programming Language: " + pro1.getLang() + ", Typing speed: " + pro1.getSpeed());
        System.out.println("----------------------------------------------------");
        System.out.println("Info about pro2: ");
        System.out.println("Porgramming Language: " + pro2.getLang() + ", Typing Speed: " + pro2.getSpeed());
        
    }
}
