package design.pattern.proxy;

// Step 1: Define the Subject interface
interface Image {
    void display();
}

// Step 2: Create the RealSubject class
class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("Loading " + fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }
}

// Step 3: Create the Proxy class
class ProxyImage implements Image {
    private String fileName;
    private RealImage realImage;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName); // Lazy initialization
        }
        realImage.display();
    }
}

// Step 4: Client code
public class ProxyPatternExample {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("image1.jpg");
        Image image2 = new ProxyImage("image2.jpg");

        // Image is not loaded until display() is called
        System.out.println("Proxy created. Images not loaded yet.");

        // Load and display image1
        image1.display();
        System.out.println();

        // Display image1 again (no loading this time)
        image1.display();
        System.out.println();

        // Load and display image2
        image2.display();
    }
}
