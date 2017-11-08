package edu.ucsb.cs56.projects.game.alva.Util;
/** class that defines a Vector2 object, which holds a position and can measure the distance between it and other vectors */
public class Vector2 {
	
	double x, y;
    /** constructor that sets x and y variables to (0,0) */
	public Vector2() {
		this.x = 0;
		this.y = 0;
	}
    /** constructor that sets x and y to the passed parameter*/
	public Vector2(double x, double y) {
		this.x = x;
		this.y = y;
	}
    /** constructor that sets the values equal to the vector that is passed as a parameter */
	public Vector2(Vector2 v) {
		set(v);
	}
    /** sets the value of x and y to the values passed as their respective parameters */
	public void set(double x, double y) {
		this.x = x;
		this.y = y;
	}
    /** sets the value of the vector equal to the value of the vector passed as a parameter */
	public void set(Vector2 v) {
		this.set(v.getX(), v.getY());
	}
    /** returns the value of x variable */
	public double getX() {
		return x;
	}
    /** returns the value of y variable */ 
	public double getY() {
		return y;
	}
    /** adds the vector wit the vector v */
	public Vector2 add(Vector2 v) {
		this.x += v.getX();
		this.y += v.getY();
		return this;
	}
    /** adds values of x variable and x parameter together, and the same with the y parameter */ 
	public Vector2 add(double x, double y) {
		this.x += x;
		this.y += y;
		return this;
	}
    /** subtracts the vector v from the vector object the method is called on */
	public Vector2 sub(Vector2 v) {
		this.x -= v.getX();
		this.y -= v.getY();
		return this;
	}
    /** subtracts this.v - x, and this.y - y, for the new value of x and y, respectively */	
	public Vector2 sub(double x, double y) {
		this.x -= x;
		this.y -= y;
		return this;
	}
    /** computes the dot product of this and vector v */
	public double dot(Vector2 v) {
		return this.x * v.getX() + this.y * v.getY();
	}
    /** computes the dot product of this and a vector with x and y values that were passed as parameter */
	public double dot(double x, double y) {
		return this.x * x + this.y * y;
	}
    /** calculates the distance between this and vector v */
	public double distance(Vector2 v) {
		double xd = v.getX() - x;
		double yd = v.getY() - y;
		return Math.sqrt(xd * xd + yd * yd);
	}
    /** calculates the distance between this and a vector with position(x,y) */
	public double distance(double x, double y) {
		double xd = x - this.x;
		double yd = y - this.y;
		return Math.sqrt(xd * xd + yd * yd);
	}
    /** calculates the cross product between this and vector v */ 
	public double cross(Vector2 v) {
		return v.getX() * y - v.getY() * x;
	}
    /** calculates the cross product between this and a vector with position (x,y)*/
	public double cross(double x, double y) {
		return x * this.y - y * this.x;
	}
    /** calculates angle of the vector */
	public double angle() {
		double angle = Math.atan2(y, x);
		if(angle < 0)
			angle += 360;
		return angle;
	}
    /** sets the value of variable y to the value passed as a parameter */
	public void setY(double y) {
		this.y = y;
	}
    /** sets the value of variable x to the value passed as a parameter */
	public void setX(double x) {
		this.x = x;
	}
    /** returns a string of "x: (x value)" then new line, then "y: (y value) */
	public String toString() {
		return "x: " + x + "\ny: " + y;
	}
    /** copies the value of the vector onto a new vector object */
	public Vector2 cpy() {
		return new Vector2(x, y);
	}
	
	
	

}
