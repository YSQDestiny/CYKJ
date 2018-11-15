package com.cykj.service.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.cykj.service.base.util.DateUtil;
import com.cykj.service.entity.Hydro;
import com.cykj.service.entity.Property;
import com.cykj.service.model.HydroGeology;
import com.cykj.service.web.Constants;
import com.cykj.service.web.service.HydroService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yangsq
 * @date 2018/11/9 11:12.
 */
@Controller
@RequestMapping("/hydro")
public class HydroController {

    @Autowired
    private HydroService hydroService;

    @RequestMapping("/showHydro")
    private String shwoHydro(Long id, Model model) throws Exception {
        Hydro hydro = null;
        if (id != null){
            hydro = hydroService.getById(Hydro.class,id);
        }
        String geologyJson = hydro.getGeology();
        if (geologyJson != null){
            HydroGeology hydroGeology = JSONObject.parseObject(geologyJson,HydroGeology.class);
            model.addAttribute("hydroGeology",hydroGeology);
        }
        model.addAttribute("hydro",hydro);
        return "hydro/hydro";
    }

    @RequestMapping(value = "/saveHydro",produces = "text/html;charset=UTF-8")
    private @ResponseBody String saveHydro(String json){
        Map<String,Object> resultMap = new HashMap<>();
        if (StringUtils.isEmpty(json)){
            resultMap.put("code", Constants.RESULT_MESSAGE_FAIL);
            resultMap.put("message",Constants.RESULT_MESSAGE_FAIL);
            resultMap.put("data", "");
        }else {
            Hydro hydro = JSONObject.parseObject(json,Hydro.class);
            hydro.setMakeTime(DateUtil.parseToSQLDate(new Date(), DateUtil.yyyyMMdd));
            Long hydroId = hydroService.saveAndGetId(hydro);
            resultMap.put("code", Constants.RESULT_CODE_SUCCESS);
            resultMap.put("message",Constants.RESULT_MESSAGE_SUCCESS);
            resultMap.put("data",hydroId);
        }
        return JSONObject.toJSONString(resultMap);
        
    }

    @RequestMapping(value = "/uploadGeology",produces = "text/html;charset=UTF-8")
    private @ResponseBody String uploadGeology(String json,long id) throws Exception {
        Map<String,Object> resultMap = new HashMap<>();
        Hydro hydro = hydroService.getById(Hydro.class,id);
        if (StringUtils.isEmpty(json)){
            resultMap.put("code", Constants.RESULT_MESSAGE_FAIL);
            resultMap.put("message",Constants.RESULT_MESSAGE_FAIL);
            resultMap.put("data", "");
        }else {
            hydro.setGeology(json);
            hydroService.update(hydro);
            resultMap.put("code", Constants.RESULT_CODE_SUCCESS);
            resultMap.put("message",Constants.RESULT_MESSAGE_SUCCESS);
            resultMap.put("data","数据已保存！");
        }
        return JSONObject.toJSONString(resultMap);
    }
}
