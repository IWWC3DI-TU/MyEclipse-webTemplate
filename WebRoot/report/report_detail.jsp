<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.gmcc.autotest.vo.HrefVo"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/common.css" type="text/css" />
<title>测试数据捕获辅助页面</title>
<style type="text/css">
<!--
.style1 {color: #FF0000}
.style2 {color: #333333}
.style3 {color: #000000}
-->
</style>
</head>
<body>
 <div id="man_zone">
 <table width="99%" border="0" align="center"  cellpadding="3" cellspacing="1" class="table_style">
   <tr align="center">
     <td width="5%" class="center_title_1"><span class="left-title">序号</br></span></td>
     <td width="21%" class="center_title_1">连接名称</br></td>
     <td width="46%" class="center_title_1">连接内容</br></td>
     <td width="9%" class="center_title_1">连接级别</br></td>
     <td width="7%" class="center_title_1">连接状态</br></td>
     <td width="7%" class="center_title_1">延时</br></td>
     <td width="7%" class="center_title_1">操作</br></td>
   </tr>
   <tr align="center">
     <td>1</td>
     <td>购物休闲</td>
   <td>http://tianjin.wap.wxcs.cn/gwxx</td>
     <td>1</td>
     <td>有效</td>
     <td>20ms</td>
     <td><a href="#">模拟显示</a></td>
   </tr>
   <tr align="center">
     <td>2</td>
     <td>生活服务</td>
   <td>http://tianjin.wap.wxcs.cn/shfw</td>
     <td>1</td>
     <td>有效</td>
     <td>23ms</td>
     <td><a href="#">模拟显示</a></td>
   </tr>
   <tr align="center">
     <td>3</td>
     <td>意见反馈</td>
   <td>http://tianjin.wap.wxcs.cn/pub/m/wzbz?tab=2&amp;areaName=tianjin&amp;jumpType=1</td>
     <td>1</td>
     <td>有效</td>
     <td>22ms</td>
     <td><a href="#">模拟显示</a></td>
   </tr>
   <tr align="center" class="wong_list">
     <td class="wong_list">4</td>
     <td class="wong_list"><img src="http://tianjin.wap.wxcs.cn/images/TJresourcePackage/20130319034734447.png" width="20" heigh="20"></img></td>
   <td class="wong_list">http://tianjin.wap.wxcs.cn/pub/m/wzbz?tab=1&amp;areaName=tianjin&amp;jumpType=1</td>
     <td class="wong_list">1</td>
     <td class="wong_list">有效</td>
     <td class="wong_list">2000ms</td>
     <td class="wong_list"><a href="#">模拟显示</a></td>
   </tr>
   <tr align="center">
     <td>5</td>
     <td>服务声明</td>
   <td>http://tianjin.wap.wxcs.cn/pub/m/wzbz?tab=4&areaName=tianjin&jumpType=1</td>
     <td>1</td>
     <td>有效</td>
     <td>23ms</td>
     <td><a href="#">模拟显示</a></td>
   </tr>
   <tr align="center">
     <td class="error_list">6</td>
     <td  class="error_list">航班查询</td>
   <td  class="error_list">http://tianjin.wap.wxcs.cn/pub/m/wzbz?tab=7&areaName=tianjin&jumpType=1</td>
     <td  class="error_list">1</td>
     <td  class="error_list">无效</td>
     <td  class="error_list">6000ms</td>
     <td  class="error_list"><a href="#">模拟显示</a></td>
   </tr>
   <%
   //List<HrefVo> ls=(List<HrefVo>)request.getAttribute("link_list");
   
   for(int i=0;i<10;i++){ %>
   <tr align="center">
     <td>7</td>
     <td>更多</td>
     <td>http://tianjin.wap.wxcs.cn/shfw</td>
     <td>2</td>
     <td>有效<%="ddddd"+i%></td>
     <td>23ms</td>
     <td><a href="#">模拟显示</a></td>
   </tr>
   <%} %>
 </table>
 </div>
  <div>
   <table width="100%" border="0">
     <tr>
       <td align="right"><form name="form1" method="post" action="">
	   <input name="export" type="button" value="报表导出">
       </form></td>
     </tr>
   </table>
 </div>
</body>
</html>

