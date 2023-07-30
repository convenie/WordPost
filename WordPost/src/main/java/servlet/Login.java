package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PostDAO;
import model.AccountInfoBean;
import model.PostBean;
import model.UserBean;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final String JDBC_URL="jdbc:mysql://localhost/reservesystemdb";
	private final String DB_USER="R2A406";
	private final String DB_PASS="mysql";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
	    String userName = request.getParameter("user_name");
	    String password = request.getParameter("password");
	    String id=null;
	    String path = "";
	    AccountInfoBean accountinfo = new AccountInfoBean();
	    PostBean postBean =new PostBean();
	    try(Connection conn=DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)) {
	    	String sql = "SELECT id,name FROM accountlist WHERE name=? AND password=?";
	    	PreparedStatement pstmt=conn.prepareStatement(sql);{
	            pstmt.setString(1, userName);
	            pstmt.setString(2, password);
	            // SQLの実行
	            ResultSet res = pstmt.executeQuery();

	            // ユーザーIDとパスワードが一致するユーザーが存在した時
	            if (res.next()) {
	                // user_idをリクエストスコープに設定する
	            	id=res.getString("id");
	                request.setAttribute("user_name", res.getString("name"));
	                request.setAttribute("id", res.getString("id"));
	                // ログイン成功画面に遷移する
	                path = "/WEB-INF/jsp/main.jsp";
	            } else {
	                // ログイン失敗の文言を追加する
	                request.setAttribute("loginFailure", "ログインに失敗しました");
	                System.out.println("ログイン失敗");
	                // ログインに失敗したときはもう一度ログイン画面を表示する
	                path = "/WEB-INF/jsp/index.jsp";
	            }
	    	}


	    	UserBean userbean=new UserBean(id,userName,password);
	    	accountinfo.setName(userName);
	    	postBean.setName(userName);
			HttpSession session=request.getSession();
			//↓俳句閲覧のためのもの
			postBean =  (PostBean)session.getAttribute("postBean");
			PostDAO postDao=new PostDAO();
			List<PostBean> postList=postDao.findAll();
			request.setAttribute("postList",postList);
			//↑俳句閲覧のためのもの
			session.setAttribute("loginUser", userbean);
			session.setAttribute("accountinfo", accountinfo);
			session.setAttribute("postBean", postBean);
	    	//System.out.println(userName+"が現在のユーザです");

	    }catch (SQLException e) {
	        e.printStackTrace();
	    }
	    RequestDispatcher rd = request.getRequestDispatcher(path);
	    rd.forward(request, response);
	}
}
