<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!-- 不要用ie演示 -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<style type="text/css">
.error_msg {
	color: #ff342a;
}
</style>
		<script type="text/javascript" src="js/jquery.min.js">
</script>
		<script type="text/javascript">
function check_ename() {
	var ename = $("#ename").val();
	// 校验Ename是否为空
	if (ename == "") {
		$("#ename_msg").text("Ename不能为空.").addClass("error_msg");
		return;
	}
	// 异步是否重复
	$.post("demo/login!checkUname.action", {
		"uname" : ename
	}, function(data) {
		 if(data.info=="success"){
			 $("#ename_msg").text("已注册").removeClass("error_msg");
		 }else{
			 $("#ename_msg").text("可用").removeClass("error_msg");
		 }
		    // 回调函数的参数就是返回的info属性
			//var info = data;
			// 根据返回值设置提示信息
			/*if (info.success) {
				//  验证通过，设置提示信息并移除错误样式
				$("#ename_msg").text(info.message).removeClass("error_msg");
			} else {
				// 验证失败，设置提示信息并添加错误样式
				$("#ename_msg").text(info.message).addClass("error_msg");
			}*/
	});
}
</script>

	</head>

	<body>
		<form action="" method="post">
			请输入员工姓名：
			<input id="ename" type="text" size="20" name="ename"   
				onblur="check_ename()" />
			<span id="ename_msg"></span>
		</form>
	</body>
</html>
