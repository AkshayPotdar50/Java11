package com.java.Collections.List;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class KaprekarSwingApp {
    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Kaprekar Constant Finder");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 1));

        // Create input panel
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Enter a four-digit number:"));
        JTextField inputField = new JTextField(10);
        inputPanel.add(inputField);

        // Create button panel
        JPanel buttonPanel = new JPanel();
        JButton calculateButton = new JButton("Calculate Iterations");
        buttonPanel.add(calculateButton);

        // Create output panel
        JPanel outputPanel = new JPanel();
        JLabel outputLabel = new JLabel("Result will be displayed here");
        outputPanel.add(outputLabel);

        // Add panels to frame
        frame.add(inputPanel);
        frame.add(buttonPanel);
        frame.add(outputPanel);

        // Add action listener to the button
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int number = Integer.parseInt(inputField.getText());
                    if (number < 1000 || number > 9999) {
                        JOptionPane.showMessageDialog(frame, "Please enter a valid four-digit number.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    int iterations = kaprekarRoutine(number);
                    outputLabel.setText("Number of iterations: " + iterations);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Display the frame
        frame.setVisible(true);
    }

    // Method to find the number of iterations to reach Kaprekar's constant
    private static int kaprekarRoutine(int number) {
        int kaprekarConstant = 6174;
        int count = 0;

        while (number != kaprekarConstant) {
            int descending = sortDigitsDescending(number);
            int ascending = sortDigitsAscending(number);
            number = descending - ascending;
            count++;
        }

        return count;
    }

    // Method to sort digits in descending order
    private static int sortDigitsDescending(int number) {
        char[] digits = String.format("%04d", number).toCharArray();
        Arrays.sort(digits);
        return Integer.parseInt(new StringBuilder(new String(digits)).reverse().toString());
    }

    // Method to sort digits in ascending order
    private static int sortDigitsAscending(int number) {
        char[] digits = String.format("%04d", number).toCharArray();
        Arrays.sort(digits);
        return Integer.parseInt(new String(digits));
    }
}

