package db;

import java.util.HashMap;

import bean.User;

public class UserDb
{

	//��ʼ��ģ���û�
	private static HashMap<Long, User> users = new HashMap<Long, User>();
	private static String[] sex = {"��","Ů"};
	//��̬�����,�ഴ����ʱ��,�ͳ�ʼ������
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
