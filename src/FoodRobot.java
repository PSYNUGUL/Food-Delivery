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
 * This class is used to modify FoodRobot's constructor and methods, and initialize the field values
 * provided.
 */
public class FoodRobot {
  /**
   * x coordinate of FoodRobot.
   */
  private int x;

  /**
   * y coordinate of FoodRobot.
   */
  private int y;

  /**
   * Name of FoodRobot.
   */
  private String name;

  /**
   * Constructs an FoodRobot object with designated position and robotName.
   * 
   * @param x    x coordinate position of robot
   * @param y    y coordinate position of robot
   * @param name name of FoodRobot
   * 
   */
  public FoodRobot(int x, int y, String name) {
    this.x = x;
    this.y = y;
    this.name = name;
  }

  /**
   * Gets x coordinate of FoodRobot.
   * 
   * @return x coordinate position of FoodRobot
   */
  public int getX() {
    return x;
  }

  /**
   * Gets y coordinate of FoodRobot.
   * 
   * @return y coordinate position of FoodRobot
   */
  public int getY() {
    return y;
  }

  /**
   * Gets name of FoodRobot.
   * 
   * @return name of FoodRobot
   */
  public String getName() {
    return name;
  }

  /**
   * Overrides toString() method.
   * 
   * Formats name in name(x,y) format.
   * 
   * @return formatted String
   */
  @Override
  public String toString() {
    return name + "(" + x + "," + y + ")";
  }
}
