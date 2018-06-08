package com.cykj.service.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.cykj.service.entity.AccidentEntity;
import com.cykj.service.web.Constants;
import com.cykj.service.web.service.AccidentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yangsq
 * @date 2018/6/8 14:44.
 */
@Controller
@RequestMapping("/accident")
public class AccidentController {

   @Autowired
   private AccidentService accidentService;

    @RequestMapping(value = "/postAccident",produces = "text/html;charset=UTF-8")
    private @ResponseBody String postAccident(String accident) throws Exception {
        Map<String,Object> resultMap = new HashMap<>();
        if (!StringUtils.isEmpty(accident)){
            AccidentEntity accidentEntity = JSONObject.parseObject(accident,AccidentEntity.class);
            accidentService.save(accidentEntity);
            resultMap.put("code", Constants.RESULT_CODE_SUCCESS);
            resultMap.put("message",Constants.RESULT_MESSAGE_SUCCESS);
            resultMap.put("data","");
        }

        return JSONObject.toJSONString(resultMap);
    }

}
