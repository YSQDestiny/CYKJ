package com.cykj.service.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.cykj.service.base.bean.Page;
import com.cykj.service.base.util.DateUtil;
import com.cykj.service.base.util.ExceptionUtils;
import com.cykj.service.entity.*;
import com.cykj.service.web.Constants;
import com.cykj.service.web.service.PropertyAccidentService;
import com.cykj.service.web.service.PropertyAreaService;
import com.cykj.service.web.service.PropertyOptionService;
import com.cykj.service.web.service.PropertyService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yangsq
 * @date 2018/9/19 9:29.
 */
@Controller
@RequestMapping("/property")
public class PropertyController  {

    @Autowired
    private PropertyAreaService propertyAreaService;

    @Autowired
    private PropertyOptionService propertyOptionService;

    @Autowired
    private PropertyService propertyService;

    @Autowired
    private PropertyAccidentService propertyAccidentService;

    @RequestMapping(value = "/postProperty",produces = "text/html;charset=UTF-8")
    private @ResponseBody String postProperty(String json) throws Exception {
        Map<String,Object> resultMap = new HashMap<>();
        if (StringUtils.isEmpty(json)){
            resultMap.put("code", Constants.RESULT_MESSAGE_FAIL);
            resultMap.put("message",Constants.RESULT_MESSAGE_FAIL);
            resultMap.put("data",JSONObject.toJSONString(null));
        }else {
            Property property = JSONObject.parseObject(json,Property.class);
            Long propertyId = propertyService.saveAndGetId(property);
            resultMap.put("code", Constants.RESULT_CODE_SUCCESS);
            resultMap.put("message",Constants.RESULT_MESSAGE_SUCCESS);
            resultMap.put("data",propertyId);
        }
        return JSONObject.toJSONString(resultMap);
    }

    @RequestMapping(value = "/getList",produces = "text/html;charset=UTF-8")
    private @ResponseBody String getList(String uniqueId){
        Map<String,Object> resultMap = new HashMap<>();

        if (uniqueId != null){
            List<Property> propertyList = propertyService.getListByUniqueId(uniqueId);
            if (propertyList != null){
                resultMap.put("code", Constants.RESULT_CODE_SUCCESS);
                resultMap.put("message",Constants.RESULT_MESSAGE_SUCCESS);
                resultMap.put("data",propertyList);
            }
        }

        return JSONObject.toJSONString(resultMap);
    }

    @RequestMapping(value = "/getAllOptions",produces = "text/html;charset=UTF-8")
    private @ResponseBody String getAllOptions(Page page){
        Map<String,Object> resultMap = new HashMap<>();
        resultMap = propertyOptionService.findAllbyPage(page);
        return JSONObject.toJSONString(resultMap);
    }

    @RequestMapping(value = "/getOption",produces = "text/html;charset=UTF-8")
    private @ResponseBody String getOption(String area){
        Map<String,Object> resultMap = new HashMap<>();
        if (StringUtils.isEmpty(area)){
            resultMap.put("code", Constants.RESULT_MESSAGE_FAIL);
            resultMap.put("message",Constants.RESULT_MESSAGE_FAIL);
            resultMap.put("data",JSONObject.toJSONString(null));
        }else {
            List<PropertyOption> optionList = propertyOptionService.findOptionByArea(area);
            if (optionList != null){
                resultMap.put("code", Constants.RESULT_CODE_SUCCESS);
                resultMap.put("message",Constants.RESULT_MESSAGE_SUCCESS);
                resultMap.put("data",JSONObject.toJSONString(optionList));
            }else {
                resultMap.put("code", Constants.RESULT_MESSAGE_FAIL);
                resultMap.put("message",Constants.RESULT_MESSAGE_FAIL);
                resultMap.put("data",JSONObject.toJSONString(null));
            }
        }
        return JSONObject.toJSONString(resultMap);
    }

    @RequestMapping(value = "/getAllArea",produces = "text/html;charset=UTF-8")
    private @ResponseBody String getAllArea(Page page){
        Map<String,Object> resultMap = new HashMap<>();
        resultMap = propertyAreaService.findAllbyPage(page);
        return JSONObject.toJSONString(resultMap);
    }

    @RequestMapping(value = "/getArea",produces = "text/html;charset=UTF-8")
    private @ResponseBody String getArea(){
        Map<String,Object> resultMap = new HashMap<>();
        List<PropertyArea> areaList = propertyAreaService.findAll();
        if (areaList == null){
            resultMap.put("code", Constants.RESULT_MESSAGE_FAIL);
            resultMap.put("message",Constants.RESULT_MESSAGE_FAIL);
            resultMap.put("data",JSONObject.toJSONString(null));
        }else {
            resultMap.put("code", Constants.RESULT_CODE_SUCCESS);
            resultMap.put("message",Constants.RESULT_MESSAGE_SUCCESS);
            resultMap.put("data",JSONObject.toJSONString(areaList));
        }
        return JSONObject.toJSONString(resultMap);
    }

    @RequestMapping(value = "/saveArea",produces = "text/html;charset=UTF-8")
    private @ResponseBody String addPropertyArea(PropertyArea propertyArea){
        Map<String,Object> returnMap = new HashMap<>();
        try {
            propertyAreaService.save(propertyArea);
            returnMap.put("status",true);
        }catch (NullPointerException e){
            returnMap.put("status", false);
            returnMap.put("message", e.getMessage());
        }catch (Exception e){
            returnMap.put("status", false);
            returnMap.put("message", ExceptionUtils.getErrorInfo(e));
        }
        return JSONObject.toJSONString(returnMap);
    }

    @RequestMapping(value = "/saveOptions",produces = "text/html;charset=UTF-8")
    private @ResponseBody String addPropertyOption(PropertyOption propertyOption){
        Map<String,Object> returnMap = new HashMap<>();
        try {
            if (StringUtils.isEmpty(propertyOption.getName())){
                throw  new NullPointerException("查勘选项不能为空");
            }
            propertyOptionService.save(propertyOption);
            returnMap.put("status",true);
        }catch (NullPointerException e){
            returnMap.put("status", false);
            returnMap.put("message", e.getMessage());
        }catch (Exception e){
            returnMap.put("status", false);
            returnMap.put("message", ExceptionUtils.getErrorInfo(e));
        }
        return JSONObject.toJSONString(returnMap);
    }

    @RequestMapping(value = "/postDeduction",produces = "text/html;charset=UTF-8")
    private @ResponseBody String postDeduction(Long id,String json) throws Exception {
        Map<String,Object> resultMap = new HashMap<>();
        Property property = propertyService.getById(Property.class,id);
        if (StringUtils.isEmpty(json)){
            resultMap.put("code", Constants.RESULT_MESSAGE_FAIL);
            resultMap.put("message",Constants.RESULT_MESSAGE_FAIL);
            resultMap.put("data",JSONObject.toJSONString(null));
        }else {
            property.setDeduction(json);
            propertyService.update(property);
            resultMap.put("code", Constants.RESULT_CODE_SUCCESS);
            resultMap.put("message",Constants.RESULT_MESSAGE_SUCCESS);
            resultMap.put("data","");
        }
        return JSONObject.toJSONString(resultMap);
    }

    @RequestMapping(value = "/postAccident",produces = "text/html;charset=UTF-8")
    private @ResponseBody String postAccident(String accident) throws Exception{
        Map<String,Object> resultMap = new HashMap<>();
        if (!StringUtils.isEmpty(accident)){
            PropertyAccident propertyAccident = JSONObject.parseObject(accident,PropertyAccident.class);
            propertyAccident.setMakeTime(DateUtil.parseToSQLDate(new Date(),DateUtil.yyyyMMddHHmmss));
            propertyAccidentService.save(propertyAccident);
            resultMap.put("code", Constants.RESULT_CODE_SUCCESS);
            resultMap.put("message",Constants.RESULT_MESSAGE_SUCCESS);
            resultMap.put("data","");
        }
        return JSONObject.toJSONString(resultMap);
    }
}
