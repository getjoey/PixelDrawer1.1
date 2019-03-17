package view;

import controller.ApplicationController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

public class DrawingPanel extends JPanel implements Runnable, MouseListener {

    private ApplicationController controller;
    JFrame parentFrame;


    public DrawingPanel(ApplicationController controller) {
        initialize();
        addMouseListener(this);
        this.controller = controller;
    }


    public void initialize() {
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        this.setOpaque(false); //transparent background for png
    }



    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);


        //covers all squares
        //DRAW OUR MAP
        for(int x=0; x<controller.getBlocksx(); x++)
        {
            for(int y=0; y<controller.getBlocksy(); y++)
            {

                if(controller.getDrawingMap().getMap()[x][y] == null)
                {
                    //dont do anything background of panel is transparent
                }
                else
                {
                    g.setColor(controller.getDrawingMap().getMapColorAt(x,y));
                    g.fillRect(x*controller.getBlocksizex(), y*controller.getBlocksizey(), controller.getBlocksizex(), controller.getBlocksizey());
                }



                //draw a grid so we can see where the blocks are
                if(!controller.isExportingImage())
                {
                    g.setColor(Color.GRAY);
                    g.drawRect(x*controller.getBlocksizex(), y*controller.getBlocksizey(), controller.getBlocksizex(), controller.getBlocksizey());
                }

            }
        }

        //Draw cursor if on panel
        if(controller.isMouseOnScreen())
        {
            //get mouse location
            Point a = (MouseInfo.getPointerInfo().getLocation());
            Point b = this.getLocationOnScreen();
            int x,y;
            x = (int) a.getX() - (int) b.getX() - 5;
            y = (int) a.getY() - (int) b.getY() - 5 ;

            //draw it
            g.setColor(controller.getMyColor());
            g.fillRect(x,y, 10, 10);

            if(controller.getMyColor() != Color.BLACK)
            {
                g.setColor(Color.BLACK);
                g.drawRect(x,y,10,10);
            }
            else
            {
                g.setColor(Color.WHITE);
                g.drawRect(x,y,10,10);
            }

        }
    }



    @Override
    public void run() {

        while(true)
        {
            handleResizingScreen();

            if(controller.isMousePressed())
            {
                Point a = (MouseInfo.getPointerInfo().getLocation());
                Point b = this.getLocationOnScreen();
                controller.updateDrawingMap(a,b);
            }



            repaint();
            if(controller.isExportingImage()){
                BufferedImage bi = new BufferedImage(controller.getWidth(), controller.getHeight(), BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2d = bi.createGraphics();

                this.paint(g2d);

                g2d.dispose();

                controller.exportImage(bi);
            }
        }
    }


    public void handleResizingScreen()
    {
        controller.setHeight(this.getHeight());
        controller.setWidth(this.getWidth());
        //resize it
        controller.setBlocksizex((int) controller.getWidth() / controller.getBlocksx());
        controller.setBlocksizey((int) controller.getHeight() / controller.getBlocksy());


        //make sure its an appropriate screen size
        if(controller.getBlocksx() !=0 && controller.getBlocksy() !=0)
        {
            parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this); //set frame since its parent window
            while( controller.getWidth() % controller.getBlocksx() != 0)
            {
                controller.setWidth(controller.getWidth() - 1);
            }

            //while( height % blocksy != 0)
            //{
            //	height++;
            //}
            //since we're keeping things square
            controller.setHeight( controller.getWidth());

            parentFrame.setSize(controller.getWidth()+17,controller.getHeight()+65);
            this.setSize(controller.getWidth(),controller.getHeight());
        }
    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        controller.setMousePressed(true);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        controller.setMousePressed(false);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        controller.setMouseOnScreen(true);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        controller.setMouseOnScreen(false);
    }

}
