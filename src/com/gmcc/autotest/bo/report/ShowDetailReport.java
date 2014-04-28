package com.gmcc.autotest.bo.report;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gmcc.autotest.control.Command;
import com.gmcc.autotest.dao.DbManager;
import com.gmcc.autotest.util.Log;
import com.gmcc.autotest.util.Utils;
import com.gmcc.autotest.vo.HrefVo;

/**
 * 
 * @author Michael
 *
 */
public class ShowDetailReport implements Command{

	public String Execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<HrefVo> HrefList=null;
		try{
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
		String sql = "insert into yqemail(toemail,plantforminfo,searchtime,yqcontent,issended,publishtime) values(?,?,?,?,?,?)";
		Connection conn = DbManager.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, "你好");
		ResultSet rs = ps.executeQuery();
		HrefList=new ArrayList<HrefVo>();
		while(rs.next()){
			HrefVo hv=new HrefVo();
			hv.setHrefName(rs.getString("对应的字段名字"));
			HrefList.add(hv);
		}
		}catch(Exception e){
			Log.err(e.getMessage());
		}
		
		request.setAttribute("Link_list",HrefList);
		return "report/report_detail.jsp";
	}
}
