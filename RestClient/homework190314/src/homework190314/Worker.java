package homework190314;

public class Worker {
	String name;//工人的姓名
	int age;//工人的年龄
	double salary;//工人的工资
	int hours;
	Address addr;
	public void Worker() {
		
	}public void Worker(String name,int age,double salary) {
		this.age = age;
		this.name = name;
		this.salary = salary;
	}public void work() {
		
	}public void work(int hours) {
		this.hours = hours;
	}
	public void show() {
		System.out.println("姓名为："+name);
		System.out.println("年龄为："+age);
		System.out.println("工资为："+salary);
		System.out.println("家庭住址为："+addr.address);
		System.out.println("邮政编码为："+addr.zipCode);

	}
}
