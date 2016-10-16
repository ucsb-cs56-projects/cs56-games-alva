package edu.ucsb.cs56.projects.game.alva.Util;

public class Vector2 {
	
	double x, y;
	
	public Vector2() {
		this.x = 0;
		this.y = 0;
	}
	
	public Vector2(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Vector2(Vector2 v) {
		set(v);
	}
	
	public void set(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public void set(Vector2 v) {
		this.set(v.getX(), v.getY());
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public Vector2 add(Vector2 v) {
		this.x += v.getX();
		this.y += v.getY();
		return this;
	}
	
	public Vector2 add(double x, double y) {
		this.x += x;
		this.y += y;
		return this;
	}
	
	public Vector2 sub(Vector2 v) {
		this.x -= v.getX();
		this.y -= v.getY();
		return this;
	}
	
	public Vector2 sub(double x, double y) {
		this.x -= x;
		this.y -= y;
		return this;
	}
	
	public double dot(Vector2 v) {
		return this.x * v.getX() + this.y * v.getY();
	}
	
	public double dot(double x, double y) {
		return this.x * x + this.y * y;
	}
	
	public double distance(Vector2 v) {
		double xd = v.getX() - x;
		double yd = v.getY() - y;
		return Math.sqrt(xd * xd + yd * yd);
	}
	
	public double distance(double x, double y) {
		double xd = x - this.x;
		double yd = y - this.y;
		return Math.sqrt(xd * xd + yd * yd);
	}
	
	public double cross(Vector2 v) {
		return v.getX() * y - v.getY() * x;
	}
	
	public double cross(double x, double y) {
		return x * this.y - y * this.x;
	}
	
	public double angle() {
		double angle = Math.atan2(y, x);
		if(angle < 0)
			angle += 360;
		return angle;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public String toString() {
		return "x: " + x + "\ny: " + y;
	}
	
	public Vector2 cpy() {
		return new Vector2(x, y);
	}
	
	
	

}
