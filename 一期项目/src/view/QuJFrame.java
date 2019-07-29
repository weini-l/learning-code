package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import entity.Teacher;
import entity.User;
import service.UserService;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class QuJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;
	
	
	
	String [] names={"编号","用户名","年龄","电话","邮箱"};


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuJFrame frame = new QuJFrame();
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
	public QuJFrame() {
		setDefaultCloseOperation(QuJFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 724, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("搜索");
		btnNewButton.setBounds(581, 26, 113, 27);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("刷新");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserService userServiceImpl=new UserService();
				List<Teacher> teachers=userServiceImpl.queryList1();
				//System.out.println(teachers);
				System.out.println("-------");
				System.out.println(teachers);
				//把list变成二维数组
				String[][] rows=new String[teachers.size()][5];
				for(int i=0;i<teachers.size();i++){
					Teacher t=teachers.get(i);
					rows[i][0]=t.getId();
					rows[i][1]=t.getName();
					rows[i][2]=t.getAge();
					rows[i][3]=t.getEmail();
					rows[i][4]=t.getTelephone();
				}
				TableModel model=new DefaultTableModel(rows,names);
				table.setModel(model);
				table.updateUI();
			
			}
		});
		button.setBounds(581, 457, 113, 27);
		contentPane.add(button);
		
		textField = new JTextField();
		textField.setBounds(58, 27, 86, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("\u59D3\u540D");
		label.setBounds(14, 30, 72, 18);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u5E74\u9F84");
		label_1.setBounds(204, 30, 72, 18);
		contentPane.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(246, 27, 86, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(397, 30, 72, 18);
		contentPane.add(lblId);
		
		textField_2 = new JTextField();
		textField_2.setBounds(421, 27, 86, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 137, 680, 307);
		contentPane.add(scrollPane);
		
		String [][] xx=new String [20][5];
		table = new JTable(xx,names);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("D:\\Documents\\Pictures\\\u9B54\u9053\u7956\u5E08\\f1555094565138.jpeg"));
		lblNewLabel.setBounds(0, 0, 708, 497);
		contentPane.add(lblNewLabel);
		
	}
}
