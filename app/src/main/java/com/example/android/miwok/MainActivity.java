/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView numberText;

    private TextView ColorText;

    private TextView FamilyText;

    private TextView PharassText;
    //using array

    /*private String[] numberofE = new String[10];
    private String[] numberofM = new String[10];
*/
    //using array list


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);
        ViewPager viewPager = (ViewPager)findViewById(R.id.view_pager);

        myViewPagerAdapter myViewPagerAdapter1 = new myViewPagerAdapter(this, getSupportFragmentManager());

        viewPager.setAdapter(myViewPagerAdapter1);

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);




    }


//    //open numbersList
//    public void openNumbersList(View view){
//        Intent numberIntent = new Intent(MainActivity.this, NumberActivity.class);
//
//        startActivity(numberIntent);
//    }
//    //open FamilyList
//    public void openFamilyList(View view){
//        Intent FamilyIntent = new Intent(MainActivity.this, FamilyActivity.class);
//
//        startActivity(FamilyIntent);
//    }
//
//    //open PharassList
//    public void openPharassList(View view) {
//        Intent PharassItent = new Intent(MainActivity.this, FamilyActivity.class);
//
//        startActivity(PharassItent);
//
//
//    }
//
//    //opent ColorList
//    public void openColorList(View view) {
//        Intent ColorIntent = new Intent(MainActivity.this, ColorActivity.class);
//
//        startActivity(ColorIntent);
//    }

}
