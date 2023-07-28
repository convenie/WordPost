package model;

public class PostBean {

	/*yoyakuInfo用*/
	private String name;
	private String syoku;
	private String niku;
	private String sanku;
	public PostBean() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public PostBean(String name,String syoku,String niku,String sanku) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.setName(name);
		this.setSyoku(syoku);
		this.setNiku(niku);	
		this.setSanku(sanku);
	}
	public String getName() {return name;}
	public void setName(String name) {this.name=name;}
	public String getSyoku() {return syoku;}
	public void setSyoku(String syoku) {this.syoku=syoku;}
	public String getNiku() {return niku;}
	public void setNiku(String niku) {this.niku=niku;}
	public String getSanku() {return sanku;}
	public void setSanku(String sanku) {this.sanku=sanku;}
}
