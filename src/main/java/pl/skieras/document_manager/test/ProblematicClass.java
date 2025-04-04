package pl.skieras.document_manager.test;

public class ProblematicClass {

    private int x = 10;
    private String unusedVariable;
    private static final int CONSTANT_VALUE = 100;
    public int publicField; // Bad practice, should be private

    public ProblematicClass() {
        x = x;
    }

    public void doSomething() {
        int unusedLocal = 0;
        String text = null;
        System.out.println(text.length()); // Null pointer risk

        for (int i = 0; i < 10; i++) {
            // Empty loop
        }

        try {
            int result = 10 / 0;
        } catch (Exception e) {
            // Do nothing
        }

        if (x = 5) { // Assignment instead of comparison
            System.out.println("x is 5");
        }

        String s = "test";
        if (s == "test") {
            System.out.println("This might work but it's not safe.");
        }
    }

    @Deprecated
    public void deprecatedMethod() {
        System.out.println("Deprecated method.");
    }

    public void recursion(int num) {
        if (num > 0) {
            recursion(num--); // Infinite recursion due to post-decrement
        }
    }

    public void duplicateCode() {
        System.out.println("Duplicate");
        System.out.println("Duplicate");
    }

    public void longMethod() {
        System.out.println("Start");
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
        System.out.println("End");
    }
}