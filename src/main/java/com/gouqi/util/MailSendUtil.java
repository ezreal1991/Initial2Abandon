package com.gouqi.util;

import com.gouqi.entity.ReportBean;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

/**
 * @ClassName MailSendUtil
 * @Description TODO
 * @Auther Wangjy
 * @Data 2019/5/17 14:59
 **/
public class MailSendUtil {
    public static void sendMail(ReportBean report) throws AddressException, MessagingException {
        Properties properties = new Properties();
        properties.put("mail.transport.protocol", "smtp");// 连接协议
        properties.put("mail.smtp.host", "smtp.qq.com");// 主机名
        properties.put("mail.smtp.port", 465);// 端口号
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.enable", "true");// 设置是否使用ssl安全连接 ---一般都使用
        properties.put("mail.debug", "true");// 设置是否显示debug信息 true 会在控制台显示相关信息
        // 得到回话对象
        Session session = Session.getInstance(properties);
        // 获取邮件对象
        Message message = new MimeMessage(session);
        // 设置发件人邮箱地址
        message.setFrom(new InternetAddress("957649465@qq.com"));
        // 设置收件人邮箱地址
        // message.setRecipients(Message.RecipientType.TO, new
        // InternetAddress[]{new InternetAddress("wangjiayu@wisetv.com.cn"),new
        // InternetAddress("wangjiayu@wisetv.com.cn")});
        message.setRecipient(Message.RecipientType.TO, new InternetAddress("wangjiayu@wisetv.com.cn"));// 一个收件人
        // 设置邮件标题
        message.setSubject("测试结果");
        // 设置邮件内容
        // message.setText("邮件内容邮件内容邮件内容xmqtest");
        Multipart mainPart = new MimeMultipart();
        // 创建一个包含HTML内容的MimeBodyPart
        BodyPart html = new MimeBodyPart();
        String htmlstr = "<html><body>";
        htmlstr += "<h2>测试报告</h2>";
        htmlstr += "<center>";
        htmlstr += "<table align='center' border='0' cellpadding='0' cellspacing='0' height='100%' width='100%' id='bodyTable'>";
        htmlstr += "<table border='1' align='center' width='400px'>";
        htmlstr += "<tr bgcolor='LightSteelBlue'><td>测试用例</td><td>数量</td>";
        htmlstr += "</tr>";
        htmlstr += "<tr bgcolor='LightSkyBlue'><td>total</td><td>" + report.getCaseNum() + "</td>";
        htmlstr += "</tr>";
        htmlstr += "<tr><td>error</td><td>" + report.getErrorNum() + "</td>";
        htmlstr += "</tr>";
        htmlstr += "<tr bgcolor='LightSkyBlue'><td>fail</td><td>" + report.getFailNum() + "</td>";
        htmlstr += "</tr>";
        htmlstr += "<tr><td>warning</td><td>" + report.getWarningNum() + "</td>";
        htmlstr += "</tr>";
        htmlstr += "<tr bgcolor='LightSkyBlue'><td>pass</td><td>" + report.getPassNum() + "</td>";
        htmlstr += "</tr>";
        htmlstr += "</table>";
        htmlstr += "<br />";
        htmlstr += "<table border='1' width='400px'>";
        htmlstr += "<tr bgcolor='LightSteelBlue'><td>接口</td><td>数量</td>";
        htmlstr += "</tr>";
        htmlstr += "<tr bgcolor='LightSkyBlue'><td>total</td><td>" + report.getiNum() + "</td>";
        htmlstr += "</tr>";
        htmlstr += "<tr><td>error</td><td>" + report.getIerrorNum() + "</td>";
        htmlstr += "</tr>";
        htmlstr += "<tr bgcolor='LightSkyBlue'><td>fail</td><td>" + report.getIfailNum() + "</td>";
        htmlstr += "</tr>";
        htmlstr += "<tr><td>warning</td><td>" + report.getIwarningNum() + "</td>";
        htmlstr += "</tr>";
        htmlstr += "<tr bgcolor='LightSkyBlue'><td>pass</td><td>" + report.getIpassNum() + "</td>";
        htmlstr += "</tr>";
        htmlstr += "</table>";
        htmlstr += "</table>";
        htmlstr += "</center>";
        htmlstr += "</body></html>";
        // 设置HTML内容
        html.setContent(htmlstr, "text/html; charset=utf-8");
        mainPart.addBodyPart(html);
        // 创建附件"节点"
        MimeBodyPart attachment = new MimeBodyPart();
        String folderPath = TimeUtil.getTime("yyyy-MM-dd");
        // 读取本地文件
        DataHandler dh2 = new DataHandler(new FileDataSource("D:\\html\\" + folderPath + "\\" + report.getName() + ".html"));
        // 将附件数据添加到"节点"
        attachment.setDataHandler(dh2);
        // 设置附件的文件名（需要编码）
        try {
            attachment.setFileName(MimeUtility.encodeText(dh2.getName()));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        mainPart.addBodyPart(attachment);     // 如果有多个附件，可以创建多个多次添加
        // 将MiniMultipart对象设置为邮件内容
        message.setContent(mainPart);
        // 得到邮差对象
        Transport transport = session.getTransport();
        // 连接自己的邮箱账户
        transport.connect("957649465@qq.com", "");// 密码为QQ邮箱开通的stmp服务后得到的客户端授权码
        // 发送邮件
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }
}
