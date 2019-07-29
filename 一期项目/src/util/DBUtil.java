package util;

import java.io.IOException;
import java.nio.channels.ScatteringByteChannel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * ������ɾ�Ĳ�
 * @author dell
 *
 */

public class DBUtil {
	
	private  static Properties properties=new Properties();
	//private static Connection con=null;  //��̬�ĳ�Ա���� ��jvm ����ֻ��һ��  
	//���ݿ������Ӳ��ܱ�����
	
	//�������ÿһ���˶���һ�����ӣ�  
	//ʹ��ThreadLocal
	private static ThreadLocal<Connection> local=new ThreadLocal<Connection>();  //�̵߳ı��ر���  
	
	static {
		try {
			properties.load(ClassLoader.getSystemResourceAsStream("db.properties"));
			System.out.println("��ʼ�������ļ��ɹ�");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	static {
		try {
			Class.forName(properties.getProperty("dirver"));
			System.out.println("�������سɹ�");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("��������ʧ��");
		}
	}
	
	//��һ������
	public static Connection openConnection() {
		Connection con=local.get();
		try {
			if(con==null || con.isClosed()) {
				con=DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("username"),properties.getProperty("password"));
				System.out.println("�����ӳɹ�");
				local.set(con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	/*
	 * DML
	 */
	public static int update(String sql,Object...params) {
		Connection con=openConnection();
		PreparedStatement pSt=null;
		int row=0;
		try {
			pSt=con.prepareStatement(sql);
			if(params!=null) {
				for(int i=0;i<params.length;i++) {
					pSt.setObject(i+1,params[i]);
				}
			}
			row=pSt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("ִ��DML����");
		}finally {
			if(pSt!=null) {
				try {
					pSt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return row;
	}
	/*
	 * DQL
	 */
	public static List<Map<String,Object>> query(String sql,Object...params) {
		List list=null;
		Connection con=openConnection();
		PreparedStatement pSt=null;
		ResultSet rs=null;
		try {
			pSt=con.prepareStatement(sql);
			if(params!=null) {
				for(int i=0;i<params.length;i++) {
					pSt.setObject(i+1,params[i]);
				}
			}
			rs=pSt.executeQuery();
			ResultSetMetaData rsData=rs.getMetaData();  //���Ԫ���ݣ�������У�
			int count=rsData.getColumnCount();
			
			list=new ArrayList<HashMap<String,Object>>();
			while(rs.next()) {
				Map<String,Object> hashmap=new HashMap<String,Object>();
				for(int i=0;i<count;i++){
					hashmap.put(rsData.getColumnLabel(i+1), rs.getObject(i+1));
				}
				list.add(hashmap);
			
			}
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("ִ��query����");
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(pSt!=null) {
				try {
					pSt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}
	
	/**
	 * �ر�����
	 */
	public static void close() {
		Connection con=local.get();
		if(con!=null) {
			try {
				con.close();
				local.remove();
				con=null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
