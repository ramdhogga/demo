<%@page import="com.techigai.service.ItemService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList" %>
    <%@page import="com.techigai.model.Item" %>
     <%@page import="java.util.List" %>
    
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<script>
var itemsArr = new Array();
var body="";
var orderarr=new Array()
var qntyarr=new Array();
var arrids="";
var pbody="";
var ammount=0;
<%
ItemService itemobj=new ItemService();

//List<Item> obj=itemobj.getAllItems();
ArrayList<Item> obj=(ArrayList)request.getAttribute("result");
for(int i=0;i<obj.size();i++){
	 Item obj1=obj.get(i);
	 Object str = "{\"id\": "+obj1.getId()+",\"name\": \""+obj1.getName()+"\", \"desc\": \""+obj1.getDesc()+"\", \"price\": \""+obj1.getPrice()+"\", \"status\": \""+obj1.getStatus()+"\", \"qnty\": \""+obj1.getAvlQnty()+"\"}";
	 %>
	 itemsArr.push(<%=str%>);
	 <%
}
//orderController orobj=new orderController();
//orobj.getData(obj);
  request.getSession().setAttribute("list", obj);
%>

for(var i=0; i< itemsArr.length;i++) {
	body+="<tr><td>"+itemsArr[i].name+"</td><td>"+itemsArr[i].desc+"</td><td>"+itemsArr[i].qnty+"</td><td>"+itemsArr[i].price+"</td>";
   if(itemsArr[i].qnty==0){
	   body+="<td>Not Available</td></tr>";
   }else{
	   body+="<td><input type='button' onClick='order(this)' value='addToCart' id='"+itemsArr[i].id+"'/></td></tr>"; 
   }

}

$(window).on('load', function() {
	$("#itemtab").empty();
	$("#itemtab").append(body);
	body="";
	//	$("#items").show();
	$("#paymenttab").hide();
	$("#ammout").val('0');
})
function calamt(obj){
	var ammount=0;	
	var len=$("#paytab").find('tr').length;
	 for(var i=1; i<=len;i++) {
		var qnty= $("#paytab").find('tr:nth-of-type('+i+')').find(':input').val(); 
		var objid=$("#paytab").find('tr:nth-of-type(1)').find('input').attr('id');
		var id=objid.split('_')[0];
		var amt=objid.split('_')[1];
		ammount+=parseInt(amt)*parseInt(qnty);
	 }
		$("#ammout").val(ammount);
}
function order(obj){
	var itemid=obj.id;
	for(var i=0;i<orderarr.length;i++){
		if(orderarr[i]==itemid){
			alert("Item is added to cart already please check cart details");
			return false;
		}
	}
	$("#paytab").val('');
	for(var i=0; i< itemsArr.length;i++) {
		if(itemsArr[i].id==itemid){
		pbody+="<tr><td>"+itemsArr[i].name+"</td><td><input type='text' id='qnty_"+itemsArr[i].price+"' onChange='calamt(this);' name='qnty' /></td><td id='"+itemsArr[i].id+"_price'>"+itemsArr[i].price+"</td></tr>";
		ammount+=parseInt(itemsArr[i].price);
		}
	
	}
	arrids+=itemid+",";
	orderarr.push(itemid)
	$("#paytab").append(pbody);
	//$("#ammout").val(ammount);
	
	pbody="";
	
}
 function payment(){
	 var len=$("#paytab").find('tr').length;
	 for(var i=1; i<=len;i++) {
		var qnty= $("#paytab").find('tr:nth-of-type('+i+')').find(':input').val(); 
		qntyarr.push(qnty);
	 }
	 debugger
	 $("#orderids").val(orderarr);
	 $("#itemquanties").val(qntyarr);
	 $("#payform").submit();
 }
 function cartDetails(){
     $("#paymenttab").show();
 }
</script>
</head>
<body>
      
      <center><h1>Order Page<h1></center>
   <center>
   <br>     
   <table border="1">
			<tr><td>   
      <div>
      <table border="1" id="items">
      <thead><td colspan="3"><b>List of Items</b></td></thead>
      <thead  bg-color="yellow"><td><b>Item Name</b></td><td><b>Item Desc</b></td><td><b>Quantity</b></td><td><b>price</b></td><td><b>Payment</b></td></thead>
      <tbody id="itemtab"></tbody>
      </table>
      </div>
      
      <center> <input type="button"  align="right"  value="CartDetails"  onclick="cartDetails()" /></center>
       <div>
       <form id="payform" action="/ordercontroller" method="get"  >

      <table border="1" id="paymenttab">
      <thead><td colspan="3"><b>Ordered Items</b></td></thead>
      <thead><td><b>Item Name</b></td><td><b>Quantity</b></td><td><b>price</b></td></thead>
      <tbody id="paytab"></tbody>
      <tfoot>
      <td>Total Cost:<td><input type="text" id="ammout" name="ammout"/><input type="button" value="Click to payment" onclick="payment()" /></td>
      
      </tfoot>
      </table>
        <input type="hidden"  id="orderids" name="orderids" />
        <input type="hidden"  id="itemquanties" name="itemquanties" />
      </form>
      </div>
     </td>  </tr></table>
</body>
</html>