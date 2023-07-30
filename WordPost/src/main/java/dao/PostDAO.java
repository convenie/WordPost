package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.PostBean;
import model.UserBean;
public class PostDAO {

	//private final String JDBC_URL="jdbc:mysql://localhost/test";
	//private final String DB_USER="R2A406";
	//private final String DB_USER="root";
	//private final String DB_PASS="mysql";

	//private final String JDBC_URL="jdbc:mysql://fukushima-pc/reserveSystemDB";
	//private final String DB_USER="teamG";
	//private final String DB_PASS="guavaMySQL";

	private final String JDBC_URL="jdbc:mysql://localhost/reservesystemdb";
	private final String DB_USER="R2A406";
	//private final String DB_USER="root";
	private final String DB_PASS="mysql";

	UserBean userBean=new UserBean();
	private int result;
	public List<PostBean> findAll(){
		List<PostBean> postList=new ArrayList<PostBean>();

		try(Connection conn=DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			String sql="SELECT * FROM postlist";
			PreparedStatement pStmt=conn.prepareStatement(sql);

			ResultSet rs=pStmt.executeQuery();

			while(rs.next()) {
				String name=rs.getString("name");
				String syoku=rs.getString("syoku");
				String niku=rs.getString("niku");
				String sanku=rs.getString("sanku");
				PostBean postBean=new PostBean(name,syoku,niku,sanku);
				postList.add(postBean);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return postList;
	}
	public static PostDAO getInstance() {
		return new PostDAO();
	}
	public boolean insert(PostBean postBean) {
		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			String sql="INSERT INTO POSTLIST(name,syoku,niku,sanku) VALUES (?,?,?,?)";
			PreparedStatement pStmt=conn.prepareStatement(sql);

			pStmt.setString(1,postBean.getName());
			pStmt.setString(2,postBean.getSyoku());
			pStmt.setString(3,postBean.getNiku());
			pStmt.setString(4,postBean.getSanku());
			int result=pStmt.executeUpdate();

			if(result!=1) {
				return false;
			}
		}catch(SQLException e) {
			System.out.println("追加時に問題が発生しました。");
			e.printStackTrace();
			return false;
		}
		System.out.println("正常追加完了");
		return true;
	}
	public ArrayList<PostBean> SelectUserData() throws SQLException {
		// 初期値をセット
		Connection db_con = null;

		// 複数のユーザ情報を格納するため、Beanを格納する配列を作成
		ArrayList<PostBean> array_userinfo = new ArrayList<PostBean>();

		try (Connection conn=DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){

			// 実行するSQL文をセット（空文字）
			String sql = "SELECT * FROM postlist ORDER BY RAND() LIMIT 3";

			PreparedStatement pStmt=conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();

			// 検索結果格納のため、Beanクラスをインスタンス
			PostBean resultUserInfo = new PostBean();

			// SQL文の実行結果件数分ループ処理
			while(rs.next()) {
				// ユーザIDと名前をBeanクラスへセット
				resultUserInfo.setName(rs.getString("NAME"));
				resultUserInfo.setSyoku(rs.getString("Syoku"));
				resultUserInfo.setNiku(rs.getString("Niku"));
				resultUserInfo.setSanku(rs.getString("Sanku"));

				// リストにBeanクラスごと格納
				array_userinfo.add(resultUserInfo);

				//Beanクラスを初期化
				resultUserInfo = new PostBean();
				}

		} catch(SQLException sql_e) {
			// エラーハンドリング
			System.out.println("sql実行失敗");
			sql_e.printStackTrace();

		} finally {
			// DB接続を解除
			if (db_con != null) {
					db_con.close();
			}
		}
		// リストを返す
		return array_userinfo;
	}
}

