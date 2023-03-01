<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><h> Login Page</h></title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>


<script>
$(window).on('load', function() {
	$("#name").val('');
	$("#pwd").val('');
})
</script>
</head>
<body> 
          <center><h1>Login Page<h1></center>
   <center>
   <br>     
   <table border="1">
			<tr><td>            
	<form action="/logincheck" method="post">
		<table>
			<tr>
				<td>User Name:</td>
				<td><input type="text" name="name" value="" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="pwd" value="" /></td>
			</tr>
			<tr>
				<td></td><td><input  align="center" type="submit" value="click" /></td>
			</tr>
		</table>
        
	</form>
 </td></tr></table>
	</center>
</body>
</html>