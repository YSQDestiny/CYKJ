package com.cykj.service.web.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cykj.service.base.controller.BaseController;
import com.cykj.service.base.util.Utils;
import com.cykj.service.entity.*;
import com.cykj.service.model.DisasterModel;
import com.cykj.service.model.WeatherModel;
import com.cykj.service.web.Constants;
import com.cykj.service.web.service.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/project")
public class ProjectController extends BaseController<Project> {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private WeatherInfoService weatherInfoService;

    @Autowired
    private DisasterService disasterService;

    @Autowired
    private ProjectAccidetnService projectAccidetnService;

    @Autowired
    private DisasterEntityService disasterEntityService;

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

    @RequestMapping(value = "/postPassingPoint", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    private @ResponseBody String postPassingPoint(String projectId,String passingPoint) throws NumberFormatException, Exception{
        Map<String, Object> resultMap = new HashMap<>();
        Project project = null;
        if(projectId != null){
            project = projectService.getById(Project.class, Long.parseLong(projectId));
        }else {
            resultMap.put("code", Constants.RESULT_CODE_FAIL);
            resultMap.put("message", "");
            resultMap.put("data", "");
            return JSONObject.toJSONString(resultMap);
        }
        if(!StringUtils.isEmpty(passingPoint)){
            project.setPassingPost(passingPoint);
        }else{
            resultMap.put("code", Constants.RESULT_CODE_FAIL);
            resultMap.put("message", "");
            resultMap.put("data", "");
            return JSONObject.toJSONString(resultMap);
        }
        projectService.update(project);

        resultMap.put("code", Constants.RESULT_CODE_SUCCESS);
        resultMap.put("message", "");
        resultMap.put("data", "");
        return JSONObject.toJSONString(resultMap);
    }

    @RequestMapping(value = "/postScore", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    private @ResponseBody String postScore(String projectId,String score,String level) throws Exception {
        Map<String, Object> resultMap = new HashMap<>();
        Project project = null;
        if(projectId != null){
            project = projectService.getById(Project.class, Long.parseLong(projectId));
        }else {
            resultMap.put("code", Constants.RESULT_CODE_FAIL);
            resultMap.put("message", "");
            resultMap.put("data", "");
            return JSONObject.toJSONString(resultMap);
        }
        if (!StringUtils.isEmpty(score) & !StringUtils.isEmpty(level)){
            project.setScore(score);
            project.setLevel(level);
        }else {
            resultMap.put("code", Constants.RESULT_CODE_FAIL);
            resultMap.put("message", "");
            resultMap.put("data", "");
            return JSONObject.toJSONString(resultMap);
        }

        projectService.update(project);

        resultMap.put("code", Constants.RESULT_CODE_SUCCESS);
        resultMap.put("message", "");
        resultMap.put("data", "");
        return JSONObject.toJSONString(resultMap);
    }

    @RequestMapping(value = "postWeather",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    private @ResponseBody String postWeatherInfo(String projectId,String weatherStr){
        return "";
    }

    @RequestMapping(value = "/getList",produces = "text/html;charset=UTF-8")
    private @ResponseBody String getProjectList(String uniqueId,String source){
        Map<String,Object> resultMap = new HashMap<>();
        if (source.equals("android")){
            if (uniqueId != null){
                List<Project> projects = projectService.findAllByUniqueId(uniqueId);
                if (projects != null){
                    resultMap.put("code", Constants.RESULT_CODE_SUCCESS);
                    resultMap.put("message",Constants.RESULT_MESSAGE_SUCCESS);
                    resultMap.put("data",projects);
                }else {
                    resultMap.put("code", Constants.RESULT_CODE_FAIL);
                    resultMap.put("message", "");
                    resultMap.put("data", "");
                }
            }
        }
        return JSONObject.toJSONString(resultMap);
    }

    @RequestMapping(value = "/postAccident",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    private @ResponseBody String postAccident(String accidentStr) throws Exception {
        Map<String,Object> resultMap = new HashMap<>();
        if (accidentStr != null){
            List<ProjectAccident> projectAccidents = JSONObject.parseArray(accidentStr,ProjectAccident.class);
            if (projectAccidents != null){
                for (ProjectAccident projectAccident : projectAccidents){
                    projectAccidetnService.save(projectAccident);
                }
                resultMap.put("code", Constants.RESULT_CODE_SUCCESS);
                resultMap.put("message",Constants.RESULT_MESSAGE_SUCCESS);
                resultMap.put("data","");
            }
        }
        return JSONObject.toJSONString(resultMap);
    }

    @RequestMapping(value = "/searchYHD",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    private @ResponseBody String getYHD(String json,String source){
        Map<String,Object> resultMap = new HashMap<>();
        if (source.equals("android")){
            if (json != null){
                Map<String,String> sqlMap = JSONObject.parseObject(json,Map.class);
                List<Disaster> list = disasterEntityService.findDisaster(sqlMap);
                resultMap.put("code", Constants.RESULT_CODE_SUCCESS);
                resultMap.put("message",Constants.RESULT_MESSAGE_SUCCESS);
                resultMap.put("data",JSONObject.toJSONString(list));
            }else {
                resultMap.put("code", Constants.RESULT_CODE_FAIL);
                resultMap.put("message", "");
                resultMap.put("data", "");
            }
        }else {
            resultMap.put("code", Constants.RESULT_CODE_FAIL);
            resultMap.put("message", "");
            resultMap.put("data", "");
        }
        return JSONObject.toJSONString(resultMap);
    }

    @RequestMapping("/showCharts")
    private String showChart(String projectId, Model model) throws Exception{
        Project project = projectService.getById(Project.class,Long.parseLong(projectId));
        String passingPoint = project.getPassingPost();
        List<String> nameList = JSONArray.parseArray(passingPoint,String.class);
        List<WeatherInfo> weatherInfoList = new ArrayList<>();
        for (String name : nameList){
            if (name.length() > 2){
                if (name.indexOf("县") != -1){
                    name = name.replace("县","");
                }else if (name.indexOf("市") != -1){
                    name = name.replace("市","");
                }else if (name.indexOf("区") != -1){
                    if (name.indexOf("龙泉驿") != -1){
                        name = "龙泉驿";
                    }else {
                        name = "成都";
                    }
                }
            }
            WeatherInfo weatherInfo = weatherInfoService.findWeatherInfoByName(name);
            if (weatherInfo != null){
                weatherInfoList.add(weatherInfo);
            }
        }
        model.addAttribute("weatherData",weatherInfoList);
        Map<String ,List<Disasters>> map = disasterService.findDisastersByAddressList(nameList);
        List<DisasterModel> disasterModels = Utils.barDataProcessing(map);
        if (disasterModels != null || disasterModels.size() > 0){
            model.addAttribute("disasterData",disasterModels);
        }

        return "project/weatherchart";
    }

    @RequestMapping("/downloadDoc")
    private ResponseEntity<byte[]> downloadDoc(HttpServletRequest request, HttpServletResponse response) throws IOException {

        File file = new File("C:/WorkSpace/CYKJ/src/main/webapp/WEB-INF/doc/project_report.docx");
//        File file = new File("F:/workspace/CYKJ/src/main/webapp/WEB-INF/doc/project_report.docx");
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

    @RequestMapping("/showProject")
    private String showProjectReport(String projectId,Model model) throws Exception {
        Project project = projectService.getById(Project.class,Long.parseLong(projectId));
        model.addAttribute("project",project);
        String passingPoint = project.getPassingPost();
        List<String> nameList = JSONArray.parseArray(passingPoint,String.class);
        List<WeatherInfo> weatherInfoList = new ArrayList<>();
        for (String name : nameList){
            if (name.length() > 2){
                if (name.indexOf("县") != -1){
                    name = name.replace("县","");
                }else if (name.indexOf("市") != -1){

                    name = name.replace("市","");
                }else if (name.indexOf("区") != -1){
                    if (name.indexOf("龙泉驿") != -1){
                        name = "龙泉驿";
                    }else {
                        name = "成都";
                    }
                }
            }
            WeatherInfo weatherInfo = weatherInfoService.findWeatherInfoByName(name);
            if (weatherInfo != null){
                weatherInfoList.add(weatherInfo);
            }
        }
        model.addAttribute("weatherData",weatherInfoList);
        Map<String ,List<Disasters>> map = disasterService.findDisastersByAddressList(nameList);
        List<DisasterModel> disasterModels = Utils.barDataProcessing(map);
        if (disasterModels != null || disasterModels.size() > 0){
            model.addAttribute("disasterData",disasterModels);
        }
        List<ProjectAccident> projectAccidents = projectAccidetnService.findProjectAccidentByProjectId(project.getId());
        model.addAttribute("projectAccidents",projectAccidents);
        return "project/report";
    }
}
