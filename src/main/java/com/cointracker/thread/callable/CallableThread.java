package com.cointracker.thread.callable;

import java.util.concurrent.*;

public class CallableThread {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Initialize with 100 threads
        ExecutorService service = Executors.newFixedThreadPool(100);
        EmployeeSalaryImpl[] emp = new EmployeeSalaryImpl[100];
        for (int i=0;i<emp.length;i++){
            emp[i] = new EmployeeSalaryImpl();
            emp[i].employeeID   = i+1;
            emp[i].salary   = 1000;
        }
        for (int i=0;i<emp.length;i++){
            Future f = service.submit(emp[i]);
            System.out.println(f.get().toString());
        }
        service.shutdown();
    }

}
