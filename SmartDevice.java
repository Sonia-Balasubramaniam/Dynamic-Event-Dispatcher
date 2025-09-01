package assignment;
//Parent class
class SmartDevice {
 // Protected attributes
 protected String brand;
 protected double price;

 // Constructor
 public SmartDevice(String brand, double price) {
     this.brand = brand;
     this.price = price;
 }

 public void displayInfo() {
     System.out.println("Brand: " + brand);
     System.out.println("Price: $" + price);
 }
}

//Subclass 1
class SmartPhone extends SmartDevice {
 private String operatingSystem;

 public SmartPhone(String brand, double price, String operatingSystem) {
     super(brand, price);
     this.operatingSystem = operatingSystem;
 }

 public void displayDetails() {
     System.out.println("Smartphone Brand: " + brand);  
     System.out.println("Smartphone Price: $" + price); 
     System.out.println("Operating System: " + operatingSystem);
 }
}
//Subclass 2
class SmartWatch extends SmartDevice {
 private boolean heartRateMonitor;

 public SmartWatch(String brand, double price, boolean heartRateMonitor) {
     super(brand, price);
     this.heartRateMonitor = heartRateMonitor;
 }

 public void displayDetails() {
     System.out.println("Smartwatch Brand: " + brand);  
     System.out.println("Smartwatch Price: $" + price); 
     System.out.println("Heart Rate Monitor: " + (heartRateMonitor ? "Yes" : "No"));
 }
}

//Main class
class Main {
 public static void main(String[] args) {
     SmartPhone phone = new SmartPhone("Samsung", 799.99, "Android");
     SmartWatch watch = new SmartWatch("Apple", 399.99, true);

     System.out.println("=== SmartPhone Info ===");
     phone.displayInfo();
     phone.displayDetails();

     System.out.println("\n=== SmartWatch Info ===");
     watch.displayInfo();
     watch.displayDetails();
 }
}
