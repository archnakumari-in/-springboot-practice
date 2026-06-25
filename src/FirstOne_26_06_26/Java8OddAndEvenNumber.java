package FirstOne_26_06_26;

import java.util.Arrays;
import java.util.List;

public class Java8OddAndEvenNumber {
	
	public static void main(String[] args) {
		List<Integer> listOfNumbers=Arrays.asList(1,3,2,4,5,6,7,7,8,9,10);
		listOfNumbers.stream().filter(n->n%2==0).forEach(System.out::println);
		
	}

}
