package com.example.importfilterlibrary;

import java.util.ArrayList;
import java.util.List;
/*
Abstract class för coordinates
 */
public abstract class Coordinates {
    //four coordinates + getters/setters
    protected float x;
    protected float y;
    protected float z;
    protected float w;

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public float getW() {
        return w;
    }

    public void setW(float w) {
        this.w = w;
    }
/**
 @param agc - instans av ArcGridContent classen
 @param col - column number
 @param row - row number
 Calculates coordinates x,y,z,w
 **/
    public void calculateCoordinates(ArcGridContent agc , int row, int col)
    {

    }

    /**
     *
     * @return list with Float (one list element for every coordinate)
     */
    public List<Float> getCoord()
    {
        List<Float> vertexCoord= new ArrayList<Float>();
        vertexCoord.add(new Float(this.x));
        vertexCoord.add(new Float(this.y));
        vertexCoord.add(new Float(this.z));
        vertexCoord.add(new Float(this.w));
        return vertexCoord;
    }

}
