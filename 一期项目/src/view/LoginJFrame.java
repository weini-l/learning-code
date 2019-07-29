package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

public class LoginJFrame<QureyJframe1> extends JFrame {

	private JPanel contentPane;
	private String loginUser1;
	
	static String loginUser;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginJFrame frame = new LoginJFrame(loginUser);
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginJFrame(String loginUser) {
		this.loginUser=loginUser;
		setTitle("欢迎"+loginUser+"来到教务系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 733, 579);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("系统管理");
		menuBar.add(menu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("用户切换\r\n");
		menu.add(mntmNewMenuItem);
		
		JMenuItem menuItem = new JMenuItem("注册\r\n");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ResigerJFrame frame = new ResigerJFrame();
				frame.setVisible(true);
			}
		});
		menu.add(menuItem);
		
		JMenu mnJiao = new JMenu("教务管理");
		menuBar.add(mnJiao);
		
		JMenuItem menuItem_4 = new JMenuItem("\u4E2A\u4EBA\u8BFE\u8868");
		mnJiao.add(menuItem_4);
		
		JMenuItem menuItem_3 = new JMenuItem("\u73ED\u7EA7\u8BFE\u8868");
		mnJiao.add(menuItem_3);
		
		JMenu menu_1 = new JMenu("教师管理");
		menuBar.add(menu_1);
		
		JMenuItem menuItem_2 = new JMenuItem("教师查询");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				QuJFrame frame = new QuJFrame();
				frame.setVisible(true);
			}
		});
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		menu_1.add(menuItem_2);
		
		
		
		JMenuBar menuBar_1 = new JMenuBar();
		menu_1.add(menuBar_1);
		
		JMenu menu_2 = new JMenu("学生管理");
		menuBar.add(menu_2);
		
		JMenuItem menuItem_1 = new JMenuItem("学生查询");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				QureyJFrame frame = new QureyJFrame();
				frame.setVisible(true);
			}
		});
		menu_2.add(menuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("D:\\Documents\\Pictures\\\u9B54\u9053\u7956\u5E08\\f1555094565138.jpeg"));
		lblNewLabel.setBounds(0, -26, 728, 538);
		contentPane.add(lblNewLabel);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}