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
/**
 * This class is used to modify Student's constructor and methods, and initialize the field values
 * provided.
 */
public class Student {
  /**
   * x coordinate of Student object.
   */
  private int x;

  /**
   * y coordinate of Student object.
   */
  private int y;

  /**
   * unique number for student.
   */
  private int id;

  /**
   * Constructs student object with the designated capacity, and location.
   * 
   * @param x  x coordinate of student
   * @param y  y coordinate of student
   * @param id student id number
   */
  public Student(int x, int y, int id) {
    this.x = x;
    this.y = y;
    this.id = id;
  }

  /**
   * Gets x coordinate of Student.
   * 
   * @return x coordinate of Student
   */
  public int getX() {
    return x;
  }

  /**
   * Gets y coordinate of Student.
   * 
   * @return y coordinate of Student
   */
  public int getY() {
    return y;
  }

  /**
   * Gets id of Student.
   * 
   * @return id of Student
   */
  public int getId() {
    return id;
  }

  /**
   * Overrides toString() method.
   * 
   * Formats string representation of Student object in id(x,y) format.
   * 
   * @return formatted String
   */
  @Override
  public String toString() {
    String format = id + "(" + x + "," + y + ")";
    return format;
  }
}
