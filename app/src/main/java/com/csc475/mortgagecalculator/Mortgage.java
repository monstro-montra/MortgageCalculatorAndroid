package com.csc475.mortgagecalculator;

public class Mortgage {
    private float mTotalAmount;
    private float interestRate;
    private int mMortgageDuration;

    public Mortgage() { //0 args constructor

    }

    public Mortgage(float totalAmount, float interestRate, int mortgageDuration) {
        setTotalAmount(totalAmount);
        setInterestRate(interestRate);
        setMortgageDuration(mortgageDuration);
    }

    //getters and setters
    //total amount
    public float getTotalAmount() {

        return mTotalAmount;
    }

    public void setTotalAmount(float totalAmount) {

        this.mTotalAmount = totalAmount;
    }

    //monthly payment

    //interest rate
    public float getInterestRate() {

        return interestRate;
    }

    public void setInterestRate(float mInterestRate) {

        this.interestRate = mInterestRate;
    }

    //mortgage duration
    public int getMortgageDuration() {
        return mMortgageDuration;
    }

    public void setMortgageDuration(int mortgageDuration) {
        this.mMortgageDuration = mortgageDuration;
    }


    //the formula for a mortgage is as follows: M = P [i (1 + i)^n] / [(1 + i) ^n - 1]
    //M = total monthly payment
    //P = Total amount of the loan
    //i = interest rate (monthly percentage)
    //n = total amount of months
    public float calculate() {
        float P = getTotalAmount();
        float i = getInterestRate() / 12 / 100; //convert the annual interest rate to a monthly interest rate. divide by 100 to convert to percentage
        int n = getMortgageDuration() * 12; //convert years to months

        float M = (float) (P * (i * Math.pow(1 + i, n)) / (Math.pow(1 + i, n) - 1));
        return M;

    }
}

