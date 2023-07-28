<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.UserBean,model.PostBean,model.AccountInfoBean,model.Mutter,java.util.List" %>
<%
UserBean loginUser=(UserBean)session.getAttribute("loginUser");
PostBean postBean =  (PostBean)session.getAttribute("postBean");
%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title><%= loginUser.getName() %></title>
    <link rel="stylesheet" type="text/css" href="css/mypage.css">
  </head>
  <body>

  	<h1>-<%= loginUser.getName() %>'s Posting-</h1>
    <div class="menu">
      <a href="/WordPost/Main?action=main"><img src="img/mainicon.png"></a>
      <a href="/WordPost/Posting" class="hover"><img src="img/homeicon.png"></a>
      <a href="/WordPost/Account" class="hover"><img src="img/humanicon.png"></a>
      <a href="/WordPost/CardSearch" class="hover"><img src="img/searchicon.png"></a>
      <a href="/WordPost/Logout" class="hover"><img src="img/exiticon.png"></a>
    </div>
    <div class="profile">
    <p>俳句を入力してください</p>
    <form method="post" action="Posting">
	   	<div class="Form-Item">
		    <label class="Form-Item-Label">初句</label>
		    <input class="in" name=syoku type="text" class="Form-Item-Input" placeholder="例）秋深き">
	    </div>
	   	<div class="Form-Item">
		    <label class="Form-Item-Label">二句</label>
		    <input class="in" name=niku type="text" class="Form-Item-Input" placeholder="例）隣は何を">
	    </div>
	   	<div class="Form-Item">
		    <label class="Form-Item-Label">結句</label>
		    <input class="in" name=sanku type="text" class="Form-Item-Input" placeholder="例）する人ぞ">
	    </div>
	    <br>
		<input class="button" type="submit" value="投稿！"><br>

	</form>
	</div>
  </body>
</html>
