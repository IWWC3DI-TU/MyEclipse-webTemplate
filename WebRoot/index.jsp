<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="css/common.css" type="text/css" />
<title>中国移动应用软件智能监控系统</title>
</head>
<frameset rows="50,*" cols="*" frameborder="no" border="0" framespacing="0">
  <frame src="topframe.html" name="topFrame" frameborder="no" scrolling="no" noresize="noresize" id="topFrame" title="topFrame" />
  <frameset name="myFrame" cols="199,7,*" frameborder="no" border="0" framespacing="0">
    <frame src="leftframe.html" name="leftFrame" frameborder="no" scrolling="no" noresize="noresize" id="leftFrame" title="leftFrame" />
	<frame src="switchframe.html" name="midFrame" frameborder="no" scrolling="no" noresize="noresize" id="midFrame" title="midFrame" />
    <frameset rows="59,*" cols="*" frameborder="no" border="0" framespacing="0">
         <frame src="mainframe.html" name="mainFrame" frameborder="no" scrolling="no" noresize="noresize" id="mainFrame" title="mainFrame" />
         <frame src="manframe.html" name="manFrame" frameborder="no" id="manFrame" title="manFrame" />
     </frameset>
  </frameset>
</frameset>
<noframes><body>
</body>
</noframes>
</html>
