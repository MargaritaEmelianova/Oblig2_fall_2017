import static org.junit.Assert.*;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;





public class TestBST<E> {
	BST<Integer> tree = new BST <>();


	@Test
	public void TestDelete() {
		Integer [] input = {45, 54, 67, 56, 50, 45, 23, 59, 23, 67};
		Integer[] result = {54, 67, 56, 50, 45, 23, 59, 23, 67};
		tree.delete(45);
		assertThat(input, is(equalTo(result)));
		

	}

}

