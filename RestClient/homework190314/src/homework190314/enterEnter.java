package homework190314;

public class enterEnter {
	public static void main(String[] args) {
		Person per =new Person();
		Person p = new Person(); 
		per.name = "张三";
		per.blood = 100;
		per.power = 5;
		p.name = "李四";
		p.blood = 100;
		p.power = 5;
		
		for (int i = 0; i <=20; i++) {
			per.pk0(per);
			p.pk(p);
			if (per.blood==0||p.blood==0) {
				break;
			}per.show();
			p.show();
		}
		
		
	}
}
