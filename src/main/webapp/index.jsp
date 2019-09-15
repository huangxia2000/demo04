<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
  </head>
  <body>
  	 <h2>SpringMVC属性注入</h2><hr>
     <form action="admin/userinfo.action" method="post">
     	用名:<input type="text" name="username"><br>
     	密码:<input type="password" name="password"><br>
     	<input type="submit" value="提交">
     </form>
     <hr>
     <h5>属性对象注入</h5>
     <form action="admin/userinfo2.action" method="post">
     	用名:<input type="text" name="username"><br>
     	密码:<input type="password" name="password"><br>
     	<input type="submit" value="提交">
     </form>
     <hr>
     <h5>ajax获取信息</h5>
     <button onclick="clickBtn()">通过ajax获取信息</button>
     <button onclick="clickBtn2()">通过ajax获取封装信息</button>
     <hr>
     <h5>文件操作</h5>
     <form action="admin/fileact.action" method="post" enctype="multipart/form-data">
     	请选择文件:<input type="file" name="fileact">
     	<input type="submit" value="提交">
     </form>
  </body>
  <script type="text/javascript">
  		var clickBtn = function(){
  			$.ajax({
  				url: "admin/userinfo3.action",
  				type: "POST",
  				dataType: "json",
  				 contentType : false,
  				 data:{"username":"zhangsan", "password" : "123"},
  				cache:false,
  				success : function(res){
  					console.log(res);
  				}  
  			});
  		};
  		var clickBtn2 = function(){
  			$.ajax({
  				url: "admin/userinfo4.action",
  				contentType : "application/json;charset=utf-8", //如果采用requestbody那么一定要加
  				type: "POST",
  				data:'{"username":"zhangsan", "password" : "123"}',
  				success : function(res){
  					console.log(res);
  				}
  			});
  		};
  </script>
</html>
