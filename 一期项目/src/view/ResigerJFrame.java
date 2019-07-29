package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.omg.Messaging.SyncScopeHelper;

import entity.User;
import service.UserService;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class ResigerJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResigerJFrame frame = new ResigerJFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ResigerJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 608, 535);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setBounds(110, 56, 140, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(387, 56, 147, 24);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(111, 107, 139, 24);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(387, 107, 147, 24);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		String[] jg={"北京","上海","天津","新疆","广州"};
		JComboBox comboBox = new JComboBox(jg);
		comboBox.setBounds(387, 189, 147, 24);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("\u59D3\u540D\uFF1A");
		lblNewLabel.setBounds(51, 59, 45, 18);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_1.setBounds(328, 51, 45, 35);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u90AE\u7BB1\uFF1A");
		lblNewLabel_2.setBounds(51, 110, 45, 18);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u7535\u8BDD\uFF1A");
		lblNewLabel_3.setBounds(328, 110, 45, 18);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u7C4D\u8D2F\uFF1A");
		lblNewLabel_4.setBounds(328, 192, 52, 18);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\u6027\u522B\uFF1A");
		lblNewLabel_5.setBounds(51, 192, 52, 18);
		contentPane.add(lblNewLabel_5);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("\u7537");
		rdbtnNewRadioButton.setBounds(112, 188, 59, 27);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("\u5973");
		rdbtnNewRadioButton_1.setBounds(177, 188, 73, 27);
		contentPane.add(rdbtnNewRadioButton_1);
		ButtonGroup bg=new ButtonGroup();
		bg.add(rdbtnNewRadioButton);
		bg.add(rdbtnNewRadioButton_1);
		
		
		JLabel lblNewLabel_6 = new JLabel("\u5174\u8DA3");
		lblNewLabel_6.setBounds(51, 284, 45, 18);
		contentPane.add(lblNewLabel_6);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("\u6E38\u6CF3");
		chckbxNewCheckBox.setBounds(110, 280, 73, 27);
		contentPane.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("\u8DF3\u821E");
		chckbxNewCheckBox_1.setBounds(204, 280, 78, 27);
		contentPane.add(chckbxNewCheckBox_1);
		
		JLabel label = new JLabel("\u5907\u6CE8\uFF1A");
		label.setBounds(51, 366, 52, 18);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(127, 363, 407, 64);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("注册");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User user=new User();
				user.setId(String.valueOf(System.currentTimeMillis()));
				user.setUsername(textField_1.getText());
				user.setPassword(textField_3.getText());
				user.setEmail(textField_4.getText());
				
				UserService service =new UserService();
				try{
					service.Regester(user);
					JOptionPane.showMessageDialog(ResigerJFrame.this, "注册成功");
				}catch(Exception e1){
					JOptionPane.showMessageDialog(ResigerJFrame.this, "注册失败");
				}
				
			}
		});
		btnNewButton.setBounds(112, 452, 113, 27);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.setBounds(344, 452, 113, 27);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setIcon(new ImageIcon("D:\\Documents\\Pictures\\\u9B54\u9053\u7956\u5E08\\\u9B54\u9053\u7956\u5E08wv_1540299834375.jpg"));
		lblNewLabel_7.setBounds(0, 0, 592, 492);
		contentPane.add(lblNewLabel_7);
	}
}
