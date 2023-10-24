public class ComplexNumber <T extends Number> {
    private T re;
    private T im;

    public ComplexNumber(T re, T im) {
        this.re = re;
        this.im = im;
    }

    public T getReal() {
        return re;
    }

    public T getImaginary() {
        return im;
    }

    public void setReal(T re) {
        this.re = re;
    }

    public void setImaginary(T im) {
        this.im = im;
    }

    // Нэмэх үйлдэл
    public ComplexNumber<T> add(ComplexNumber<T> other) {
        double newReal = this.re.doubleValue() + other.getReal().doubleValue();
        double newImaginary = this.im.doubleValue() + other.getImaginary().doubleValue();
        return (ComplexNumber<T>) new ComplexNumber<>(newReal, newImaginary);
    }
    public ComplexNumber<T> subtract(ComplexNumber<T> other) {
        double newReal = this.re.doubleValue() - other.getReal().doubleValue();
        double newImaginary = this.im.doubleValue() - other.getImaginary().doubleValue();
        return (ComplexNumber<T>) new ComplexNumber<>(newReal, newImaginary);
    }

    public void print() {
        System.out.println(this.re + " + " + this.im + "i");
    }
    public static void main(String[] args) {
        ComplexNumber<Double> complex1 = new ComplexNumber<>(3.0, 4.0);
        ComplexNumber<Double> complex2 = new ComplexNumber<>(1.0, 2.0);

        ComplexNumber<Double> sum = complex1.add(complex2);
        ComplexNumber<Double> difference = complex1.subtract(complex2);

        System.out.println("Complex1: ");
        complex1.print();

        System.out.println("Complex2: ");
        complex2.print();

        System.out.println("Sum: ");
        sum.print();

        System.out.println("Difference: ");
        difference.print();
    }
}
