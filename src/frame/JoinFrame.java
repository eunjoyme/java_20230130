package frame;

import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

//1. estends JDialog 상속
public class JoinFrame extends JDialog {
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	public JoinFrame() {
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("등록");
		btnNewButton.setBounds(81, 315, 107, 23);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("회원가입");
		lblNewLabel.setBounds(65, 38, 57, 15);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("아이디");
		lblNewLabel_1.setBounds(65, 74, 57, 15);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("비밀번호");
		lblNewLabel_2.setBounds(65, 111, 57, 15);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("이름");
		lblNewLabel_3.setBounds(65, 151, 57, 15);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("연락처");
		lblNewLabel_4.setBounds(65, 189, 57, 15);
		getContentPane().add(lblNewLabel_4);
		
		textField_1 = new JTextField();
		textField_1.setBounds(156, 71, 158, 21);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(156, 108, 158, 21);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(156, 148, 158, 21);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(156, 186, 158, 21);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("취소");
		btnNewButton_1.setBounds(200, 315, 114, 23);
		getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_5 = new JLabel("권한");
		lblNewLabel_5.setBounds(65, 229, 57, 15);
		getContentPane().add(lblNewLabel_5);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("판매자");
		chckbxNewCheckBox.setBounds(156, 225, 77, 23);
		getContentPane().add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("구매자");
		chckbxNewCheckBox_1.setBounds(253, 225, 61, 23);
		getContentPane().add(chckbxNewCheckBox_1);
		
		JLabel lblNewLabel_6 = new JLabel("등록일자");
		lblNewLabel_6.setBounds(65, 266, 57, 15);
		getContentPane().add(lblNewLabel_6);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerDateModel(new Date(1675350000000L), null, null, Calendar.DAY_OF_YEAR));
		spinner.setBounds(158, 263, 156, 22);
		getContentPane().add(spinner);
		
			
		//3줄 추가하기
		this.setModal(true);
		this.setSize(445, 430);
		this.setVisible(true);
		
	}
}
