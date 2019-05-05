package com.qdu.service;

import com.qdu.dao.FStoreDao;
import com.qdu.pojo.Foodinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class FStoreServiceImpl implements FStoreService {

    @Autowired
    private FStoreDao fStoreDao;

    //根据店的ID获取店里的所有美食；
    @Override
    public List<Foodinfo> storeFoodList(int did) {
        return fStoreDao.storeFoodList(did);
    }
}
