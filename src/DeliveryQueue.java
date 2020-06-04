//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Food Delivery
// Files: Student.java , FoodRobot.java, Delivery.java, DeliveryQueue.java
////////////////
// Course: CS300 Spring 2020
//
// Author: Yeon Jae Cho
// Email: ycho226@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////// PAIR PROGRAMMING (MAY SKIP WHEN WORKING INDIVIDUALLY) ////////////
//
// Partner Name: none
// Partner Email: none
// Partner Lecturer's Name: none
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// ___ Write-up states that pair programming is allowed for this assignment.
// ___ We have both read and understood the course Pair Programming Policy.
// ___ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Students who get help from sources other than their partner and the course
// staff must fully acknowledge and credit those sources here. If you did not
// receive any help of any kind from outside sources, explicitly indicate NONE
// next to each of the labels below.
//
// Persons: none
// Online Sources: just piazza
//
//
///////////////////////////////////////////////////////////////////////////////
import java.util.NoSuchElementException;


/**
 * This class is used to modify DeliveryQueue's constructor and methods, and initialize the field
 * values provided.
 */
public class DeliveryQueue {
  /**
   * Initial capacity of delivery array.
   */
  private static final int INITIAL_CAPACITY = 20;

  /**
   * Heap; Delivery array.
   */
  private Delivery[] heap;

  /**
   * Size of the delivery array.
   */
  private int size;

  /**
   * Constructs an DeliveryQueue object.
   * 
   * Sets Delivery array's capacity to initial capacity and size to 0;
   */
  public DeliveryQueue() {
    heap = new Delivery[INITIAL_CAPACITY];
    size = 0;
  }

  /**
   * Adds a new delivery to this priority queue.
   * 
   * Create a new larger capacity array (twice the previous heap capacity), copy the old arrays
   * contents into this larger array, and then use this array as the heap going forward (until it is
   * filled and replaced with an even larger one) if the heap is already at capacity
   */
  public void offerDelivery(Delivery d) {
    if ((heap.length) == size) {
      Delivery[] temp = new Delivery[heap.length * 2];
      for (int i = 0; i < heap.length; i++) {
        temp[i] = heap[i];
      }
      heap = temp;
    }
    heap[size] = d;
    percolateUp(size);
    size++;
  }

  /**
   * Removes and returns the highest priority delivery object from this priority queue, and also
   * removes all other delivery objects that “equals” (with matching studentIds or robotNames) that
   * highest priority one.
   * 
   * Heapify array to maintain its heap structure after removing.
   * 
   * @throw NoSuchElementException if heap is empty with message: "“Warning: Empty Heap!”
   * @return Delivery object at first position of Delivery array
   */
  public Delivery pollBestDelivery() {
    if (isEmpty()) {
      throw new NoSuchElementException("Warning: Empty Heap!");
    }

    Delivery highestPriority = heap[0]; // highestPriority element is at root
    heap[0] = heap[size - 1]; // swapping the last element and the root
    heap[size - 1] = null; // the root element before swapping will be returned later
    percolateDown(0); // start percolating down from the new root(swapped element)
    size--;
    heapify();
    return highestPriority;

  }

  /**
   * Returns the highest priority delivery without removing.
   * 
   * @throws NoSuchElementException if heap is empty with message: "Warning: Empty Heap!"
   * @return highest priority delivery
   */
  public Delivery peek() {
    if (isEmpty()) {
      throw new NoSuchElementException("Warning: Empty Heap!");
    }
    return heap[0];
  }

  /**
   * Swaps the position of deliveries in heap.
   * 
   * @param first  index of the first delivery to be swapped
   * @param second index of second delivery to be swapped
   */
  private void swap(int first, int second) {
    Delivery indexVal = heap[first];
    heap[first] = heap[second];
    heap[second] = indexVal;
  }

  /**
   * Gets size of the heap.
   * 
   * @return size of heap
   */
  public int getSize() {
    return size;
  }

  /**
   * Orders heap with Percolate Up algorithm.
   * 
   * @param index index of specified delivery
   */
  private void percolateUp(int index) {

    int parentIndex = (index - 1) / 2;

    if (index > 0 && heap[parentIndex] != null && heap[index] != null
        && heap[parentIndex].compareTo(heap[index]) > 0) {
      swap(index, parentIndex);
      percolateUp(parentIndex);
    }

  }

  /**
   * Orders heap with Percolate Down algorithm.
   * 
   * @param index index of specified delivery
   */
  private void percolateDown(int index) {

    int leftChildIndex = (index * 2) + 1;
    if (leftChildIndex < size) {
      int min = leftChildIndex; // set
      int rightChildIndex = leftChildIndex + 1;
      if (heap[leftChildIndex] != null && heap[rightChildIndex] != null) {
        if (rightChildIndex < size && heap[leftChildIndex].compareTo(heap[rightChildIndex]) > 0) {
          min = rightChildIndex;
        }

        if (heap[index].compareTo(heap[min]) > 0) {
          swap(index, min);
          percolateDown(min);
        }
      }
    }
  }

  /*
   * Heapifies an array by percolating down.
   */
  private void heapify() {
    for (int i = size / 2 - 1; i >= 0; i--)
      percolateDown(i);
  }

  /**
   * Determines whether or not the heap is empty.
   * 
   * @return true if heap is empty and false if heap is not empty
   */
  public boolean isEmpty() {
    if (heap[0] == null && size == 0) {
      return true;
    }
    return false;
  }

  /**
   * Overrides toString() method.
   * 
   * Formats String representation of deliveryQueue as "This DeliveryQueue contains " + size + "
   * elements".
   * 
   * @return formatted String
   */
  @Override
  public String toString() {
    String string = "This DeliveryQueue contains " + size + " elements";
    if (size == 0) {
      return string;
    }
    string += ": [ ";
    for (int i = 0; i < size; i++)
      string += "\n" + heap[i].toString();
    string += " ]\n";
    return string;
  }
}
