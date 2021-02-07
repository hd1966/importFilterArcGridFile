package com.example.importfilterlibrary;


import android.content.Context;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class FilterLoader {
    //instans of ArcGridContent class
    private ArcGridContent agc=new ArcGridContent();
    // if format of arc grid ascii file is valid
    private boolean validFormat=false;
    //errorType "None" = no error, "Invalid format" = some error in file format, "Wrong number of elements in array heights"
    private String errorType;
    //elements in arc grid file (keys, key value)
    String[] arcGridElements={"ncols","nrows","xllcenter","yllcenter","cellsize","nodata_value"};
    //how many elements has been passed (see above)
    int counter=0;
    // count element in array heights
    private int heightscounter=0;
    //getters0/setters
    public ArcGridContent getAgc() {
        return agc;
    }

    public void setAgc(ArcGridContent agc) {
        this.agc = agc;
    }

    public boolean isValidFormat() {
        return validFormat;
    }

    public void setValidFormat(boolean validFormat) {
        this.validFormat = validFormat;
    }

    public int getHeightscounter() {
        return heightscounter;
    }

    public void setHeightscounter(int heightscounter) {
        this.heightscounter = heightscounter;
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    /**
     *
     * @param resourceId - resource Id of the esri grid file (arc grid ascii file)
     * @param c - content
     *          Populate ArcGridContent instans and set value on errorType. Value is one of the following:
     *          "None" = no error, "Invalid format" = some error in file format, "Wrong number of elements in array heights"
     */
    public void loadArcGrid(int resourceId, Context c) {
        // The InputStream opens the resourceId and sends it to the buffer
        try {
            InputStream is = c.getResources().openRawResource(resourceId);
            Scanner sc = new Scanner(is);
            while(sc.hasNext()) {
                String temp = sc.next();
                String temp1=temp.toLowerCase();
                if(counter <= 6) {
                    if (temp1.equals(arcGridElements[counter])) {
                        if(sc.hasNext()) {
                            String temp2 = sc.next();
                            if(!agc.setContent(temp2).equals("None"))
                                break;
                            counter++;
                        }
                    }
                    if (counter == 6) {
                        if(agc.getnCols()<=0 || agc.getCellSize()<=0 || agc.getnRows()<=0)
                            break;
                        agc.setHeights(new float[agc.getnCols() * agc.getnRows()]);
                        counter++;
                    }
                }
                else{
                    validFormat=true;
                    try {
                        agc.populateHeights(getHeightscounter(), Float.parseFloat(temp1));
                    }
                    catch(NumberFormatException nfe)
                    {
                        validFormat=false;
                        break;
                    }
                    heightscounter++;
                }


            }
            if(validFormat && agc.getHeights().length==heightscounter && agc.getnCols()>0 && agc.getCellSize()>0 && agc.getnRows()>0 )
            {
                setErrorType("None");
            }
            else if(!validFormat)
            {
                setErrorType("Invalid format");
            }
            else if(!(agc.getHeights().length==heightscounter))
            {
                setErrorType("Wrong number of elements in array heights");
            }
            else if(agc.getnCols()<=0 || agc.getCellSize()<=0 || agc.getnRows()<=0)
            {
                setErrorType("Wrong values in file(ncols or nrows or cellsize)");
            }


            // Close the InputStream and Scanner
            is.close();
            sc.close();

        } catch (IOException e) {
                e.printStackTrace();
        }
    }


}

