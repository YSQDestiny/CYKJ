package com.cykj.service.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.cykj.service.base.bean.Page;
import com.cykj.service.base.util.ExceptionUtils;
import com.cykj.service.entity.PropertyArea;
import com.cykj.service.entity.PropertyOption;
import com.cykj.service.web.service.PropertyAreaService;
import com.cykj.service.web.service.PropertyOptionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
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

    @RequestMapping(value = "/getAllOptions",produces = "text/html;charset=UTF-8")
    private @ResponseBody String getAllOptions(Page page){
        Map<String,Object> resultMap = new HashMap<>();
        resultMap = propertyOptionService.findAllbyPage(page);
        return JSONObject.toJSONString(resultMap);
    }

    @RequestMapping(value = "/getAllArea",produces = "text/html;charset=UTF-8")
    private @ResponseBody String getAllArea(Page page){
        Map<String,Object> resultMap = new HashMap<>();
        resultMap = propertyAreaService.findAllbyPage(page);
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
}
