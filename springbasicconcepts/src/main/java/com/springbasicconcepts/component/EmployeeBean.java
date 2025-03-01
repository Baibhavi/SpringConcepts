package com.springbasicconcepts.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class EmployeeBean {
    private int eid;
    private String ename;

    @Autowired
    private DepartmentBean deptBean;
    public static final Logger logger = LoggerFactory.getLogger(EmployeeBean.class);

    public EmployeeBean() {}

    @Autowired
    public EmployeeBean(DepartmentBean deptBean) {
        logger.trace("*** Autowiring by using @Autowire annotation on constructor ***");
        this.deptBean = deptBean;
    }
    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public DepartmentBean getDeptbean() {
        return deptBean;
    }

    @Autowired
    public void setDeptBean(DepartmentBean deptBean) {
        logger.trace("*** Autowiring by using @Autowired annotation on setter ***");
        this.deptBean = deptBean;
    }
    public void showEmployeeDetails(){
        logger.debug("Employee ID : {}", eid);
        logger.debug("Employee Name : {}", ename);
        deptBean.setDeptName("Information Technology");
        logger.debug("Department : {}", deptBean.getDeptName());
    }

}
