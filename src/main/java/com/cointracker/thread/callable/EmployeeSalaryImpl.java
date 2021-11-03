package com.cointracker.thread.callable;

import java.util.concurrent.Callable;

public class EmployeeSalaryImpl implements Callable {

    Integer employeeID = 0;
    Integer salary = 0;

    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public Object call() throws Exception {
        return this.employeeID * this.salary;
    }
}
