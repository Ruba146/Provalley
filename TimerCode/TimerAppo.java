/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ruba2030;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.border.Border;

import javax.swing.SwingUtilities;

import javax.swing.JOptionPane;

import javax.swing.JOptionPane;

import javax.swing.JOptionPane;

import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.border.Border;

class RoundedTextField extends JTextField {
    private int radius;

    public RoundedTextField(int radius) {
        super();
        this.radius = radius; 
        setOpaque(false); 
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

      
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);

       
        g2.setColor(getForeground());
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);

        g2.dispose();
        super.paintComponent(g);
    }

    @Override
    public void setBorder(Border border) {
        
    }
}

public class TimerAppo {
    private JFrame frame;
    private RoundedTextField hoursField, minutesField, secondsField;
    private JButton startButton, stopButton, resetButton;
    private Timer timer;
    private int totalSeconds;

    public TimerAppo() {
        
        frame = new JFrame("Timer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Countdown Timer", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.DARK_GRAY);
        frame.add(titleLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel hoursLabel = new JLabel("Hours:");
        hoursField = new RoundedTextField(15); 
        hoursField.setPreferredSize(new Dimension(30, 15));

        JLabel minutesLabel = new JLabel("Minutes:");
        minutesField = new RoundedTextField(15);
        minutesField.setPreferredSize(new Dimension(30, 15)); 

        JLabel secondsLabel = new JLabel("Seconds:");
        secondsField = new RoundedTextField(15);
        secondsField.setPreferredSize(new Dimension(30, 15)); 

        inputPanel.add(hoursLabel);
        inputPanel.add(hoursField);
        inputPanel.add(minutesLabel);
        inputPanel.add(minutesField);
        inputPanel.add(secondsLabel);
        inputPanel.add(secondsField);

        frame.add(inputPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        resetButton = new JButton("Reset");

        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);
        buttonPanel.add(resetButton);

        frame.add(buttonPanel, BorderLayout.SOUTH);

        startButton.addActionListener(new StartButtonListener());
        stopButton.addActionListener(new StopButtonListener());
        resetButton.addActionListener(new ResetButtonListener());

        frame.setVisible(true);
    }
    private class StartButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int hours = Integer.parseInt(hoursField.getText());
                int minutes = Integer.parseInt(minutesField.getText());
                int seconds = Integer.parseInt(secondsField.getText());
                totalSeconds = hours * 3600 + minutes * 60 + seconds;

                if (timer != null) {
                    timer.stop();
                }

                timer = new Timer(1000, new TimerListener());
                timer.start();
            } 
            catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter valid numbers!");
            }
        }
    }

    private class StopButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (timer != null) {
                timer.stop();
            }
        }
    }

    private class ResetButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (timer != null) {
                timer.stop();
            }
            hoursField.setText("0");
            minutesField.setText("0");
            secondsField.setText("0");
        }
    }

    private class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (totalSeconds > 0) {
                totalSeconds--;
                int hours = totalSeconds / 3600;
                int minutes = (totalSeconds % 3600) / 60;
                int seconds = totalSeconds % 60;

                hoursField.setText(String.valueOf(hours));
                minutesField.setText(String.valueOf(minutes));
                secondsField.setText(String.valueOf(seconds));
            } 
            else {
                timer.stop();
                JOptionPane.showMessageDialog(frame, "Time's up!");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TimerAppo::new);
    }
}