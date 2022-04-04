package com.toxicant123.imperial.court.service.api;

import com.toxicant123.imperial.court.entity.Emp;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2022-04-04 12:11
 */
public interface EmpService {

    Emp getEmpByLoginAccount(String loginAccount, String loginPassword);
}
