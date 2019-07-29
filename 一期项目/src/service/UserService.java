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
 * 用户的业务(异常的传递)
 * @author Administrator
 *
 */

public class UserService {
	
	/**
	 * 登录
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
	 * 查看所有人信息
	 */
	public  List<User> queryList() {
		UserDao dao =new UserDao();
		List<User> user=dao.queryList();
		System.out.println(user);
		
		return user;
		
	}

	
	/**
	 *查看教师信息 
	 */
	public  List<Teacher> queryList1(){
		UserDao dao =new UserDao();
		List<Teacher> teacher1=dao.queryList1();
		return teacher1;
		
	}
	
	
	
	
	
	/*
	 * 注册信息
	 */
	public void Regester(User u){
		UserDao dao =new UserDao();
		System.out.println(u);
		dao.Regester(u);
	}
	
	

}

