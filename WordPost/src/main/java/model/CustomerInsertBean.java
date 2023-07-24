package model;

import servlet.IDLogic;

public class CustomerInsertBean {

	/*yoyakuInfo用*/
	
	public String ID;
	private String TEL;
	private String name;
	private String nameK;
	private String password;
	public int count=2023000000;
	public CustomerInsertBean() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public CustomerInsertBean(String ID,String TEL,String name,String nameK,String password,int count) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.setID(Integer.toString(count+1));
		this.setTEL(TEL);
		this.setName(name);
		this.setNameK(nameK);
		this.setPassword(password);
		
	}
	public String getID() {return ID;}
	public void setID(String string) {this.ID=string;}
	public String getTEL() {return TEL;}
	public void setTEL(String TEL) {this.TEL=TEL;}
	public String getName() {return name;}
	public void setName(String name) {this.name=name;}
	public String getNameK() {return nameK;}
	public void setNameK(String nameK) {this.nameK=nameK;}
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password=password;}
	public int getCount() {
		System.out.println("CustemerinsertBeanでの出来事"+IDLogic.getIDplus());
		count=IDLogic.getIDplus()+1;
		//count=2023000010;
		return count;
		}
	public void setCount(int count) {
		this.count=count+1;
		}
}
