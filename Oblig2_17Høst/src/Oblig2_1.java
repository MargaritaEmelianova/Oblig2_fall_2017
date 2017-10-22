import java.util.Iterator;
import java.util.ListIterator;

public class Oblig2_1{
	  public static void main(String[] args) {
		    TwoWayLinkedList<String> list = new TwoWayLinkedList<String>();
		    list.add("Canada");
		    list.add("Russia");
		    list.add("USA");
		    list.add("Norway");

		    Iterator<String> iterator = list.iterator();
		    iterator.next();
		    iterator.next();
		    iterator.next();


		    while (((ListIterator<String>) iterator).hasPrevious())
		      System.out.print(((ListIterator<String>) iterator).previous() + " ");
		  }
 
  }
class  TwoWayLinkedList<E> extends  java.util.AbstractSequentialList<E> {

	private int size;
	private Node<E> head, tail;

	public  TwoWayLinkedList() {
	}

	public TwoWayLinkedList(E[] objects) {
		   for (E e : objects)
		        add(e);
		    }
	

	public E getFirst() {
		if (size == 0) {
			return null;
		} else {
			return head.element;
		}
	}

	public E getLast() {
		if (size == 0) {
			return null;
		} else {
			return tail.element;
		}
	}

	public void addFirst(E e) {
		Node<E> newNode = new Node<E>(e);
		newNode.next = head;
		head = newNode;
		size++; 

		if (tail == null) 
			tail = head;
		
		if(head!=tail)
			head.next.previous = head;
	}

	
	public void addLast(E e) {
		Node<E> newNode = new Node<E>(e); 

	    Node<E> temp = tail; 
	    
		if (tail == null) {
			head = tail = newNode; 
		} else {
			tail.next = newNode; 
			newNode.previous = tail;
			tail = tail.next; 
		}

		size++;
		
		  tail.previous = temp; 
	}

	 
	public void add(int index, E e) {
		if (index == 0) {
			addFirst(e);
		} else if (index >= size) {
			addLast(e);
		} else {
			Node<E> current = head;
			for (int i = 1; i < index; i++) {
				current = current.next;
			}
			Node<E> temp = current.next;
			current.next = new Node<E>(e);
			(current.next).next = temp;
			size++;
			
			temp.previous = current.next; 
	        current.next.previous = current;
	      }
		}
	

	public E removeFirst() {
		if (size == 0) {
			return null;
		} else {
			Node<E> temp = head;
			head = head.next;
			size--;
			if (head == null) {
				tail = null;
			} 
			return temp.element;
		}
	}

	public E removeLast() {
		if (size == 0) {
			return null;
		} else if (size == 1) {
			Node<E> temp = head;
			head = tail = null;
			size = 0;
			return temp.element;
		} else {
			Node<E>current = head;
			for (int i = 0; i < size -2; i++){
				current=current.next;
			}
			
			Node<E> temp = tail;
			tail = current;
			tail.next = null;
			size--;
			return temp.element;
		}
	}

	@Override
	public E remove(int index) {
		if (index < 0 || index >= size) {
			return null;
		} else if (index == 0) {
			return removeFirst();
		} else if (index == size - 1) {
			return removeLast();
		} else {
			Node<E> previous = head;

			for (int i = 1; i < index; i++) {
				previous = previous.next;
			}

			Node<E> current = previous.next;
			previous.next = current.next;
			previous.next.previous = previous;
			size--;
			return current.element;
		}
	}

	@Override 
	public String toString() {
		StringBuilder result = new StringBuilder("[");

		Node<E> current = head;
		for (int i = 0; i < size; i++) {
			result.append(current.element);
			current = current.next;
			if (current != null) {
				result.append(", "); 
			} else {
				result.append("]"); 
			}
		}

		return result.toString();
	}



	public java.util.ListIterator<E> iterator() {
		return new LinkedListIterator<E>();
	}

	
	private class LinkedListIterator<E> implements java.util.ListIterator<E> {
		private Node<E> current = (Node<E>) head; 

        
        public LinkedListIterator() {
        }
        public LinkedListIterator(int index) {
            if (index < 0 || index > size)
              throw new IndexOutOfBoundsException("Index: " + index + "out of bound");
            for (int nextIndex = 0; nextIndex < index; nextIndex++)
              current = current.next;
          }
		@Override
		public boolean hasNext() {
			return (current != null);
		}
		
		public E next() {
			E e = current.element;
			current = current.next;
			return e;
		}

		public boolean hasPrevious() {
			return current !=head;
		}

		public E previous() {
		        E result = current.element;
		        current = current.previous;
		        return result;
		    }
		   
		@Override
		public void remove() {
			if (current != null) {
				Node<E> temp = current;
				current = current.next;
				size--;
				if (temp.next != null)
					temp.next.previous = temp.previous;
				if (temp.previous != null)
					temp.previous.next = temp.next;
			}

		}
		@Override
		public int nextIndex() {
			// TODO Auto-generated method stub
			return 0;
		}
		@Override
		public int previousIndex() {
			// TODO Auto-generated method stub
			return 0;
		}
		@Override
		public void set(E e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void add(E e) {
			// TODO Auto-generated method stub
			
		}
	}

	static class Node<E> {
		E element;
		Node<E> next;
		Node<E> previous;

		public Node(E e) {
			element = e;
		}
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		  return new LinkedListIterator<E>(index); 
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

}
