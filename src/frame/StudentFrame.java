package frame;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class StudentFrame extends JFrame{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public StudentFrame() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("학번");
		lblNewLabel.setBounds(67, 38, 57, 15);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setText("201711024");
		textField.setBounds(125, 35, 116, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("이름");
		lblNewLabel_1.setBounds(67, 66, 57, 15);
		getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setText("김은정");
		textField_1.setBounds(125, 63, 116, 21);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("학년");
		lblNewLabel_2.setBounds(67, 94, 57, 15);
		getContentPane().add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setText("4학년");
		textField_2.setBounds(125, 91, 116, 21);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("등록하기");
		btnNewButton.setBounds(66, 145, 97, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("취소하기");
		btnNewButton_1.setBounds(173, 145, 97, 23);
		getContentPane().add(btnNewButton_1);
		
		//2줄 추가하기
		this.setSize(500,  400);
		this.setVisible(true);
		
		//Main5.java를 만들어서
		//StudentFrame obj =new StudentFrame();
	}
}
