package homework190314;

public class Person {
	String name;
	int blood;
	int power;
	public void pk(Person p){
		p.blood=p.blood-power;
	}
	public void pk0(Person per){
		per.blood=per.blood-power;
	}void show() {
		System.out.println("名字为"+name);
		System.out.println("血量为"+blood);
		System.out.println("力量为"+power);

	}   
}
