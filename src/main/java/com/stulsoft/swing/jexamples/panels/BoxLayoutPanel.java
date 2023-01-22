/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.swing.jexamples.panels;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BoxLayoutPanel extends JFrame {
    // JFrame
    static JFrame f;

    // JButton
    static JButton b, b1, b2, b3;

    // Label to display text
    static JLabel l;

    // Main drive method
    public static void main(String[] args) {
        // Creating a new frame to store text field and
        // button
        f = new JFrame("panel");

        // Creating a label to display text
        l = new JLabel("panel label");

        // Creating a new buttons
        b = new JButton("button1");
        b1 = new JButton("button2");
        b2 = new JButton("button3");
        b3 = new JButton("button4");

        // Creating a panel to add buttons and
        // textfield and a layout
        JPanel p = new JPanel();

        // Setting box layout
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
//        p.setLayout(new BoxLayout(p, BoxLayout.X_AXIS));
//        p.setLayout(new BoxLayout(p, BoxLayout.LINE_AXIS));
//        p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));

        // Adding buttons and textfield to panel
        p.add(b);
        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(l);

        // Setting background of panel
        p.setBackground(Color.red);

        // Adding panel to frame
        f.add(p);

        // Setting the size of frame
        f.setSize(300, 300);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.show();
    }
}
