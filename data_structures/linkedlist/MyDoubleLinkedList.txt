import java.util.*;

public class MyDoubleLinkedList<E extends Comparable<E>>  {
	
   private Node<E> head, tail;
   private int size;

	    /** Create a default list */
   public MyDoubleLinkedList() 
   {
      this.head = null;
      this.tail = null;
      size = 0;
   }

	    /** Create a list from an array of objects */
   @SuppressWarnings("unchecked")
   public MyDoubleLinkedList(E[] objects) 
   {
      Node<E> newnode = new Node<E>(objects[0]);
      head = newnode;
      tail = head;
      size = 1;

      for(int i = 1; i < objects.length; i++)
      {
         Node<E> current = new Node<E>(objects[i]);
         tail.next = current;
         current.previous = tail;
         tail = current; 
         size++;
      } 
   }

	    /** Return the head element in the list */
   public E getFirst() 
   {
      if (size == 0) 
      {
         return null;
      } 
      else 
      {
         return head.element;
      }
   }

	    /** Return the last element in the list */
   public E getLast() 
   {
      if (size == 0) 
      {
         return null;
      } 
      else 
      {
         return tail.element;
      }
   }

	    /** Add an element to the beginning of the list */
   public void addFirst(E e) {
      Node<E> newNode = new Node<E>(e); // Create a new node
      newNode.next = head; // link the new node with the head
      head = newNode; // head points to the new node
      size++; // Increase list size
   
      if (tail == null) // the new node is the only node in list
         tail = head;
   
      if (head != tail)
         head.next.previous = head; // For a two-way linked list
   }

	    /** Add an element to the end of the list */
   public void addLast(E e) {
      Node<E> newNode = new Node<E>(e); // Create a new for element e
   
      if (tail == null) {
         head = newNode; // The new node is the only node in list
         tail = newNode;
         size++;
      } else {
         tail.next = newNode;
         newNode.previous = tail;
         tail = newNode;
         size++;
      }
   }

	    /**
	     * Add a new element at the specified index in this list The index of the
	     * head element is 0
	     */
   public void add(int index, E e) {
     // "Implementation left as an exercise";
     int count = 0;

     if(index == 0)
     {
        addFirst(e);
     }
     else if(index == size)
     {
         addLast(e);
     }
     else 
     {
        Node<E> current = head;
        while(count < index)
        {
           current = current.next;
           count++;
        }

        Node<E> newNode = new Node<>(e);
        Node<E> temp = current;
        newNode.next = current.next;
        newNode.previous = temp;
        current.next = newNode;
        current.next.previous = newNode;
        size++;

        Node<E> trailer = head;
        while(trailer != null)
        {
           tail = trailer;
           trailer = trailer.next;
        }
     }	  
   }
	    
	    /** Add a new element at the specified index in this list in ascending order */
   public void addInOrder(E e) {
      // "Implementation left as an exercise";
      if(head == null)
      {
         Node<E> newNode = new Node<>(e);
         head = newNode;
         tail = head;
         size++;
      }
      else 
      {
         Node<E> current = head;
         while(current.element.compareTo(e) < 0)
         {
            current = current.next;
         }

         Node<E> newNode = new Node<>(e);
         Node<E> temp = current;
         newNode.next = temp.next;
         newNode.previous = temp;
         current.next = newNode;
         current.next.previous = newNode;
         size++;

         Node<E> trailer = head;
         while(trailer != null)
         {
            tail = trailer;
            trailer = trailer.next;
         }
      }	  
   }
	    
	    /** Return true if this list contains no elements */
   public  boolean isEmpty() {
      return size() == 0;
   }

	    /** Check to see if this list contains element e */
   public boolean contains(E e) {
     	  // "Implementation left as an exercise";
         Node<E> current = head;

         while(current != null)
         {
            if((current.element).compareTo(e) == 0)
            {
               return true;
            }
            else
            {
               current = current.next;
            }
         }
         return false;
   }

	    /**
	     * Remove the head node and return the object that is contained in the
	     * removed node.
	     */
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

	    /**
	     * Remove the last node and return the object that is contained in the
	     * removed node.
	     */
   public E removeLast() {
      if (size == 0) 
      {
         return null;
      } 
      else if (size == 1) 
      {
         Node<E> temp = head;
         head = tail = null;
         size = 0;
         return temp.element;
      } 
      else 
      {
         Node<E> current = head;
      
         while(!(current.equals(tail)))
         {
            current = current.next;
         }
      
         Node<E> temp = tail;
         tail = current.previous;
         tail.next = null;
         size--;
         return temp.element;
      }
   }

	    /**
	     * Remove the element at the specified position in this list. Return the
	     * element that was removed from the list.
	     */
   public E remove(int index) {
      // "Implementation left as an exercise";
      if(index == 0)
      {
         E temp = get(index);
         removeFirst();
         return temp;
      }
      else if(index == (size - 1))
      {
         E temp = get(index);
         removeLast();
         return temp;
      }
      else
      {
         Node<E> current = head;
         E temp = get(index);
         int count = 0;

         while(count < index)
         {
            current = current.next;
            count++;
         }

         current.previous.next = current.next;
         current.next.previous = current.previous;
         current.next = null;
         current.previous = null;
         size--;

         return temp;
      }
   }
	    
	    /** Remove the first occurrence of the element e 
	     *  from this list. Return true if the element is removed. */
   public boolean remove(E e)
   {
      	  // "Implementation left as an exercise";
         Node<E> current = head;

            if(head.element == e)
            {
               removeFirst();
               return true;
            }
            else if(tail.element == e)
            {
               if(!(indexOf(e) < (size - 1)))
               {
                  removeLast();
                  return true;
               }
               else
               {
                  while(!(current.element.equals(e)))
               {  
                  if(current.next == null)
                  {
                     return false;
                  }
                  else
                  {
                     current = current.next;
                  }
               }

               current.previous.next = current.next;
               current.next.previous = current.previous;
               current.next = null;
               current.previous = null;
               size--;

               return true;
               }
            }
            else
            {
               while(!(current.element.equals(e)))
               {  
                  if(current.next == null)
                  {
                     return false;
                  }
                  else
                  {
                     current = current.next;
                  }
               }

               current.previous.next = current.next;
               current.next.previous = current.previous;
               current.next = null;
               current.previous = null;
               size--;

               return true;
            }
   }
	    
	     /** Return the length of this list using recursion */
   public int getLength() 
   {
      return getLengthHelper(head);
   }

   public int getLengthHelper(Node<E> node)
   {
      if(node == null)
      {
         return 0;
      }
      else
      {
         return 1 + getLengthHelper(node.next);
      }
   }
	     
      

   @Override
   public String toString() 
   {
      StringBuilder result = new StringBuilder("[");
   
      Node<E> current = head;
      for (int i = 0; i < size; i++) {
         result.append(current.element);
         current = current.next;
         if (current != null) {
            result.append(", "); // Separate two elements with a comma
         } else {
            result.append("]"); // Insert the closing ] in the string
         }
      }
   
      return result.toString();
   }
	    
	    /** Print the list in reverse order */
   public void printReverse() {
      Node<E> current = tail;

      System.out.print("[");

      while (current != null)
      {
         if(current.equals(head))
         {
            System.out.print(current.element);
            current = current.previous;
         }
         else
         {
            System.out.print(current.element + ", ");
            current = current.previous;
         }
      }

      System.out.print("]");
   }
	    
	    /** Print this list using recursion */
   public void printList() {
      System.out.print("[");

     	printListHelper(head);

      System.out.print("]");
   }

   public void printListHelper(Node<E> node)
   {
      if(node.equals(tail))
      {
         System.out.print(node.element);

         if(node.next == null)
         {
            return;
         }
         else
         {
            printListHelper(node.next);
         }
      }
      else
      {
         System.out.print(node.element + ", ");
         
         if(node.next == null)
         {
            return;
         }
         else
         {
            printListHelper(node.next);
         }
      }
   }
	    
      
	    /** Clear the list */
   public void clear() {
      head = tail = null;
   }

	  

	    /** Return the element from this list at the specified index */
   public E get(int index) {
        // "Implementation left as an exercise"
        Node<E> current = head;
        int count = 0;

        if(index == 0)
        {
            return head.element;
        }
        else if(index == (size - 1))
        {
            return tail.element;
        }
        else
        {
            while(count < index)
            {
               current = current.next;
               count++;
            }

            return current.element;
        }


   }

	    /**
	     * Return the index of the head matching element in this list. Return -1 if
	     * no match.
	     */
   public int indexOf(Object e) {
        // "Implementation left as an exercise"
      Node<E> current = head;
      int index = 0;
      while(!(current.element.equals(e)))
      {  
         if(current.element == null)
         {
            return -1;
         }
         else
         {
            current = current.next;
            index++;
         }
      }

      return index;
   }

	    /**
	     * Return the index of the last matching element in this list Return -1 if
	     * no match.
	     */
   public int lastIndexOf(Object e) {
        // "Implementation left as an exercise";
        Node<E> current = tail;
        int index = size - 1;
        while(!(current.element.equals(e)))
        {  
           if(current.element == null)
           {
              return -1;
           }
           else
           {
              current = current.previous;
              index--;
           }
        }
  
        return index;
   }

	    /**
	     * Replace the element at the specified position in this list with the
	     * specified element.
	     */
   public E set(int index, E e) {
      if(index == 0)
      {  
         Node<E> temp = head;
         head.element = e;
         return temp.element;
      }
      else if(index >= size)
      {
         return null;
      }
      else
      {
         Node<E> current = head;
         Node<E> temp = current;

         for (int i = 0; i < index; i++)
         {
            current = current.next;
         }

         current.element = e;
         return temp.element;
      }
   }

	    
   public class Node<T> {
      T element;
      Node<T> next;
      Node<T> previous;
   
      public Node(T o) {
         element = o;
      }
   }

   public int size() {
      return size;
   }

	    /** Split the original list in half. The original     
	     * list will continue to reference the 
	     * front half of the original list and the method 
	     * returns a reference to a new list that stores the 
	     * back half of the original list. If the number of 
	     * elements is odd, the extra element should remain 
	     * with the front half of the list. */
   public MyDoubleLinkedList<E> split(){
          // "Implementation left as an exercise";

      MyDoubleLinkedList<E> list2 = new MyDoubleLinkedList<>();
      int index = 0;
      int count = 0;
      Node<E> current = head;


      if(size % 2 == 0)
      {
         index =  (size / 2) - 1;
      }
      else if(size % 2 == 1)
      {
         index = (size / 2);
      }

      int backRem = size - 1;
      int sepLength = backRem - index;

      while(count <= index){
         current = current.next;
         count++;
      }

      for(int i = 0; i < sepLength; i++)
      {  
         list2.add(i, current.element);
         current = current.next;
      }

      for(int j = index + 1; j < size; j = index + 1)
      {
         remove(j);
      }

      return list2;
   }

}
	
