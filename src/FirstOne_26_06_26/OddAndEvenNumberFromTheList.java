package FirstOne_26_06_26;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OddAndEvenNumberFromTheList {
	public static void main(String[] args) {
	List<Integer> listOfNumber= Arrays.asList(2,1,4,5,6,7,8,9,8,7,6,5,4,3);
Map<Boolean,List<Integer>> OddAndEvennumber =listOfNumber.stream().collect(Collectors.partitioningBy(i->i%2==0));
	System.out.println(OddAndEvennumber);
	
	}

}
