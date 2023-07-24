package model;

public class CustomerBean {

	/*yoyakuInfo用*/
	
	public int ID;
	private String TEL;
	private String name;
	private String nameK;
	private String password;
	public CustomerBean() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public CustomerBean(int ID,String TEL,String name,String nameK,String password) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.setID(ID);
		this.setTEL(TEL);
		this.setName(name);
		this.setNameK(nameK);
		this.setPassword(password);
		
	}
	public int getID() {return ID;}
	public void setID(int id) {this.ID=id;}
	public String getTEL() {return TEL;}
	public void setTEL(String TEL) {this.TEL=TEL;}
	public String getName() {return name;}
	public void setName(String name) {this.name=name;}
	public String getNameK() {return nameK;}
	public void setNameK(String nameK) {this.nameK=nameK;}
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password=password;}

}
