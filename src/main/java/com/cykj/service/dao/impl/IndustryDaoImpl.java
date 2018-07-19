package com.cykj.service.dao.impl;

import com.alibaba.fastjson.JSONObject;
import com.cykj.service.base.Constants;
import com.cykj.service.base.bean.Page;
import com.cykj.service.base.dao.impl.BaseDaoImpl;
import com.cykj.service.dao.IndustryDao;
import com.cykj.service.entity.Industry;
import jnr.constants.Constant;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yangsq
 * @date 2018/7/18 9:31.
 */
@Repository("industryDao")
public class IndustryDaoImpl extends BaseDaoImpl<Industry> implements IndustryDao {

    @Override
    public Map<String, Object> findAllByPage(Page page) {
        Map<String,Object> returnMap = new HashMap<>();
        String hql = "from Industry";
        Query query = getCurrentSession().createQuery(hql);
        returnMap.put(Constants.TOTALS,query.list().size());
        query.setProperties(null);
        query.setFirstResult((page.getPage() -1) * page.getRows());
        query.setMaxResults(page.getRows());
        returnMap.put(Constants.ROWS,query.list());
        return returnMap;
    }

    @Override
    public Industry findIndustryByName(String name) {
        String hql = "from Industry where name =:name";
        Query query = getCurrentSession().createQuery(hql);
        query.setParameter("name",name);
        List<Industry> industries = query.list();
        if (industries == null || industries.size() ==0){
            return null;
        }
        return industries.get(0);
    }

    public @ResponseBody String deleteIndustry(long id){
        Map<String,Object> returnMap = new HashMap<>();
        
        return JSONObject.toJSONString(returnMap);
    }

}
