import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class CtoF extends JFrame implements ActionListener{
    private Container pane, input, buttons, output;
    private JTextField t;
    private JButton b1;
    private JButton b2;
    private JLabel l;   

    public CtoF(){
        this.setTitle("Celsius to Fahrenheit Converter");
        this.setSize(400,300);
        this.setLocation(100,100);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        pane = this.getContentPane();
        pane.setLayout(new GridLayout(3,1));

        t = new JTextField(15);
        b1 = new JButton("Celsius to Fahrenheit");
        b2 = new JButton("Fahrenheit to Celcius");
        l = new JLabel("",null,JLabel.CENTER);

        b1.setActionCommand("CtoF");
        b1.addActionListener(this);
        b2.setActionCommand("FtoC");
        b2.addActionListener(this);

        input = new Container();
        input.setLayout(new FlowLayout());
        input.add(t);

        buttons = new Container();
        buttons.setLayout(new FlowLayout());
        buttons.add(b1);
        buttons.add(b2);

        output = new Container();
        output.setLayout(new FlowLayout());
        output.add(l);

        pane.add(input);
        pane.add(buttons);
        pane.add(output);
    }

    public void actionPerformed(ActionEvent e){
        String action = e.getActionCommand();
	    if (action.equals("CtoF")){
            String str = t.getText();
            double i = Double.parseDouble(str);
            double a = (i * 9 / 5) + 32;
            l.setText(a + "\u00b0F");
        }
        if (action.equals("FtoC")){
            String str = t.getText();
            double i = Double.parseDouble(str);
            double a = (i - 32) * 5 / 9;
            l.setText(a + "\u00b0C");
        }
    }

    public static void main(String[] args) {
        CtoF g = new CtoF();
        g.setVisible(true);
    }
}