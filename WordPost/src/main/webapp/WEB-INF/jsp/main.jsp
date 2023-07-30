<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.UserBean,model.AccountInfoBean,model.PostBean,model.Mutter,java.util.List,java.util.ArrayList" %>
<%
UserBean loginUser=(UserBean)session.getAttribute("loginUser");
PostBean postBean = (PostBean)session.getAttribute("postBean");
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
	<h1>おかえりなさい、<%= loginUser.getName() %>さん。</h1>
	<p>今日の投稿はどんな投稿になるのでしょうか。</p>
	<h2>～みんなの投稿コーナー～</h2>
<%
	ArrayList<PostBean> postlist = (ArrayList<PostBean>)request.getAttribute("postList");

	if (postlist == null || postlist.size() == 0){
%>
	<br>
	<div class="businessCard">
	<p>　投稿<br>　　なし</p>
	</div>
	<br>
<%	} else { %>
<%int count=0;%>

<%		for(int i = 0; i < postlist.size(); i++){ %>
<div class="onehaiku">
<p><%= postlist.get(i).getSyoku() %><br><%= postlist.get(i).getNiku() %><br><%= postlist.get(i).getSanku() %><br><%= postlist.get(i).getName() %>魂の一句</p>
</div>
	<% } %>

<% } %>
  </body>
</html>

