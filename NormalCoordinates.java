package com.example.importfilterlibrary;

import java.util.List;
/**
 * List with all normal coordinates has been calculated
 **/
public class NormalCoordinates extends Coordinates {


    /**
     *
     * @param x - normal coordinate x
     * @param y - normal coordinate y
     * @param z - normal coordinate z
     *          Constructor - creates instans of class normal coordinates (x,y,z,w initialize)
     */
    public NormalCoordinates(float x, float y,float z)
    {
        this.w = 0.0f;
        this.x=x;
        this.y=y;
        this.z=z;
    }

    /**
     *
     * @param nv - list with all vertex coordinates
     * @param begin - start element in the list. Vector coordinates are element in the list
     *             which stand on begin, begin +1  and begin+2 place
     * @return - vector with vertex coordinates has been build
     */
    public float[] buildVector(List<Float> nv, int begin)
    {
        float[] res=new float[3];
        for(int i=0;i<res.length;i++)
        {
            res[i] = nv.get(begin+i);
        }
        return res;
    }

    /**
     *
     * @param vertex1 - one vertex used in calculation
     * @param vertex2 - other vertext used in calculation
     * @return vector v = vertex2 - vertex1
     */
    public float[] getVector(float[] vertex1,float[] vertex2)
    {
        float[] res=new float[3];
        for(int i=0;i<res.length;i++)
        {
            res[i]=vertex2[i]-vertex1[i];
        }
        return res;
    }

    /**
     * Compute the cross product (a vector) of two vectors.
     *
     * @param v0, v1        Vectors to compute cross product between vo[x,y,z] and v1.
     *
     */
    public void computeCrossProductWith(float[] v0, float[] v1) {
        this.x = v0[1] * v1[2] - v0[2] * v1[1];
        this.y = v0[2] * v1[0] - v0[0] * v1[2];
        this.z = v0[0] * v1[1] - v0[1] * v1[0];
   }


}
