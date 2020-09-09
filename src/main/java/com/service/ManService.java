package com.service;

import com.dao.CrudDao;
import com.dao.ManDao;
import com.domain.Man;

public class ManService implements CrudService<Man> {

    private CrudDao<Man> crudDao = new ManDao();

    @Override
    public void save(Man man) {
        crudDao.save(man);
    }

    @Override
    public Man getById(int id) {
        return crudDao.getById(id);
    }

    @Override
    public void update(Man man) {
        crudDao.update(man);
    }

    @Override
    public Man deleteById(int id) {
        return crudDao.deleteById(id);
    }
}
