package com.gmcc.autotest.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.log4j.Logger;

public class Utils {
	public Logger Log = Logger.getLogger(this.getClass().getName());

	private static Utils instance = null;

	public static Utils getInstance() {
		if (instance == null) {
			instance = new Utils();
		}

		return instance;
	}
	/**
	 * get web real path
	 * @param request
	 * @return
	 */
	public static String GETRealPaht(HttpServletRequest request){
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		return basePath;
	}
	/**
	 * get body from body
	 * @param url :web url
	 * @return web body Stream as String
	 * @throws HttpException
	 * @throws IOException
	 */
	public String getBody(String url) throws HttpException, IOException {
		MultiThreadedHttpConnectionManager connectionManager = new MultiThreadedHttpConnectionManager();
		HttpClient client = new HttpClient(connectionManager);
		List<Header> headers = new ArrayList<Header>();
		headers.add(new Header("User-Agent", "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1)"));
		client.getHostConfiguration().getParams().setParameter("http.default-headers", headers);
		client.getHostConfiguration().getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "utf-8");
		GetMethod getMethod = new GetMethod(url);
		// Log.info("url---->"+url);
//		postMethod.addParameter("p", "\"java2s\"");
//		postMethod.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
		int statusCode = client.executeMethod(getMethod);
		Log.info("status===>" + statusCode);
		String responseString = "";

		// 保存用户全局cookies

		responseString = getMethod.getResponseBodyAsString();
		getMethod.releaseConnection();// 关闭POST请求
		return responseString;
	}

	public String getStreamAsString(String url) {
		StringBuffer sb = new StringBuffer();
		try {
			File f = new File(url);
			InputStream is = new FileInputStream(f);

			int i = 0;

			while ((i = is.read()) != -1) {
				sb.append(i + "&");
				// System.out.println("i===>"+i);
			}
			is.close();
			System.out.println("opt===>" + sb.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	public void doWork(String url) {
		try {
			//http://tianjin.wap.wxcs.cn/m/index?areaCode=120000

			String body = getBody(url);
			Log.info(body);
			ExtractLink el = new ExtractLink(body);
			Map<String, String> link = el.getLinks();
			Iterator<String> it = link.keySet().iterator();
			while (it.hasNext()) {
				String key = it.next();
				System.out.print("key===>" + key + "...");
				System.out.println("href===>" + link.get(key));
				String href = link.get(key);
				if (href.indexOf("http://") == -1&&href.indexOf("#")==-1) {
					href = "http://tianjin.wap.wxcs.cn/"+ href;
					System.out.println("合法连接："+href);
				}
//				doWork(href);
			}
			// System.out.println("结果："+body);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		String str1 = "";
		String str2 = "";
		Utils ut = Utils.getInstance();
		ut.doWork("http://tianjin.wap.wxcs.cn/m/index");

		// str1=ut.getStreamAsString("c:\\source.jpg");
		// str2=ut.getStreamAsString("c:\\target.jpg");
		// Compare cap=new Compare(str1,str2);
		// System.out.println("source===>"+cap.getResultSource());
		// System.out.println("target===>"+cap.getResultTarget());
		System.out.println("结果：" + str1.indexOf(str2));
	}
}
