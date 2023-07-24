s<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.UserBean,model.AccountInfoBean,model.Mutter,java.util.List" %>
<%
UserBean loginUser=(UserBean)session.getAttribute("loginUser");
AccountInfoBean accountinfo = (AccountInfoBean)session.getAttribute("accountinfo");
System.out.println(accountinfo.getName()+":mainjsp");
%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>マイページ</title>
    <link rel="stylesheet" type="text/css" href="css/mypage.css">
  </head>
  <body>
  	<h1>マイページ</h1>
    <div class="menu">
      <a href="/WordPost/Main?action=main"><img src="img/mainicon.png"></a>
      <a href="/WordPost/Posting" class="hover"><img src="img/homeicon.png"></a>
      <a href="/WordPost/Account" class="hover"><img src="img/humanicon.png"></a>
      <a href="/WordPost/CardSearch" class="hover"><img src="img/searchicon.png"></a>
      <a href="/WordPost/Logout" class="hover"><img src="img/exiticon.png"></a>
    </div>
	<h1>おかえりなさい、<%= accountinfo.getName() %>さん。</h1>
	<p>今日の投稿はどんな投稿になるのでしょうか。</p>
  </body>
</html>

