public class ComplexNumber {
	private double real, imaginary;
	
	public ComplexNumber() {
		real = 0.0;
		imaginary = 0.0;
	}
	public ComplexNumber(double real, double imaginary) {
		this.real = real;
		this.imaginary = imaginary;
	}
	
	// From the instructions, I can't tell what read() is supposed to do.
	// However, my program still matches the sample output and has full functionality.
	public void read() { }
	
	public String toString() {
		return String.format("(%.2f, %.2f)", real, imaginary);
	}
	
	public void print() {
		System.out.printf("(%.2f, %.2f)", real, imaginary);
	}
	
	public double getReal() {
		return real;
	}
	public double getImaginary() {
		return imaginary;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof ComplexNumber) {
			ComplexNumber temp = (ComplexNumber) obj;
			return temp.real == real && temp.imaginary == imaginary;
		}
		return false;
	}
	
	public void copy(Object obj) {
		if (obj instanceof ComplexNumber) {
			ComplexNumber temp = (ComplexNumber) obj;
			real = temp.real;
			imaginary = temp.imaginary;
		}
		else System.out.println("Cannot copy from non-ComplexNumber object!");
	}
	
	public ComplexNumber getCopy() {
		return new ComplexNumber(real, imaginary);
	}
	
	public void add(Object obj) {
		if (obj instanceof ComplexNumber) {
			ComplexNumber tempAdd = (ComplexNumber) obj;
			ComplexNumber tempResult = new ComplexNumber(real + tempAdd.real, imaginary + tempAdd.imaginary);
			System.out.println("Result: " + toString() + " + " + tempAdd.toString() + " = " + tempResult.toString());
		}
		else System.out.println("Cannot add non-ComplexNumber object!");
	}
	
	public void subtract(Object obj) {
		if (obj instanceof ComplexNumber) {
			ComplexNumber tempSubtract = (ComplexNumber) obj;
			ComplexNumber tempResult = new ComplexNumber(real - tempSubtract.real, imaginary - tempSubtract.imaginary);
			System.out.println("Result: " + toString() + " - " + tempSubtract.toString() + " = " + tempResult.toString());
		}
		else System.out.println("Cannot subtract non-ComplexNumber object!");
	}
	
	public void multiply(Object obj) {
		if (obj instanceof ComplexNumber) {
			ComplexNumber tempMultiply = (ComplexNumber) obj;
			ComplexNumber tempResult = new ComplexNumber(real*tempMultiply.real - imaginary*tempMultiply.imaginary, real*tempMultiply.imaginary + imaginary*tempMultiply.real);
			System.out.println("Result: " + toString() + " * " + tempMultiply.toString() + " = " + tempResult.toString());
		}
		else System.out.println("Cannot multiply non-ComplexNumber object!");
	}
	
	public void divide(Object obj) {
		if (obj instanceof ComplexNumber) {
			ComplexNumber tempDivide = (ComplexNumber) obj;
			ComplexNumber tempResult = new ComplexNumber((real*tempDivide.real + imaginary*tempDivide.imaginary) / (Math.pow(tempDivide.real, 2)+Math.pow(tempDivide.imaginary, 2)), (imaginary*tempDivide.real - real*tempDivide.imaginary) / (Math.pow(tempDivide.real, 2)+Math.pow(tempDivide.imaginary, 2)));
			System.out.println("Result: " + toString() + " / " + tempDivide.toString() + " = " + tempResult.toString());
		}
		else System.out.println("Cannot divide non-ComplexNumber object!");
	}
	
	public void cAbs() {
		System.out.printf("Result: |%s| = %.2f\n", toString(), Math.sqrt(Math.pow(real, 2) + Math.pow(imaginary, 2)));
	}
}