package model;

public class AccountInfoBean {

	/*yoyakuInfo用*/
	private String name;
	private String image;
	private String comment;
	private String birthmonth;
	private String birthday;
	public AccountInfoBean() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public AccountInfoBean(String name,String image,String comment,String birthmonth,String birthday) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.setName(name);
		this.setImage(image);
		this.setComment(comment);
		this.setBirthmonth(birthmonth);
		this.setBirthday(birthday);
	}
	public String getName() {return name;}
	public void setName(String name) {this.name=name;}
	public String getImage() {return image;}
	public void setImage(String image) {this.image=image;}
	public String getComment() {return comment;}
	public void setComment(String comment) {this.comment=comment;}
	public String getBirthmonth() {return birthmonth;}
	public void setBirthmonth(String birthmonth) {this.birthmonth=birthmonth;}
	public String getBirthday() {return birthday;}
	public void setBirthday(String birthday) {this.birthday=birthday;}
}
