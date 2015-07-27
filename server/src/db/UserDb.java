package db;

import java.util.HashMap;

import bean.User;

public class UserDb
{

	//初始化模拟用户
	private static HashMap<Long, User> users = new HashMap<Long, User>();
	private static String[] sex = {"男","女"};
	//静态代码块,类创建的时候,就初始化数据
	static{
		for (int i = 0; i <100; i++)
		{
			User user = new User();
			user.setAccount(10000+i);
			user.setAge(i);
			user.setNick("user"+i);
			user.setSex(sex[i%2]);
			user.setPassword("test"+i);
			users.put(user.getAccount(),user);
		}
	}
	
}
