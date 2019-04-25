package com.cykj.service.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.cykj.service.base.util.DateUtil;
import com.cykj.service.base.util.FtpUtil;
import com.cykj.service.base.util.IDUtils;
import com.cykj.service.base.util.SFTPUtil;
import com.cykj.service.entity.Hydro;
import com.cykj.service.entity.HydroImage;
import com.cykj.service.web.Constants;
import com.cykj.service.web.service.HydroImageService;
import com.cykj.service.web.service.HydroService;
import com.jcraft.jsch.SftpException;
import org.apache.james.mime4j.dom.datetime.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/img")
public class ImgUploadController {

    @Autowired
    private HydroImageService imageService;
    @Autowired
    private HydroService hydroService;


    private String host = "47.92.209.204";
    // 端口
    private int port = 22;
    // ftp用户名
    private String userName = "ftpuser";
    // ftp用户密码
    private String passWord = "64055329";
    // 文件在服务器端保存的主目录
    private String basePath = "/home/ftpuser/www/images";
    // 访问图片时的基础url
    private String baseUrl = "http://47.92.209.204:201/images";

    @RequestMapping(value = "/upload",produces="text/html;charset=UTF-8")
    private @ResponseBody String pictureUpload(@RequestParam("pic")MultipartFile uploadFile, String target, Long id,String name) {

        Map<String,Object> resultMap = new HashMap<>();
        try {
            String oldName = uploadFile.getOriginalFilename();
            String newName = IDUtils.genImageName();
            newName = newName + oldName.substring(oldName.lastIndexOf("."));
            String filePath = target +"/"+ DateUtil.parseToString(new Date(),DateUtil.yyMMdd2);

            InputStream inputStream = uploadFile.getInputStream();
            SFTPUtil sftp = new SFTPUtil(userName,passWord,host,port);
            sftp.login();
            sftp.upload(basePath,filePath,newName,inputStream);
            sftp.logout();

            String url = baseUrl+"/"+filePath+"/"+newName;
            System.out.println("=========================>url:"+baseUrl+"/"+filePath+"/"+newName);

            Hydro hydro = hydroService.getById(Hydro.class,id);
            if (hydro == null){
                resultMap.put("code", Constants.RESULT_CODE_FAIL);
                resultMap.put("message",Constants.RESULT_MESSAGE_FAIL);
                resultMap.put("data","");
            }else {
                HydroImage hydroImage = new HydroImage();
                hydroImage.setHydroID(id);
                hydroImage.setName(name);
                hydroImage.setImg(url);
                imageService.save(hydroImage);
            }
            resultMap.put("code", Constants.RESULT_CODE_SUCCESS);
            resultMap.put("message",Constants.RESULT_MESSAGE_SUCCESS);
            resultMap.put("data","");
        } catch (SftpException ex){
            ex.printStackTrace();
            resultMap.put("code", Constants.RESULT_CODE_FAIL);
            resultMap.put("message",Constants.RESULT_MESSAGE_FAIL);
            resultMap.put("data","");
        } catch (Exception e){
            e.printStackTrace();
            resultMap.put("code", Constants.RESULT_CODE_FAIL);
            resultMap.put("message",Constants.RESULT_MESSAGE_FAIL);
            resultMap.put("data","");
        }
        return JSONObject.toJSONString(resultMap);
    }

    @RequestMapping(value = "/uploadImg",produces="text/html;charset=UTF-8")
    private @ResponseBody String uploadProjectImage(@RequestParam("pic")MultipartFile uploadFile,String target){
        Map<String,Object> resultMap = new HashMap<>();
        try {
            String oldName = uploadFile.getOriginalFilename();
            String newName = IDUtils.genImageName();
            newName = newName + oldName.substring(oldName.lastIndexOf("."));
            String filePath = target +"/"+ DateUtil.parseToString(new Date(),DateUtil.yyMMdd2);

            InputStream inputStream = uploadFile.getInputStream();
            SFTPUtil sftp = new SFTPUtil(userName,passWord,host,port);
            sftp.login();
            sftp.upload(basePath,filePath,newName,inputStream);
            sftp.logout();

            String url = baseUrl+"/"+filePath+"/"+newName;
            System.out.println("=========================>url:"+baseUrl+"/"+filePath+"/"+newName);

            resultMap.put("code", Constants.RESULT_CODE_SUCCESS);
            resultMap.put("message",Constants.RESULT_MESSAGE_SUCCESS);
            resultMap.put("data",url);
        } catch (SftpException ex){
            ex.printStackTrace();
            resultMap.put("code", Constants.RESULT_CODE_FAIL);
            resultMap.put("message",Constants.RESULT_MESSAGE_FAIL);
            resultMap.put("data","");
        } catch (Exception e){
            e.printStackTrace();
            resultMap.put("code", Constants.RESULT_CODE_FAIL);
            resultMap.put("message",Constants.RESULT_MESSAGE_FAIL);
            resultMap.put("data","");
        }
        return JSONObject.toJSONString(resultMap);



    }

}

