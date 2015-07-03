package com.luna.efrain.eshop.util;

/**
 * Created by Efraín on 2015-05-19.
 */
public class Point {
    private double x;
    private double y;

    public double getX() {
        return x;
    }
    public void setX(float x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void setY(float y) {
        this.y = y;
    }
    public static void Point(){};
    public  void Point(double x, double y){
        this.x=x;
        this.y=y;
    }
}
