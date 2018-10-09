package com.cykj.service.base.util;

import com.alibaba.fastjson.JSONObject;
import com.cykj.service.entity.Disasters;
import com.cykj.service.entity.Property;
import com.cykj.service.entity.PropertyArea;
import com.cykj.service.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yangsq
 * @date 2018/8/1 11:30.
 */
public class Utils {

    private static Map<String, String> nameMap;
    static {
        nameMap = new HashMap<>();
        nameMap.put("公共区域-通道", "publicPass");
        nameMap.put("公共区域-消防楼梯", "publicStairs");
        nameMap.put("公共区域-楼顶", "publicTop");
        nameMap.put("公共区域-各层走廊", "publicCorridor");
        nameMap.put("公共区域-绿化、景观", "publicGreen");
        nameMap.put("公共区域-健身、娱乐", "publicPlay");
        nameMap.put("公共区域-电梯", "publicElevator");
        nameMap.put("公共区域-游泳池", "publicSwimming");
        nameMap.put("公共区域-安防", "publicSecurity");
        nameMap.put("公共区域-外围、停车场", "publicParking");
        nameMap.put("公共区域-防汛排水", "publicFlood");
        nameMap.put("公共区域-防雷", "publicLightning");
        nameMap.put("公共区域-其他", "publicOther");
        nameMap.put("办公区域", "office");
        nameMap.put("设备机房-高位水箱间", "roomHigh");
        nameMap.put("设备机房-钢瓶间", "roomSteel");
        nameMap.put("设备机房-弱电井", "roomWeak");
        nameMap.put("设备机房-消防控制室", "roomFire");
        nameMap.put("设备机房-变配电系统", "roomPower");
        nameMap.put("设备机房-发电机房", "roomGenerator");
        nameMap.put("设备机房-其他机房", "roomOther");
        nameMap.put("设备机房-泵房", "roomPump");
        nameMap.put("物品库房、非机动车库", "storehouse");
        nameMap.put("风险控制", "controll");
        nameMap.put("基础服务-清洁卫生服务", "basicsSanitation");
        nameMap.put("基础服务-景观绿化维护", "basicsLandscaping");
        nameMap.put("基础服务-公示、告知", "basicsPublicity");
        nameMap.put("基础服务-沟通、提升", "basicsCommunicate");
    }

    public static List<DisasterModel> barDataProcessing(Map<String, List<Disasters>> map) {
        List<DisasterModel> disasterModels = new ArrayList<>();
        for (String address : map.keySet()) {
            List<BarDataModel> barDataModels = new ArrayList<>();
            Map<String, Integer> tempMap = new HashMap<>();
            List<Disasters> disastersList = map.get(address);
            List<String> nameList = new ArrayList<>();
            if (disastersList != null) {
                for (Disasters disasters : disastersList) {
                    if (tempMap.containsKey(disasters.getPattern())) {
                        tempMap.put(disasters.getPattern(), tempMap.get(disasters.getPattern()) + 1);
                    } else {
                        tempMap.put(disasters.getPattern(), 1);
                    }
                }
                for (String str : tempMap.keySet()) {
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

    public static String propertyDescribe(Property property) {
        String describe = "";
        describe += property.getCompanyName() + "于" + property.getCompanyDate() + "在" + property.getCompanyAddr()
                + "注册，注册资金" + property.getCapital() + "元。" + property.getCompanyName() + "于" + property.getEnterDate()
                + "入驻" + property.getName() + "进行物业管理服务工作至今，" + property.getName() + "位于" + property.getProvince()
                + property.getCity() + property.getCounty() + property.getAddress() + "\n" + "该项目于"
                + property.getCreateDate() + "建成，总占地" + property.getAcreage() + "平方米，住宅" + property.getResidence()
                + "栋，商铺" + property.getShops() + "间，住户" + property.getHousehold() + "户，租户" + property.getTenant()
                + "户，物业收费标准为" + property.getCharge() + "/㎡。项目设有"
                + (Integer.parseInt(property.getGroundParking()) + Integer.parseInt(property.getUnderGroundParkting()))
                + "个停车位，其中地面停车位" + property.getGroundParking() + "个，地下停车位" + property.getUnderGroundParkting() + "个。";
        return describe;
    }

    public static String initEquipment(String json) {
        String result = "";
        String str1 = "教育配套：";
        String str2 = "医疗卫生配套：";
        String str3 = "健身、娱乐配套：";
        int a = 0;
        int b = 0;
        int c = 0;
        List<Equipment> equipmentList = JSONObject.parseArray(json, Equipment.class);
        for (Equipment equipment : equipmentList) {
            switch (equipment.getType()) {
            case "教育配套":
                if (a == 0) {
                    str1 += equipment.getName();
                    a++;
                } else {
                    str1 += "," + equipment.getName();
                }
                break;
            case "医疗卫生配套":
                if (b == 0) {
                    str2 += equipment.getName();
                    b++;
                } else {
                    str2 += "," + equipment.getName();
                }
                break;
            case "健身、娱乐配套":
                if (c == 0) {
                    str3 += equipment.getName();
                    c++;
                } else {
                    str3 += "," + equipment.getName();
                }
                break;
            default:
                break;
            }
        }
        result = str1 + "\n" + str2 + "\n" + str3;
        return result;
    }

    public static String initCompanyinfo(Property property) {
        String result = "";
        result += "受" + property.getClient() + "委托，成都正和德能风险管理咨询有限公司风险评定工作组于"
                + DateUtil.parseToString(property.getMakeTime(), DateUtil.yyyyMMdd) + "对" + property.getCompanyName()
                + "的" + property.getName()
                + "住宅物业项目进行风险评定工作，工作内容包括：公共区域评定、办公区域评定、设备机房评定、库房评定、风险控制评定、物业服务评定等几大部分，通过工作组评定，"
                + property.getCompanyName() + property.getName() + "的风险评定结果为： ";
        return result;
    }

    public static String initPointTable(String json) {
        String result = "";
        Map<String, Double> pointMap = calculationScore(json);
        double score = pointMap.get("score");
        String leve = "";
        if (score < 60) {
            leve = "差";
        } else if (score >= 60 & score < 75) {
            leve = "中";
        } else if (score >= 75 & score < 90) {
            leve = "良";
        } else if (score >= 90) {
            leve = "优";
        }
        result += "<table class=\"mdui-table\">\n" + "<thead>\n" + "<tr>\n" + "<th>总分</th>\n" + "<th>缺项</th>\n"
                + "<th>扣分</th>\n" + "<th>最终得分</th>\n" + "<th>风险程度</th>\n" + "</tr>\n" + "</thead>\n" + "<tbody>\n"
                + "<tr>\n" + "<td>" + pointMap.get("total") + "</td>" + "<td>" + pointMap.get("missingPoint") + "</td>"
                + "<td>" + pointMap.get("deduction") + "</td>" + "<td>" + pointMap.get("score") + "</td>" + "<td>"
                + leve + "</td>";

        return result;
    }

    public static Map<String, Double> calculationScore(String deductionJson) {

        Map<String, Double> resultMap = new HashMap<>();
        // 总分
        double total = 1000;
        // 扣分
        double deduction = 0;
        // 缺项
        double missingPoint = 0;
        // 追加
        double append = 0;
        // 得分
        double score;

        List<Deduction> deductionList = JSONObject.parseArray(deductionJson, Deduction.class);

        for (Deduction temp : deductionList) {
            if (temp.isMissing()) {
                missingPoint += temp.getTotal();
            } else {
                deduction += temp.getDeduction();
                if (temp.getImportant() == 1) {
                    if (temp.getDeduction() == temp.getTotal()) {
                        append += 20;
                    }
                }
            }
        }
        score = (total - deduction - missingPoint - append) / (total - missingPoint) * 100;
        resultMap.put("total", total);
        resultMap.put("deduction", deduction);
        resultMap.put("missingPoint", missingPoint);
        resultMap.put("append", append);
        resultMap.put("score", score);

        return resultMap;
    }

    //
    public static List<ReportDeduction> initPropertyReportDeduction(String deductionJson) {
        List<ReportDeduction> returnList = new ArrayList<>();
        List<Deduction> deductionList = JSONObject.parseArray(deductionJson, Deduction.class);
        for (Deduction deduction : deductionList) {
            ReportDeduction reportDeduction = new ReportDeduction();

            reportDeduction.setResonName(nameMap.get(deduction.getArea()) + "Reson");
            reportDeduction.setMissingName(nameMap.get(deduction.getArea()) + "Missing");

            if (deduction.isMissing()) {
                reportDeduction.setMissing("是");
                reportDeduction.setReson("无");
            } else {
                if (deduction.getReson() != null) {
                    reportDeduction.setMissing("否");
                    String reson = "";
                    int i = 0;
                    for (String str : deduction.getReson()) {
                        if (i == 0) {
                            reson += str;
                            i++;
                        } else {
                            reson += "<w:br/>" + str;
                        }
                    }
                    reportDeduction.setReson(reson);
                } else {
                    reportDeduction.setMissing("否");
                    reportDeduction.setReson("无");
                }

            }
            returnList.add(reportDeduction);
        }
        return returnList;
    }
}
