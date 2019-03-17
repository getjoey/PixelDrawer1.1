package controller;

import model.DrawingMap;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class ApplicationController {
    private int blocksx; //8 block pixel art maker ... so we will have this many blocks by this many blocks. so for 8 itll be 8x8
    private int blocksy;
    private int blocksizex; // = (int) 640/blocks; // this is how big we should make the blocks on the screen.  //640x640 is our panel size
    private int blocksizey;
    private Color myColor;

    private boolean mousePressed;
    private boolean mouseOnScreen;
    private boolean eraseOn;
    private boolean exportingImage;

    private int width, height;


    //model
    DrawingMap drawingMap;

    public ApplicationController(){
        initialize();
    }

    public void initialize()
    {
        blocksx = 16;
        blocksy = 16;

        blocksizex = (int)640/blocksx;
        blocksizey= (int)640/blocksy;

        drawingMap = new DrawingMap(blocksx,blocksy);

        //default settings
        mouseOnScreen = false;
        mousePressed = false;
        myColor = Color.BLACK;
        this.width = 640;
        this.height = 640;
        eraseOn = false;
        exportingImage = false;
    }

    public void setSize(int size)
    {
        blocksx = size;
        blocksy = size;
        drawingMap = new DrawingMap(blocksx,blocksy);
    }

    public void updateDrawingMap(Point a, Point b){
        //fix the mouse point so its relative to Jpanel by taking its position on screen and fixing it to the position where the panel is
        int x,y;
        x = (int) a.getX() - (int) b.getX() + 1;
        y= (int) a.getY() - (int) b.getY() + 1 ;
        //make sure its only on panel  .. no negatives.. no values greater than panel size
        if(x < 0) {
            x = 0;
            mousePressed = false;
        }
        if(y < 0) {
            y = 0;
            mousePressed = false;
        }
        if(x > width) {
            x = width;
            mousePressed = false;
        }
        if(y > height) {
            y = height;
            mousePressed = false;
        }
        //convert it to map array position
        if(mousePressed) {
            int xx = (int) x / blocksizex;
            int yy = (int) y / blocksizey;
            if(!eraseOn) {
                drawingMap.setMapColorAt(xx,yy,myColor);
            }
            else {
                drawingMap.setMapColorAt(xx,yy,null);
            }
        }
    }

    public void exportImage(BufferedImage bi){
        exportingImage = false;
        try
        {
            File file = new File("exportedImage.png");
            ImageIO.write(bi,"png", file);
        }
        catch (Exception e)
        {

        }
    }

    //getter and setters
    public int getBlocksx() {
        return blocksx;
    }

    public void setBlocksx(int blocksx) {
        this.blocksx = blocksx;
    }

    public int getBlocksy() {
        return blocksy;
    }

    public void setBlocksy(int blocksy) {
        this.blocksy = blocksy;
    }

    public int getBlocksizex() {
        return blocksizex;
    }

    public void setBlocksizex(int blocksizex) {
        this.blocksizex = blocksizex;
    }

    public int getBlocksizey() {
        return blocksizey;
    }

    public void setBlocksizey(int blocksizey) {
        this.blocksizey = blocksizey;
    }

    public Color getMyColor() {
        return myColor;
    }

    public void setMyColor(Color myColor) {
        this.myColor = myColor;
    }

    public DrawingMap getDrawingMap() {
        return drawingMap;
    }

    public void setDrawingMap(DrawingMap drawingMap) {
        this.drawingMap = drawingMap;
    }

    public boolean isMousePressed() {
        return mousePressed;
    }

    public void setMousePressed(boolean mousePressed) {
        this.mousePressed = mousePressed;
    }

    public boolean isMouseOnScreen() {
        return mouseOnScreen;
    }

    public void setMouseOnScreen(boolean mouseOnScreen) {
        this.mouseOnScreen = mouseOnScreen;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isEraseOn() {
        return eraseOn;
    }

    public void setEraseOn(boolean eraseOn) {
        this.eraseOn = eraseOn;
    }

    public boolean isExportingImage() {
        return exportingImage;
    }

    public void setExportingImage(boolean exportingImage) {
        this.exportingImage = exportingImage;
    }



}
