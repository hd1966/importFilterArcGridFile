package com.example.importfilterlibrary;

import java.util.ArrayList;
import java.util.List;

/**
 * Lists with all vertex and texture coordinates has been calculated
 **/
public class AllVertexTexture {
    //list with all vertex coordinates and list with all texture coordinates + getter/setter
    private List<Float> lv=new ArrayList<Float>();//list med vertex coordinates
    private List<Float> lt=new ArrayList<Float>(); // list med texture coordinates
    private Coordinates[] temp={new VertexCoordinates(0,0,0), new TextureCoordinates(0,0)};

    public List<Float> getLv() {
        return lv;
    }
    public List<Float> getTv() {
        return lt;
    }
    public void setLv(List<Float> lv) {
        this.lv = lv;
    }
    public void setTv(List<Float> tv) {
        this.lt = tv;
    }


    /**
     *
     * @param agc - instans of ArcGridContent
     *            Calculates vertexes and texture coordinates for all triangles (2 triangles = 6 vertexes at the time)
     */
    public void getAllPosition(ArcGridContent agc)
    {
        for(int i=0;i<agc.getnRows()-1;i++)
        {
            for(int j=0;j<agc.getnCols()-1;j++)
            {

                    for (int k = 0; k < temp.length; k++) {
                        temp[k].calculateCoordinates(agc, i, j);
                        fillLists(k);
                        temp[k].calculateCoordinates(agc, i, j + 1);
                        fillLists(k);
                        temp[k].calculateCoordinates(agc, i + 1, j);
                        fillLists(k);
                        temp[k].calculateCoordinates(agc, i+1, j);
                        fillLists(k);
                        temp[k].calculateCoordinates(agc, i, j + 1);
                        fillLists(k);
                        temp[k].calculateCoordinates(agc, i + 1, j+1);
                        fillLists(k);
                    }


            }
        }

    }

    /**
     *
     * @param k - fyll lists (k=0 list with vertex coordinates, k=1 list with texture coordinates
     */
    private void fillLists(int k) {
        if (k == 0)
            lv.addAll(temp[k].getCoord());
        else if (k == 1)
            lt.addAll(temp[k].getCoord());

    }


}
