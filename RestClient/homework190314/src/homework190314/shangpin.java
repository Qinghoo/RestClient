package homework190314;

public class shangpin {
	public static int id = 1;
	String name;//名称
	double price;//价格
	String date;//生产日期
	int bao;//保质期
	public void show() {
		
		System.out.println("产品编号为:"+id++);
		System.out.println("产品名称为："+name);
		System.out.println("产品价格为："+price);
		System.out.println("生产日期为："+date);
		System.out.println("保质期为："+bao+"天");
		System.out.println();
	}
	
}
