package service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.management.RuntimeErrorException;

import com.mysql.fabric.xmlrpc.base.Data;

import dao.UserDao;
import entity.Teacher;
import entity.User;

/**
 * �û���ҵ��(�쳣�Ĵ���)
 * @author Administrator
 *
 */

public class UserService {
	
	/**
	 * ��¼
	 */
	public boolean login(String username,String password) { 
		boolean bool=false;
		UserDao dao=new UserDao();
		User user=dao.query(username, password);
		if(user!=null) {
			bool=true;
		}
		return bool;
	}
	
	
	/**
	 * �鿴��������Ϣ
	 */
	public  List<User> queryList() {
		UserDao dao =new UserDao();
		List<User> user=dao.queryList();
		System.out.println(user);
		
		return user;
		
	}

	
	/**
	 *�鿴��ʦ��Ϣ 
	 */
	public  List<Teacher> queryList1(){
		UserDao dao =new UserDao();
		List<Teacher> teacher1=dao.queryList1();
		return teacher1;
		
	}
	
	
	
	
	
	/*
	 * ע����Ϣ
	 */
	public void Regester(User u){
		UserDao dao =new UserDao();
		System.out.println(u);
		dao.Regester(u);
	}
	
	

}

