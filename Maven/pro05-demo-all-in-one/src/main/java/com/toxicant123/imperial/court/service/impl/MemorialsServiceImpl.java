package com.toxicant123.imperial.court.service.impl;

import com.toxicant123.imperial.court.dao.api.MemorialsDao;
import com.toxicant123.imperial.court.dao.impl.MemorialsDaoImpl;
import com.toxicant123.imperial.court.entity.Memorials;
import com.toxicant123.imperial.court.service.api.MemorialsService;

import java.util.List;

public class MemorialsServiceImpl implements MemorialsService {

    private MemorialsDao memorialsDao = new MemorialsDaoImpl();

    @Override
    public List<Memorials> getAllMemorialsDigest() {
        return memorialsDao.selectAllMemorialsDigest();
    }

}
