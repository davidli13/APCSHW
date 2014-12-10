import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class CtoF extends JFrame implements ActionListener{
    private Container pane;
    private JTextField t;
    private JButton b1;
    private JButton b2;
    private JLabel l;

    

    public CtoF(){
        this.setTitle("Celsius to Fahrenheit Converter");
        this.setSize(600,400);
        this.setLocation(100,100);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());
	
	b1 = new JButton("Celsius to Fahrenheit");
	b2 = new JButton("Fahrenheit to Celcius");
	pane.add(b1);
	pane.add(b2);
    }




    public void actionPerformed(ActionEvent e){
	
    }


    public static void main(String[] args) {
        CtoF g = new CtoF();
        g.setVisible(true);
    }
}