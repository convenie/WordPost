package servlet;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AIDAO;
import model.AccountInfoBean;
import model.UserBean;

/**
 * Servlet implementation class AccountInfoChange
 */
@WebServlet("/AccountInfoChange")
public class AccountInfoChange extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AIDAO aiDAO=new AIDAO();
		List<AccountInfoBean> aiList=aiDAO.findAll();
		request.setAttribute("aiList",aiList);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		HttpSession session=request.getSession();
		UserBean loginUser=(UserBean) session.getAttribute("loginUser");
		AccountInfoBean accountinfo = (AccountInfoBean)session.getAttribute("accountinfo");
		System.out.println(accountinfo.getName()+":aijsp");
		//UserBean userbean=new UserBean();
		//IDLogic idLogic=new IDLogic();
		//insertの値を定義している。
		String image=request.getParameter("image");
		String comment=request.getParameter("comment");
		String birthmonth=request.getParameter("birthmonth");
		String birthday=request.getParameter("birthday");
		Path p1=Paths.get(image);
		Path p2=Paths.get("C:/pleiades/2022-12/workspace/WordPost/src/main/webapp/img/"+loginUser.getId()+".png");
		try{
			Files.copy(p1,p2, StandardCopyOption.REPLACE_EXISTING);
		}catch(IOException e){
			System.out.println(e);
		}
		accountinfo.setImage(p2.toString());
		accountinfo.setComment(comment);
		accountinfo.setBirthmonth(birthmonth);
		accountinfo.setBirthday(birthday);



		System.out.println(accountinfo.getName()+":AccountInfoBean");
		AIDAO aiDao=new AIDAO();
		if(aiDao.select(accountinfo).equals(accountinfo.getName())) {
			aiDao.update(accountinfo);
		}else {
			aiDao.insert(accountinfo);
		}

		session=request.getSession();

		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/account.jsp");
		dispatcher.forward(request, response);
	}

}
