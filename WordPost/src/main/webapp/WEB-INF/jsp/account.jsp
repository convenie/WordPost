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

    <div class="menu">
      <a href="/WordPost/Main?action=main"><img src="img/mainicon.png"></a>
      <a href="/WordPost/Posting" class="hover"><img src="img/homeicon.png"></a>
      <a href="/WordPost/Account" class="hover"><img src="img/humanicon.png"></a>
      <a href="/WordPost/CardSearch" class="hover"><img src="img/searchicon.png"></a>
      <a href="/WordPost/Logout" class="hover"><img src="img/exiticon.png"></a>
    </div>
    <div class="profile">
    <h3><%= loginUser.getName() %></h3>
    <img class="myicon" src="
    <%if(accountinfo.getImage()!=null){ %>
    <%= accountinfo.getImage() %>
    <%}else{ %>
    img/nullicon.png
    <%} %>">
    <p>誕生日：
    <%if(accountinfo.getBirthmonth()!=null){ %>
    <%= accountinfo.getBirthmonth() %>
    <%}else{ %>
    ?
    <%} %>
    月
    <%if(accountinfo.getBirthday()!=null){ %>
    <%= accountinfo.getBirthday() %>
    <%}else{ %>
    ?
    <%} %>
    日</p>
    <p>ひとこと：
    <%if(accountinfo.getComment()!=null){ %>
    <%= accountinfo.getComment() %></p>
    <%}else{ %>
    コメントを入力してね★
    <%} %>
    <form action="Account" method="post">
	<input class="button" type="submit" value="アカウント情報の変更"><br>
	</form>
	<br>
	</div>
  </body>
</html>
