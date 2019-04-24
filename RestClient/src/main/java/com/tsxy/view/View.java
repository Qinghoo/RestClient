package com.tsxy.view;

public class View {
	//首页
	public void welcome() {
		System.out.println("\t\t餐厅管理系统");
		System.out.println("---------------------------------------------------");
		System.out.println("请选择你的身份登录：");
		System.out.println("1、客户登录");
		System.out.println("2、员工登录");
		System.out.println("3、经理登录");
		System.out.println("---------------------------------------------------");
	}
	//客户界面
	public void ClientJM() {
		System.out.println("欢迎来到雅惠餐厅管理系统！");
		System.out.println("1、挂失会员卡");
		System.out.println("2、查询积分");
		System.out.println("0、退出系统");
	}
	//员工界面
	public void EmpJM() {
		System.out.println("欢迎来到雅惠餐厅管理系统！");
		System.out.println("1、点菜");
		System.out.println("2、开卡");
		System.out.println("3、充值会员卡");
		System.out.println("0、退出系统");
	}
	//员工界面---点菜界面
	public void EmpJMdc() {
		System.out.println("请进行点菜操作：");
		System.out.println("1、添加菜品到购物车");
		System.out.println("2、删除购物车菜品");
		System.out.println("3、修改购物车菜品");
		System.out.println("4、查询购物车菜品");
		System.out.println("5、结账");
		System.out.println("6、返回上一层菜单");
		System.out.println("0、退出系统");
	}
	//员工界面---开卡界面
	public void EmpJMkk() {
		System.out.println("请选择开卡类型：");
		System.out.println("1、会员");
		System.out.println("2、超级会员");
		System.out.println("3、返回上一层菜单");
		System.out.println("0、退出系统");		
	}
	//经理界面
	public void ManagerJM() {
		System.out.println("欢迎来到雅惠餐厅管理系统！");
		System.out.println("1、员工管理");
		System.out.println("2、客户补卡或解除冻结");
		System.out.println("3、客户冻结");
		System.out.println("4、菜品管理");
		System.out.println("5、设置特价菜");
		System.out.println("6、显示销量");
		System.out.println("7、设置优惠");
		System.out.println("8、导出近30天销售情况");
		System.out.println("0、退出系统");
	}
	//经理界面---员工管理界面
	public void MgrJMemp() {
		System.out.println("请进行员工管理：");
		System.out.println("1、添加员工");
		System.out.println("2、删除员工");
		System.out.println("3、修改员工");
		System.out.println("4、查询员工");
		System.out.println("5、返回上一层菜单");
		System.out.println("0、退出系统");
	}
	//经理界面---菜品管理界面
		public void MgrJMmenu() {
			System.out.println("请进行菜品管理：");
			System.out.println("1、添加菜品");
			System.out.println("2、删除菜品");
			System.out.println("3、修改菜品");
			System.out.println("4、查询菜品");
			System.out.println("5、添加菜品种类");
			System.out.println("6、删除菜品种类");
			System.out.println("7、修改菜品种类");
			System.out.println("8、查询菜品种类");
			System.out.println("9、返回上一层菜单");
			System.out.println("0、退出系统");
		}
	//经理界面---统计销量界面
		public void MgrJMTj() {
			System.out.println("请进行菜品统计操作：");
			System.out.println("1、统计月销量前三名菜色");
			System.out.println("2、统计月销量所有菜色");
			System.out.println("3、返回上一层菜单");
			System.out.println("0、退出系统");
		}
}
