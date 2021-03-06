package com.cykj.service.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.cykj.service.base.util.DateUtil;
import com.cykj.service.entity.Hydro;
import com.cykj.service.entity.HydroImage;
import com.cykj.service.entity.Property;
import com.cykj.service.model.HydroGeology;
import com.cykj.service.web.Constants;
import com.cykj.service.web.service.HydroImageService;
import com.cykj.service.web.service.HydroService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
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

    @Autowired
    private HydroImageService hydroImageService;

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
        List<HydroImage> imageList = hydroImageService.findImagByHydroID(hydro.getId());
        if (imageList != null){
            model.addAttribute("imageList",imageList);
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

    @RequestMapping(value = "/uploadDisaster",produces = "text/html;charset=UTF-8")
    private @ResponseBody String uploadDisaster(String disaster,long id) throws Exception {
        Map<String,Object> resultMap = new HashMap<>();
        Hydro hydro = hydroService.getById(Hydro.class,id);
        if (disaster != null){
            hydro.setDistaster(disaster);
            hydroService.update(hydro);
            resultMap.put("code", Constants.RESULT_CODE_SUCCESS);
            resultMap.put("message",Constants.RESULT_MESSAGE_SUCCESS);
            resultMap.put("data","数据已保存！");
        }else {
            resultMap.put("code", Constants.RESULT_MESSAGE_FAIL);
            resultMap.put("message",Constants.RESULT_MESSAGE_FAIL);
            resultMap.put("data", "");
        }
        return JSONObject.toJSONString(resultMap);
    }

    @RequestMapping(value = "/uploadElectromechanical",produces = "text/html;charset=UTF-8")
    private @ResponseBody String uploadElectromechanical(String electromechanical,long id) throws Exception {
        Map<String,Object> resultMap = new HashMap<>();
        Hydro hydro = hydroService.getById(Hydro.class,id);
        if (electromechanical != null){
            hydro.setElectromechanical(electromechanical);
            hydroService.update(hydro);
            resultMap.put("code", Constants.RESULT_CODE_SUCCESS);
            resultMap.put("message",Constants.RESULT_MESSAGE_SUCCESS);
            resultMap.put("data","数据已保存！");
        }else {
            resultMap.put("code", Constants.RESULT_MESSAGE_FAIL);
            resultMap.put("message",Constants.RESULT_MESSAGE_FAIL);
            resultMap.put("data", "");
        }
        return JSONObject.toJSONString(resultMap);
    }

    @RequestMapping(value = "/uploadBuilding",produces = "text/html;charset=UTF-8")
    private @ResponseBody String uploadBuilding(String building,long id) throws Exception {
        Map<String,Object> resultMap = new HashMap<>();
        Hydro hydro = hydroService.getById(Hydro.class,id);
        if (building != null){
            hydro.setBuilding(building);
            hydroService.update(hydro);
            resultMap.put("code", Constants.RESULT_CODE_SUCCESS);
            resultMap.put("message",Constants.RESULT_MESSAGE_SUCCESS);
            resultMap.put("data","数据已保存！");
        }else {
            resultMap.put("code", Constants.RESULT_MESSAGE_FAIL);
            resultMap.put("message",Constants.RESULT_MESSAGE_FAIL);
            resultMap.put("data", "");
        }
        return JSONObject.toJSONString(resultMap);
    }

    @RequestMapping(value = "/uploadOthers",produces = "text/html;charset=UTF-8")
    private @ResponseBody String uploadOthers(String other,long id) throws Exception {
        Map<String,Object> resultMap = new HashMap<>();
        Hydro hydro = hydroService.getById(Hydro.class,id);
        if (other != null){
            hydro.setOther(other);
            hydroService.update(hydro);
            resultMap.put("code", Constants.RESULT_CODE_SUCCESS);
            resultMap.put("message",Constants.RESULT_MESSAGE_SUCCESS);
            resultMap.put("data","数据已保存！");
        }else {
            resultMap.put("code", Constants.RESULT_MESSAGE_FAIL);
            resultMap.put("message",Constants.RESULT_MESSAGE_FAIL);
            resultMap.put("data", "");
        }
        return JSONObject.toJSONString(resultMap);
    }

    @RequestMapping(value = "/uploadImage",produces = "text/html;charset=UTF-8")
    private @ResponseBody String uploadImage(String json){
        Map<String,Object> resultMap = new HashMap<>();
        if (json != null){
            List<HydroImage> imageList = JSONObject.parseArray(json,HydroImage.class);
            hydroImageService.saveImageList(imageList);
            resultMap.put("code", Constants.RESULT_CODE_SUCCESS);
            resultMap.put("message",Constants.RESULT_MESSAGE_SUCCESS);
            resultMap.put("data","数据已保存！");
        }else {
            resultMap.put("code", Constants.RESULT_MESSAGE_FAIL);
            resultMap.put("message",Constants.RESULT_MESSAGE_FAIL);
            resultMap.put("data", "");
        }
        return JSONObject.toJSONString(resultMap);
    }

    @RequestMapping(value = "/getList",produces = "text/html;charset=UTF-8")
    private @ResponseBody String getHydroList(String uniqueId){
        Map<String,Object> resultMap = new HashMap<>();
        if (uniqueId != null){
            List<Hydro> hydroList = hydroService.getListByUniqueId(uniqueId);
            if (hydroList != null){
                resultMap.put("code", Constants.RESULT_CODE_SUCCESS);
                resultMap.put("message",Constants.RESULT_MESSAGE_SUCCESS);
                resultMap.put("data",hydroList);
            }
        }
        return JSONObject.toJSONString(resultMap);
    }


}
