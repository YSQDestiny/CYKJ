package com.cykj.service.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.cykj.service.base.util.Base64Img;
import com.cykj.service.base.util.DateUtil;
import com.cykj.service.base.util.WordUtils;
import com.cykj.service.entity.AccidentEntity;
import com.cykj.service.entity.CompanyEntity;
import com.cykj.service.entity.Record;
import com.cykj.service.model.CompanyModel;
import com.cykj.service.web.Constants;
import com.cykj.service.web.service.AccidentService;
import com.cykj.service.web.service.CompanyService;
import com.cykj.service.web.service.RecordService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * @author yangsq
 * @date 2018/6/6 17:27.
 */
@Controller
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;
    @Autowired
    private RecordService recordService;
    @Autowired
    private AccidentService accidentService;

    @RequestMapping("/test")
    private String test(){

        return "test";
    }

    @RequestMapping(value = "/post",produces="text/html;charset=UTF-8")
    private @ResponseBody String postAndReturnId(String json){
        Map<String,Object> resultMap = new HashMap<>();
        if (!StringUtils.isEmpty(json)){
            CompanyModel company = JSONObject.parseObject(json,CompanyModel.class);
            if (company != null){
                Long id = companyService.saveAndGetId(company);
                List<Record> recordModels = company.getRecords();
                if (recordModels != null && recordModels.size() > 0){
                    recordService.saveModelList(recordModels,id);
                }
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

    @RequestMapping(value = "/industry",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    private @ResponseBody String postIndustry(Long companyId,String industry) throws Exception {
        Map<String,Object> resultMap = new HashMap<>();
        if(companyId != null & !StringUtils.isEmpty(industry)){
            CompanyEntity company = companyService.getById(CompanyEntity.class,companyId);
            if (company != null){
                company.setIndustry(industry);
                companyService.update(company);
                resultMap.put("code", Constants.RESULT_CODE_SUCCESS);
                resultMap.put("message",Constants.RESULT_MESSAGE_SUCCESS);
                resultMap.put("data","");
            }else {
                resultMap.put("code", Constants.RESULT_CODE_FAIL);
                resultMap.put("message","查勘信息不存在！");
                resultMap.put("data","");
            }
        }else {
            resultMap.put("code", Constants.RESULT_CODE_FAIL);
            resultMap.put("message","id不能为空！");
            resultMap.put("data","");
        }

        return JSONObject.toJSONString(resultMap);
    }

    @RequestMapping(value = "/getList",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    private @ResponseBody String getListByUniqueId(String uniqueId){
        Map<String,Object> resultMap = new HashMap<>();

        if (uniqueId != null){
            List<CompanyEntity> companies = companyService.getListByUniqueId(uniqueId);
            if (companies != null){
                resultMap.put("code", Constants.RESULT_CODE_SUCCESS);
                resultMap.put("message",Constants.RESULT_MESSAGE_SUCCESS);
                resultMap.put("data",companies);
            }
        }

        return JSONObject.toJSONString(resultMap);
    }

    @RequestMapping(value = "/uploadPhoto",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    private @ResponseBody String postPhoto(String companyId,String businessPhoto,String industryPhoto,String systemPhoto) throws Exception {
        Map<String,Object> resultMap = new HashMap<>();
        CompanyEntity companyEntity = null;
        if (companyId != null){
            companyEntity  = companyService.getById(CompanyEntity.class,Long.parseLong(companyId));
        }else {
            resultMap.put("code",Constants.RESULT_CODE_FAIL);
            resultMap.put("message","");
            resultMap.put("data","");
            return JSONObject.toJSONString(resultMap);
        }

        if (!StringUtils.isEmpty(businessPhoto)){
            companyEntity.setBusinessPhoto(businessPhoto);
        }else{
            resultMap.put("code",Constants.RESULT_CODE_FAIL);
            resultMap.put("message","");
            resultMap.put("data","");
            return JSONObject.toJSONString(resultMap);
        }

        if (!StringUtils.isEmpty(industryPhoto)){
            companyEntity.setIndustryPhoto(industryPhoto);
        }else {
            resultMap.put("code",Constants.RESULT_CODE_FAIL);
            resultMap.put("message","");
            resultMap.put("data","");
            return JSONObject.toJSONString(resultMap);
        }

        if (!StringUtils.isEmpty(systemPhoto)){
            companyEntity.setSystemPhoto(systemPhoto);
        }else {
            resultMap.put("code",Constants.RESULT_CODE_FAIL);
            resultMap.put("message","");
            resultMap.put("data","");
            return JSONObject.toJSONString(resultMap);
        }

        companyService.update(companyEntity);

        resultMap.put("code",Constants.RESULT_CODE_SUCCESS);
        resultMap.put("message","");
        resultMap.put("data","");
        return JSONObject.toJSONString(resultMap);
    }

    @RequestMapping(value = "/postStr",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    private @ResponseBody String postStr(String companyId,String weatherStr,String geologyStr) throws Exception {
        Map<String,Object> resultMap = new HashMap<>();
        CompanyEntity companyEntity = null;
        if (companyId != null){
            companyEntity  = companyService.getById(CompanyEntity.class,Long.parseLong(companyId));
        }else {
            resultMap.put("code",Constants.RESULT_CODE_FAIL);
            resultMap.put("message","");
            resultMap.put("data","");
            return JSONObject.toJSONString(resultMap);
        }

        if (!StringUtils.isEmpty(weatherStr)){
            companyEntity.setWeatherStr(weatherStr);
        }else {
            resultMap.put("code",Constants.RESULT_CODE_FAIL);
            resultMap.put("message","");
            resultMap.put("data","");
            return JSONObject.toJSONString(resultMap);
        }

        if (!StringUtils.isEmpty(geologyStr)){
            companyEntity.setGeologyStr(geologyStr);
        }else {
            resultMap.put("code",Constants.RESULT_CODE_FAIL);
            resultMap.put("message","");
            resultMap.put("data","");
            return JSONObject.toJSONString(resultMap);
        }

        companyService.update(companyEntity);

        resultMap.put("code",Constants.RESULT_CODE_SUCCESS);
        resultMap.put("message","");
        resultMap.put("data","");
        return JSONObject.toJSONString(resultMap);
    }

    @RequestMapping(value = "/getData",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    private @ResponseBody String getDataById(String id) throws Exception {
        Map<String,Object> resultMap = new HashMap<>();

        if (!StringUtils.isEmpty(id)){
            CompanyEntity companyEntity = companyService.getById(CompanyEntity.class,Long.parseLong(id));
            CompanyModel companyModel = new CompanyModel();
            companyModel.setCompanyEntity(companyEntity);
            List<AccidentEntity> accidents = accidentService.findAccidentByCompanyId(Long.parseLong(id));
            List<Record> records = recordService.findRecordByCompanyId(Long.parseLong(id));
            companyModel.setRecords(records);
            companyModel.setAccidents(accidents);
            resultMap.put("code", Constants.RESULT_CODE_SUCCESS);
            resultMap.put("message",Constants.RESULT_MESSAGE_SUCCESS);
            resultMap.put("data",companyModel);
        }
        return JSONObject.toJSONString(resultMap);
    }

    @RequestMapping("/exportDoc")
    public @ResponseBody void exportDoc(Long id, HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (id != null){
            CompanyEntity companyEntity = companyService.getById(CompanyEntity.class,id);
            Map<String,Object> map = new HashMap<>();
            map.put("companyName",companyEntity.getName());
            map.put("client",companyEntity.getClient());
            map.put("companyAddr",companyEntity.getProvince() + companyEntity.getCity() + companyEntity.getCounty() +companyEntity.getAddr());
            map.put("companyCity",companyEntity.getCity());
            map.put("industry",companyEntity.getIndustry());
            map.put("geologyStr",companyEntity.getGeologyStr());
            map.put("weatherStr",companyEntity.getWeatherStr());
            map.put("weatherPhoto",Base64Img.GetImageStrFromPath("C://chengdu.png"));
            map.put("makeTime",DateUtil.parseToString(companyEntity.getMakeTime(),DateUtil.yyyyMMdd));
            List<Record> records = recordService.findRecordByCompanyId(id);
            if (records == null){
                map.put("recSize",0);
            }else {
                map.put("recSize",records.size());
            }

            List<AccidentEntity> accidentList = accidentService.findAccidentByCompanyId(id);
            List<Map<String,Object>> accidents = new ArrayList<>();
            for (AccidentEntity accident : accidentList){
                Map<String,Object> tempmap = new HashMap<>();
                tempmap.put("instructions",accident.getInstructions());
                tempmap.put("type",accident.getType());
                tempmap.put("sitePhoto",accident.getSitePhoto());
                tempmap.put("level",accident.getLevel() + "，" + accident.getLevelDes());
                accidents.add(tempmap);
            }
            map.put("accidents",accidents);
            WordUtils.exportMillCertificateWord(request,response,map,companyEntity.getName(),"templat_basic.ftl");
        }
    }
}
