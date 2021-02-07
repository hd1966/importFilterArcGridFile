package com.example.importfilterlibrary;

import java.util.ArrayList;
import java.util.List;

public class AllNormalVectors {
    //list with all normal coordinates + getter/setter
    private List<Float> nv=new ArrayList<Float>();

    public List<Float> getNv() {
        return nv;
    }

    public void setNv(List<Float> nv) {
        this.nv = nv;
    }


    /**
     *
     * @param agc - instans of ArcGridContent
     * @param vp - list with all vertexes
     */
    public void getAllNormals(ArcGridContent agc, List<Float> vp)
    {
        //12 - triangle with 3 vertexes and 12 coordinates
        for(int i=0;i<vp.size();i+=12)
        {
            //three points a, b,c = corner of triangle, v0 = ab  v1 = ac
            NormalCoordinates temp=new NormalCoordinates(0.0f,0.0f,0.0f);
            // build three vectors for 3 points of the triangles (a,b,c)
            float[] a =temp.buildVector(vp,i);
            float[] b =temp.buildVector(vp,i+4);
            float[] c =temp.buildVector(vp,i+8);
            //calculate vectors ab and ac
            float[] v0= temp.getVector(a,b);
            float[] v1= temp.getVector(a,c);
            //calculate cross product
            temp.computeCrossProductWith(v0, v1);
            List<Float> result= temp.getCoord();
            for(int j=0;j<3;j++) // triangle = three points
                nv.addAll(result);


        }
    }







}
