package design.pattern.decorator;

public abstract class ShapeDecorator implements Shape {
    protected Shape shapeDecorated;

    public ShapeDecorator(Shape shapeDecorated)
    {
        this.shapeDecorated = shapeDecorated;
    }
    @Override
    public void draw() {
        shapeDecorated.draw();
    }
}