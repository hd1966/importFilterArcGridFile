package com.example.importfilterlibrary;

public class VertexCoordinates extends Coordinates {

    /**
     *
     * @param x - vertex coordinate x
     * @param y - vertex coordinate y
     * @param z - vertex coordinate z
     *          Constructor - creates instans of class vertex coordinates (x,y,z,w initialize)
     */
    public VertexCoordinates(float x, float y,float z)
    {
        this.w = 1.0f;
        this.x=x;
        this.y=y;
        this.z=z;
    }

    /**
     @param agc - instans av ArcGridContent classen
     @param col - column number
     @param row - row number
     Calculates coordinates x,y,z,w
     **/

    @Override
    public void calculateCoordinates(ArcGridContent agc , int row, int col)
    {
        this.x = col*agc.getCellSize()+ agc.getCellSize()/2;
        this.y = row*agc.getCellSize()+ agc.getCellSize()/2;
        this.z = agc.getHeights()[row*agc.getnCols()+col];
    }



}
