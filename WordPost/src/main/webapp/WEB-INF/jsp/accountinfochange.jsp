<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.UserBean,model.AccountInfoBean,model.Mutter,java.util.List" %>
<%
UserBean loginUser=(UserBean)session.getAttribute("loginUser");
AccountInfoBean accountinfo = (AccountInfoBean)session.getAttribute("accountinfo");
System.out.println(accountinfo.getName()+":aijsp");
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

    <p>コメントを入力してください</p>
    <form method="post" action="AccountInfoChange">
	   	<div class="Form-Item">
		    <label class="Form-Item-Label">コメント</label>
		    <input class="in" name=comment type="text" class="Form-Item-Input" placeholder="例）よろしく！">
	    </div>
	   	<div class="Form-Item">
		    <label class="Form-Item-Label">誕生月</label>
		    <input class="in" name=birthmonth type="text" class="Form-Item-Input" placeholder="例）09">
	    </div>
	   	<div class="Form-Item">
		    <label class="Form-Item-Label">誕生日</label>
		    <input class="in" name=birthday type="text" class="Form-Item-Input" placeholder="例）09">
	    </div>
		<input class="button" type="submit" value="変更"><br>

	</form>
	</div>
  </body>
</html>
