package com.csc475.mortgagecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText mTotalAmountEditText;
    private EditText mInterestRateEditText;
    private SeekBar mLoanDurationSeekBar;
    private TextView mYearsTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTotalAmountEditText = findViewById(R.id.total_amount_edit_text);
        mInterestRateEditText = findViewById(R.id.interest_rate_edit_text);
        mLoanDurationSeekBar = findViewById(R.id.loan_duration_seek_bar);
        mYearsTextView = findViewById(R.id.years_text_view);

        calculateClick();
    }

    public void calculateClick(){
        Mortgage mortgage = new Mortgage();
        //total amount section
        try{
            //convert string from the edit text to mortgage total amount (float)
            String totalAmountStr = mTotalAmountEditText.getText().toString();
            mortgage.setTotalAmount(Float.parseFloat(totalAmountStr));
        } catch (NumberFormatException ex){
            mortgage.setTotalAmount(0);
        }

        //interest rate section
        try{
            String interestRateStr = mInterestRateEditText.getText().toString();
            mortgage.setInterestRate(Float.parseFloat(interestRateStr));
        } catch (NumberFormatException ex) {
            mortgage.setInterestRate(0);
        }

        //mortgage duration section
        mLoanDurationSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                mYearsTextView.setVisibility(View.VISIBLE);
                mYearsTextView.setText(progress + " / 30");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}