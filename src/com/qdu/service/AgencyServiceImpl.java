package com.qdu.service;

import com.qdu.dao.AgencyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgencyServiceImpl implements AgencyService {
    @Autowired
    private AgencyDao agencyDao;


    @Override
    public List agencyAll() {
        return agencyDao.agencyAll();
    }
}
