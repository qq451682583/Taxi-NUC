
package app.ui.activity.setting;





import cn.bmob.v3.BmobUser;


/**
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class User  extends BmobUser{

	
	private String sex;  		// 性别
	private String age;  		// 性别
	private String phone; 		// 电话
	private String gard; 			// 年级
	private String school = "中北大学";  // 学校
	private String cademy; 		// 学院
	private String dorPart; 	// 校区		

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGard() {
		return gard;
	}

	public void setGard(String gard) {
		this.gard = gard;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getCademy() {
		return cademy;
	}

	public void setCademy(String cademy) {
		this.cademy = cademy;
	}

	public String getDorPart() {
		return dorPart;
	}

	public void setDorPart(String dorPart) {
		this.dorPart = dorPart;
	}

//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}

//	public String getUsername() {
//		return username;
//	}
//
//	public void setUsername(String username) {
//		this.username = username;
//	}

	
}
