package view;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import entity.User;
import service.UserService;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;

public class QureyJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table_1;
	
	String [] usernames={"编号","用户名","密码","邮箱"};
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QureyJFrame frame = new QureyJFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	

	/**
	 * Create the frame
	 */
	
	
	public QureyJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 492);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 796, 1);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u6570\u636E\u67E5\u8BE2", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(28, 32, 703, 194);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("id_card");
		lblNewLabel_1.setBounds(27, 23, 90, 29);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(390, 34, 0, 0);
		panel_1.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(92, 25, 130, 24);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblUsername = new JLabel("username");
		lblUsername.setBounds(330, 26, 72, 18);
		panel_1.add(lblUsername);
		
		textField_1 = new JTextField();
		textField_1.setBounds(399, 22, 143, 24);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPassword = new JLabel("password");
		lblPassword.setBounds(26, 110, 72, 18);
		panel_1.add(lblPassword);
		
		textField_2 = new JTextField();
		textField_2.setBounds(92, 106, 134, 24);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblEmail = new JLabel("   email");
		lblEmail.setBounds(330, 110, 72, 18);
		panel_1.add(lblEmail);
		
		JButton button = new JButton("查询");
		button.setBounds(569, 17, 113, 27);
		panel_1.add(button);
		
		JButton btnNewButton = new JButton("刷新");
		btnNewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				UserService userServiceImpl=new UserService();
				List<User> users=userServiceImpl.queryList();
				//把list变成二维数组
				String[][] rows=new String[users.size()][4];
				for(int i=0;i<users.size();i++){
					User u=users.get(i);
					rows[i][0]=u.getId();
					rows[i][1]=u.getUsername();
					rows[i][2]=u.getPassword();
					rows[i][3]=u.getEmail();
				}
				TableModel model=new DefaultTableModel(rows,usernames);
				table_1.setModel(model);
				table_1.updateUI();
			}
		});
			
		
		btnNewButton.setBounds(569, 101, 113, 27);
		panel_1.add(btnNewButton);
		
		textField_3 = new JTextField();
		textField_3.setBounds(399, 107, 143, 24);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 253, 703, 183);
		contentPane.add(scrollPane);
		
		String [][] xx=new String [20][4];
		table_1 = new JTable(xx,usernames);
		scrollPane.setViewportView(table_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\Documents\\Pictures\\\u9B54\u9053\u7956\u5E08\\f1555094565138.jpeg"));
		lblNewLabel_2.setBounds(5, 5, 816, 448);
		contentPane.add(lblNewLabel_2);
		
		
	
		
	}
}
