package com.cykj.service.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.cykj.service.base.bean.Page;
import com.cykj.service.base.util.ExceptionUtils;
import com.cykj.service.entity.Area;
import com.cykj.service.web.Constants;
import com.cykj.service.web.service.AreaService;
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
 * @date 2018/9/6 11:56.
 */
@Controller
@RequestMapping("/area")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @RequestMapping(value = "/getAll",produces = "text/html;charset=UTF-8")
    private @ResponseBody String getAllArea(Page page){
        Map<String,Object> resultMap = new HashMap<>();
        resultMap = areaService.findAllbyPage(page);
        return JSONObject.toJSONString(resultMap);
    }

    @RequestMapping(value = "/saveArea",produces = "text/html;charset=UTF-8")
    private @ResponseBody String addArea(Area area){
        Map<String,Object> returnMap = new HashMap<>();
        try {
            if (StringUtils.isEmpty(area.getName())){
                throw new NullPointerException("区域名称不能为空");
            }
            Area temp = areaService.findAreaByName(area.getName());
            if (temp != null){
                if (temp.getIndustry().equals(area.getIndustry())){
                    throw new NullPointerException("当前行业已存在该区域");
                }
            }
            areaService.save(area);
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

    @RequestMapping(value = "/getArea",produces = "text/html;charset=UTF-8")
    private @ResponseBody String getAreaByIndustry(String industry){
        Map<String,Object> resultMap = new HashMap<>();
        if (StringUtils.isEmpty(industry)){
            resultMap.put("code", Constants.RESULT_CODE_FAIL);
            resultMap.put("message",Constants.RESULT_MESSAGE_FAIL);
            resultMap.put("data","");
        }else {
            List<Area> areaList = areaService.findAreaByIndustry(industry);
            resultMap.put("code", Constants.RESULT_CODE_SUCCESS);
            resultMap.put("message",Constants.RESULT_MESSAGE_SUCCESS);
            resultMap.put("data",JSONObject.toJSONString(areaList));
        }
        return JSONObject.toJSONString(resultMap);
    }
}
