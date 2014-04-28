/*
 * Created on 2005-4-9
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.gmcc.autotest.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;
/**
 * @author �ƽ�
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public interface Command {
  public String Execute(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException;
 // public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}