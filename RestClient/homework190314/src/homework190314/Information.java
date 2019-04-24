package homework190314;

public class Information {
	int id;//信息编号
	String stime;//申请时间
	String qtime;//请假时间
	int day;//请假天数
	String qtype;//请假类型
	String thing;//事由
	public void showInf() {
		System.out.println("信息编号为:"+id);
		System.out.println("申请时间为:"+stime);
		System.out.println("请假时间为:"+qtime);
		System.out.println("请假天数为:"+day);
		System.out.println("请假类型为:"+qtype);
		System.out.println("请假事由为:"+thing);
	}
}
