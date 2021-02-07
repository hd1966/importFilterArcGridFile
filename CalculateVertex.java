package com.example.importfilterlibrary;

import android.content.Context;

public class CalculateVertex {
    //instans of filterloader class + getter/setter
    private FilterLoader fl=new FilterLoader();
    //float array with vertex, normal and texture coordinates + getter/setter
    private float[] allVerticesData;
    public FilterLoader getFl() {
        return fl;
    }

    public void setFl(FilterLoader fl) {
        this.fl = fl;
    }

    public float[] getAllVerticesData() {
        return allVerticesData;
    }

    public void setAllVerticesData(float[] allVerticesData) {
        this.allVerticesData = allVerticesData;
    }

    /**
     *
     * @param resourceId - resource Id of the esri grid file (arc grid ascii file)
     * @param c - content
     * @param vsize - size for one vertex = vertex coordinates + normal coordinates + texture coordinates
     * @return "None" = no error, "Invalid format" = some error in file format, "Wrong number of elements in array heights"
     */
    public String calculateAllData(int resourceId, Context c,int vsize)
    {
        fl.loadArcGrid(resourceId,c);
        AllVertexTexture av= new AllVertexTexture();
        if(fl.getErrorType().equals("None")) {
            av.getAllPosition(fl.getAgc());
            AllNormalVectors an = new AllNormalVectors();
            an.getAllNormals(fl.getAgc(), av.getLv());
            this.allVerticesData=new float[av.getLv().size() + av.getTv().size() + an.getNv().size()];
            int l = 0;
            int m = 0;
            for (int i = 0; i < allVerticesData.length; i += vsize) {
                for (int j = 0; j < 4; j++) {
                    this.allVerticesData[i + j] = av.getLv().get(l + j);
                }
                for (int j = 0; j < 4; j++) {
                    this.allVerticesData[i + j + 4] = an.getNv().get(l + j);
                }
                for (int j = 0; j < 2; j++) {
                    this.allVerticesData[i + j + 8] = av.getTv().get(m + j);
                }
                l += 4;
                m += 2;
            }
        }
        return fl.getErrorType();
    }


}
