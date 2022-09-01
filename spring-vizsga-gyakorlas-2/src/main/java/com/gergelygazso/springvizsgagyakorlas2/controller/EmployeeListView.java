package com.gergelygazso.springvizsgagyakorlas2.controller;

import java.util.HashMap;
import java.util.Map;

public class EmployeeListView {

    Map<EmployeeDTO, Boolean> employeeMap = new HashMap<EmployeeDTO, Boolean>();

    public void addKeyValuePair(EmployeeDTO employeeDTO, boolean raise){
        employeeMap.put(employeeDTO, raise);
    }

    public Map<EmployeeDTO, Boolean> getEmployeeMap() {
        return employeeMap;
    }

    public void setEmployeeMap(Map<EmployeeDTO, Boolean> employeeMap) {
        this.employeeMap = employeeMap;
    }
}
