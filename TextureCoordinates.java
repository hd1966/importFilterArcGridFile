package com.example.importfilterlibrary;

import java.util.ArrayList;
import java.util.List;

public class TextureCoordinates extends Coordinates {
    /**
     *
     * @param x - texture coordinate u
     * @param y - texture coordinate v
     *          Constructor - creates instans of class texture coordinates (u,v initialize)
     */
    public TextureCoordinates(float x, float y)
    {
        this.x=x;
        this.y=y;

    }
    /**
     @param agc - instans av ArcGridContent classen
     @param col - column number
     @param row - row number
     Calculates texture coordinates u,v (x,y)
     **/
    @Override
    public void calculateCoordinates(ArcGridContent agc , int row, int col)
    {
        this.x = (float)(col+1)/(float)agc.getnCols();
        this.y = (float)(agc.getnRows()-(row+1))/(float)agc.getnRows();


    }
    /**
     *
     * @return list with Float object(one list element for every texture coordinate)
     */
@Override
    public List<Float> getCoord()
    {
        List<Float> vertexCoord= new ArrayList<Float>();
        vertexCoord.add(new Float(this.x));
        vertexCoord.add(new Float(this.y));
        return vertexCoord;
    }
}
