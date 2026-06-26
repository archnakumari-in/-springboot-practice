package FirstOne_26_06_26;

import java.util.Arrays;
import java.util.List;

public class JavaPractisToday {
	public static void main(String[] args) {
		
	// remover duplicate element form the list 
	List<Integer> listOfNumber= Arrays.asList(1,4,3,2,2,2,6,5,4,3,12,4);

	listOfNumber.stream().distinct().forEach(System.out::print);
	
	
	
	}
	
}