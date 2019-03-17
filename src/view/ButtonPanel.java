package view;

import controller.ApplicationController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPanel extends JPanel {

    private JButton btnButtonRed;
    private JButton btnButtonBlue;
    private JButton btnButtonGreen;
    private JButton btnButtonBlack;
    private JButton btnButtonYellow;
    private JButton btnButtonCyan;
    private JButton btnButtonWhite;


    private JButton btnExportButton;
    private JButton btnEraser;
    private JButton btnCurrentColor;


    private ApplicationController controller;


    public ButtonPanel(ApplicationController controller) {

        this.controller = controller;
        initialize();
    }


    public void initialize() {
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        //ERASER
        btnEraser = new JButton("Eraser (OFF)");
        btnEraser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {

                if(btnEraser.getText().equals("Eraser (OFF)"))
                {
                    btnEraser.setText("Eraser (ON) ");
                    controller.setEraseOn(true);
                }
                else
                {
                    btnEraser.setText("Eraser (OFF)");
                    controller.setEraseOn(false);
                }

            }
        });
        this.add(btnEraser);



        //COLORS
        btnButtonBlack = new JButton("+");
        btnButtonBlack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                controller.setMyColor(Color.BLACK);
                btnCurrentColor.setBackground(controller.getMyColor());
            }
        });
        btnButtonBlack.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnButtonBlack.setForeground(Color.BLACK);
        btnButtonBlack.setBackground(Color.BLACK);
        this.add(btnButtonBlack);

        btnButtonWhite = new JButton("+");
        btnButtonWhite.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                controller.setMyColor(Color.WHITE);
                btnCurrentColor.setBackground(controller.getMyColor());
            }
        });
        btnButtonWhite.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnButtonWhite.setForeground(Color.BLACK);
        btnButtonWhite.setBackground(Color.WHITE);
        this.add(btnButtonWhite);


        btnButtonRed = new JButton("+");
        btnButtonRed.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                controller.setMyColor(Color.RED);
                btnCurrentColor.setBackground(controller.getMyColor());
            }
        });
        btnButtonRed.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnButtonRed.setForeground(Color.BLACK);
        btnButtonRed.setBackground(Color.RED);
        this.add(btnButtonRed);


        btnButtonBlue = new JButton("+");
        btnButtonBlue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                controller.setMyColor(Color.BLUE);
                btnCurrentColor.setBackground(controller.getMyColor());
            }
        });
        btnButtonBlue.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnButtonBlue.setForeground(Color.BLACK);
        btnButtonBlue.setBackground(Color.BLUE);
        this.add(btnButtonBlue);

        btnButtonGreen = new JButton("+");
        btnButtonGreen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                controller.setMyColor(Color.GREEN);
                btnCurrentColor.setBackground(controller.getMyColor());
            }
        });
        btnButtonGreen.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnButtonGreen.setForeground(Color.BLACK);
        btnButtonGreen.setBackground(Color.GREEN);
        this.add(btnButtonGreen);

        btnButtonYellow = new JButton("+");
        btnButtonYellow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                controller.setMyColor(Color.YELLOW);
                btnCurrentColor.setBackground(controller.getMyColor());
            }
        });
        btnButtonYellow.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnButtonYellow.setForeground(Color.BLACK);
        btnButtonYellow.setBackground(Color.YELLOW);
        this.add(btnButtonYellow);

        btnButtonCyan = new JButton("+");
        btnButtonCyan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                controller.setMyColor(Color.CYAN);
                btnCurrentColor.setBackground(controller.getMyColor());
            }
        });
        btnButtonCyan.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnButtonCyan.setForeground(Color.BLACK);
        btnButtonCyan.setBackground(Color.CYAN);
        this.add(btnButtonCyan);





        //this is a button but were only using it to show color since labels dont allow background color change
        btnCurrentColor = new JButton("Current Color");
        btnCurrentColor.setBackground(Color.BLACK);
        btnCurrentColor.setEnabled(false);
        btnCurrentColor.setForeground(Color.BLACK);
        this.add(btnCurrentColor);


        //EXPORT BUTTON
        btnExportButton = new JButton("Export Image");
        btnExportButton.setVerticalAlignment(SwingConstants.TOP);
        this.add(btnExportButton);
        btnExportButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
               controller.setExportingImage(true);
            }
        });

    }
}
