package com.toxicant123.imperial.court.dao.api;

import com.toxicant123.imperial.court.entity.Emp;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2022-04-03 10:31
 */
public interface EmpDao {
    Emp selectEmpByLoginAccount(String loginAccount, String encodedLoginPassword);
}
