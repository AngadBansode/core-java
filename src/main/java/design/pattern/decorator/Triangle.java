package design.pattern.decorator;

public class Triangle implements Shape {
    // Overriding the draw method
    @Override
    public void draw()
    {
        System.out.println("Triangle Drawn...");
    }
}