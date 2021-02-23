<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>메일 테스트</title>
</head>
<body>

<h4>메일 보내기</h4>
<form action="/mail/mailSending" method="post">
<input type="text" name="tomail" size="120" >
      <input type="text"name="title">
      <textarea name="content" placeholder="내용#" class="form-control"></textarea>
      <input type="submit" value="메일 보내기" class="btn btn-warning">
  </form>

</body>
</html>