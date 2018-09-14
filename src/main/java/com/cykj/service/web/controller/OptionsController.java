package com.cykj.service.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.cykj.service.base.bean.Page;
import com.cykj.service.base.util.ExceptionUtils;
import com.cykj.service.entity.Options;
import com.cykj.service.web.Constants;
import com.cykj.service.web.service.OptionsService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yangsq
 * @date 2018/9/7 10:31.
 */
@Controller
@RequestMapping("/options")
public class OptionsController {

    @Autowired
    private OptionsService optionsService;

    @RequestMapping(value = "/getAll",produces = "text/html;charset=UTF-8")
    private @ResponseBody String getAllOptions(Page page){
        Map<String,Object> resultMap = new HashMap<>();
        resultMap = optionsService.findAllbyPage(page);
        return JSONObject.toJSONString(resultMap);
    }

    @RequestMapping(value = "/saveOptions",produces = "text/html;charset=UTF-8")
    private @ResponseBody String addOptions(Options options){
        Map<String,Object> returnMap = new HashMap<>();
        try {
            if (StringUtils.isEmpty(options.getName())){
                throw new NullPointerException("选项内容不能为空");
            }
            if(StringUtils.isEmpty(options.getArea())){
                throw new NullPointerException("所属区域不能为空");
            }
            if (StringUtils.isEmpty(options.getIndustry())){
                throw new NullPointerException("所属行业不能为空");
            }
            optionsService.save(options);
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

    @RequestMapping(value = "/getOptions",produces = "text/html;charset=UTF-8")
    private @ResponseBody String getOptions(String industry,String area){
        Map<String,Object> resultMap = new HashMap<>();
        List<Options> optionsList = optionsService.findOptionsByIndustryAndArea(industry,area);
        resultMap.put("code", Constants.RESULT_CODE_SUCCESS);
        resultMap.put("message",Constants.RESULT_MESSAGE_SUCCESS);
        resultMap.put("data",JSONObject.toJSONString(optionsList));
        return JSONObject.toJSONString(resultMap);
    }


}
