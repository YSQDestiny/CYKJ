package com.cykj.service.base.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.PropertyPreFilter;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;
import com.cykj.service.base.service.BaseService;
import com.cykj.service.base.util.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yangsq
 * @date 2018/6/6 16:49.
 */
@SuppressWarnings({"rawtypes","unchecked"})
public class BaseController <T extends Serializable>{

    @Autowired
    private BaseService<T> baseService;

    /**
     * class 每一个继承此class的Controller class都必须在无参构造函数中给予赋值
     */
    private Class<T> c;

    /**
     * 根据ID查询
     *
     * @param id
     *            对象
     * @author 杨仕其
     */
    @RequestMapping("/getById")
    public @ResponseBody
    Map getById(Integer id) {
        T t = null;
        try {
            t = (T) baseService.getById(c, id);
        } catch (Exception e) {
            System.out.println(ExceptionUtils.getErrorInfo(e));
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("object", t);
        return map;
    }

    /**
     * 统计数目
     *
     * @author 杨仕其
     */

    @RequestMapping("/count")
    public @ResponseBody
    Map count() {
        BigInteger count = new BigInteger("0");
        try {
            count = baseService.count(c);
        } catch (Exception e) {
            System.out.println(ExceptionUtils.getErrorInfo(e));
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("count", count);
        return map;
    }

    private static SerializeConfig mapping = new SerializeConfig();
    private static String dateFormat;
    static {
        dateFormat = "yyyy-MM-dd HH:mm:ss";
        mapping.put(Date.class, new SimpleDateFormatSerializer(dateFormat));
    }

    public void flushJson(HttpServletResponse response, Object object,
                          PropertyPreFilter filter) {
        response.setContentType("text/html;charset=UTF-8");
        SerializerFeature feature = SerializerFeature.WriteDateUseDateFormat;
        try {
            if (filter != null) {
                response.getWriter().write(JSONObject.toJSONString(object,mapping, filter, feature,
                        SerializerFeature.WriteMapNullValue,
                        SerializerFeature.WriteNullStringAsEmpty,
                        SerializerFeature.DisableCircularReferenceDetect,
                        SerializerFeature.WriteNullListAsEmpty));
            } else {
                response.getWriter().write(JSONObject.toJSONString(object,mapping, feature,
                        SerializerFeature.WriteMapNullValue,
                        SerializerFeature.WriteNullStringAsEmpty,
                        SerializerFeature.DisableCircularReferenceDetect,
                        SerializerFeature.WriteNullListAsEmpty));
            }
            response.getWriter().flush();
            response.getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Class getC() {
        return c;
    }

    public void setC(Class c) {
        this.c = c;
    }

}
