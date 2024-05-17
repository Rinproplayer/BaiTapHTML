package songsong;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JButton;
import java.awt.event.ActionListener;

public class ThreadedEchoClient extends JFrame {

	private static final long serialVersionUID = 1L;
	private static Socket s;
	private static DataInputStream in;
	private static DataOutputStream out;
	private JPanel contentPane;
	private JTextField textFieldNumber1;
	private JTextField textFieldNumber2;
	private JTextField textFieldResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThreadedEchoClient frame = new ThreadedEchoClient();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		try {
			s = new Socket("localhost",1234);
			in = new DataInputStream(s.getInputStream());
			out = new DataOutputStream(s.getOutputStream());
			
		}catch(Exception e) {
			
		}
	}

	/**
	 * Create the frame.
	 */
	public ThreadedEchoClient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 714, 541);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldNumber1 = new JTextField();
		textFieldNumber1.setBounds(239, 98, 156, 52);
		contentPane.add(textFieldNumber1);
		textFieldNumber1.setColumns(10);
		
		textFieldNumber2 = new JTextField();
		textFieldNumber2.setColumns(10);
		textFieldNumber2.setBounds(239, 205, 156, 52);
		contentPane.add(textFieldNumber2);
		
		JLabel lblNewLabel = new JLabel("Number1:\r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel.setToolTipText("Number1\r\n");
		lblNewLabel.setBounds(46, 98, 121, 52);
		contentPane.add(lblNewLabel);
		
		JLabel lblNumber = new JLabel("Number2:\r\n");
		lblNumber.setToolTipText("Number1\r\n");
		lblNumber.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNumber.setBounds(46, 205, 121, 52);
		contentPane.add(lblNumber);
		
		JButton ButtonOK = new JButton("OK\r\n");
		ButtonOK.addActionListener(new ActionListener() {
			private double a;
			private double b;

			public void actionPerformed(ActionEvent e) {
				a = Double.parseDouble(textFieldNumber1.getText());
				b = Double.parseDouble(textFieldNumber2.getText());
				try {
					out.writeDouble(a);
					out.writeDouble(b);
					textFieldResult.setText(""+in.readDouble());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		ButtonOK.setFont(new Font("Tahoma", Font.BOLD, 20));
		ButtonOK.setBounds(57, 357, 144, 64);contentPane.add(ButtonOK);
		
		JButton ButtonCancle = new JButton("Cancel\r\n\r\n");
		ButtonCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				 out.writeUTF("Cancel");
				 System.exit(0);
				 
				}catch(Exception ex) {
					
				}
				dispose();
			}
		});
		ButtonCancle.setFont(new Font("Tahoma", Font.BOLD, 20));
		ButtonCancle.setBounds(271, 357, 144, 64);
		contentPane.add(ButtonCancle);
		
		JLabel lblResult = new JLabel("Result:");
		lblResult.setToolTipText("Number1\r\n");
		lblResult.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblResult.setBounds(46, 291, 121, 52);
		contentPane.add(lblResult);
		
		textFieldResult = new JTextField();
		textFieldResult.setColumns(10);
		textFieldResult.setBounds(239, 295, 156, 52);
		contentPane.add(textFieldResult);
	}
}