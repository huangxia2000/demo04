<%@ page language="java" contentType="text/html"
    pageEncoding="utf-8" import="java.util.List"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<title>注册后台用户</title>
<script type="text/javascript" src="jquery.min.js"></script>
<style type="text/css">
input[type="submit"] {
	background-color: #555555;
	border: none;
	color: white;
	padding: 8px 20px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 12px;
	margin: 4px 2px;
	cursor: pointer;
	border-radius: 4px;
}</style>
<style>
</style>

<script type="text/javascript">
 $(function(){ 
	 $("#zhuce1").click(function (){
		 $.ajax({
			url:"/Hospital/RegServlet",
			type:"POST",
			data:$("#myfrom").serialize(),
		 	success:function(redata){
		 		
		 	var obj = eval('('+redata+')');
			alert(obj.sid);	 	
		 	},
		 	error:function (){}	,		 			 
		 })
	 });
 })
 $(function(){ 
	 $("#zhanghao").blur(function (){
		 $.ajax({
			url:"/Hospital/RegServlet",
			type:"POST",
			data:{"action":"jiance","zhanghao":$("#zhanghao").val()},
			/* 	$("#myfrom").serialize(), */
		 	success:function(redata){
				var msg="";
				if(redata=="1"){
					msg="恭喜,该用户名可以使用";
					$("#msg").val(0);
				}else
				{
					msg ="该用户名已注册，不能使用";
					$("#msg").val(1);
				}
				$("#txt").html(msg);
		 	},
		 	error:function (){}	,		 			 
		 })
	 });
 }) 
 function tit() {
	var title = $("#quanxian").val();
	if (title==1) {
		$("#divly").hide();
		$("#lingyu").empty();
		$("#shoufei").empty();
		$("#shoufei").val(1);
		$("#lingyu").append(
		"<option value='0'></option>");

		
	} else {
		$("#divly").show();
		$("#lingyu").empty();
		$("#shoufei").empty();
		$("#lingyu").append(
		"<option value='1'>亲子</option><option value='2'>职场</option><option value='3'>爱情</option>"
		);
	
	}
}
	function aa() {

		 var yonghuming=$("#zhanghao").val();
		 var yonghumingsize=$("#zhanghao").val().length;
		 var xingming=$("#xingming").val();
		 var xingmingsize=$("#xingming").val().length;
		 var upass=$("#upass").val();
		 var upasssize=$("#upass").val().length;
	 
		 var nianling=$("#nianling").val();
		 var nianlingsize=$("#nianling").val().length;

			var shouji=$("#xuexiao").val();
			var shoujisize=$("#xuexiao").val().length;
			var dizhi=$("#beijing").val();
			var dizhisize=$("#beijing").val().length;
			
			 var shoufei=$("#shoufei").val();
			 var shoufeisize=$("#shoufei").val().length;
			
			
			var msg=$("#msg").val();
		if (yonghuming == null || "" == yonghuming) {
			alert("账号不能为空!");
			return false;
		}
		if (yonghumingsize >12) {
			alert("账号过长(控制在12字以内)!");
			return false;
		}
		
		
		if (xingming == null || "" == xingming) {
			alert("姓名不能为空!");
			return false;
		}
		if (xingmingsize >7 ) {
			alert("姓名过长(控制在7字以内)!");
			return false;
		}
		
		
		if (upass == null || "" == upass) {
			alert("密码不能为空!");
			return false;
		}
		if (upasssize >8 ) {
			alert("密码过长(控制在8字以内)!");
			return false;
		}
		
		
		if (nianling == null || "" == nianling) {
			alert("年龄不能为空!");
			return false;
		}
		if (nianlingsize >2 ) {
			alert("年龄不正确（100岁以内）!");
			return false;
		}
	 	var x = document.getElementById("nianling").value;//获取input内元素
		if(x==0||x<0){
			 alert("年龄不能为0或者负数");
			 return false;
		 }
		 if(x==""|| isNaN(x))
		 {
			 alert("请填数字");
			 return false;
		}
		
		 
		if (shouji == null || "" == shouji) {
			alert("学校不能为空!");
				return false;
			}
		
		
			if (shoujisize>15) {
				
				 alert("不能超过15个字符!");
				
				return false;
			} 
		


			 
		if (dizhi == null || "" == dizhi) {
			alert("背景不能为空!");
			return false;
		}
		if (dizhisize >30 ) {
			alert("背景过长(控制在30字以内)!");
			return false;
		}
		
		
		if (shoufei == null || "" == shoufei) {
			alert("收费价格为空!");
			return false;
		}
		if (shoufeisize >3 ) {
			alert("价格不超过1000!");
			return false;
		}
	 	var x2 = document.getElementById("shoufei").value;//获取input内元素
		if(x2==0||x2<0){
			 alert("收费不能为0或者负数");
			 return false;
		 }
		 if(x2==""|| isNaN(x2))
		 {
			 alert("收费价格请填数字");
			 return false;
		}
		
		if (msg == 1 ) {
			 alert("账号已经注册");
			return false;
		}
		return true;
	 } 
</script>
</head>
	<body>	
<%-- <a href="LoginFilter">
	第${applicationScope.cishu}次登入;
	账号:${sessionScope.loginName}
	<c:out value="${sessionScope.loginName}"/>	</a> --%>

<form id="myfrom" action="/Hospital/RegServlet" onSubmit="return aa()"  target="main" method="post">


账号：<input type="text"  id="zhanghao" name="zhanghao">
	<span style="color:red;">(必填*) </span>
	<span id="txt" style="color:red;"> </span><br/><br/>

姓名：<input type="text" id="xingming" name="xingming"/><span style="color:red;">(必填*) </span><br/><br/>

密码：<input type="password" id="upass" name="upass" /><span style="color:red;">(必填*) </span><br/><br/>

权限： <select id="quanxian"name="quanxian" onclick="tit()">
 <option value="1">管理员</option>
 <option value="2">咨询师</option>
	</select><br/><br/>	
角色： <select id="jiaose"name="jiaose">
 <option value="1">实习生</option>
 <option value="2">老师</option>
 <option value="3">校长</option>
	</select><br/><br/>	
	
性别：<input type="radio" id="sex" name="sex"value="男" checked="checked">男
	<input type="radio" id="sex1" name="sex" value="女"/>女<br/><br/>
	

年龄：<input type="text" id="nianling" name="nianling"/><span style="color:red;">(必填*) </span><br/><br/>
学校：<input type="text" id="xuexiao" name="xuexiao"/><span style="color:red;">(必填*) </span><br/><br/>
背景：<textarea style="height:50px" size="50px"  id="beijing" name="beijing"/></textarea><span style="color:red;">(必填*) </span><br/><br/>

<div id="divly" style="display:none">

领域：
<select id="lingyu" name="lingyu">
<option value='0'></option>
</select><br/>
收费价格：<input type="text" id="shoufei" value="1" name="shoufei"/><span style="color:red;">(必填*) </span><br/><br/>
</div>

<input type="hidden" name="msg" id="msg"/>
<input type="hidden" name="action" value="zhuce"/>
<input type="submit" value="注册"/><br/>

</form>
<form  action="/Hospital/RegServlet" method="post">
<input type="hidden" name="action" value="fanhui1"/>
<input type="submit" value="返回"/><br/>
</form>
	</body>
</html>