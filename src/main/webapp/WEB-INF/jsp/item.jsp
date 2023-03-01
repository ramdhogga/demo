<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
$(window).on('load', function() {
	$("#name").val('');
	$("#price").val('');
	$("#qnty").val('');
})
</script>
<script>
function formsubmit(){
	var name=$("#name").val();
	var price=$("#price").val();
	var qnty=$("#qnty").val();
	if(name==''||price==''||qnty==''){
		alert("name and price and quantity should n't be empty ");
		return false;
	}
	$("#formid").submit();
}
</script>
</head>
<body>
 <center><h1>Item Add<h1></center>
   <center>
   <br>     
   <table border="1">
			<tr><td>   
<form  id="formid" action="/addItem">
<table>
<tr><td>Item Name:</td><td><input type="text" id="name" name="name"/></td></tr>
<tr><td>Item desc:</td><td><input type="text" name="desc"/></td></tr>
<tr><td>Price:</td><td><input type="text"  id="price" name="price"/></td></tr>
<tr><td>Item Quantity:</td><td><input type="text" id="qnty" name="qnty"/></td></tr>
<tr><td></td><td><input type="button" onclick="formsubmit();" value="click"/></td></tr>
</table>
</form>
</td>  </tr></table>
</body>
</html>