import java.util.*;
abstract class Animal{
String Name;
String Food;
String Sleep;
abstract void eat();
abstract void sleep();
}
class Lion extends Animal{
	void eat(){
		System.out.println("Carnivorous");
	}
	void sleep(){
		System.out.println("12 hours");
	}
}
class Tiger extends Animal{
	void eat(){
		System.out.println("Carnivorous");
	}
	void sleep(){
		System.out.println("10 hours");
	}
}
class Deer extends Animal{
	void eat(){
		System.out.println("Herbivorous");
	}
	void sleep(){
		System.out.println("8 hours");
	}
}
public class Main{
	public static void main(String[] args){
		Lion L=new Lion();
		L.eat();
		L.sleep();
		Tiger T=new Tiger();
		T.eat();
		T.sleep();
		Deer D=new Deer();
		D.eat();
		D.sleep();
	}
}
