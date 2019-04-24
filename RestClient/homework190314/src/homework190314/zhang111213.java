package homework190314;

import java.util.jar.Attributes.Name;

public class zhang111213 {
	public static void main(String[] args) {
		Worker worker = new Worker();
		worker.name = "张三";
		worker.age = 25;
		worker.salary = 2500;
		worker.addr=new Address();
		worker.addr.address = "北京市海淀区清华园1 号";
		worker.addr.zipCode = "063000";
		worker.show();
		
	}
		
		
	
}
