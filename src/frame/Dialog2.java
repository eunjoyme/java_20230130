package frame;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Dialog2 extends JDialog{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
		public Dialog2() {
			getContentPane().setLayout(null);
			
			JLabel lblNewLabel = new JLabel("학생정보 수정하기");
			lblNewLabel.setBounds(50, 34, 132, 15);
			getContentPane().add(lblNewLabel);
			
			textField = new JTextField();
			textField.setBounds(190, 64, 151, 21);
			getContentPane().add(textField);
			textField.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("비밀번호");
			lblNewLabel_1.setBounds(50, 67, 57, 15);
			getContentPane().add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("연락처");
			lblNewLabel_2.setBounds(50, 140, 57, 15);
			getContentPane().add(lblNewLabel_2);
			
			JLabel lblNewLabel_3 = new JLabel("이름");
			lblNewLabel_3.setBounds(50, 105, 57, 15);
			getContentPane().add(lblNewLabel_3);
			
			textField_1 = new JTextField();
			textField_1.setBounds(190, 102, 151, 21);
			getContentPane().add(textField_1);
			textField_1.setColumns(10);
			
			textField_2 = new JTextField();
			textField_2.setBounds(190, 137, 151, 21);
			getContentPane().add(textField_2);
			textField_2.setColumns(10);
			
			JButton btnNewButton = new JButton("수정");
			btnNewButton.setBounds(85, 189, 97, 23);
			getContentPane().add(btnNewButton);
			
			JButton btnNewButton_1 = new JButton("취소");
			btnNewButton_1.setBounds(230, 189, 97, 23);
			getContentPane().add(btnNewButton_1);
		}
	}
