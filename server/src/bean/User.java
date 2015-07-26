package bean;

public class User implements java.io.Serializable {
	String operation;//����
	long account;//�˺� QQ��
	String password;//����
	String nick;//�ǳ�
	int avatar;//ͷ��
	String trends;//ǩ��
	String sex;//�Ա�
	int age;//����
	int lev;//����
	String time; //ע��

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public long getAccount() {
		return account;
	}

	public void setAccount(long account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public int getAvatar() {
		return avatar;
	}

	public void setAvatar(int avatar) {
		this.avatar = avatar;
	}

	public String getTrends() {
		return trends;
	}

	public void setTrends(String trends) {
		this.trends = trends;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getLev() {
		return lev;
	}

	public void setLev(int lev) {
		this.lev = lev;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String toBuddy() {
		return this.getAccount() + "_" + this.getNick() + "_" + this.getAvatar() + "_" + this.getTrends() + "";
	}

	@Override
	public String toString() {
		return "User [operation=" + operation + ", account=" + account + ", password=" + password + ", nick=" + nick + ", avatar=" + avatar + ", trends=" + trends + ", sex=" + sex + ", age=" + age + ", lev=" + lev + ", time=" + time + "]";
	}

}
