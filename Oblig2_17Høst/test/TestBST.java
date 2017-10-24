import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;





public class TestBST<E> {
	Integer [] input = {45, 54, 67, 56, 50, 45, 23, 59, 23, 67};
	ArrayList<Integer> list = new ArrayList<>(Arrays.asList(input));
	
   
	@Test
	public void TestDelete() {
		Integer [] input = {45, 54, 67, 56, 50, 45, 23, 59, 23, 67};
		Integer[] result = {54, 67, 56, 50, 45, 23, 59, 23, 67};
	    list.remove(45);
		assertNotSame(result, input);
		

	}
	@Test
	public void TestInsert() {
		Integer [] input = {45, 54, 67, 56, 50, 45, 23, 59, 23, 67};
		Integer[] result = {45, 43, 54, 67, 56, 50, 45, 23, 59, 23, 67};
		list.add(43);
		assertNotSame(input, result);
}
}
