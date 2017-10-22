import java.util.ArrayList;
import java.util.Scanner;

public class Oblig2_2 {

	 public static void main(String[] args) {
		
	
		    Scanner input = new Scanner(System.in);
		    BST<Integer> tree = new BST<>();
		    
		    int[] list = new int[10];
		    System.out.print("Enter 10 integers: ");
		    for (int i = 0; i < list.length; i++) {
		      tree.insert(list[i] = input.nextInt());
		    }
		    input.close();
		    tree.delete(45);
		    
		    for (int i = 0; i < list.length; i++) {
		      if (tree.isLeaf(list[i])) {
		        System.out.println(tree.getPath(list[i]));
		      }
		    }
		  }
		  
		  public static class BST<E extends Comparable<E>>
		      extends AbstractTree<E> {
		    protected TreeNode<E> root;
		    protected int size = 0;

		    public BST() {
		    }

		
		    public BST(E[] objects) {
		      for (int i = 0; i < objects.length; i++) {
		        insert(objects[i]);
		      }
		    }

		    @Override
		  
		    public boolean search(E e) {
		      TreeNode<E> current = root; 

		      while (current != null) {
		        if (e.compareTo(current.element) < 0) {
		          current = current.left;
		        } 
		        else if (e.compareTo(current.element) > 0) {
		          current = current.right;
		        } 
		        else  { 
		          return true; 
		        }
		      }

		      return false;
		    }

		    @Override
		    
		    public boolean insert(E e) {
		      if (root == null) {
		        root = createNewNode(e); 
		      } else {
		        TreeNode<E> parent = null;
		        TreeNode<E> current = root;
		        while (current != null) {
		          if (e.compareTo(current.element) < 0) {
		            parent = current;
		            current = current.left;
		          } else if (e.compareTo(current.element) > 0) {
		            parent = current;
		            current = current.right;
		          } else {
		            return false; 
		          }
		        }
		        if (e.compareTo(parent.element) < 0) {
		          parent.left = createNewNode(e);
		          parent.left.parent = parent;
		        } else {
		          parent.right = createNewNode(e);
		          parent.right.parent = parent;
		        }
		      }

		      size++;
		      return true; 
		    }

		    protected TreeNode<E> createNewNode(E e) {
		      return new TreeNode<E>(e);
		    }

		    @Override
		    
		    public void inorder() {
		      inorder(root);
		    }

		    protected void inorder(TreeNode<E> root) {
		      if (root == null) {
		        return;
		      }
		      inorder(root.left);
		      System.out.print(root.element + " ");
		      inorder(root.right);
		    }

		    @Override
		  
		    public void postorder() {
		      postorder(root);
		    }

		    protected void postorder(TreeNode<E> root) {
		      if (root == null) {
		        return;
		      }
		      postorder(root.left);
		      postorder(root.right);
		      System.out.print(root.element + " ");
		    }

		    @Override
		
		    public void preorder() {
		      preorder(root);
		    }

		    
		    protected void preorder(TreeNode<E> root) {
		      if (root == null) {
		        return;
		      }
		      System.out.print(root.element + " ");
		      preorder(root.left);
		      preorder(root.right);
		    }

		    public static class TreeNode<E extends Comparable<E>> {
		      protected E element;
		      protected TreeNode<E> left;
		      protected TreeNode<E> right;
		      protected TreeNode<E> parent;

		      public TreeNode(E e) {
		        element = e;
		      }
		    }

		    @Override
		 
		    public int getSize() {
		      return size;
		    }


		    public TreeNode<E> getRoot() {
		      return root;
		    }

		    public java.util.ArrayList<TreeNode<E>> path(E e) {
		      java.util.ArrayList<TreeNode<E>> list
		              = new java.util.ArrayList<>();
		      TreeNode<E> current = root; 

		      while (current != null) {
		        list.add(current); 
		        if (e.compareTo(current.element) < 0) {
		          current = current.left;
		        } else if (e.compareTo(current.element) > 0) {
		          current = current.right;
		        } else {
		          break;
		        }
		      }

		      return list;
		    }

		    @Override
		    
		    public boolean delete(E e) {
		      TreeNode<E> parent = null;
		      TreeNode<E> current = root;
		      while (current != null) {
		        if (e.compareTo(current.element) < 0) {
		          parent = current;
		          current = current.left;
		        } else if (e.compareTo(current.element) > 0) {
		          parent = current;
		          current = current.right;
		        } else {
		          break; 
		        }
		      }

		      if (current == null) {
		        return false; 
		      }
		     
		      if (current.left == null) {
		      
		        if (parent == null) {
		          root = current.right;
		          root.parent = null;
		        } 
		        else {
		          if (e.compareTo(parent.element) < 0) {
		            parent.left = current.right;
		          } 
		          else {
		            parent.right = current.right;
		          }
		          current.right.parent = parent;
		        }
		      } 
		      else {
		    
		        TreeNode<E> parentOfRightMost = current;
		        TreeNode<E> rightMost = current.left;

		        while (rightMost.right != null) {
		          parentOfRightMost = rightMost;
		          rightMost = rightMost.right; 
		        }
 
		        current.element = rightMost.element;

		        
		        if (parentOfRightMost.right == rightMost) {
		          parentOfRightMost.right = rightMost.left;
		        } 
		        else { 
		          parentOfRightMost.left = rightMost.left;
		        }
		        
		        if (rightMost.left != null) {
		          rightMost.left.parent = parentOfRightMost;
		        }
		      }

		      size--;
		      return true; 
		    }

		    @Override
		  
		     
		    public java.util.Iterator<E> iterator() {
		      return new InorderIterator();
		    }

		    private class InorderIterator implements java.util.Iterator<E> {
		   

		      private ArrayList<E> list
		              = new ArrayList<E>();
		      private int current = 0; 

		      public InorderIterator() {
		        inorder(); 
		      }

		      private void inorder() {
		        inorder(root);
		      }

		     
		      private void inorder(TreeNode<E> root) {
		        if (root == null) {
		          return;
		        }
		        inorder(root.left);
		        list.add(root.element);
		        inorder(root.right);
		      }

		      @Override
		      
		      public boolean hasNext() {
		        if (current < list.size()) {
		          return true;
		        }

		        return false;
		      }

		      @Override
		     
		      public E next() {
		        return list.get(current++);
		      }

		      @Override
		      
		      public void remove() {
		        delete(list.get(current)); 
		        list.clear();
		        inorder(); 
		      }
		    }

		    
		    public void clear() {
		      root = null;
		      size = 0;
		    }
		
		    private TreeNode<E> getNode(E e) {
		      TreeNode<E> current = root; 

		      while (current != null) {
		        if (e.compareTo(current.element) < 0) {
		          current = current.left;
		        } 
		        else if (e.compareTo(current.element) > 0) {
		          current = current.right;
		        } 
		        else  { 
		          return current; 
		        }
		      }

		      return null;
		    }

		    
		    private boolean isLeaf(E element) {
		      TreeNode<E> node = getNode(element);
		      
		      return node != null && node.left == null && node.right == null;
		    }

		    
		    public ArrayList<E> getPath(E e) {
		      TreeNode<E> temp = getNode(e);
		      ArrayList<E> list = new ArrayList<>();
		      while (temp != null) {
		        list.add(temp.element);
		        temp = temp.parent;
		      }
		      return list;
		    }
		  }
		}
