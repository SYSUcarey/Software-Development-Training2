import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Calculator extends JFrame implements ActionListener {
	private double numberA;
	private double numberB;
	private double result;
	private int mode = -1;

	private JLabel jlb1, jlb2, jlb3 = null;
	private JTextField jtf1, jtf2 = null;
	private JButton jb1, jb2, jb3, jb4, jb5 = null;

	public static void main(String[] args) {
		Calculator myCalculator = new Calculator();
		myCalculator.nothing();
	}

	public Calculator(){
		// init 
		jlb1 = new JLabel(" ");
		jlb2 = new JLabel("=");
		jlb3 = new JLabel(" ");
		jlb3.setBorder(BorderFactory.createLineBorder(Color.black));

		jtf1 = new JTextField(10);
		jtf2 = new JTextField(10);

		jb1 = new JButton("+");
		jb2 = new JButton("-");
		jb3 = new JButton("*");
		jb4 = new JButton("/");
		jb5 = new JButton("OK");
		//add ActionListener to buttons
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		jb4.addActionListener(this);
		jb5.addActionListener(this);

		this.add(jtf1);
		this.add(jlb1);
		this.add(jtf2);
		this.add(jlb2);
		this.add(jlb3);

		this.add(jb1);
		this.add(jb2);
		this.add(jb3);
		this.add(jb4);
		this.add(jb5);

		//set GridLayout for window
		this.setLayout(new GridLayout(2,5));
		//set title for window
		this.setTitle("myCalculator");
		//set size for window
		this.setSize(500,300);
		//set init position
		this.setLocation(500,350);
		//quit JVM when closing the window
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//display the window
		this.setVisible(true);
		this.setResizable(true);
	}
	public void nothing(){

	}

	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals("+")){
			jlb1.setText("+");
			mode = 0;
		}
		else if(e.getActionCommand().equals("-")){
			jlb1.setText("-");
			mode = 1;
		}
		else if(e.getActionCommand().equals("*")){
			jlb1.setText("*");
			mode = 2;
		}
		else if(e.getActionCommand().equals("/")){
			jlb1.setText("/");
			mode = 3;
		}
		else {
			try {
				numberA = Double.parseDouble(jtf1.getText());
				numberB = Double.parseDouble(jtf2.getText());
				String s = "";
				if (mode == 0) {
					result = numberA + numberB;
					s = "" + result;
				}
				else if (mode == 1) {
					result = numberA - numberB;
					s = "" + result;
				} 
				else if (mode == 2) {
					result = numberA * numberB;
					s = "" + result;
				}
				else if (mode == 3){
					result = numberA / numberB;
					s = "" + result;
				}
				else {
					JOptionPane.showMessageDialog(null,"There must be a operator", "WARNING", JOptionPane.WARNING_MESSAGE);
				}
				jlb3.setText(s);
			} catch (Exception er) {
				JOptionPane.showMessageDialog(null,"Input Invalid!", "WARNING", JOptionPane.WARNING_MESSAGE);
			}
			
		}
	}
}
