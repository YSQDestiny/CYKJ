package com.cykj.service.dao.impl;

import com.cykj.service.base.dao.impl.BaseDaoImpl;
import com.cykj.service.dao.AccidentDao;
import com.cykj.service.entity.AccidentEntity;
import org.springframework.stereotype.Repository;

/**
 * @author yangsq
 * @date 2018/6/8 16:24.
 */
@Repository("accidentDao")
public class AccidentDaoImpl extends BaseDaoImpl<AccidentEntity> implements AccidentDao {
}
