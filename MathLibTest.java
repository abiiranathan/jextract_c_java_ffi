import java.io.File;
import static org.example.math_h.*;

public class MathLibTest {
    static {
        try {
            System.out.println("Current working directory: " + System.getProperty("user.dir"));
            System.out.println("Java library path: " + System.getProperty("java.library.path"));
            
            File lib = new File("libmath.so");
            System.out.println("libmath.so exists: " + lib.exists());
            System.out.println("libmath.so absolute path: " + lib.getAbsolutePath());
            
            System.load(lib.getAbsolutePath());
            System.out.println("Successfully loaded libmath.so");
        } catch (UnsatisfiedLinkError e) {
            System.err.println("Failed to load libmath.so: " + e.getMessage());
        }
    }

    static long jfactorial(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        try {
            double a = 10.0;
            double b = 5.0;

            System.out.println("Addition: " + add(a, b));
            System.out.println("Subtraction: " + subtract(a, b));
            System.out.println("Multiplication: " + multiply(a, b));
            System.out.println("Division: " + divide(a, b));
            System.out.println("Factorial(20): " + factorial(20));
        } catch (Exception e) {
            System.err.println("Error during math operations: " + e.getMessage());
        }

        // Time how long it takes to calculate factorial(20) 100 times
        long start = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            factorial(20);
        }
        long end = System.nanoTime();
        System.out.println("Time taken to calculate factorial(20) in C 100000 times: " + (end - start) + " ns");

        // Time how long it takes to calculate jfactorial(20) 100000 times
        start = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            jfactorial(20);
        }
        end = System.nanoTime();
        System.out.println("Time taken to calculate jfactorial(20) in Java 100000 times: " + (end - start) + " ns");
    }
}

