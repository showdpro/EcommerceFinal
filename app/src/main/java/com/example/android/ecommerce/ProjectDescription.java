package com.example.android.ecommerce;

import android.support.design.widget.TextInputLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ProjectDescription extends AppCompatActivity {
    ImageView iconCart;
    TextView ProductBrand,ProductName,ProductPrice,ProductMRP,ProductDiscount;
    TextView WishList,Cart;
    EditText editText1, editText2, editText3, editText4, editText5, editText6, editText7, editText8, editText9;

    TextInputLayout textInput1, textInput2, textInput3, textInput4, textInput5, textInput6, textInput7, textInput8, textInput9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_description);
        iconCart=findViewById(R.id.icon_cart);


        ViewPager viewpager = findViewById(R.id.temp_view_pager);

        ImageAdapter adapter = new ImageAdapter(this);
        viewpager.setAdapter(adapter);

        editText1=findViewById(R.id.temp_user_name);
        editText2=findViewById(R.id.temp_user_mobile);
        editText3=findViewById(R.id.temp_user_address);
        editText4=findViewById(R.id.temp_user_email);
        editText5=findViewById(R.id.temp_user_website_url);
//        editText6=findViewById(R.id.temp_user_instagram_url);
//        editText7=findViewById(R.id.temp_user_facebook_url);
        editText8=findViewById(R.id.temp_user_designation);
        editText9=findViewById(R.id.temp_user_work_type);


        int Name=editText1.getText().toString().trim().length();
        int phone=editText2.getText().toString().trim().length();
        int address=editText3.getText().toString().trim().length();
        int email=editText4.getText().toString().trim().length();
        int website=editText5.getText().toString().trim().length();
//        int instagram=editText6.getText().toString().trim().length();
//        int facebook=editText7.getText().toString().trim().length();
        int designation=editText8.getText().toString().trim().length();
        int work_type=editText9.getText().toString().trim().length();


        textInput1=findViewById(R.id.text_layout_name);
        textInput2=findViewById(R.id.text_layout_mobile);
        textInput3=findViewById(R.id.text_layout_address);
        textInput4=findViewById(R.id.text_layout_email);
        textInput5=findViewById(R.id.text_layout_website_url);
//        textInput6=findViewById(R.id.text_layout_instagram_url);
//        textInput7=findViewById(R.id.text_layout_facebook_url);
        textInput8=findViewById(R.id.text_layout_designation);
        textInput9=findViewById(R.id.text_layout_work_type);



        if(Name==0||phone==0||address==0||email==0||designation==0||work_type==0)
        {
            if(Name==0)
            {

                textInput1.setError("This field needs to be filled");
            }
            if(phone==0)
            {

                textInput2.setError("This field needs to be filled");
            }
            if(address==0)
            {

                textInput3.setError("This field needs to be filled");
            }
            if(email==0)
            {

                textInput4.setError("This field needs to be filled");
            }
            if(designation==0)
            {

                textInput8.setError("This field needs to be filled");
            }
            if(work_type==0)
            {

                textInput9.setError("This field needs to be filled");
            }


        }

    }
    }

