import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestTwoWayLinkedList {
	TwoWayLinkedList<String> dll = new TwoWayLinkedList<String>();;
	
	@Test
		public void testNewTwoWayLinkedListEmpty() {
			assertEquals(true, dll.isEmpty());
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
		public void TestIterator(){
			
		}
		}

