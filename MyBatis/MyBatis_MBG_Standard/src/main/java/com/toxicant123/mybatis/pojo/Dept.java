package com.toxicant123.mybatis.pojo;

public class Dept {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_dept.did
     *
     * @mbggenerated Wed Mar 16 15:20:03 GMT+08:00 2022
     */
    private Integer did;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_dept.dept_name
     *
     * @mbggenerated Wed Mar 16 15:20:03 GMT+08:00 2022
     */
    private String deptName;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_dept.did
     *
     * @return the value of t_dept.did
     *
     * @mbggenerated Wed Mar 16 15:20:03 GMT+08:00 2022
     */
    public Integer getDid() {
        return did;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_dept.did
     *
     * @param did the value for t_dept.did
     *
     * @mbggenerated Wed Mar 16 15:20:03 GMT+08:00 2022
     */
    public void setDid(Integer did) {
        this.did = did;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_dept.dept_name
     *
     * @return the value of t_dept.dept_name
     *
     * @mbggenerated Wed Mar 16 15:20:03 GMT+08:00 2022
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_dept.dept_name
     *
     * @param deptName the value for t_dept.dept_name
     *
     * @mbggenerated Wed Mar 16 15:20:03 GMT+08:00 2022
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    public Dept() {
    }

    public Dept(Integer did, String deptName) {
        this.did = did;
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "did=" + did +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}