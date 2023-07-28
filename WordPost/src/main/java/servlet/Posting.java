package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PostDAO;
import model.PostBean;
import model.UserBean;

@WebServlet("/Posting")
public class Posting extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		UserBean loginUser=(UserBean) session.getAttribute("loginUser");
		PostBean postBean =  (PostBean)session.getAttribute("postBean");
		PostDAO postDao=new PostDAO();
		postDao.findAll();
		String forwardPath=null;
		String action=request.getParameter("action");
		if(action!=null&&action.equals("postview")) {
			forwardPath="/WEB-INF/jsp/postview.jsp";
		}else if(action!=null&&action.equals("postin")) {
			forwardPath="/WEB-INF/jsp/charpost.jsp";
		}
		session=request.getSession();
		RequestDispatcher dispatcher=request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		HttpSession session=request.getSession();
		UserBean loginUser=(UserBean) session.getAttribute("loginUser");
		PostBean postBean =  (PostBean)session.getAttribute("postBean");
		//UserBean userbean=new UserBean();
		//IDLogic idLogic=new IDLogic();
		//insertの値を定義している。
		String syoku=request.getParameter("syoku");
		String niku=request.getParameter("niku");
		String sanku=request.getParameter("sanku");
		postBean.setSyoku(syoku);
		postBean.setNiku(niku);
		postBean.setSanku(sanku);

		PostDAO postDao=new PostDAO();
		postDao.insert(postBean);
		
		session=request.getSession();
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/charpost.jsp");
		dispatcher.forward(request, response);
	}

}
