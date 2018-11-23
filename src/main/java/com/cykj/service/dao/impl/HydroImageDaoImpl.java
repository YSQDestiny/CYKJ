package com.cykj.service.dao.impl;

import com.cykj.service.base.dao.impl.BaseDaoImpl;
import com.cykj.service.base.util.DynamicDataSourceGlobal;
import com.cykj.service.base.util.DynamicDataSourceHolder;
import com.cykj.service.dao.HydroImageDao;
import com.cykj.service.entity.HydroImage;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yangsq
 * @date 2018/11/22 15:06.
 */
@Repository("hydroImageDao")
public class HydroImageDaoImpl extends BaseDaoImpl<HydroImage> implements HydroImageDao {

    @Override
    public void saveImageList(List<HydroImage> imageList) {
        DynamicDataSourceHolder.setDataSourceType(DynamicDataSourceGlobal.CYKJ);
        for (HydroImage img : imageList){
            getCurrentSession().save(img);
        }
    }

    @Override
    public List<HydroImage> findImagByHydroID(long hydroID) {
        DynamicDataSourceHolder.setDataSourceType(DynamicDataSourceGlobal.CYKJ);
        String hql = "from HydroImage where hydroID = :hydroID";
        Query query = getCurrentSession().createQuery(hql);
        query.setParameter("hydroID",hydroID);
        List<HydroImage> imageList = query.list();
        if (imageList == null | imageList.size() == 0){
            return null;
        }
        return imageList;
    }
}
