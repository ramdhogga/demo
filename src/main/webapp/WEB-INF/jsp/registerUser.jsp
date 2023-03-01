<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<script>
<script>
$(window).on('load', function() {
	$("#name").val('');
	$("#pwd").val('');
    $("#role").val('');
})
</script>
</head>
<body>
   <center><h1>Registration Page<h1></center>
   <center>
   <br>
   <table border="1">
   <tr><td>
<form action="/registeruser" method="post">
<table border="0">
<tr><td>User Name:</td><td><input type="text" id="name" name="name"/></td></tr>
<tr><td>Password:</td><td><input type="password" id="pwd" name="pwd"/></td></tr>
<tr><td>Role</td><td><select name="role" id="role" width="40">
                     <option value="admin">admin</option>
                     <option value="user">user</option>
                     </select></td></tr>
<tr><td></td><td><input width="30" type="submit" value="click"/></td></tr>
</table>
</form>
 </td></tr>
</table>
</center>
</body>
</html>