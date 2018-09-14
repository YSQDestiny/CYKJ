package com.cykj.service.dao.impl;

import com.cykj.service.base.Constants;
import com.cykj.service.base.bean.Page;
import com.cykj.service.base.dao.impl.BaseDaoImpl;
import com.cykj.service.base.util.DynamicDataSourceGlobal;
import com.cykj.service.base.util.DynamicDataSourceHolder;
import com.cykj.service.dao.OptionsDao;
import com.cykj.service.entity.Options;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yangsq
 * @date 2018/9/7 10:20.
 */
@Repository("optionsDao")
public class OptionsDaoImpl extends BaseDaoImpl<Options> implements OptionsDao {


    @Override
    public List<Options> findAll() {
        DynamicDataSourceHolder.setDataSourceType(DynamicDataSourceGlobal.CYKJ);
        String hql = "from Options";
        Query query = getCurrentSession().createQuery(hql);
        List<Options> options = query.list();
        if (options == null || options.size() == 0){
            return null;
        }
        return options;
    }

    @Override
    public Map<String, Object> findAllbyPage(Page page) {
        DynamicDataSourceHolder.setDataSourceType(DynamicDataSourceGlobal.CYKJ);
        Map<String,Object> returnMap = new HashMap<>();
        String hql = "from Options";
        Query query = getCurrentSession().createQuery(hql);
        returnMap.put(Constants.TOTALS,query.list().size());
        query.setProperties(null);
        query.setFirstResult((page.getPage() -1) * page.getRows());
        query.setMaxResults(page.getRows());
        returnMap.put(Constants.ROWS,query.list());
        return returnMap;
    }

    @Override
    public List<Options> findOptionsByIndustryAndArea(String inudstry, String area) {
        DynamicDataSourceHolder.setDataSourceType(DynamicDataSourceGlobal.CYKJ);
        String hql = "from Options where industry = :industry and area = :area";
        Query query = getCurrentSession().createQuery(hql);
        query.setParameter("industry",inudstry);
        query.setParameter("area",area);
        List<Options> optionsList = query.list();
        if (optionsList == null || optionsList.size() == 0){
            return null;
        }
        return optionsList;
    }
}
