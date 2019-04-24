package homework190314;

public class Notice {
	int id;//通知编号
	String time;//通知时间
	String content;//通知内容
	int yid;//员工编号
	public void showNot() {
		System.out.println("通知编号为:"+id);
		System.out.println("通知时间为:"+time);
		System.out.println("通知内容为:"+content);
		System.out.println("员工编号:"+yid);
	}
}
