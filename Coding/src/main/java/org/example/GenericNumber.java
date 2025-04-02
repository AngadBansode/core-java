package org.example;

public class GenericNumber<T extends Number> {
    private T value;

    public GenericNumber(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public GenericNumber<T> add(GenericNumber<T> other) {
        double result = this.value.doubleValue() + other.getValue().doubleValue();
        return (GenericNumber<T>) new GenericNumber<>(result);
    }

    public GenericNumber<T> subtract(GenericNumber<T> other) {
        double result = this.value.doubleValue() - other.getValue().doubleValue();
        return (GenericNumber<T>) new GenericNumber<>(result);
    }

    public GenericNumber<T> multiply(GenericNumber<T> other) {
        double result = this.value.doubleValue() * other.getValue().doubleValue();
        return (GenericNumber<T>) new GenericNumber<>(result);
    }

    public GenericNumber<T> divide(GenericNumber<T> other) {
        double result = this.value.doubleValue() / other.getValue().doubleValue();
        return (GenericNumber<T>) new GenericNumber<>(result);
    }

    @Override
    public String toString() {
        return value.toString();
    }

    public static void main(String[] args) {
        GenericNumber<Integer> num1 = new GenericNumber<>(5);
        GenericNumber<Integer> num2 = new GenericNumber<>(3);

        GenericNumber<Integer> sum = num1.add(num2);
        GenericNumber<Integer> difference = num1.subtract(num2);
        GenericNumber<Integer> product = num1.multiply(num2);
        GenericNumber<Integer> quotient = num1.divide(num2);

        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + difference);
        System.out.println("Product: " + product);
        System.out.println("Quotient: " + quotient);
    }
}
