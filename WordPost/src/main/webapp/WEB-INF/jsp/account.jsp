<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.UserBean,model.AccountInfoBean,model.Mutter,java.util.List" %>
<%
UserBean loginUser=(UserBean)session.getAttribute("loginUser");
AccountInfoBean accountinfo = (AccountInfoBean)session.getAttribute("accountinfo");
%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title><%= loginUser.getName() %></title>
    <link rel="stylesheet" type="text/css" href="css/account.css">
  </head>
  <body>

  	<h1><%= loginUser.getName() %></h1>
    <div class="menu">
      <a href="/WordPost/Main?action=main"><img src="img/mainicon.png"></a>
      <a href="/WordPost/Posting" class="hover"><img src="img/homeicon.png"></a>
      <a href="/WordPost/Account" class="hover"><img src="img/humanicon.png"></a>
      <a href="/WordPost/CardSearch" class="hover"><img src="img/searchicon.png"></a>
      <a href="/WordPost/Logout" class="hover"><img src="img/exiticon.png"></a>
    </div>
    <div class="profile">
    <h3><%= loginUser.getName() %></h3>
    <img class="myicon" src="img/myicon.png">
    <p>誕生日：<%= accountinfo.getBirthmonth() %>月<%= accountinfo.getBirthday() %>日</p>
    <p>ひとこと：<%= accountinfo.getComment() %></p>
    <form action="Account" method="post">
	<input class="button" type="submit" value="アカウント情報の変更"><br>
	</form>
	<br>
	</div>
  </body>
</html>
