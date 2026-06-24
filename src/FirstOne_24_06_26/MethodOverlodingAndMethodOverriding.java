package FirstOne_24_06_26;



 class Animal{
	 void eat() {
		 System.out.println("eating...");
	 }
 }
 class Dog extends Animal{
	 void eat() {
		 System.out.println("eating bread...");
	 }
 }
public class MethodOverlodingAndMethodOverriding {
	public static void main(String[] args) {
		
		Animal a=new Dog();  
		a.eat();
	}
	

}
