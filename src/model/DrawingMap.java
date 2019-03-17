package model;

import java.awt.*;

public class DrawingMap{

    private Color[][] map;
    public DrawingMap(int sizex,int sizey)
    {
        map = new Color[sizex][sizey];
    }


    public Color[][] getMap() {
        return this.map;
    }

    public void setMap(Color[][] map){
        this.map = map;
    }

    public Color getMapColorAt(int x, int y) {
        return map[x][y];  //returns color located at that block
    }

    public void setMapColorAt(int x, int y, Color c){
       this.map[x][y] = c;

    }
}
