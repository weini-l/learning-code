package entity;

public class Teacher {
	private String id;
	private String name;
	private String age;
	private String email;
	private String telephone;
	
	public Teacher(){
		
	}
	
	public Teacher(String id,String name,String age,String email,String telephone){
		this.id=id;
		this.name=name;
		this.age=age;
		this.email=email;
		this.telephone=telephone;
	}
	

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", age=" + age + ", email=" + email + ", telephone=" + telephone
				+ "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTeelphone(String telephone) {
		this.telephone = telephone;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
