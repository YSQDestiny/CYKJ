package com.cykj.service.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.cykj.service.base.util.DateUtil;
import com.cykj.service.entity.CompanyEntity;
import com.cykj.service.web.Constants;
import com.cykj.service.web.service.CompanyService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yangsq
 * @date 2018/6/6 17:27.
 */
@Controller
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @RequestMapping("/test")
    private String test(Model model){
        Date date = new Date();
        CompanyEntity company = new CompanyEntity();
        company.setName("测试一号");
        company.setAddr("测试地址");
        company.setLinkman("测试联系人");
        company.setManager("测试总经理");
        company.setViceManager("测试副总经理");
        company.setSafe("测试安全负责人");
        company.setWokerNormal(1);
        company.setWokerSpecial(2);
        company.setMakeTime(DateUtil.parseToSQLDate(date,DateUtil.yyyyMMddHHmmss));

        Long id = companyService.saveAndGetId(company);

        model.addAttribute("id",id);

        return "test";
    }

    @RequestMapping(value = "/post",produces="text/html;charset=UTF-8")
    private @ResponseBody String postAndReturnId(String json){
        Map<String,Object> resultMap = new HashMap<>();
        if (!StringUtils.isEmpty(json)){
            CompanyEntity company = JSONObject.parseObject(json,CompanyEntity.class);
            if (company != null){
                Long id = companyService.saveAndGetId(company);
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
}
