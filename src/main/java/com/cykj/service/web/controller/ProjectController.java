package com.cykj.service.web.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cykj.service.base.controller.BaseController;
import com.cykj.service.base.util.DateUtil;
import com.cykj.service.base.util.Utils;
import com.cykj.service.entity.*;
import com.cykj.service.model.DisasterModel;
import com.cykj.service.model.StringModel;
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
import java.util.*;

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

    /**
     * 创建工程查勘项目
     * @param name
     * @param uniqueId
     * @return
     */
    @RequestMapping(value = "/createProject",produces = "text/html;charset=UTF-8")
    private @ResponseBody String createProject(String name,String uniqueId){
        Map<String,Object> resultMap = new HashMap<>();
            if (!StringUtils.isEmpty(name)){
                Project project = new Project();
                project.setName(name);
                project.setUniqueId(uniqueId);
                project.setMakeTime(DateUtil.parseToString(new Date(),DateUtil.yyyyMMddHHmmss));
                Long id = projectService.saveAndGetId(project);
                resultMap.put("code", Constants.RESULT_CODE_SUCCESS);
                resultMap.put("message",Constants.RESULT_MESSAGE_SUCCESS);
                resultMap.put("data",id);
            }else {
                resultMap.put("code", Constants.RESULT_CODE_FAIL);
                resultMap.put("message","name字段不能为空！");
                resultMap.put("data","");
            }
        return JSONObject.toJSONString(resultMap);
    }

    @RequestMapping(value = "/saveProject",produces = "text/html;charset=UTF-8")
    private @ResponseBody String saveProject(Long id,String json) throws Exception {
        Map<String,Object> resultMap = new HashMap<>();
        if (id != null){
            Project temp = projectService.getById(Project.class,id);
            if (json != null){
                Project project = JSONObject.parseObject(json,Project.class);
                temp.setAddr(project.getAddr());
                temp.setTown(project.getTown());
                temp.setProvince(project.getProvince());
                temp.setCity(project.getCity());
                temp.setCounty(project.getCounty());
                temp.setConstruction(project.getConstruction());
                temp.setBuilding(project.getBuilding());
                temp.setType(project.getType());
                temp.setReviewType(project.getReviewType());
                temp.setClientContact(project.getClientContact());
                temp.setClientPhone(project.getClientPhone());
                temp.setClient(project.getClient());
                projectService.update(temp);
                resultMap.put("code", Constants.RESULT_CODE_SUCCESS);
                resultMap.put("message",Constants.RESULT_MESSAGE_SUCCESS);
                resultMap.put("data","");
            }else {
                resultMap.put("code", Constants.RESULT_CODE_FAIL);
                resultMap.put("message","项目数据为空！");
                resultMap.put("data","");
            }
        }else{
            resultMap.put("code", Constants.RESULT_CODE_FAIL);
            resultMap.put("message","项目ID为空！");
            resultMap.put("data","");
        }
        return JSONObject.toJSONString(resultMap);
    }

    @RequestMapping(value = "/updateProject",produces = "text/html;charset=UTF-8")
    private @ResponseBody String updateProject(Long id,String target,String json) throws Exception {
        Map<String,Object> resultMap = new HashMap<>();
        if (id != null){
            Project project = projectService.getById(Project.class,id);
            if (project != null){
                switch (target){
                    case "scale":
                        project.setScale(json);
                        projectService.update(project);
                        break;
                    case "geology":
                        project.setGeological(json);
                        projectService.update(project);
                        break;
                    case "analysis":
                        Map<String,Object> map = JSONObject.parseObject(json,Map.class);
                        Map<String,String> YHDmap = null;
                        if (map.get("YHD").equals("")){
                            YHDmap = null;
                        }else {
                            YHDmap = (Map<String, String>) map.get("YHD");
                        }
                        String lv = (String) map.get("lv");
                        project.setLv(lv);
                        if (YHDmap != null){
                            project.setYhd(JSONObject.toJSONString(YHDmap));
                        }else {
                            project.setYhd("");
                        }
                        projectService.update(project);
                        break;
                    default:
                        break;
                }
                resultMap.put("code", Constants.RESULT_CODE_SUCCESS);
                resultMap.put("message",Constants.RESULT_MESSAGE_SUCCESS);
                resultMap.put("data","");
            }else {
                resultMap.put("code", Constants.RESULT_CODE_FAIL);
                resultMap.put("message","项目数据获取失败！");
                resultMap.put("data","");
            }
        }else {
            resultMap.put("code", Constants.RESULT_CODE_FAIL);
            resultMap.put("message","项目id为空！");
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
    private @ResponseBody String getProjectList(String uniqueId){
        Map<String,Object> resultMap = new HashMap<>();
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
        return JSONObject.toJSONString(resultMap);
    }

    @RequestMapping(value = "/postAccident",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    private @ResponseBody String postAccident(String accidentStr) throws Exception {
        Map<String,Object> resultMap = new HashMap<>();
        if (accidentStr != null){
            ProjectAccident projectAccident = JSONObject.parseObject(accidentStr,ProjectAccident.class);
            projectAccidetnService.save(projectAccident);

            resultMap.put("code", Constants.RESULT_CODE_SUCCESS);
            resultMap.put("message",Constants.RESULT_MESSAGE_SUCCESS);
            resultMap.put("data","");
        }
        return JSONObject.toJSONString(resultMap);
    }

    @RequestMapping(value = "/searchYHD",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    private @ResponseBody String getYHD(String json){
        Map<String,Object> resultMap = new HashMap<>();
            if (json != null){
                Map<String,String> sqlMap = JSONObject.parseObject(json,Map.class);
                List<Disaster> list = disasterEntityService.findDisaster(sqlMap);
                resultMap.put("code", Constants.RESULT_CODE_SUCCESS);
                resultMap.put("message",Constants.RESULT_MESSAGE_SUCCESS);
                resultMap.put("data",list);
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
        List<String> nameList = new ArrayList<>();
        nameList.add(project.getCounty());
        Map<String,String> scaleMap = JSONObject.parseObject(project.getScale(),Map.class);
        List<StringModel> scaleList = new ArrayList<>();
        for (String str : scaleMap.keySet()){
            scaleList.add(new StringModel(str,scaleMap.get(str)));
        }
        model.addAttribute("scaleList",scaleList);
        List<StringModel> yhdList = new ArrayList<>();
        if (project.getYhd()!=null){
            if(!project.getYhd().equals("")){
                Map<String,String> yhdMap = JSONObject.parseObject(project.getYhd(),Map.class);
                for (String str : yhdMap.keySet()){
                    yhdList.add(new StringModel(str,yhdMap.get(str)));
                }
                model.addAttribute("yhdList",yhdList);
            }
        }
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
