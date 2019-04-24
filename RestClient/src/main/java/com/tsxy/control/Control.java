package com.tsxy.control;

import java.net.Socket;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;


import com.tsxy.domain.Client;
import com.tsxy.domain.Dish;
import com.tsxy.domain.DishType;
import com.tsxy.domain.Emp;
import com.tsxy.domain.MemberType;
import com.tsxy.domain.Permission;
import com.tsxy.domain.ShoppingCar;
import com.tsxy.util.UserInput;
import com.tsxy.util.excel;
import com.tsxy.view.View;

public class Control {
	private View v;
	private int youhui=0; 
	private String end="00";
	private UserInput ui;
	private Service service;
	public static final int PORT=6666; 
	public static final String IP="10.10.49.47"; 
	public Control() {
		super();
		this.v = new View();
		this.ui = new UserInput();
		service=ProxyClient.getClient(Service.class, IP, PORT);
	}
	//自定义方法-项目流程方法
	public void Start() {
		while(true){
			//登录
			this.v.welcome();
			int select =this.ui.getInt("请选择：");
			M:switch (select) {
			//客户登录
			case 1:
				Client aString;
				k:while (true) {
					String cliaccount =this.ui.getString("请输入客户账号：");
					String clipasswd = this.ui.getString("请输入客户密码：");
					List<Client> list = this.service.findAllClient();
					for (Client object : list) {
						if(cliaccount.equals(object.getCliaccount())&&clipasswd.equals(object.getClipasswd())&&!("冻结".equals(object.getStatus()))){
							aString=object;
							break k;
						}
					}
					System.out.println("账号密码输入错误或您的账号已被冻结！");
					System.out.println("请重新输入：");
				}
				System.out.println("登录成功");
				//客户界面
				while(true){
					this.v.ClientJM();
					int a =this.ui.getInt("请选择：");
					switch (a) {
					case 1:
						String or = this.ui.getString("是否确定挂失您的会员卡？（y/n）");
						if ("y".equals(or)) {
							aString.setStatus("挂失");
							this.service.changeClientStatus(aString);
							System.out.println("您的会员卡已挂失！");
						}
						break;
					case 2:
						System.out.println("您的信息如下：");
						System.out.println("id\t名字\t积分\t联系电话\t\t客户类型\t金额\t状态");
						System.out.println(aString);
						System.out.println("您的积分为"+aString.getCliintegral());
						break;
					case 0:
						break M;
					default:
						break;	
					}	
				}
			//员工登录
			case 2:
				 int idsyy = 0;
				while (true) {
					Emp emp=new Emp();
					int empid =this.ui.getInt("请输入员工账号：");
					String epasswd = this.ui.getString("请输入员工密码：");
					emp = this.service.findByIdEmp(empid);
					idsyy=empid;
					if (epasswd.equals(emp.getEpasswd())&&emp.getEmpid()==empid) {
						break;
					}
					System.out.println("账号密码输入错误！");
					System.out.println("请重新输入：");
				}
				System.out.println("登录成功");
				//员工界面
				while (true) {
					this.v.EmpJM();
					int b = this.ui.getInt("请选择：");
					N:switch (b) {
					//点菜
					case 1:
						ShoppingCar car = new ShoppingCar();
						while (true) {
							//员工界面---点菜
							this.v.EmpJMdc();
							int c = this.ui.getInt("请选择：");
							switch (c) {
							//添加菜品到购物车
							case 1:
								while (true) {
									System.out.println("今天有以下种类菜品供您选择：");
									System.out.println("id\t菜品种类");
									List<DishType> fadt = this.service.findAllDishType();
									for (DishType dishType : fadt) {
										System.out.println(dishType);
									}
									while(true){
										int num =this.ui.getInt("请输入您要选择的菜品种类ID：");
										DishType fbidtt = this.service.findByIdDishType(num);
										if(fbidtt==null) {
											System.out.println("您输入的菜品种类Id不存在！请重新输入：");
											continue;
										}
										for (DishType dishType : fadt) {
											if (num==dishType.getDishtypeid()) {
												List<Dish> fad = this.service.findAllDish();
												System.out.println("id\t菜名\t菜品价格\t菜品种类\t菜品描述");
												for (Dish dish : fad) {
													if (dish.getDishtype().getDishtypeid()==num) {
														System.out.println(dish);
													}
												}
											}
										}
										break;
									}
									
									Dish d = new Dish();
									int menuid = this.ui.getInt("请输入您选择的菜ID:");
									d = this.service.findByIdDish(menuid);
									if (d==null) {
										System.out.println("输入错误，不存在此菜！请重新输入：");
										continue;
									}
									int num1 = this.ui.getInt("请输入点菜数量：");
									car.addDish(d,num1);
									String or = this.ui.getString("是否继续点菜？（y/n）");
									if ("n".equals(or)) {
										break;
									}
								}
								System.out.println("您已点菜完成！");
								System.out.println("您的购物车内有以下菜品：");
								car.print();
								break;
							//删除购物车菜品
							case 2:
								System.out.println("您的购物车内有以下菜品：");
								car.print();
								while (true) {
									int menuid = this.ui.getInt("请输入您要删除的菜ID:");
									Dish d = this.service.findByIdDish(menuid);
									if (d==null) {
										System.out.println("输入错误，不存在此菜！请重新输入：");
										continue;
									}
									int num1 = this.ui.getInt("请输入要删除的份数为：");
									car.deleteDish(d,num1);
									String or = this.ui.getString("是否继续删除？（y/n）");
									if ("n".equals(or)) {
										break;
									}
								}
								System.out.println("删除完成！");
								System.out.println("您的购物车内有以下菜品：");
								car.print();
								break;
							case 3:
								System.out.println("您的购物车内有以下菜品：");
								car.print();
								while (true) {
									int menuid = this.ui.getInt("请输入您要修改的菜ID:");
									Dish fBID = this.service.findByIdDish(menuid);
									int num101 = this.ui.getInt("请输入要减少的数量为：");
									car.deleteDish(fBID, num101);
									System.out.println("您的购物车内有以下菜品：");
									car.print();
									String cai = this.ui.getString("修改成功，您减少了"+num101+"份菜品,需要再加菜嘛？（y/n）");
									if ("y".equals(cai)) {
										System.out.println("今天有以下菜色可供您选择：");
										List<Dish> fAD1 = this.service.findAllDish();
										System.out.println("id\t菜名\t菜品价格\t菜品种类\t菜品描述");
										for (Dish dish : fAD1) {
											System.out.println(dish);
										}
										while(true){
											int meid = this.ui.getInt("请输入要添加菜品ID");
											Dish fBD = this.service.findByIdDish(meid);
											if (fBD==null) {
												System.out.println("输入错误，不存在此菜！请重新输入：");
												continue;
											}
											int num01 = this.ui.getInt("请输入要添加的数量：");
											car.addDish(fBD, num01);
											System.out.println("添加成功，您的购物车内有以下菜品：");
											car.print();
											String or=this.ui.getString("是否要继续添加？（y/n）");
											if ("n".equals(or)) {
												break;
											}
										}
									}String or=this.ui.getString("是否要继续修改其他菜品？（y/n）");
									if ("n".equals(or)) {
										break;
									}
									
									
								}
								
								break;
							case 4:
								System.out.println("您的购物车内有以下菜品：");
								car.print();
								break;
							case 5:
								System.out.println("您的购物车内有以下菜品：");
								car.print();
								String huiyuan=this.ui.getString("是否拥有会员卡？（y/n）");
								if ("y".equals(huiyuan)) {
									int hui = this.ui.getInt("请输入用户ID：");
									Client findByIdClient = this.service.findByIdClient(hui);
									if (findByIdClient==null) {
										System.out.println("此用户不是雅惠的会员！");
									}
									findByIdClient.setCliintegral((int)car.getSumPrice());
									this.service.changeClient(findByIdClient);
								}
								DecimalFormat df = new DecimalFormat("#.00");
								double shouqian;
								while(true){
									double shou=this.ui.getDouble("请输入收到的钱：");
									shouqian=shou;
									if (shou<car.getSumPrice()) {
										System.out.println("您输入的钱不足以支付！请重新输入：");
									}
									break;
								}
								System.out.println("总价为："+car.getSumPrice());
								
								double zhao=shouqian-car.getSumPrice();
								System.out.println("你需要找钱"+df.format(zhao));
								System.out.println("小票如下：");
								System.out.println("唐山学院店");
								car.setShouPrice(shouqian);
								car.setRest("唐山学院店");
								car.setEmpId(idsyy);
								car.printxiaopiao();
								System.out.println("实收"+shouqian);
								System.out.println("找零"+df.format(zhao));
								String a=this.ui.getString("是否确认导出小票？（y/n）");
								if ("y".equals(a)) {
									excel.excelxiaopiao(car);
									System.out.println("导出成功！");
								}
								this.service.addOrder(car);
								break;
							case 6:
								break N;
							case 0:
								break M;
							default:
								break;
							}
						}
						
					case 2:
						//员工界面---开卡界面
						this.v.EmpJMkk();
						int e = this.ui.getInt("请选择：");
						switch (e) {
						case 1:
							while(true){
								int int1 = this.ui.getInt("请输入要添加的会员id：");
								String a = this.ui.getString("请输入要添加的会员账号：");
								Client findByIdClient = this.service.findByIdClient(int1);
								if (findByIdClient!=null&&findByIdClient.getCliaccount().equals(a)){
									System.out.println("此用户ID或账号已经存在！请重新输入：");
									continue;
								}
								Client client=new Client(int1, 
										  a, 
										  this.ui.getString("请输入要添加的会员密码："), 
										  this.ui.getString("请输入要添加的会员姓名："), 
											0, 
										  this.ui.getString("请输入要添加的会员联系电话："), 
											new MemberType(2, "会员"), 
											this.ui.getInt("请输入要充值的金钱数额：")+10, 
											"持卡");
								service.addClient(client);
								System.out.println("尊敬的客户你好，开卡成功，您已经成为雅惠餐厅的会员。您的信息如下：");
								System.out.println("id\t名字\t积分\t联系电话\t\t客户类型\t金额\t状态");
								System.out.println(client);
								String or=this.ui.getString("是否要继续开卡？（y/n）");
								if ("n".equals(or)) {
									break;
								}
							}
							break;
						case 2:while (true) {
							int int1 = this.ui.getInt("请输入要添加的超级会员id：");
							String a = this.ui.getString("请输入要添加的超级会员账号：");
							Client findByIdClient = this.service.findByIdClient(int1);
							if (findByIdClient!=null&&findByIdClient.getCliaccount().equals(a)){
								System.out.println("此用户ID或账号已经存在！请重新输入：");
								continue;
							}
							
							Client client2=new Client(int1, 
													  a, 
													  this.ui.getString("请输入要添加的超级会员密码："), 
													  this.ui.getString("请输入要添加的超级会员姓名："), 
														0, 
													  this.ui.getString("请输入要添加的超级会员联系电话："), 
														new MemberType(1, "超级会员"), 
														this.ui.getInt("请输入要充值的金钱数额：")+10, 
														"持卡");
							service.addClient(client2);
							System.out.println("尊敬的客户你好，开卡成功，您已经成为雅惠餐厅的超级会员。您的信息如下：");
							System.out.println("id\t名字\t积分\t联系电话\t\t客户类型\t金额\t状态");
							System.out.println(client2);
							String or01=this.ui.getString("是否要继续开卡？（y/n）");
							if ("n".equals(or01)) {
								break;
							}
						}
							break;
						case 0:
							break M;
						default:
							break;
						}
						break;
	                case 3:
	                	//员工界面---充值会员卡
	                	SimpleDateFormat sdf=new SimpleDateFormat("yyyymmdd");
	                	Date date= new Date();
	                	String format = sdf.format(date);
						int qianid=this.ui.getInt("请输入要充值的会员卡ID：");
						Client client = this.service.findByIdClient(qianid);
						System.out.println("您的会员卡情况如下：");
						System.out.println("id\t名字\t积分\t联系电话\t\t客户类型\t金额\t状态");
						System.out.println(client);
						if ("超级会员".equals(client.getMemberType().getMembertype())) {
							int qian=this.ui.getInt("请输入要充值的会员卡金额：");
							if (format.endsWith(end)&&qian>=100) {
							qian=qian +(qian/100)*youhui;
							}
							qian=qian+client.getMoney();
							client.setMoney(qian);
						}
						if ("会员".equals(client.getMemberType().getMembertype())) {
							int qian=this.ui.getInt("请输入要充值的会员卡金额：");
							if (format.endsWith(end)&&qian>=200) {
							qian=qian +(qian/200)*youhui;
							
							}qian=qian+client.getMoney();
							client.setMoney(qian);
						}
						this.service.changeClientMoney(client);
						System.out.println("充值成功！您的会员卡情况如下：");
						System.out.println("id\t名字\t积分\t联系电话\t\t客户类型\t金额\t状态");
						System.out.println(client);
						break;
	                case 0:
	                	break M;
					default:
						break;
					}
				}
			//经理登录
			case 3:
				int id12345;
				while (true) {
					Emp emp=new Emp();
					int empid =this.ui.getInt("请输入经理账号：");
					id12345=empid;
					String epasswd = this.ui.getString("请输入经理密码：");
					emp = this.service.findByIdEmp(empid);
					if (emp!=null) {
						if (epasswd.equals(emp.getEpasswd())&&empid==emp.getEmpid()&&emp.getPermission().getPerid()==2) {
							break;
						}
						else{
							System.out.println("账号密码输入错误或您的权限不足！");
							System.out.println("请重新输入：");
						}	
					}
					else{
						System.out.println("不存在这个客户！请重新输入：");
					}
				}
				System.out.println("登录成功");
				//经理界面
				while(true){
					this.v.ManagerJM();
					int e =this.ui.getInt("请选择：");
					Q:switch (e) {
						case 1:
							//经理界面---员工管理界面
							while (true) {
								this.v.MgrJMemp();
								int f =this.ui.getInt("请选择：");
								switch (f) {
								case 1:
									while (true) {
										Emp emp=new Emp();
										int id=this.ui.getInt("请输入要添加的员工ID:");
										Emp findByIdEmp = this.service.findByIdEmp(id);
										if (findByIdEmp!=null) {
											System.out.println("您输入的员工ID已存在，请重新输入：");
											continue;
										}
										emp.setEmpid(id);
										String name=this.ui.getString("请输入要添加的员工姓名：");
										emp.setEname(name);
										String passwd=this.ui.getString("请输入要添加的员工密码：");
										emp.setEpasswd(passwd);
										String tel=this.ui.getString("请输入要添加的员工联系方式：");
										emp.setEtel(tel);
										String num=this.ui.getString("请输入要添加的员工身份证号：");
										emp.setEnum1(num);
										String address=this.ui.getString("请输入要添加的员工家庭住址：");
										emp.setEaddress(address);
										Permission permission=new Permission();
										int perid=this.ui.getInt("请输入要添加的员工职位序号：1.普通员工  2.经理");
										permission.setPerid(perid);
										if (perid==1) {
											permission.setPername("普通员工");
										}
										if (perid==2) {
											permission.setPername("经理");
										}
										emp.setPermission(permission);
										this.service.addEmp(emp);
										System.out.println("尊敬的用户你好，添加员工成功。您的信息如下：");
										System.out.println("员工编号\t员工姓名\t密码\t联系电话\t\t身份证号\t\t\t职位\t家庭住址\t\t\t");
										System.out.println(emp);
										String or=this.ui.getString("是否要继续添加员工？（y/n）");
										if ("n".equals(or)) {
											break;
										}
									}
									break;
								case 2:
									while (true) {
										int id = this.ui.getInt("请输入要删除的员工ID：");
										System.out.println("您将要删除的员工信息如下：");
										Emp findByIdEmp = this.service.findByIdEmp(id);
										if (findByIdEmp==null||id==id12345) {
											System.out.println("没有此员工或不能删除自己！");
											continue;
										}
										System.out.println("员工编号\t员工姓名\t密码\t联系电话\t\t身份证号\t\t\t职位\t家庭住址\t\t\t");
										System.out.println(findByIdEmp);
										String or=this.ui.getString("确认删除该员工吗？（y/n）");
										if ("y".equals(or)) {
											this.service.removeByIdEmp(id);
											System.out.println("该员工已删除！");
										}else {
											System.out.println("删除已经取消！");
										}
										String or01=this.ui.getString("是否要继续删除员工？（y/n）");
										if ("n".equals(or01)) {
											break;
										}
									}
									break;
								case 3:
									while (true) {
										int id=this.ui.getInt("请输入要更改的员工ID:");
										Emp emp=this.service.findByIdEmp(id);
										if (emp==null) {
											System.out.println("输入错误，不存在此员工！请重新输入：");
											continue;
										}
										System.out.println("您想要更改的员工信息如下：");
										System.out.println("员工编号\t员工姓名\t密码\t联系电话\t\t身份证号\t\t\t职位\t家庭住址\t\t\t");
										System.out.println(emp);
										String name=this.ui.getString("请输入更改后的员工姓名：");
										emp.setEname(name);
										String passwd=this.ui.getString("请输入更改后的员工密码：");
										emp.setEpasswd(passwd);
										String tel=this.ui.getString("请输入更改后员工联系方式：");
										emp.setEtel(tel);
										String num=this.ui.getString("请输入更改后员工身份证号：");
										emp.setEnum1(num);
										Permission permission=new Permission();
										int perid=this.ui.getInt("请输入更改后员工职位序号：1.普通员工  2.经理");
										permission.setPerid(perid);
										if (perid==1) {
											permission.setPername("普通员工");
										}
										if (perid==2) {
											permission.setPername("经理");
										}
										emp.setPermission(permission);
										this.service.changeEmp(emp);
										System.out.println("尊敬的用户你好，更改员工成功。您的信息如下：");
										System.out.println("员工编号\t员工姓名\t密码\t联系电话\t\t身份证号\t\t\t职位\t家庭住址\t\t\t");
										System.out.println(emp);
										String or=this.ui.getString("是否要继续更改员工？（y/n）");
										if ("n".equals(or)) {
											break;
										}
									}
									break;
								case 4:
									while (true) {
										int id=this.ui.getInt("请选择查询方式：1.查询所有员工   2.查询个别员工");
										if (id==1) {
											System.out.println("所有员工信息如下：");
											System.out.println("员工编号\t员工姓名\t密码\t联系电话\t\t身份证号\t\t\t职位\t家庭住址\t\t\t");
											List<Emp> findAllEmp = this.service.findAllEmp();
											for (Emp emp : findAllEmp) {
												System.out.println(emp);
											}
										}
										if (id==2) {
											int id01=this.ui.getInt("请输入要查询的员工ID：");
											Emp findByIdEmp = this.service.findByIdEmp(id01);
											System.out.println("员工编号\t员工姓名\t密码\t联系电话\t\t身份证号\t\t\t职位\t家庭住址\t\t\t");
											System.out.println(findByIdEmp);
										}
										String or=this.ui.getString("是否要继续查询员工？（y/n）");
										if ("n".equals(or)) {
											break;
										}
									}
									break;
								case 5:
									break Q;
								case 0:
									break M;
								default:
									break;
								}
							}
						case 2:
							//经理界面---客户补卡界面
							while (true) {
								System.out.println("需要补卡的客户有：");
								List<Client> findAllClient = this.service.findAllClient();
								System.out.println("id\t名字\t积分\t联系电话\t\t客户类型\t金额\t状态");
								for (Client client : findAllClient) {
									String status = client.getStatus();
									if ("挂失".equals(status)||"冻结".equals(status)) {
										System.out.println(client);
									}	
								}
								int id=this.ui.getInt("请输入要补卡或解除冻结的客户ID：");
								Client findByIdClient = this.service.findByIdClient(id);
								findByIdClient.setStatus("持卡");
								this.service.changeClientStatus(findByIdClient);
								String or=this.ui.getString("是否要继续补卡或解除冻结？（y/n）");
								if ("n".equals(or)) {
									break;
								}
							}
							break;
						case 3:
							//经理界面---冻结客户界面
							while (true) {
								int id=this.ui.getInt("请输入要冻结的客户ID：");
								Client findByIdClient = this.service.findByIdClient(id);
								if (findByIdClient==null) {
									System.out.println("此客户不存在，请重新输入：");
									continue;
								}
								findByIdClient.setStatus("冻结");
								this.service.changeClientStatus(findByIdClient);
								System.out.println("冻结成功");
								String or=this.ui.getString("是否要继续冻结客户？（y/n）");
								if ("n".equals(or)) {
									break;
								}
							}
							break;
						case 4:
							//经理界面---菜品管理界面
							while (true) {
								this.v.MgrJMmenu();
								int g=this.ui.getInt("请选择：");
								switch (g) {
								//添加菜品
								case 1:
									while (true) {
										Dish dish=new Dish();
										int id=this.ui.getInt("请输入要添加的菜的ID：");
										Dish findByIdDish = this.service.findByIdDish(id);
										if (findByIdDish!=null) {
											System.out.println("此菜品ID已存在，请重新输入：");
											continue;
										}
										dish.setDishid(id);
										String name = this.ui.getString("请输入要添加的菜的名字：");
										dish.setDishname(name);
										String miaoshu=this.ui.getString("请输入要添加的菜品描述：");
										dish.setDishdepict(miaoshu);
										double price=this.ui.getDouble("请输入要添加的菜品的价格：");
										dish.setDisprice(price);;
										DishType dType=new DishType();
										System.out.println("已拥有菜品种类如下：");
										List<DishType> findAllDishType = this.service.findAllDishType();
										System.out.println("id\t菜品种类名称");
										for (DishType dishType : findAllDishType) {
											System.out.println(dishType);	
										}
										int dishtype=this.ui.getInt("请输入要添加的菜品种类ID:");
										DishType findByIdDishType = this.service.findByIdDishType(dishtype);
										dish.setDishtype(findByIdDishType);
										System.out.println("您添加的菜品信息如下：");
										System.out.println("id\t菜名\t菜品价格\t菜品种类\t菜品描述");
										System.out.println(dish);
										String j=this.ui.getString("确定添加嘛？（y/n）");
										if ("y".equals(j)) {
											this.service.addDish(dish);
											System.out.println("添加成功！");
										}
										if ("n".equals(j)) {
											System.out.println("添加已取消！");
										}
										String or=this.ui.getString("是否要继续添加菜品？（y/n）");
										if ("n".equals(or)) {
											break;
										}
									}
									break;
								//删除菜品
								case 2:
									while (true) {
										int id = this.ui.getInt("请输入要删除的菜品ID：");
										Dish findByIdDish = this.service.findByIdDish(id);
										if (findByIdDish==null) {
											System.out.println("输入错误，此菜品不存在！请重新输入：");
											continue;
										}
										System.out.println("您将要删除的菜品信息如下：");
										System.out.println("id\t菜名\t菜品价格\t菜品种类\t菜品描述");
										System.out.println(findByIdDish);
										String or=this.ui.getString("确认删除该菜品吗？（y/n）");
										if ("y".equals(or)) {
											this.service.removeByIdDish(id);
											System.out.println("该菜品已删除！");
										}else {
											System.out.println("删除已经取消！");
										}
										String or01=this.ui.getString("是否要继续删除菜品？（y/n）");
										if ("n".equals(or01)) {
											break;
										}
									}
									break;
								//修改菜品
								case 3:
									while (true) {
										int id=this.ui.getInt("请输入要更改的菜品ID:");
										Dish dish=this.service.findByIdDish(id);
										if (dish==null) {
											System.out.println("输入错误，此菜品不存在！请重新输入：");
											continue;
										}
										System.out.println("您想要更改的菜品信息如下：");
										System.out.println("id\t菜名\t菜品价格\t菜品种类\t菜品描述");
										System.out.println(dish);
										String name=this.ui.getString("请输入更改后的菜品姓名：");
										dish.setDishname(name);
										String miaoshu=this.ui.getString("请输入更改后的菜品描述：");
										dish.setDishdepict(miaoshu);
										double price=this.ui.getDouble("请输入更改后的菜品的价格：");
										dish.setDisprice(price);
										DishType dType=new DishType();
										System.out.println("已拥有菜品种类如下：");
										List<DishType> findAllDishType = this.service.findAllDishType();
										System.out.println("id\t菜品种类名称");
										for (DishType dishType : findAllDishType) {
											System.out.println(dishType);	
										}
										int dishtype=this.ui.getInt("请输入更改后的菜品种类ID:");
										DishType findByIdDishType = this.service.findByIdDishType(dishtype);
										dish.setDishtype(findByIdDishType);
										System.out.println("您更改后的菜品信息如下：");
										System.out.println("id\t菜名\t菜品价格\t菜品种类\t菜品描述");
										System.out.println(dish);
										String j=this.ui.getString("确定更改嘛？（y/n）");
										if ("y".equals(j)) {
											this.service.changeDish(dish);
											System.out.println("更改成功！");
										}
										if ("n".equals(j)) {
											System.out.println("更改已取消！");
										}
										String or=this.ui.getString("是否要继续更改菜品？（y/n）");
										if ("n".equals(or)) {
											break;
										}
									}
									break;
								//查询菜品
								case 4:
									while (true) {
										System.out.println("请选择查询方式：");
										System.out.println("1.查询所有菜品 ");
										System.out.println("2.查询个别菜品");
										int id=this.ui.getInt("3.根据菜品种类查询");
										if (id==1) {
											System.out.println("所有菜品信息如下：");
											System.out.println("id\t菜名\t菜品价格\t菜品种类\t菜品描述");
											List<Dish> findAlldish = this.service.findAllDish();
											for (Dish dish : findAlldish) {
												System.out.println(dish);
											}
										}
										if (id==2) {
											int id01=this.ui.getInt("请输入要查询的菜品ID：");
											Dish findByIdDish = this.service.findByIdDish(id01);
											if (findByIdDish==null) {
												System.out.println("输入错误，此菜品不存在！请重新输入：");
												continue;
											}
											System.out.println("id\t菜名\t菜品价格\t菜品种类\t菜品描述");
											System.out.println(findByIdDish);
										}
										if (id==3) {
											List<DishType> fadt = this.service.findAllDishType();
											System.out.println("id\t菜品种类");
											for (DishType dishType : fadt) {
												System.out.println(dishType);
											}
											while(true){
												int id01=this.ui.getInt("请输入要查询的菜品所属种类ID：");
												DishType fbidt = this.service.findByIdDishType(id01);
												if (fbidt==null) {
													System.out.println("您输入的菜品种类不存在！请重新输入：");
													continue;
												}
												for (DishType dishType : fadt) {
													if (dishType.getDishtypeid()==id01) {
														List<Dish> fad = this.service.findAllDish();
														for (Dish dish : fad) {
															if (dish.getDishtype().getDishtypeid()==id01) {
																System.out.println(dish);
															}
														}
													}
												}
												break;
											}
											
											
										}
										String or=this.ui.getString("是否要继续查询菜品？（y/n）");
										if ("n".equals(or)) {
											break;
										}
									}
									break;
								//添加菜品种类
								case 5:
									while (true) {
										DishType dishType=new DishType();
										int id=this.ui.getInt("请输入要添加的菜种类的ID：");
										DishType findByIdDishType = this.service.findByIdDishType(id);
										if (findByIdDishType!=null) {
											System.out.println("此菜品种类ID已存在，请重新输入：");
											continue;
										}
										dishType.setDishtypeid(id);
										String name = this.ui.getString("请输入要添加的菜种类的名字：");
										dishType.setDishtypename(name);
										System.out.println("您添加的菜品种类信息如下：");
										System.out.println("id\t菜品种类名称");
										System.out.println(dishType);
										String j=this.ui.getString("确定添加嘛？（y/n）");
										if ("y".equals(j)) {
											this.service.addDishType(dishType);
											System.out.println("添加成功！");
										}
										if ("n".equals(j)) {
											System.out.println("添加已取消！");
										}
										String or=this.ui.getString("是否要继续添加菜品种类？（y/n）");
										if ("n".equals(or)) {
											break;
										}
									}
									break;
								//删除菜品种类
								case 6:
									while (true) {
										int id = this.ui.getInt("请输入要删除的菜品种类ID：");
										System.out.println("您将要删除的菜品种类信息如下：");
										DishType findByIdDishType = this.service.findByIdDishType(id);
										if (findByIdDishType==null) {
											System.out.println("输入错误，此菜品不存在！请重新输入：");
											continue;
										}
										System.out.println("id\t菜品种类名称");
										System.out.println(findByIdDishType);
										String or=this.ui.getString("确认删除该菜品种类吗？（y/n）");
										if ("y".equals(or)) {
											this.service.removeByIdDishType(id);
											System.out.println("该菜品种类已删除！");
										}else {
											System.out.println("删除已经取消！");
										}
										String or01=this.ui.getString("是否要继续删除菜品种类？（y/n）");
										if ("n".equals(or01)) {
											break;
										}
									}
									break;
								//修改菜品种类
								case 7:
									while (true) {
										int id=this.ui.getInt("请输入要更改的菜种类的ID：");
										DishType findByIdDishType = this.service.findByIdDishType(id);
										if (findByIdDishType==null) {
											System.out.println("输入错误，此菜品种类不存在！请重新输入：");
											continue;
										}
										String name = this.ui.getString("请输入要更改的菜种类的名字：");
										findByIdDishType.setDishtypename(name);
										System.out.println("您更改的菜品种类信息如下：");
										System.out.println("id\t菜品种类名称");
										System.out.println(findByIdDishType);
										String j=this.ui.getString("确定更改嘛？（y/n）");
										if ("y".equals(j)) {
											this.service.changeDishType(findByIdDishType);
											System.out.println("更改成功！");
											}
										if ("n".equals(j)) {
											System.out.println("更改已取消！");
											}
										String or=this.ui.getString("是否要继续更改菜品种类？（y/n）");
										if ("n".equals(or)) {
											break;
											}
										}
									break;
								//查询菜品种类
								case 8:
									while (true) {
										int id=this.ui.getInt("请选择查询方式：1.查询所有菜品种类   2.查询个别菜品种类");
										if (id==1) {
											System.out.println("所有菜品种类信息如下：");
											System.out.println("id\t菜品种类名称");
											List<DishType> findAlldishtype = this.service.findAllDishType();
											for (DishType dishtype : findAlldishtype) {
												System.out.println(dishtype);
											}
										}
										if (id==2) {
											int id01=this.ui.getInt("请输入要查询的菜品种类ID：");
											DishType findByIdDishType = this.service.findByIdDishType(id01);
											if (findByIdDishType==null) {
												System.out.println("输入错误，此菜品种类不存在！请重新输入：");
												continue;
											}
											System.out.println("id\t菜品种类名称");
											System.out.println(findByIdDishType);
										}
										String or=this.ui.getString("是否要继续查询菜品种类？（y/n）");
										if ("n".equals(or)) {
											break;
										}
									}
									break;
								case 9:
									break Q;
								case 0:
									break M;
								default:
									break;
								}
							}
						
						//经理界面---设置特价菜界面
						case 5:
							while (true) {
								int int1 = this.ui.getInt("请输入要设置的菜的ID：");
								Dish findByIdDish = this.service.findByIdDish(int1);
								if (findByIdDish!=null) {
									System.out.println("此菜品种类已存在，请重新输入：");
									continue;
								}
								Dish dish = new Dish(int1,
										this.ui.getString("请输入要设置的菜的名字："),
										this.ui.getString("请输入要设置的菜品描述："),
										this.ui.getDouble("请输入要设置的菜品的价格："),
										new DishType(3, "特价菜"),0);
								System.out.println("您设置的菜品信息如下：");
								System.out.println("id\t菜名\t价格\t菜品种类\t菜品描述");
								System.out.println(dish);
								String j=this.ui.getString("确定设置嘛？（y/n）");
								if ("y".equals(j)) {
									this.service.addDish(dish);
									System.out.println("设置成功！");
								}
								if ("n".equals(j)) {
									System.out.println("设置已取消！");
								}
								String or=this.ui.getString("是否要继续设置特价菜品？（y/n）");
								if ("n".equals(or)) {
									break;
								}
							}
							break;
						//经理界面---显示销量
						case 6:
							while (true) {
								this.v.MgrJMTj();
								int se=this.ui.getInt("请选择：");
								if (se==1) {
									Map<String, Integer> treemap=new TreeMap<String, Integer>(this.service.findGoodFood());
									Set<String> dishs=treemap.keySet();
									Iterator<String> it=dishs.iterator();
									System.out.println("\t菜名\t数量");
									while (it.hasNext()) {
										String k=it.next();
										Integer v=treemap.get(k);
										System.out.println(k+"\t"+v);
									}
								}
								if (se==2) {
									Map<String, Integer> fm = new TreeMap<String, Integer>(this.service.findMonth());
									Set<String> xiaoliang=fm.keySet();
									Iterator<String> iterator=xiaoliang.iterator();
									System.out.println("\t菜名\t数量");
									while (iterator.hasNext()) {
										String mString=iterator.next();
										Integer m=fm.get(mString);
										System.out.println(mString+"\t"+m);
									}
								}
								if (se==3) {
									break Q;
								}
								if (se==0) {
									break M;
								}
								
							}
						case 7:
							end = this.ui.getString("请输入你要优惠的日期结尾数字");
							
							youhui = this.ui.getInt("请输入你想要优惠的额度，送多少钱");
							
							System.out.println("修改成功！");
							break;
						case 8:
							String a=this.ui.getString("是否确认导出近30天的销售情况到excel表格？（y/n）");
							if ("y".equals(a)) {
								excel.excelChu(null);
								System.out.println("导出成功！");
							}
							break;
						case 0:
							break M;
						default:
							break;
						}
				}
			default:
				break;
			}
			
		}
	}
}
