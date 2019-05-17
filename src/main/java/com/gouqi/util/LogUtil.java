package com.gouqi.util;

import com.gouqi.entity.ReportBean;

import java.io.*;

/**
 * @ClassName LogUtil
 * @Description 写log的工具类
 * @Auther Wangjy
 * @Data 2019/5/17 14:18
 **/
public class LogUtil {
    // log文件存放的路径
    private final static String logPath = "D:\\logs\\";
    public static BufferedWriter out = null;

    /**
     * @return void
     * @Description // 开始log
     * @Date 14:20 2019/5/17
     * @Param []
     **/
    public static void startLog() {
        String path = "";
        FileOutputStream fileOutputStream = null;
        String logTime = TimeUtil.getTime("HH时mm分ss秒");
        String logFolder = TimeUtil.getTime("yyyy-MM-dd");
        path = logPath + logFolder + "\\Testlog" + logTime + ".txt";
        // 创建文件夹
        File logFolderPath = new File(logPath + logFolder);
        // 创建文件
        File file = new File(path);
        try {
            if (!logFolderPath.exists()) {
                logFolderPath.mkdir();
            }
            if (!file.exists()) {
                file.createNewFile();
            }
            fileOutputStream = new FileOutputStream(file);
            out = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @Description // 统计结果并结束log
     * @Date 14:21 2019/5/17
     * @Param ReportBean
     * @return void
     **/
    public static void endLog(ReportBean report) {
        try {
			out.write("共执行用例： " + report.getCaseNum() + " 个 ");
			out.write(" pass： " + report.getPassNum() + " 个 ");
			out.write(" warning： " + report.getWarningNum() + " 个 ");
			out.write(" fail： " + report.getFailNum() + " 个 ");
			out.write(" error： " + report.getErrorNum() + " 个\r\n");
			out.write("共执行接口： " + report.getiNum() + " 个 ");
			out.write(" pass： " + report.getIpassNum() + " 个 ");
			out.write(" warning： " + report.getIwarningNum() + " 个 ");
			out.write(" fail： " + report.getIfailNum() + " 个 ");
			out.write(" error： " + report.getIerrorNum() + " 个\r\n");
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
