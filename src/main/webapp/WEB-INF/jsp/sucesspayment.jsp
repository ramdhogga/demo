<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList" %>
    <%@page import="com.techigai.model.Item" %>
     <%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
$(window).on('load', function() {
	$("#itemtab").empty();
	$("#itemtab").append(body);
	
});
var itemsArr = new Array();
<%
List<Item> obj=(List)request.getAttribute("result");
for(int i=0;i<obj.size();i++){
	 Item obj1=obj.get(i);
	 Object str = "{\"id\": "+obj1.getId()+",\"name\": \""+obj1.getName()+"\", \"desc\": \""+obj1.getDesc()+"\", \"price\": \""+obj1.getPrice()+"\"}";
	 %>
	 itemsArr.push(<%=str%>);
	 <%
}
%>
var body="";
for(var i=0; i< itemsArr.length;i++) {
	body+="<tr><td>"+itemsArr[i].name+"</td><td>"+itemsArr[i].desc+"</td><td>"+itemsArr[i].price+"</td>	</tr>";
}
</script>
</head>
<body>
   <center>Payment have done Sucessfully</center>
   <center> List of Ordered Items</center>
      <center><div>
      <table border="1" id="items">
      <thead><td colspan="3">List of Items</td></thead>
      <thead  bg-color="yellow"><td>Item Name</td><td>Item Desc</td><td>price of item</td></thead>
      <tbody id="itemtab"></tbody>
      </table>
      </div></center>
</body>
</html>