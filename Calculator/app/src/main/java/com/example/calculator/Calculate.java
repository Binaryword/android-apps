package com.example.calculator;

import android.content.Context;

public class Calculate {

    private  double mFirstNum ;
    private double mSecondNum ;
    private String mOperator;

    public Calculate(){
        this(0 , 0 , "");
    }

    public Calculate(double fn ){
        this(fn , 0 , "");
    }

    public Calculate(double fn , double sn){
        this(fn , sn ,"");
    }

    public Calculate(double fn , double sn , String opr){
        this.mFirstNum = fn ;
        this.mSecondNum = sn ;
        this.mOperator = opr ;
    }


    public double getFirstNum() {
        return mFirstNum;
    }

    public void setFirstNum(double firstNum) {
        mFirstNum = firstNum;
    }

    public double getSecondNum() {
        return mSecondNum;
    }

    public void setSecondNum(double secondNum) {
        mSecondNum = secondNum;
    }

    public String getOperator() {
        return mOperator;
    }

    public void setOperator(String operator) {
        mOperator = operator;
    }



    public double compute(double fn , double sn , String opr){

      switch (opr){
          case "+" :
              return fn + sn ;
          case "-" :
                  return fn - sn ;
          case "*" :
              return fn * sn ;
          case  "/" :
              return fn / sn ;
          case "sqr" :
              return Math.sqrt(fn) ;
              default:
                  return fn ;
      }

    }// end of method .....


}
