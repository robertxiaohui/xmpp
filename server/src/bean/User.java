package bean;

public class User implements java.io.Serializable {
	String operation;//描述
	long account;//账号 QQ号
	String password;//密码
	String nick;//昵称
	int avatar;//头像
	String trends;//签名
	String sex;//性别
	int age;//年龄
	int lev;//级别
	String time; //注册

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
