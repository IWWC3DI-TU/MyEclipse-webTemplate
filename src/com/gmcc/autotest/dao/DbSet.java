package com.gmcc.autotest.dao;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

//import org.apache.log4j.Logger ;

/**
 * <p>
 * Title:  
 * </p>
 * <p>
 * Description:  
 * </p>
 * <p>
 * Copyright: Copyright (c) 2003
 * </p>
 * <p>
 * Company:  
 * </p>
 * 
 * @author lizq
 * @version 1.0
 */
public class DbSet {
	private static  Logger Log = Logger.getLogger(Class.class.getName());
    public static String driverClass; // ��ݿ���

    public static String url; // ���Դ

    public static String minCount; // ��ݿ����Сl����

    public static String maxCount; // ��ݿ�����l����

    public static String user; // �û���

    public static String passwd; // �û�����

    public static String logPath; // ��ݿ���־�ļ�·��

    public static int timeOut; // ֱ�ȴ�

    private static String GBKtoISO;

    private static String ISOtoGBK; // �Ƿ���Ҫ���ַ�ת��


    public static void main(String args[]) {

        int i = 0;
        String s = "";
        String a[] = null;

        try {

            s = "insert into ck values('ck','���Ĳ���') ";

            if (args.length > 0)
                s = args[0];

            // parseSql(s) ;
            // Log.info("***=" + s);

        } catch (Exception e) {
            Log.info(e.getMessage());
            // Log.info(e);
        }
    }
//
//    /**
//     * ��ԭʼ��sql�����������һ��PreparedStatement���� add by ck 2003.09.24
//     * 
//     * @param conn
//     * @param sSql
//     * @return
//     */
//    public static PreparedStatement prepareSql(Connection conn, String sSql)
//            throws Exception {
//        try {
//            Function f = new Function();
//
//            PreparedStatement ps = null;
//
//            String sReturn = "";
//
//            String[] a = null;
//            a = f.strToArray(f.replace(sSql, "''", "' '") + " ", "'");
//
//
//            sReturn = "";
//            if (a.length == 1) {
//                // ��û���ַ����ʱ
//                sReturn = a[0];
//            } else if (a.length <= 4) {
//                // ��ֻ��һ���ַ����ʱ
//                sReturn = a[0] + "?";
//            } else {
//                // ������һ���ַ����ʱ
//                for (int i = 0; i + 2 < a.length; i += 2) {
//                    // logger.info("i=" + i);
//                    sReturn += a[i] + "?";
//                    // logger.info("119.sReturn=" + sReturn);
//                }
//            }
//            // ����ʣ��Ԫ�أ���֮׷���ں��档
//            if (a.length > 1)
//                sReturn += a[a.length - 1];
//
//            // logger.info("125.sReturn=" + sReturn);
//
//            ps = conn.prepareStatement(sReturn);
//
//            if (a.length == 1) {
//                // ��û���ַ����ʱ
//                sReturn = a[0];
//            } else if (a.length <= 4) {
//                // ��ֻ��һ���ַ����ʱ
//                ps.setString(1, GBKtoISO(a[1]));
//
//            } else {
//                // ������һ���ַ����ʱ
//                for (int i = 0, j = 0; i + 2 < a.length; i += 2, j++) {
//                    // logger.info("143.j=" + j + "-----" + a[i + 1]);
//                    ps.setString(j + 1, GBKtoISO(a[i + 1]));
//                }
//            }
//
//            return ps;
//        } catch (Exception e) {
//            e.printStackTrace(System.out);
//            throw e;
//        }
//    }

    /**
     * ��ʼ�����Դ����
     * 
     * @throws EBankException
     */
    public static void init() {
        try {
            ResourceBundle resource = null;
            resource = ResourceBundle.getBundle("conn", Locale.getDefault());
            driverClass = resource.getString("driverClass");
            url = resource.getString("url");
            minCount = resource.getString("minCount");
            maxCount = resource.getString("maxCount");
            user = resource.getString("user");
            passwd = resource.getString("passwd");
            logPath = resource.getString("logPath");
            timeOut = 18000;
            GBKtoISO = resource.getString("GBKtoISO");
            ISOtoGBK = resource.getString("ISOtoGBK");
        } catch (Exception e) {
        }
    }

    /**
     * ת�룺GBK ----> iso-8859-1
     * 
     * @param s
     *            Ҫת���ֶ�
     * @return ת�����ֶ�
     */
    public static String GBKtoISO(String s) {
        try {
            if (GBKtoISO.equals("1")) // �Ƿ���ת�룬�������ļ�conn.propertiesֻ����
                s = new String(s.getBytes("GBK"), "iso-8859-1");
        } catch (Exception e) {
        }
        return s;
    }

    /**
     * ת�룺iso-8859-1 ----> GBK
     * 
     * @param s
     *            ת���ֶ�
     * @return ת�����ֶ�
     */
    public static String ISOtoGBK(String s) {
        try {
            if (ISOtoGBK.equals("1"))// �Ƿ���ת�룬�������ļ�conn.propertiesֻ����
                s = new String(s.getBytes("iso-8859-1"), "GBK");
        } catch (Exception e) {
        }
        return s;
    }

    /**
     * ��ݿ�д��־
     * 
     * @param logType
     *            ��־����
     * @param msg
     *            ��־��Ϣ
     */
    public static void writeLog(String logType, String msg) {

        // ��ȡ���ں�ʱ�䣬��ɸ�ʽΪ 2001-03-09 09:08:07
        Calendar calNow = Calendar.getInstance();

        String yy = "", mm = "", dd = "";
        int y = calNow.get(calNow.YEAR);
        int m = calNow.get(calNow.MONTH) + 1;
        int d = calNow.get(calNow.DAY_OF_MONTH);

        yy = String.valueOf(y);
        mm = String.valueOf(100 + m).substring(1);
        dd = String.valueOf(100 + d).substring(1);
        String tmpDay = yy + "-" + mm + "-" + dd;

        String hh = "", min = "", ss = "";
        int h = calNow.get(calNow.HOUR_OF_DAY);
        int mi = calNow.get(calNow.MINUTE);
        int s = calNow.get(calNow.SECOND);
        hh = String.valueOf(100 + h).substring(1);
        min = String.valueOf(100 + mi).substring(1);
        ss = String.valueOf(100 + s).substring(1);
        String tmpTime = String.valueOf(hh + ":" + min + ":" + ss);

        if (logType.equals("work")) {
            logType = "Work_";
        } else if (logType.equals("error")) {
            logType = "Err_";
        } else {
            logType = "Other_";
        }

        try {
            if (logPath == null)
                init();
        } catch (Exception e) {
        }
        // ���ļ�����
        String nameOfTextFile = logPath + "\\" + logType + tmpDay + ".log";
        // ��ȡ�ļ����Ȳ���������
        File fl = new File(nameOfTextFile);
        int flen = (int) fl.length();
        char file_content[] = new char[flen];

        // ���ļ�����
        try {
            if (fl.canRead()) {
                FileReader fis = new FileReader(nameOfTextFile);
                flen = fis.read(file_content);
                fis.close();
            }
        } catch (IOException e) {
        }

        // д�ļ�����
        try {
            String head = "[" + tmpDay + " " + tmpTime + "]  " + msg + "\r\n";
            FileWriter pw = new FileWriter(nameOfTextFile);
            pw.write(head);
            pw.write(file_content, 0, flen);

            // pw.write(file_content, 0, flen);
            // pw.write(head);

            pw.close();
        } catch (IOException e) {
        }
    }
}
