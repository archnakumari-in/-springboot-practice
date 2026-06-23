package FirstOne_23_06_26;

public class StringAndStringBuilderAndStringBuffer {
	public static void main(String[] args) {
		
		String str = "Hello";
		StringBuilder strBuilder = new StringBuilder("Hello");
		StringBuffer strBuffer = new StringBuffer("Hello");

		System.out.println("String: " + str);
		System.out.println("StringBuilder: " + strBuilder);
		System.out.println("StringBuffer: " + strBuffer);

		str += " World"; // Creates a new String object
		strBuilder.append(" World"); // Modifies the existing StringBuilder object
		strBuffer.append(" World"); // Modifies the existing StringBuffer object

		System.out.println("After modification:");
		System.out.println("String: " + str);
		System.out.println("StringBuilder: " + strBuilder);
		System.out.println("StringBuffer: " + strBuffer);
	}

}
