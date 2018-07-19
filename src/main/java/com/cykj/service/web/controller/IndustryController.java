package com.cykj.service.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.cykj.service.base.bean.Page;
import com.cykj.service.base.util.ExceptionUtils;
import com.cykj.service.entity.Industry;
import com.cykj.service.web.service.IndustryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yangsq
 * @date 2018/7/18 10:08.
 */
@Controller
@RequestMapping("/industry")
public class IndustryController {

    @Autowired
    private IndustryService industryService;

    @RequestMapping(value = "/getAll",produces = "text/html;charset=UTF-8")
    private @ResponseBody String getAll(Page page){
        Map<String,Object> resultMap = new HashMap<>();
        resultMap = industryService.findAllByPage(page);
        return JSONObject.toJSONString(resultMap);
    }

    @RequestMapping(value = "/saveIndustry",produces = "text/html;charset=UTF-8")
    private @ResponseBody String addIndustry(Industry industry){
        Map<String,Object> returnMap = new HashMap<>();
        try {
            if (StringUtils.isEmpty(industry.getName())){
                throw new NullPointerException("行业名称不能为空");
            }
            Industry temp = industryService.findIndustryByName(industry.getName());
            if (temp != null){
                throw new NullPointerException("当前行业已存在，请重新输入");
            }
            if (industry.getParentId() < 0){
                throw new NullPointerException("父ID数据异常");
            }
            Industry parentIndustry = industryService.getById(Industry.class,industry.getParentId());
            if (parentIndustry == null){
                throw new NullPointerException("父行业数据为空");
            }
            industryService.save(industry);
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
