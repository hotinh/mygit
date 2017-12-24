package cn.cc.mp.wb.service.impl;

import cn.cc.mp.wb.dao.DictMapper;
import cn.cc.mp.wb.model.Dict;
import cn.cc.mp.wb.service.DictService;
import cn.cc.mp.wb.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2017/12/24.
 */
@Service
@Transactional
public class DictServiceImpl extends AbstractService<Dict> implements DictService {
    @Resource
    private DictMapper dictMapper;

}
