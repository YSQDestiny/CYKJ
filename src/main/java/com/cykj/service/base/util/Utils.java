package com.cykj.service.base.util;

import com.alibaba.fastjson.JSONObject;
import com.cykj.service.entity.Disasters;
import com.cykj.service.model.BarDataModel;
import com.cykj.service.model.DisasterModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yangsq
 * @date 2018/8/1 11:30.
 */
public class Utils {

    public static List<DisasterModel> barDataProcessing(Map<String,List<Disasters>> map){
        List<DisasterModel> disasterModels = new ArrayList<>();
        for (String address:map.keySet()){
            List<BarDataModel> barDataModels = new ArrayList<>();
            Map<String,Integer> tempMap = new HashMap<>();
            List<Disasters> disastersList = map.get(address);
            List<String> nameList = new ArrayList<>();
            if (disastersList != null){
                for (Disasters disasters : disastersList){
                    if (tempMap.containsKey(disasters.getAddress())){
                        tempMap.put(disasters.getPattern(),tempMap.get(disasters.getPattern()) + 1);
                    }else {
                        tempMap.put(disasters.getPattern(),1);
                    }
                }
                for (String str : tempMap.keySet()){
                    BarDataModel barDataModel = new BarDataModel();
                    barDataModel.setName(str);
                    barDataModel.setValue(tempMap.get(str));
                    barDataModels.add(barDataModel);
                    nameList.add(str);
                }
                DisasterModel disasterModel = new DisasterModel();
                disasterModel.setName(address);
                disasterModel.setNameList(JSONObject.toJSONString(nameList));
                disasterModel.setBarData(JSONObject.toJSONString(barDataModels));
                disasterModels.add(disasterModel);
            }
        }

        return disasterModels;
    }

}
