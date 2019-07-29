package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import service.UserService;

public class MainJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainJFrame frame = new MainJFrame();
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
	public MainJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 581, 487);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(194, 385, 218, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(194, 303, 218, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
							String username=textField_1.getText();
							String password=textField.getText();
							//常量写在前，避免NPE（空指针）问题
							UserService u1=new UserService();
							Boolean boolean1=false;
							try {
								 boolean1=u1.login(username, password);
							} catch (Exception e) {
								JOptionPane.showMessageDialog(MainJFrame.this,e.getMessage());
							}
							
							if(boolean1) {
								LoginJFrame frame = new LoginJFrame(username);
								frame.setVisible(true);
								//匿名类
								MainJFrame.this.disable();
								
							}else {
								JOptionPane.showMessageDialog(MainJFrame.this, "登陆失败");
								//System.out.println("登陆失败");
							}
						}
					});

		btnNewButton.setBounds(471, 302, 66, 27);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u6CE8\u518C");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResigerJFrame frame=new ResigerJFrame();
				frame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(471, 384, 66, 27);
		contentPane.add(btnNewButton_1);
		
		textField_2 = new JTextField();
		textField_2.setText("\u7528\u6237\u540D");
		textField_2.setBounds(60, 303, 74, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setText("\u5BC6\u7801");
		textField_3.setBounds(60, 385, 74, 24);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("D:\\Documents\\Pictures\\\u9B54\u9053\u7956\u5E08\\\u9B54\u9053\u7956\u5E08wv_1540299834375.jpg"));
		lblNewLabel.setBounds(0, 0, 565, 444);
		contentPane.add(lblNewLabel);
	}

}
