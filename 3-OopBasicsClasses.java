// Package declaration
package com.example.vehicles;

// This class demonstrates: class, attributes, methods, access specifiers, static, final
public class Car {
    
    // ---------- Attributes (fields) ----------
    public String model;               // public: accessible anywhere
    private int speed;                 // private: only inside this class
    protected String color;            // protected: accessible in subclasses and same package
    static int totalCarsCreated;       // static: belongs to class, not instances
    final int WHEELS = 4;              // final: constant, cannot be changed
    
    // ---------- Constructor ----------
    public Car(String model, String color) {
        this.model = model;
        this.color = color;
        this.speed = 0;
        totalCarsCreated++;             // increment static counter
    }
    
    // ---------- Methods (behaviors) ----------
    // Public method: accessible anywhere
    public void accelerate(int increase) {
        if (increase > 0) {
            speed += increase;
            System.out.println(model + " accelerated to " + speed + " km/h");
        }
    }
    
    // Private method: only used inside this class
    private void logSpeed() {
        System.out.println("Current speed of " + model + ": " + speed);
    }
    
    // Protected method: accessible in subclasses & same package
    protected void displayInfo() {
        System.out.println("Model: " + model + ", Color: " + color + ", Wheels: " + WHEELS);
        logSpeed();  // calling private method
    }
    
    // Static method: can be called without an object
    public static void showTotalCars() {
        System.out.println("Total cars created: " + totalCarsCreated);
    }
    
    // Getter for private speed (encapsulation)
    public int getSpeed() {
        return speed;
    }
}