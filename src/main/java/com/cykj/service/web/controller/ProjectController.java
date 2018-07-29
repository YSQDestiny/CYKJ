package com.cykj.service.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.cykj.service.base.controller.BaseController;
import com.cykj.service.entity.Project;
import com.cykj.service.entity.Record;
import com.cykj.service.model.CompanyModel;
import com.cykj.service.web.Constants;
import com.cykj.service.web.service.ProjectService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/project")
public class ProjectController extends BaseController<Project> {

    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "/post",produces="text/html;charset=UTF-8")
    private @ResponseBody String saveProject(String json) throws Exception {
        Map<String,Object> resultMap = new HashMap<>();
        if (!StringUtils.isEmpty(json)){
            Project project = JSONObject.parseObject(json,Project.class);
            if (project != null){
                Long id = projectService.saveAndGetId(project);
                resultMap.put("code", Constants.RESULT_CODE_SUCCESS);
                resultMap.put("message",Constants.RESULT_MESSAGE_SUCCESS);
                resultMap.put("data",id);
            }else {
                resultMap.put("code", Constants.RESULT_CODE_FAIL);
                resultMap.put("message","json数据处理失败！");
                resultMap.put("data","");
            }
        }else {
            resultMap.put("code", Constants.RESULT_CODE_FAIL);
            resultMap.put("message","json数据不能为空！");
            resultMap.put("data","");
        }
        return JSONObject.toJSONString(resultMap);
    }

    @RequestMapping(value = "/postStr",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    private @ResponseBody String postStr(String projectId,String geologyStr) throws Exception {
        Map<String,Object> resultMap = new HashMap<>();
        Project project = null;
        if (projectId != null){
            project = projectService.getById(Project.class,Long.parseLong(projectId));
        }else {
            resultMap.put("code",Constants.RESULT_CODE_FAIL);
            resultMap.put("message","");
            resultMap.put("data","");
            return JSONObject.toJSONString(resultMap);
        }
        if (!StringUtils.isEmpty(geologyStr)){
            project.setGeological(geologyStr);
        }else {
            resultMap.put("code",Constants.RESULT_CODE_FAIL);
            resultMap.put("message","");
            resultMap.put("data","");
            return JSONObject.toJSONString(resultMap);
        }

        projectService.update(project);

        resultMap.put("code",Constants.RESULT_CODE_SUCCESS);
        resultMap.put("message","");
        resultMap.put("data","");
        return JSONObject.toJSONString(resultMap);
    }

    @RequestMapping("/downloadDoc")
    private ResponseEntity<byte[]> downloadDoc(HttpServletRequest request, HttpServletResponse response) throws IOException {


//        File file = new File("C:/WorkSpace/CYKJ/src/main/webapp/WEB-INF/doc/project_report.docx");
        File file = new File("F:/workspace/CYKJ/src/main/webapp/WEB-INF/doc/project_report.docx");
        byte[] body = null;
        InputStream is = new FileInputStream(file);
        body = new byte[is.available()];
        is.read(body);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attchement;filename=" + file.getName());
        HttpStatus statusCode = HttpStatus.OK;
        ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(body, headers, statusCode);
        return entity;
    }
}
