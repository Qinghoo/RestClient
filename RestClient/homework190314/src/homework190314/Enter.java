package homework190314;

public class Enter {
	public static void main(String[] args) {
		Employee guyuan = new Employee();
		guyuan.id = 1;
		guyuan.name = "张三";
		guyuan.passwd = "1111111";
		guyuan.quan = "主管";
		guyuan.showEmp();
		Information jiatiao = new Information();
		jiatiao.id = 1;
		jiatiao.stime = "2019年3月14日";
		jiatiao.qtime = "2019年3月14日--2019年3月20日";
		jiatiao.day = 7;
		jiatiao.qtype = "事假";
		jiatiao.thing = "家中有事";
		jiatiao.showInf();
		Notice tongzhi = new Notice();
		tongzhi.id = 1;
		tongzhi.time = "2019年3月14日";
		tongzhi.content = "这周六加班都不能请假";
		tongzhi.yid = 1;
		tongzhi.showNot();
	}
}
