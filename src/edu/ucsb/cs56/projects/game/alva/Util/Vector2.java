package edu.ucsb.cs56.projects.game.alva.Util;
/** class that defines a Vector2 object, which holds a position and can measure the distance between it and other vectors */
public class Vector2 {
	
	double x, y;
    /** constructor that sets x and y variables to (0,0) */
	public Vector2() {
		this.x = 0;
		this.y = 0;
	}
    /** constructor that sets x and y to the passed parameter
     @param x double value that is the new value for the x instance variable.
    @param y double value that is the new value for the y instance variable.*/
	public Vector2(double x, double y) {
		this.x = x;
		this.y = y;
	}
    /** constructor that sets the values equal to the vector that is passed as a parameter 
     @param v Vector2 object that will be used as the basis for the new Vector2 object being created*/
	public Vector2(Vector2 v) {
		set(v);
	}
    /** sets the value of x and y to the values passed as their respective parameters 
     @param x double value that is the new value for the x instance variable.
    @param y double vlaue that is the new value for the y instance variable.*/
	public void set(double x, double y) {
		this.x = x;
		this.y = y;
	}
    /** sets the value of the vector equal to the value of the vector passed as a parameter 
     @param v Vector2 object whose instance variable values are copied to the new object we're creating
    */
	public void set(Vector2 v) {
		this.set(v.getX(), v.getY());
	}
    /** returns the value of x variable 
     @return returns value of the x instance variable*/
	public double getX() {
		return x;
	}
    /** returns the value of y variable 
     @return returns value of the y instance variable
    */ 
	public double getY() {
		return y;
	}
    /** adds vector v with Vector2 object that called the method
     @param v Vector2 object added with method calling object
    @return Vector2 object whose instance variable */
	public Vector2 add(Vector2 v) {
		this.x += v.getX();
		this.y += v.getY();
		return this;
	}
    /** adds values of x variable and x parameter together, and the same with the y parameter 
     @param x double value that is added to current value of instance variable x
    @param y double value that is added to current value of instance variable y
    @return Vector2 object with new value of variables x and y*/ 
	public Vector2 add(double x, double y) {
		this.x += x;
		this.y += y;
		return this;
	}
    /** subtracts the vector v from the vector object the method is called on 
     @param v Vector2 object subtracted from method calling object
    @return Vector2 object whose instance variables are the original values minus the value of the*/
	public Vector2 sub(Vector2 v) {
		this.x -= v.getX();
		this.y -= v.getY();
		return this;
	}
    /** subtracts this.v - x, and this.y - y, for the new value of x and y, respectively 
     @param x double value that is subtracted from the current value of instance variable x
    @param y double value that is subtracted from the current value of instance variable y 
    @return Vector2 object with new values of variables x and y*/	
	public Vector2 sub(double x, double y) {
		this.x -= x;
		this.y -= y;
		return this;
	}
    /** computes the dot product of this and vector v 
     @param v Vector2 object. The dot product we are calculating is from v and the Vector2 object calling the method
    @return double value which returns the product of the x values of both objects, added together with product of the y values of both objects */
	public double dot(Vector2 v) {
		return this.x * v.getX() + this.y * v.getY();
	}
    /** computes the dot product of this and a vector with x and y values that were passed as parameter 
     @param x double value that represents the x value of another vector object
    @param y double value that represents the y value of another vector object
    @return double value which returns the product of the objects x value and passed value x, and adds this to the product of the objects y value and passed value y*/
	public double dot(double x, double y) {
		return this.x * x + this.y * y;
	}
    /** calculates the distance between this and vector v 
     @param v Vector 2 object that we are measuring the distance from
    @return double value that is the measured distance between the Vector2 object v and the method calling Vector2 object*/
	public double distance(Vector2 v) {
		double xd = v.getX() - x;
		double yd = v.getY() - y;
		return Math.sqrt(xd * xd + yd * yd);
	}
    /** calculates the distance between this and a vector with position(x,y) 
     @param x double value that represents an x coordinate
    @param y double value that represents a y coordinate
    @return double value that is the measured distance between (x,y) and the method calling Vector2 object*/
	public double distance(double x, double y) {
		double xd = x - this.x;
		double yd = y - this.y;
		return Math.sqrt(xd * xd + yd * yd);
	}
    /** calculates the cross product between this and vector v 
     @param v Vector2 object that we are finding the cross product of with the ethod calling object
    @return double value which represents the cross product of v X method calling object */ 
	public double cross(Vector2 v) {
		return v.getX() * y - v.getY() * x;
	}
    /** calculates the cross product between this and a vector with position (x,y)
     @param x double value that represents the x coordinate of a vector
    @param y double value that represents the y coordinate of a vector
    @return double value which represents the cross product of a Vector2 objects with position (x,y) and the method calling object*/
	public double cross(double x, double y) {
		return x * this.y - y * this.x;
	}
    /** calculates angle of the vector 
     @return double value that represents the angle of the vector object*/
	public double angle() {
		double angle = Math.atan2(y, x);
		if(angle < 0)
			angle += 360;
		return angle;
	}
    /** sets the value of variable y to the value passed as a parameter 
     @param y double value which the instance variable y will be set to
    */
	public void setY(double y) {
		this.y = y;
	}
    /** sets the value of variable x to the value passed as a parameter 
     @param x double value which the instance variable x will be set to
    */
	public void setX(double x) {
		this.x = x;
	}
    /** returns a string of "x: (x value)" then new line, then "y: (y value) 
     @return String which shows the x and y instance variable values, along with labels to distinguish the two from each other
    */
	public String toString() {
		return "x: " + x + "\ny: " + y;
	}
    /** copies the value of the vector onto a new vector object 
     @return Vector2 object which is an exact copy of the method calling object
    */
	public Vector2 cpy() {
		return new Vector2(x, y);
	}
	
	
	

}
