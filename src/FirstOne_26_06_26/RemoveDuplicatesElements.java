package FirstOne_26_06_26;

import java.util.Arrays;
import java.util.List;

public class RemoveDuplicatesElements {
	public static void main(String[] args) {
		List<Integer> listOfNumber=Arrays.asList(9,8,7,6,5,4,3,2,1,1,2,3,4,5);
		listOfNumber.stream().distinct().forEach(System.out::println);
		
		
		
	listOfNumber.stream().distinct().sorted().forEach(System.out::println);
		
		
		
		
	}

}
