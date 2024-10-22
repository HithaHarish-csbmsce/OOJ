import java.util.*;
abstract class Shape{
abstract void printArea();
}
class Rectangle extends Shape{
	double l;
	double b;
	Rectangle(double l,double b){
		this.l=l;
		this.b=b;
	}
	void printArea(){
		System.out.println(l*b);
	}
}
class Triangle extends Shape{
	double h;
	double b;
	Triangle(double h,double b){
		this.h=h;
		this.b=b;
	}
	void printArea(){
		System.out.println(0.5*h*b);
	}
}
class Circle extends Shape{
	double r;
	Circle(double r){
		this.r=r;
	}
	void printArea(){
		System.out.println(3.14*r*r);
	}
}
public class Main1{
	public static void main(String[] args){
		Rectangle R=new Rectangle(5,6);
		R.printArea();
		Triangle T=new Triangle(2,5);
		T.printArea();
		Circle C=new Circle(1);
		C.printArea();


	}
}

