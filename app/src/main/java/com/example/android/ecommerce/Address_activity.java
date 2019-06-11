package com.example.android.ecommerce;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class Address_activity extends AppCompatActivity {

    EditText editText1, editText2, editText3, editText4, editText5, editText6, editText7;

    TextInputLayout textInput1, textInput2, textInput3, textInput4, textInput5, textInput6, textInput7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_activity);

        editText1=findViewById(R.id.edit_name);
        editText2=findViewById(R.id.edit_phn);
        editText3=findViewById(R.id.pin_code);
        editText4=findViewById(R.id.edit_address);
        editText5=findViewById(R.id.edit_locality);
        editText6=findViewById(R.id.edit_city);
        editText7=findViewById(R.id.edit_state);

        int Name=editText1.getText().toString().trim().length();
        int phone=editText2.getText().toString().trim().length();
        int pin_code=editText3.getText().toString().trim().length();
        int address=editText4.getText().toString().trim().length();
        int locality=editText5.getText().toString().trim().length();
        int city=editText6.getText().toString().trim().length();
        int state=editText7.getText().toString().trim().length();


        textInput1=findViewById(R.id.text_layout_name);
        textInput2=findViewById(R.id.text_layout_phn);
        textInput3=findViewById(R.id.text_layout_pin_code);
        textInput4=findViewById(R.id.text_layout_address);
        textInput5=findViewById(R.id.text_layout_locality);
        textInput6=findViewById(R.id.text_layout_city);
        textInput7=findViewById(R.id.text_layout_state);


        if(Name==0||phone==0||pin_code==0||address==0||locality==0||city==0||state==0)
        {
            if(Name==0)
            {

                textInput1.setError("This field needs to be filled");
            }
            if(phone==0)
            {

                textInput2.setError("This field needs to be filled");
            }
            if(pin_code==0)
            {

                textInput3.setError("This field needs to be filled");
            }
            if(address==0)
            {

                textInput4.setError("This field needs to be filled");
            }
            if(locality==0)
            {

                textInput5.setError("This field needs to be filled");
            }
            if(city==0)
            {

                textInput6.setError("This field needs to be filled");
            }
            if(state==0)
            {

                textInput7.setError("This field needs to be filled");
            }

        }

            }
}
