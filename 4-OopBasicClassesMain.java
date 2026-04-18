// Import the Car class from the package
import com.example.vehicles.Car;

// Nested class example (inside Main)
class Engine {
    String type;
    
    Engine(String type) {
        this.type = type;
    }
    
    void start() {
        System.out.println(type + " engine started.");
    }
}

// Main class with static nested class and inner class examples
public class Main {
    
    // ---------- Static nested class ----------
    static class Garage {
        String name;
        Garage(String name) {
            this.name = name;
        }
        void park(Car car) {
            System.out.println(car.model + " parked in " + name + " garage.");
        }
    }
    
    // ---------- Inner class (non-static nested) ----------
    class Key {
        void unlock() {
            System.out.println("Key used to unlock the car.");
        }
    }
    
    public static void main(String[] args) {
        
        // 1. Creating objects using the Car class (from package)
        System.out.println("=== Creating Car Objects ===");
        Car myCar = new Car("Tesla Model 3", "Red");
        Car anotherCar = new Car("Honda Civic", "Blue");
        
        // 2. Accessing public attribute
        System.out.println("My car model: " + myCar.model);
        
        // 3. Calling methods
        myCar.accelerate(50);
        anotherCar.accelerate(30);
        
        // 4. Static method call (no object needed)
        Car.showTotalCars();
        
        // 5. Using final attribute (read-only)
        // myCar.WHEELS = 5;   // ERROR: cannot assign a value to final variable
        
        // 6. Protected method is accessible because Main and Car are in different packages?
        // Actually, protected is not accessible from different package unless subclass.
        // So we'll use public getter for speed:
        System.out.println("Current speed of myCar: " + myCar.getSpeed());
        
        // 7. Using static nested class
        System.out.println("\n=== Static Nested Class ===");
        Garage homeGarage = new Garage("Home");
        homeGarage.park(myCar);
        
        // 8. Using non-static inner class (requires an instance of outer class)
        System.out.println("\n=== Inner Class ===");
        Main outer = new Main();
        Key carKey = outer.new Key();
        carKey.unlock();
        
        // 9. Using another nested class (Engine) defined in this file but outside Main
        System.out.println("\n=== Another Nested Class ===");
        Engine v8 = new Engine("V8");
        v8.start();
        
        // 10. Demonstrating access specifier boundaries (compile-time errors commented)
        // myCar.speed = 100;        // ERROR: speed is private
        // myCar.logSpeed();         // ERROR: logSpeed is private
        // myCar.displayInfo();      // ERROR: displayInfo is protected (different package & no inheritance)
        
        // 11. Using a method that uses protected method inside its own package? Not here.
        // But if we were in same package, it would work.
    }
}