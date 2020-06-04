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
 * This class implements Comparable<T> with type of Delivery.
 * 
 * This class is used to modify Delivery's constructor and methods, and initialize the field values
 * provided.
 */
public class Delivery implements Comparable<Delivery> {
  /**
   * id of Student
   */
  private int studentId;
  /**
   * name of FoodRobot
   */
  private String robotName;

  /**
   * Manhattan distance between positions of its Student and FoodRobot.
   */
  private int distance;

  /**
   * Constructs an Delivery object with designated studentId, robotName, and distance
   * 
   * @param person student object
   * @param robot  robot object
   */
  public Delivery(Student person, FoodRobot robot) {
    this.studentId = person.getId();
    this.robotName = robot.getName();
    this.distance = Math.abs(robot.getX() - person.getX()) + Math.abs(robot.getY() - person.getY());
  }

  /**
   * Overrides equals() method
   * 
   * Determines whether or not the object is equal based on the type of objects.
   * 
   * @param type type of object passed
   * @return true when object is equal to the other object and false otherwise
   */
  @Override
  public boolean equals(Object type) {
    if (type instanceof Student) {
      if (studentId == ((Student) type).getId()) {
        return true;
      }
    }

    if (type instanceof FoodRobot) {
      if (((FoodRobot) type).getName() != null && this.robotName != null) {
        if (this.robotName.compareTo(((FoodRobot) type).getName()) == 0) {
          return true;
        }
      }
    }

    if (type instanceof Delivery) {
      if (this.studentId == ((Delivery) type).studentId) {
        return true;
      } else if (((Delivery) type) != null && this.robotName != null) {
        if (this.robotName.compareTo(((Delivery) type).robotName) == 0) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * Overrides toString() method.
   * 
   * Formats String in the format "The distance between (studentId) and (robotName) is (distance)".
   * 
   * @return formatted String
   */
  @Override
  public String toString() {
    return "The distance between " + studentId + " and " + robotName + " is " + distance;
  }

  /**
   * Overrides compareTo() method.
   * 
   * Determine whether or not a Delivery object's priority is less than or greater than the other
   * Delivery object.
   * 
   * @return negative integer if Delivery object's priority is less or positive integer if greater
   *         than the specified Delivery object.
   */
  @Override
  public int compareTo(Delivery o) {
    if (o.distance < distance) {
      return 1;
    } else if (o.distance > distance) {
      return -1;
    }
    if (o.studentId < studentId) {
      return 1;
    } else if (o.studentId > studentId) {
      return -1;
    }
    if (o.robotName != null && robotName != null) {
      if (robotName.compareTo(o.robotName) < 0) {
        return -1;
      }
    }
    return 1;
  }
}

