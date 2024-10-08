/**
 * File:  	    Point.java
 * Author:	    Dylan Brueggeman, Kaan Demirer, Jackson Pender
 * Course:   	    AP Computer Science A
 * Last Modified:    August 2024
 * Description:	    This class has constructors for a default point
 * 		   			and a custom point. These points contain a price
 * 		    		with the data type "double" and a quantity with
 * 		    		with the data type "int." Both the variables
 * 		    		have accessors and mutators. There is 2 equals()
 * 		    		methods, one for objects and one for Points. There
 * 		    		is also a toString() method to return a Point's
 * 		    		data as an ordered pair.
 */

import java.util.ArrayList;


public class Point extends Object
{
    // Declare variables.
    private int    quantity;
    private double price;
    private Point[] pCurve;
    private double[] ProducerCurve;
    static ArrayList<Integer> ProducerCoordinates = new ArrayList<Integer>();


    // Define final static variables.
    final static private double TOLERANCE = 0.01;

    /**
     * Default Point() Constructor.
     */
    public Point()
    {
        quantity = 0;
        price    = 0.0;
    }

    /**
     * Custom Point(int, double) Constructor.
     */
    public Point(int q, double p)
    {
        // Check if negatives or zeros.
        if ((q > 0) && (p > 0.0))
        {
            quantity = q;
            price    = p;
        }

        // If negatives or zeros the warn user of problems.
        else
        {
            System.out.println("Invalid Params Entered, program may"
                    + "break if you continue.");
        }
    }



    /**
     * setQuantity(int) sets the quantity to the int provided.
     */
    public void setQuantity(int q)
    {
        // Check if negatives or zeros.
        if (q > 0)
        {
            quantity = q;
        }

        // If negatives or zeros the warn user of problems.
        else
        {
            System.out.println("Invalid Params Entered, program may"
                    + "break if you continue.");
        }
    }

    /**
     * getQuantity() returns the int quantity.
     */
    public int getQuantity()
    {
        return quantity;
    }

    /**
     * setPrice(double) sets the price to the double provided.
     */
    public void setPrice(double p)
    {
        // Check if negatives or zeros.
        if (p > 0.0)
        {
            price = p;
        }

        // If negatives or zeros the warn user of problems.
        else
        {
            System.out.println("Invalid Params Entered, program may"
                    + "break if you continue.");
        }
    }

    /**
     * getPrice() returns the double price.
     */
    public double getPrice()
    {
        return price;
    }

    /**
     * equals(Object) returns true if the Objects are equal,
     * else it returns false.
     */
    @Override // Overriding equals(Object) method in Java.
    public boolean equals(Object otherObject)
    {
        // If otherObject doesn't exist then return false.
        if (otherObject == null)
        {
            return false;
        }

        // If otherObject's Class is "Point" and then return true.
        if ((otherObject instanceof Point) && (this.equals(otherObject)))
        {
            return true;
        }

        return true;
    }

    /**
     * equals(Point) returns true if the Points quantity and price
     * are within 0.01, else it returns false.
     */
    public boolean equals(Point otherPoint)
    {

        double t = Math.abs(this.price - otherPoint.price);

        if ((t <= TOLERANCE) && (this.quantity == otherPoint.quantity))
        {
            return true;
        }

        // If the above statement is false then return false.
        return false;
    }

    /**
     * The toString() method returns a String containing the Point's
     * price and quantity as an ordered pair.
     */
    @Override // Overriding toString() method of String class.
    public String toString()
    {
        // Round the price and put in format of (price,quantity).
        String stringTemp = "("+quantity+","+(Math.round(price*100)/100)+")";

        return stringTemp;
    }


}
