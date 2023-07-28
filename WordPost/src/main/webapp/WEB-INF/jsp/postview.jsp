<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
UserBean loginUser=(UserBean)session.getAttribute("loginUser");
PostBean postBean =  (PostBean)session.getAttribute("postBean");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	ArrayList<PostBean> cardDatalist = (ArrayList<PostBean>)request.getAttribute("postList");

	if (cardDatalist == null || cardDatalist.size() == 0){
%>
	<br>
	<div class="businessCard">
	<p>　検索結果<br>　　なし</p>
	</div>
	<br>
<%	} else { %>
<%		for(int i = 0; i < cardDatalist.size(); i++){ %>
	    <div class="profile">
	    <h3><%= cardDatalist.get(i).getName() %></h3>
	    <p>誕生日：<%= cardDatalist.get(i).getSyoku() %></p>
		</div>
		<% } %>
	<% } %>
</body>
</html>