<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../css/common.css" type="text/css" />
<title>测试数据捕获辅助页面</title>
<style type="text/css">
</style>
</head>
<body>
<div id="man_zone">
 <table width="99%" border="0" align="center"  cellpadding="3" cellspacing="1" class="table_style">
   <tr align="center">
     <td width="5%" class="center_title_1"><span class="left-title">序号</br></span></td>
     <td width="15%" bgcolor="#669999" class="center_title_1">任务名称</br></td>
     <td width="19%" class="center_title_1">自动拨测日期</br></td>
     <td width="13%" class="center_title_1">正常连接数</td>
     <td width="13%" class="center_title_1">延时连接数</td>
     <td width="13%" class="center_title_1">无效连接数</td>
     <td width="15%" class="center_title_1">UI/UE异常数</br></td>
   <td width="15%" class="center_title_1">操作</td>
   </tr>
   <tr align="center">
     <td>1</td>
     <td>无线城市WEB测试</td>
   <td>2013/11/18</td>
     <td bgcolor="#669933">120</td>
     <td bgcolor="#FFCC00">3</td>
     <td bgcolor="#FF8262">13</td>
     <td bgcolor="#669999">1</td>
   <td><a href="<%=basePath%>Controller?nextBo=com.gmcc.autotest.bo.report.ShowDetailReport&id=testID">详细信息</a></td>
   </tr>
   <tr align="center">
     <td>2</td>
     <td>139邮箱测试</td>
   <td>2013/11/19</td>
      <td bgcolor="#669933">98</td>
     <td bgcolor="#FFCC00">1</td>
     <td bgcolor="#FF8262">0</td>
     <td bgcolor="#669999">0</td>
   <td><a href="#">详细信息</a></td>
   </tr>
   <tr align="center">
     <td>3</td>
     <td>其它WEB系统测试</td>
   <td>2013/11/21</td>
      <td bgcolor="#669933">72</td>
     <td bgcolor="#FFCC00">0</td>
     <td bgcolor="#FF8262">0</td>
     <td bgcolor="#669999">1</td>
   <td><a href="#">详细信息</a></td>
   </tr>
 </table>
</div>
 <div>
   <table width="99%" border="0">
     <tr>
       <td align="right"><form name="form1" method="post" action="">
	   <input name="export" type="button" value="报表导出">
       </form></td>
     </tr>
   </table>
 </div>
</body>
</html>
