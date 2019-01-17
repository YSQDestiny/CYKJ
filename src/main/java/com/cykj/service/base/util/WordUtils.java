package com.cykj.service.base.util;

import freemarker.template.Configuration;
import freemarker.template.Template;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.Map;

/**
 * @author yangsq
 * @date 2018/6/14 14:32.
 */
public class WordUtils {

    private static Configuration configuration;

//    private static final String templateFolder = WordUtils.class.getClassLoader().getResource("../../").getPath() + "WEB_INF/templetes";
    private static final String templateFolder = "D:/WorkSpace/CYKJ/src/main/webapp/WEB-INF/templates";
    static {
        configuration = new Configuration();
        configuration.setDefaultEncoding("utf-8");
        try {
            configuration.setDirectoryForTemplateLoading(new File(templateFolder));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private WordUtils(){
        throw new AssertionError();
    }

    public static void exportMillCertificateWord(HttpServletRequest request, HttpServletResponse response,Map map,String title,String ftlFile)throws IOException{
        Template freemarkerTemplate = configuration.getTemplate(ftlFile);
        File file = null;
        InputStream fin = null;
        ServletOutputStream out = null;
        try {
            //调用工具类的createDoc方法生成Word文档
            file = createDoc(map,freemarkerTemplate);
            fin = new FileInputStream(file);

            response.setCharacterEncoding("utf-8");
            response.setContentType("application/msword");
            //设置浏览器以下载的方式处理该文件名
            String fileName = title +"查勘报告"+".doc";
            response.setHeader("Content-Disposition","attachment;filename=".concat(String.valueOf(URLEncoder.encode(fileName,"UTF-8"))));

            out = response.getOutputStream();
            //缓冲区
            byte[] buffer = new byte[512];
            int bytesToRead = -1;
            //通过循环将读入的Word文件的内容输出到浏览器中
            while ((bytesToRead = fin.read(buffer)) != -1){
                out.write(buffer,0,bytesToRead);
            }
        }finally {
            if (fin != null){
                fin.close();
            }
            if (out != null){
                out.close();
            }
            if (file != null){
                file.delete(); //删除临时文件
            }
        }
    }

    private static File createDoc(Map<?,?> dataMap, Template template){
        String name = "report.doc";
        File f = new File(name);
        Template t = template;
        try {
            // 这个地方不能使用FileWriter因为需要指定编码类型否则生成的Word文档会因为有无法识别的编码而无法打开
            Writer w = new OutputStreamWriter(new FileOutputStream(f),"utf-8");
            t.process(dataMap,w);
            w.close();
        }catch (Exception ex){
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return f;
    }

}
