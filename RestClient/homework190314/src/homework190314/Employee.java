package homework190314;

public class Employee {
	int id;//员工编号
	String name;//员工姓名
	String passwd;//密码
	String quan;//权限
	public void showEmp() {
		System.out.println("员工编号为:"+id);
		System.out.println("员工姓名为:"+name);
		System.out.println("密码为:"+passwd);
		System.out.println("权限为:"+quan);
	}
}
