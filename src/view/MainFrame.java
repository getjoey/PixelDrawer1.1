package view;

import controller.ApplicationController;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private DrawingPanel drawingPanel;
    private ButtonPanel buttonPanel;
    private ApplicationController controller;
    private int size = 0;

    public MainFrame() {
        //init
        initialize();
        //handle input for the grid size
        doSize();
        //run the drawing panel
        drawingPanel.run();
    }

    public void initialize(){

        //initial JFrame settings
        this.setBounds(100, 100, 657, 675);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //create the controller
        controller = new ApplicationController();

        //create components and pass shared controller so they both have access to it
        drawingPanel = new DrawingPanel(controller);
        buttonPanel = new ButtonPanel(controller);

        //add components set layout
        this.getContentPane().add(drawingPanel, BorderLayout.CENTER);
        this.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        //set visible after everythings done
        this.setVisible(true);

    }

    public void doSize()
    {
        while(size == 0  || (size!= 8 && size!= 16 && size!= 32 && size!= 64 &&  size!= 128))
        {
            String val = JOptionPane.showInputDialog(this,"Specify Grid Size 8,16,32,64,128", null);
            size = Integer.parseInt(val);
        }

        controller.setSize(size);

    }


}
