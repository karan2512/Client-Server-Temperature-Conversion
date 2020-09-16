/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmitemp;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Math;
/**
 *
 * @author Karan
 */
public class client implements ActionListener{
    public static JFrame window;
    public static JTextField input1,input2;
    public static JButton btn_submit;
    public static JComboBox combobox1,combobox2;
    public static final int WINDOW_WIDTH = 600;
    public static final int WINDOW_HEIGHT = 600;
    public static final int BUTTON_WIDTH = 100; // Button width
    public static final int BUTTON_HEIGHT = 30; // Button height
    String str1,str2;
    double   num,result;
    
    
    public static void main(String args[])
    {
        client c =new client();
        
        
        window = new JFrame("Temperature Converter");
        window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT); // Set the width and the Height of the window
        window.setLocationRelativeTo(null); // Move Window To Center
        Font btnFont = new Font("Comic Sans MS", Font.PLAIN, 20);
        
        input1 = new JTextField();
        input1.setBounds(50,100 , 150, 30);
        input1.setEditable(true);
        input1.setBackground(Color.WHITE);
        input1.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        window.add(input1);
        
        input2 = new JTextField();
        input2.setBounds(50,250 , 150, 30);
        input2.setEditable(true);
        input2.setBackground(Color.WHITE);
        input2.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        window.add(input2);
        
        combobox1 = new JComboBox();
        combobox1.setBounds(250,100 , 200, 30);
        combobox1.setEditable(false);
        combobox1.setBackground(Color.WHITE);
        combobox1.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        combobox1.addItem("Celsius");
        combobox1.addItem("Fahrenheit");
        combobox1.addItem("Kelvin");
        combobox1.setSelectedIndex(0);
        window.add(combobox1);
        
        combobox2 = new JComboBox();
        combobox2.setBounds(250,250 , 200, 30);
        combobox2.setEditable(false);
        combobox2.setBackground(Color.WHITE);
        combobox2.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        combobox2.addItem("Celsius");
        combobox2.addItem("Fahrenheit");
        combobox2.addItem("Kelvin");
        combobox2.setSelectedIndex(1);
        window.add(combobox2);
        
        btn_submit = new JButton("Submit");
        btn_submit.setBounds(200, 350, BUTTON_WIDTH, BUTTON_HEIGHT);
        btn_submit.setFont(btnFont);
        
        window.add(btn_submit);
        
        
        btn_submit.addActionListener(c);
        
        
        window.setLayout(null);
        window.setResizable(false);
        window.setBackground(Color.blue);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // If Click into The Red Button => End The Processus
        window.setVisible(true);
    }
    
    
  

    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        try
        {
            
            
            Registry reg=LocateRegistry.getRegistry("127.0.0.1",9999);
            tempinterface in =(tempinterface)reg.lookup("Server");
            
            str1 = combobox1.getSelectedItem().toString();
            str2 = combobox2.getSelectedItem().toString();
            
            num = Double.parseDouble(input1.getText().toString());
            
            if(str1.equals("Celsius") && str2.equals("Fahrenheit"))
            {
                result = in.cel_fh(num);
                input2.setText(Math.round(result)+ "");
            }
            if(str1.equals("Fahrenheit") && str2.equals("Celsius"))
            {
                result = in.fh_cel(num);
                input2.setText(Math.round(result)+ "");
            }
            if(str1.equals("Celsius") && str2.equals("Kelvin"))
            {
                result = in.cel_kel(num);
                input2.setText(Math.round(result)+ "");
            }
            if(str1.equals("Kelvin") && str2.equals("Celsius"))
            {
                result = in.kel_cel(num);
                input2.setText(Math.round(result)+ "");
            }
            if(str1.equals("Fahrenheit") && str2.equals("Kelvin"))
            {
                result = in.fh_kel(num);
                input2.setText(Math.round(result)+ "");
            }
            if(str1.equals("Kelvin") && str2.equals("Fahrenheit"))
            {
                result = in.kel_fh(num);
                input2.setText(Math.round(result)+ "");
            }
            
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        
    }
    
}
