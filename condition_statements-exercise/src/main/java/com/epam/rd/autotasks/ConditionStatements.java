package com.epam.rd.autotasks;

import java.rmi.UnexpectedException;

class ConditionStatements {
    public static int task1(int n) {
        if(n == 0){
            return n;
        }else if(n < 0){
            return n * (-1);
        }else{
            return n * n;
        }
    }
}


