package com.algo.algoproblems;

public class PowFunction {
	public double myPow(double x, int n) {
        double result=1;
        if (n==0)
            return 1;
        else if(n>=1){ 
            while(n>=1){
                result=result*x;
                n--;
            }
        }else if (n<0){
            while(n<0){
                result = result/x;
                n++;
            }
        }
        return result;
    }
}
