<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="model.AccountInfoBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>名刺検索画面</title>
<link rel="stylesheet" href="css/cardsearch.css">
</head>
<body>
    <div class="menu">
      <a href="/WordPost/Main?action=main"><img src="img/mainicon.png"></a>
      <a href="/WordPost/Posting" class="hover"><img src="img/homeicon.png"></a>
      <a href="/WordPost/Account" class="hover"><img src="img/humanicon.png"></a>
      <a href="/WordPost/CardSearch" class="hover"><img src="img/searchicon.png"></a>
      <a href="/WordPost/Logout" class="hover"><img src="img/exiticon.png"></a>
    </div>
<form action="/WordPost/CardSearch" method="post">
    <label>
        <input class="in" type="text" name="othername" placeholder="ユーザ名,コメント">
    </label>
    <button class="send" type="submit" aria-label="検索"></button>
</form>
<form action="#" class="search-form-001">
    <label>
        <input type="text" placeholder="キーワードを入力">
    </label>
    <button type="submit" aria-label="検索"></button>
</form>
<%
	ArrayList<AccountInfoBean> cardDatalist = (ArrayList<AccountInfoBean>)request.getAttribute("user_list");

	if (cardDatalist == null || cardDatalist.size() == 0){
%>
	<br>
	<div class="businessCard">
	<p>　検索結果<br>　　なし</p>
	</div>
	<br>
<%	} else { %>
<%		for(int i = 0; i < cardDatalist.size(); i++){ %>
		<div class="businessCard">
		<p>　<%= cardDatalist.get(i).getName() %></p>
		<p>　<%= cardDatalist.get(i).getBirthmonth() %>:<%= cardDatalist.get(i).getBirthday() %></p>
		<p>　<%= cardDatalist.get(i).getComment() %></p>
		</div>
		<% } %>
	<% } %>

</body>
</html>