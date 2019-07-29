package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import entity.Teacher;
import entity.User;
import util.DBUtil;

public class UserDao {
	
	/**
	 * 
	 * 根据用用户名密码查询登录
	 * @return 
	 */
	public User query(String username,String password) { 
		User user=null;
		String sql="select * from user where username=? and password=?";
		List<Map<String, Object>> list=DBUtil.query(sql,username,password);
		if(list.size()>0) {
			user=new User();
			Map<String, Object> map=list.get(0);
			user.setId(map.get("id")==null?null:map.get("id").toString());
			user.setUsername(map.get("username")==null?null:map.get("username").toString());
			user.setPassword(map.get("password")==null?null:map.get("password").toString());
			user.setEmail(map.get("email")==null?null:map.get("email").toString());
		}
		DBUtil.close();
		return user;
	}

	
	/**
	 * 查询所有信息
	 */
	public List<User>  queryList(){
		List<User> list =new ArrayList<User>();
		String sql="select * from user";
		List<Map<String, Object>> data  =DBUtil.query(sql);
		for(Map<String,Object>map:data){
			User user=new User();
			user.setId(map.get("id")==null?null:map.get("id").toString());
			user.setUsername(map.get("username")==null?null:map.get("username").toString());
			user.setPassword(map.get("password")==null?null:map.get("password").toString());
			user.setEmail(map.get("email")==null?null:map.get("email").toString());
			list.add(user);		
			}
			DBUtil.close();
			return list;
	}
	
	/**
	 * 查询教师的信息
	 */
	
	public List<Teacher>  queryList1(){
		List<Teacher> list =new ArrayList<Teacher>();
		String sql="select * from teacher";
		List<Map<String, Object>> data  =DBUtil.query(sql);
		for(Map<String,Object>map:data){
			Teacher teacher=new Teacher();
			teacher.setId(map.get("id")==null?null:map.get("id").toString());
			teacher.setName(map.get("name")==null?null:map.get("name").toString());
			teacher.setAge(map.get("age")==null?null:map.get("age").toString());
			teacher.setEmail(map.get("email")==null?null:map.get("email").toString());
			teacher.setTeelphone(map.get("telphone")==null?null:map.get("telphone").toString());
			list.add(teacher);	

			}
			DBUtil.close();
			System.out.println(list);
			return list;
	}
	
	
	/**
	 * 注册信息
	 */
	public void Regester(User user){
		String sql="insert into user(id,username,password,email) values(?,?,?,?)";
		DBUtil.update(sql, user.getId(),user.getUsername(),user.getPassword(),user.getEmail());
		DBUtil.close();
		//return row;
			
	}
}

