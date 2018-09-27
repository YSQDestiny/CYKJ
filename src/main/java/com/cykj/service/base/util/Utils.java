package com.cykj.service.base.util;

import com.alibaba.fastjson.JSONObject;
import com.cykj.service.entity.Disasters;
import com.cykj.service.entity.Property;
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
                    if (tempMap.containsKey(disasters.getPattern())){
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

    public static String propertyDescribe(Property property){
        String describe = "";
        describe += property.getCompanyName() + "于" + property.getCompanyDate() + "在" +
                property.getCompanyAddr() + "注册，注册资金" + property.getCapital() + "元。"
                + property.getCompanyName() + "于" + property.getEnterDate() + "入驻" + property.getName()
                + "进行物业管理服务工作至今，"+ property.getName() + "位于" + property.getProvince() + property.getCity()
                + property.getCounty() + property.getAddress() + "\n"
                + "该项目于"+ property.getCreateDate() + "建成，总占地"+ property.getAcreage() +"平方米，住宅"+
                property.getResidence()+"栋，商铺"+property.getShops()+"间，住户"+property.getHousehold()+"户，租户"
                +property.getTenant()+"户，物业收费标准为"+property.getCharge()+"/㎡。项目设有"+(Integer.parseInt(property.getGroundParking())+Integer.parseInt(property.getUnderGroundParkting()))
                +"个停车位，其中地面停车位"+property.getGroundParking()+"个，地下停车位"+property.getUnderGroundParkting()+"个。";
        return describe;
    }

}
