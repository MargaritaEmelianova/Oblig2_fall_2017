import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.List;
import java.util.ListIterator;

import org.junit.Before;
import org.junit.Test;

public class TestTwoWayLinkedList {

	TwoWayLinkedList<String> dll = new TwoWayLinkedList<String>();
	
	
	@Test
		public void testNewTwoWayLinkedListEmpty() {
			assertTrue(dll.isEmpty());
			//assetEquals(0,dll.size());
		
		}

		@Test
		public void  TestAddFirst(){
			dll.addFirst("Canada");
			assertEquals("Canada", dll.getFirst());
			


		}
		
		@Test
		public void TestAddLast(){
			
			dll.addLast("Oslo");
			assertEquals("Oslo", dll.getLast());

		}
		@Test
		public void TestAddElementAtSpesificIndex(){
			dll.add(0, "Jarkhan");
			assertThat(dll.get(0), is ("Jarkhan"));
		
		}
		@Test
		public void TestRemoveElementAtSpecifiedIndex(){
			dll.remove(1);
			assertEquals(dll.get(1), dll.remove(0) );
		}
		
		@Test
		public void TestIterarHasNext(){
			ListIterator<String> iterator = dll.iterator();
			assertTrue(iterator.hasNext());
			assertEquals("Canada", iterator.next());
			
		}
		@Test
		public void TestIterarHasPrevios(){
			ListIterator<String> iterator = dll.iterator();
			assertTrue(iterator.hasPrevious());
			assertEquals("Oslo", iterator.previous());
		}

}