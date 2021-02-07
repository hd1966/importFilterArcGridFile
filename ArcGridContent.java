package com.example.importfilterlibrary;


/**
 * Container esri(arc grid ascii) grid (https://en.wikipedia.org/wiki/Esri_grid) file format (all properties of arcgrid format)
 */
public class ArcGridContent {
    //take care of order of the properties (esri grid file)
    private int order=0;
    //all properties of esri grid format + setter/getter
    private float cellSize;
    private int nCols;
    private int nRows;
    private float xllCenter;
    private float yllCenter;
    private int noDataValue;
    private float[] heights;

    public float getCellSize() {
        return cellSize;
    }

    public void setCellSize(float cellSize) {
        this.cellSize = cellSize;
    }

    public int getnCols() {
        return nCols;
    }

    public void setnCols(int nCols) {
        this.nCols = nCols;
    }

    public int getnRows() {
        return nRows;
    }

    public void setnRows(int nRows) {
        this.nRows = nRows;
    }

    public float getXllCenter() {
        return xllCenter;
    }

    public void setXllCenter(float xllCenter) {
        this.xllCenter = xllCenter;
    }

    public float getYllCenter() {
        return yllCenter;
    }

    public void setYllCenter(float yllCenter) {
        this.yllCenter = yllCenter;
    }

    public int getNoDataValue() {
        return noDataValue;
    }

    public void setNoDataValue(int noDataValue) {
        this.noDataValue = noDataValue;
    }

    public float[] getHeights() {
        return heights;
    }

    public void setHeights(float[] heights) {
        this.heights = heights;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
    /**
    @param c  - value of property as a string
    @return  "None" if there is no error, "Invalid format" if some error happened with parse
     **/
    public String setContent(String c)
    {
        try {
            switch (getOrder()) {
                case 0:
                    setnCols(Integer.parseInt(c));
                    order++;
                    break;
                case 1:
                    setnRows(Integer.parseInt(c));
                    order++;
                    break;
                case 2:
                    setXllCenter(Float.parseFloat(c));
                    order++;
                    break;
                case 3:
                    setYllCenter(Float.parseFloat(c));
                    order++;
                    break;
                case 4:
                    setCellSize(Float.parseFloat(c));
                    order++;
                    break;
                case 5:
                    setNoDataValue(Integer.parseInt(c));
                    order++;
                    break;
            }
            return "None";
        }
        catch(NumberFormatException ne)
        {
            return "Invalid format";
        }

    }

    /**
     *
     * @param i - place in the heights array
     * @param value - value which has been stored as element on place i in array heights
     */
    public void populateHeights(int i,float value)
    {
        heights[i]=value;
    }


    /**
     *
     * @return maximum height has been returned (from array heights)
     */
    public float getMaxHeights(){
        float maxValue = heights[0];
        for(int i=1;i < heights.length;i++){
            if(heights[i] > maxValue){
                maxValue = heights[i];
            }
        }
        return maxValue;
    }

    /**
     *
     * @return minimum height has been returned (from array heights)
     */
    public float getMinHeights(){
        float minValue = heights[0];
        for(int i=1;i < heights.length;i++){
            if(heights[i] < minValue){
                minValue = heights[i];
            }
        }
        return minValue;
    }


}
