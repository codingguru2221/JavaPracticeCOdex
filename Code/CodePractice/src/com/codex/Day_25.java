package com.codex;

// ---------- Thread-Safe Singleton (Bill Pugh Implementation) ----------
class Singleton {

    // private constructor to restrict instantiation
    private Singleton() {
        System.out.println("Singleton instance created!");
    }

    // Inner static helper class (thread-safe and lazy-loaded)
    private static class SingletonHelper {
        private static final Singleton INSTANCE = new Singleton();
    }

    // Global access point
    public static Singleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
}

// ---------- Factory Pattern Example ----------
interface Gadget {
    void activate();
}

class Drone implements Gadget {
    public void activate() {
        System.out.println("Drone is flying...");
    }
}

class Robot implements Gadget {
    public void activate() {
        System.out.println("Robot is working...");
    }
}

class GadgetFactory {
    // Factory method
    public Gadget getGadget(String type) {
        if (type == null) return null;
        if (type.equalsIgnoreCase("DRONE")) return new Drone();
        if (type.equalsIgnoreCase("ROBOT")) return new Robot();
        return null;
    }
}

// ---------- Main Class ----------
public class Day_25 {
    public static void main(String[] args) {

        // Test Singleton
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println("Are both instances same? " + (s1 == s2));

        // Test Factory
        GadgetFactory factory = new GadgetFactory();

        Gadget drone = factory.getGadget("DRONE");
        drone.activate();

        Gadget robot = factory.getGadget("ROBOT");
        robot.activate();
    }
}
