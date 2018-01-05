package juborajsarker.iplator;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import java.io.File;

public class HomeActivity extends AppCompatActivity {

    InterstitialAd mInterstitialAd;
    int count = 0;

    private EditText first_octate;
    private EditText second_octate;
    private EditText third_octate;
    private EditText fourth_octate;
    private EditText cidr_value;

    private TextView decimal_network;
    private TextView decimal_subnet_mask;
    private TextView decimal_first_host;
    private TextView decimal_last_host;
    private TextView decimal_broadcast;

    private TextView invalid_message;

    private TextView binary_network;
    private TextView binary_subnet_mask;
    private TextView binary_first_host;
    private TextView binary_last_host;
    private TextView binary_broadcast;

    int first_octate_value, second_octate_value, third_octate_value, fourth_octate_value;
    int cidr_value_integer;

    int binary_first_octate_size, binary_second_octate_size, binary_third_octate_size, binary_fourth_octate_size;

    int temp_size1 = 0;
    int temp_size2 = 0;
    int temp_size3 = 0;
    int temp_size4 = 0;

    StringBuilder temp_string1 = new StringBuilder();
    StringBuilder temp_string2 = new StringBuilder();
    StringBuilder temp_string3 = new StringBuilder();
    StringBuilder temp_string4 = new StringBuilder();

    StringBuffer extra_h = new StringBuffer();
    StringBuffer extra_b = new StringBuffer();
    String binary_h;
    String binary_b;


    StringBuilder cidr_srring = new StringBuilder();


    String s;
    String binary_first_part, binary_second_part, binary_third_part, binary_fourth_part;
    int decimal_first_part, decimal_second_part, decimal_third_part, decimal_fourth_part;

    int m, h, b;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);







        first_octate = (EditText) findViewById(R.id.first_octate_ET);
        second_octate = (EditText) findViewById(R.id.second_octate_ET);
        third_octate = (EditText) findViewById(R.id.third_octate_ET);
        fourth_octate = (EditText) findViewById(R.id.fourth_octate_ET);
        cidr_value = (EditText) findViewById(R.id.cidr_value_ET);



        first_octate.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start,int before, int count)
            {
                // TODO Auto-generated method stub
                if(first_octate.getText().toString().length()==3)     //size as per your requirement
                {
                    second_octate.requestFocus();
                }
            }
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
                // TODO Auto-generated method stub

            }

            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }

        });




        second_octate.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start,int before, int count)
            {
                // TODO Auto-generated method stub
                if(second_octate.getText().toString().length()==3)     //size as per your requirement
                {
                    third_octate.requestFocus();
                }
            }
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
                // TODO Auto-generated method stub

            }

            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }

        });






        third_octate.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start,int before, int count)
            {
                // TODO Auto-generated method stub
                if(third_octate.getText().toString().length()==3)     //size as per your requirement
                {
                    fourth_octate.requestFocus();
                }
            }
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
                // TODO Auto-generated method stub

            }

            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }

        });




        fourth_octate.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start,int before, int count)
            {
                // TODO Auto-generated method stub
                if(fourth_octate.getText().toString().length()==3)     //size as per your requirement
                {
                    cidr_value.requestFocus();
                }
            }
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
                // TODO Auto-generated method stub

            }

            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }

        });












        decimal_network = (TextView) findViewById(R.id.decimal_network_TV);
        decimal_subnet_mask = (TextView) findViewById(R.id.decimal_subnet_TV);
        decimal_first_host = (TextView) findViewById(R.id.decimal_first_host_TV);
        decimal_last_host = (TextView) findViewById(R.id.decimal_last_host_TV);
        decimal_broadcast = (TextView) findViewById(R.id.decimal_broadcast_TV);

        invalid_message = (TextView) findViewById(R.id.invalid_message_TV);

        binary_network = (TextView) findViewById(R.id.binary_network_TV);
        binary_subnet_mask = (TextView) findViewById(R.id.binary_subnet_TV);
        binary_first_host = (TextView) findViewById(R.id.binary_first_host_TV);
        binary_last_host = (TextView) findViewById(R.id.binary_last_host_TV);
        binary_broadcast = (TextView) findViewById(R.id.binary_broadcast_TV);
    }



    private void showInterstitial() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }




    public void calculate(View view) {


        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_full_screen1));
        AdRequest adRequest = new AdRequest.Builder().addTestDevice("93448558CC721EBAD8FAAE5DA52596D3").build();
        mInterstitialAd.loadAd(adRequest);

        mInterstitialAd.setAdListener(new AdListener() {
            public void onAdLoaded() {
                showInterstitial();
            }
        });




        if (first_octate.getText().toString().isEmpty() || second_octate.getText().toString().isEmpty() ||
                third_octate.getText().toString().isEmpty() || fourth_octate.getText().toString().isEmpty()) {

            Toast.makeText(this, "Please enter a valid IP", Toast.LENGTH_SHORT).show();

            invalid_message.setVisibility(View.VISIBLE);
            invalid_message.setText("Invalid IP. Every octate must required");

            decimal_network.setText("");
            decimal_subnet_mask.setText("");
            decimal_first_host.setText("");
            decimal_last_host.setText("");
            decimal_broadcast.setText("");

            binary_network.setText("");
            binary_subnet_mask.setText("");
            binary_first_host.setText("");
            binary_last_host.setText("");
            binary_broadcast.setText("");

        } else {


//            if (first_octate.length() ==3){
//
//                int maxLength = 3;
//                first_octate.setFilters(new InputFilter[] {new InputFilter.LengthFilter(maxLength)});
//            }

            if (cidr_value.getText().toString().isEmpty()) {

                first_octate_value = Integer.parseInt(String.valueOf(first_octate.getText()));
                second_octate_value = Integer.parseInt(String.valueOf(second_octate.getText()));
                third_octate_value = Integer.parseInt(String.valueOf(third_octate.getText()));
                fourth_octate_value = Integer.parseInt(String.valueOf(fourth_octate.getText()));

                if (first_octate_value > 255 || second_octate_value > 255 || third_octate_value > 255 || fourth_octate_value > 255) {

                    Toast.makeText(this, "Invalid IP Every octate must between 0-255", Toast.LENGTH_LONG).show();

                    invalid_message.setVisibility(View.VISIBLE);
                    invalid_message.setText("Invalid IP. Every octate must between 0-255");

                    decimal_network.setText("");
                    decimal_subnet_mask.setText("");
                    decimal_first_host.setText("");
                    decimal_last_host.setText("");
                    decimal_broadcast.setText("");

                    binary_network.setText("");
                    binary_subnet_mask.setText("");
                    binary_first_host.setText("");
                    binary_last_host.setText("");
                    binary_broadcast.setText("");

                } else {

                    invalid_message.setVisibility(View.GONE);

                    String binary_first_octate = Integer.toBinaryString(first_octate_value);
                    String binary_second_octate = Integer.toBinaryString(second_octate_value);
                    String binary_third_octate = Integer.toBinaryString(third_octate_value);
                    String binary_fourth_octate = Integer.toBinaryString(fourth_octate_value);


                    binary_first_octate_size = binary_first_octate.length();
                    binary_second_octate_size = binary_second_octate.length();
                    binary_third_octate_size = binary_third_octate.length();
                    binary_fourth_octate_size = binary_fourth_octate.length();

                    if (binary_first_octate_size < 8) {

                        temp_size1 = 8 - binary_first_octate_size;
                        for (int i = 0; i < temp_size1; i++) {

                            temp_string1.append("0");
                        }


                    }

                    if (binary_second_octate_size < 8) {

                        temp_size2 = 8 - binary_second_octate_size;
                        for (int i = 0; i < temp_size2; i++) {

                            temp_string2.append("0");
                        }


                    }

                    if (binary_third_octate_size < 8) {

                        temp_size3 = 8 - binary_third_octate_size;
                        for (int i = 0; i < temp_size3; i++) {

                            temp_string3.append("0");
                        }


                    }

                    if (binary_fourth_octate_size < 8) {

                        temp_size4 = 8 - binary_fourth_octate_size;
                        for (int i = 0; i < temp_size4; i++) {

                            temp_string4.append("0");
                        }


                    }


                    temp_size1 = 0;
                    temp_size2 = 0;
                    temp_size3 = 0;
                    temp_size4 = 0;


                    if (first_octate_value < 128) {

                        decimal_network.setText(first_octate.getText().toString() + ".0.0.0");
                        decimal_subnet_mask.setText("255.0.0.0");
                        decimal_first_host.setText(first_octate.getText().toString() + ".0.0.1");
                        decimal_last_host.setText(first_octate.getText().toString() + ".255.255.254");
                        decimal_broadcast.setText(first_octate.getText().toString() + ".255.255.255");


                        binary_network.setText(temp_string1 + binary_first_octate + ".00000000.00000000.00000000");
                        binary_subnet_mask.setText("11111111.00000000.00000000.00000000");
                        binary_first_host.setText(temp_string1 + binary_first_octate + ".00000000.00000000.00000001");
                        binary_last_host.setText(temp_string1 + binary_first_octate + ".11111111.11111111.11111110");
                        binary_broadcast.setText(temp_string1 + binary_first_octate + ".11111111.11111111.11111111");

                        temp_string1.setLength(0);

                    } else if (first_octate_value > 127 && first_octate_value < 192) {

                        decimal_network.setText(first_octate.getText().toString() + "."
                                + second_octate.getText().toString() + ".0.0");
                        decimal_subnet_mask.setText("255.255.0.0");
                        decimal_first_host.setText(first_octate.getText().toString() + "." +
                                second_octate.getText().toString() + "." + "0.1");
                        decimal_last_host.setText(first_octate.getText().toString() + "." +
                                second_octate.getText().toString() + "." + "255.254");
                        decimal_broadcast.setText(first_octate.getText().toString() + "." +
                                second_octate.getText().toString() + ".255.255");


                        binary_network.setText(temp_string1 + binary_first_octate + "." + temp_string2 +
                                binary_second_octate + ".00000000.00000000");
                        binary_subnet_mask.setText("11111111.11111111.00000000.00000000");
                        binary_first_host.setText(temp_string1 + binary_first_octate + "." + temp_string2 +
                                binary_second_octate + ".00000000.00000001");
                        binary_last_host.setText(temp_string1 + binary_first_octate + "." + temp_string2 +
                                binary_second_octate + ".11111111.11111110");
                        binary_broadcast.setText(temp_string1 + binary_first_octate + "." + temp_string2 +
                                binary_second_octate + ".11111111.11111111");

                        temp_string1.setLength(0);
                        temp_string2.setLength(0);

                    } else if (first_octate_value > 191 && first_octate_value < 224) {

                        decimal_network.setText(first_octate.getText().toString() + "."
                                + second_octate.getText().toString() + "." + third_octate.getText().toString() + ".0");
                        decimal_subnet_mask.setText("255.255.255.0");
                        decimal_first_host.setText(first_octate.getText().toString() + "." +
                                second_octate.getText().toString() + "." + third_octate.getText().toString() + ".1");
                        decimal_last_host.setText(first_octate.getText().toString() + "." + second_octate.getText().toString() +
                                "." + third_octate.getText().toString() + ".254");
                        decimal_broadcast.setText(first_octate.getText().toString() + "." + second_octate.getText().toString() +
                                "." + third_octate.getText().toString() + ".255");


                        binary_network.setText(temp_string1 + binary_first_octate + "." + temp_string2 +
                                binary_second_octate + "." + temp_string3 + binary_third_octate + ".00000000");
                        binary_subnet_mask.setText("11111111.11111111.11111111.00000000");
                        binary_first_host.setText(temp_string1 + binary_first_octate + "." + temp_string2 +
                                binary_second_octate + "." + temp_string3 + binary_third_octate + ".00000001");
                        binary_last_host.setText(temp_string1 + binary_first_octate + "." + temp_string2 +
                                binary_second_octate + "." + temp_string3 + binary_third_octate + ".11111110");
                        binary_broadcast.setText(temp_string1 + binary_first_octate + "." + temp_string2 +
                                binary_second_octate + "." + temp_string3 + binary_third_octate + ".11111111");


                        temp_string1.setLength(0);
                        temp_string2.setLength(0);
                        temp_string3.setLength(0);

                    } else if (first_octate_value > 223 && first_octate_value < 240) {

                        decimal_network.setText(first_octate.getText().toString() + "." + second_octate.getText().toString() + "" +
                                third_octate.getText().toString() + "." + fourth_octate.getText().toString());
                        decimal_subnet_mask.setText("255.255.255.255");
                        decimal_first_host.setText(first_octate.getText().toString() + "." + second_octate.getText().toString() + "." +
                                third_octate.getText().toString() + "." + fourth_octate.getText().toString());

                        decimal_last_host.setText(first_octate.getText().toString() + "." + second_octate.getText().toString() + "." +
                                third_octate.getText().toString() + "." + fourth_octate.getText().toString());

                        decimal_broadcast.setText(first_octate.getText().toString() + "." + second_octate.getText().toString() + "." +
                                third_octate.getText().toString() + "." + fourth_octate.getText().toString());


                        binary_network.setText(temp_string1 + binary_first_octate + "." + temp_string2 + binary_second_octate + "." +
                                temp_string3 + binary_third_octate + "." + temp_string4 + binary_fourth_octate);

                        binary_subnet_mask.setText("11111111.11111111.11111111.11111111");

                        binary_first_host.setText(temp_string1 + binary_first_octate + "." + temp_string2 + binary_second_octate + "." +
                                temp_string3 + binary_third_octate + "." + temp_string4 + binary_fourth_octate);

                        binary_last_host.setText(temp_string1 + binary_first_octate + "." + temp_string2 + binary_second_octate + "." +
                                temp_string3 + binary_third_octate + "." + temp_string4 + binary_fourth_octate);

                        binary_broadcast.setText(temp_string1 + binary_first_octate + "." + temp_string2 + binary_second_octate + "." +
                                temp_string3 + binary_third_octate + "." + temp_string4 + binary_fourth_octate);

                        temp_string1.setLength(0);
                        temp_string2.setLength(0);
                        temp_string3.setLength(0);
                        temp_string4.setLength(0);


                    } else if (first_octate_value > 239 && first_octate_value < 256) {

                        decimal_network.setText("not defined");
                        decimal_subnet_mask.setText("not defined");
                        decimal_first_host.setText("not defined");
                        decimal_last_host.setText("not defined");
                        decimal_broadcast.setText("not defined");

                        binary_network.setText("not defined");
                        binary_subnet_mask.setText("not defined");
                        binary_first_host.setText("not defined");
                        binary_last_host.setText("not defined");
                        binary_broadcast.setText("not defined");

                        temp_string1.setLength(0);
                        temp_string2.setLength(0);
                        temp_string3.setLength(0);
                        temp_string4.setLength(0);
                    }


                }


            } else {

                first_octate_value = Integer.parseInt(String.valueOf(first_octate.getText()));
                second_octate_value = Integer.parseInt(String.valueOf(second_octate.getText()));
                third_octate_value = Integer.parseInt(String.valueOf(third_octate.getText()));
                fourth_octate_value = Integer.parseInt(String.valueOf(fourth_octate.getText()));


                if (first_octate_value > 255 || second_octate_value > 255 || third_octate_value > 255 || fourth_octate_value > 255) {

                    Toast.makeText(this, "Invalid IP. Every octate must between 0-255", Toast.LENGTH_SHORT).show();

                    invalid_message.setVisibility(View.VISIBLE);
                    invalid_message.setText("Invalid IP. Every octate must between 0-255");

                    decimal_network.setText("");
                    decimal_subnet_mask.setText("");
                    decimal_first_host.setText("");
                    decimal_last_host.setText("");
                    decimal_broadcast.setText("");

                    binary_network.setText("");
                    binary_subnet_mask.setText("");
                    binary_first_host.setText("");
                    binary_last_host.setText("");
                    binary_broadcast.setText("");


                } else {

                    cidr_value_integer = Integer.parseInt(String.valueOf(cidr_value.getText()));

                    if (cidr_value_integer > 32) {

                        Toast.makeText(this, "Invalid CIDR value. It must between 0-32", Toast.LENGTH_SHORT).show();

                        invalid_message.setVisibility(View.VISIBLE);
                        invalid_message.setText("Invalid CIDR value. It must between 0-32");

                        decimal_network.setText("");
                        decimal_subnet_mask.setText("");
                        decimal_first_host.setText("");
                        decimal_last_host.setText("");
                        decimal_broadcast.setText("");

                        binary_network.setText("");
                        binary_subnet_mask.setText("");
                        binary_first_host.setText("");
                        binary_last_host.setText("");
                        binary_broadcast.setText("");

                    } else if (cidr_value_integer != 0 || cidr_value_integer != 8 || cidr_value_integer != 16 || cidr_value_integer != 24) {

                        invalid_message.setVisibility(View.GONE);

                        cidr_value_integer = Integer.parseInt(String.valueOf(cidr_value.getText()));

                        first_octate_value = Integer.parseInt(String.valueOf(first_octate.getText()));
                        second_octate_value = Integer.parseInt(String.valueOf(second_octate.getText()));
                        third_octate_value = Integer.parseInt(String.valueOf(third_octate.getText()));
                        fourth_octate_value = Integer.parseInt(String.valueOf(fourth_octate.getText()));


                        String binary_first_octate = Integer.toBinaryString(first_octate_value);
                        String binary_second_octate = Integer.toBinaryString(second_octate_value);
                        String binary_third_octate = Integer.toBinaryString(third_octate_value);
                        String binary_fourth_octate = Integer.toBinaryString(fourth_octate_value);


                        binary_first_octate_size = binary_first_octate.length();
                        binary_second_octate_size = binary_second_octate.length();
                        binary_third_octate_size = binary_third_octate.length();
                        binary_fourth_octate_size = binary_fourth_octate.length();

                        if (binary_first_octate_size < 8) {

                            temp_size1 = 8 - binary_first_octate_size;
                            for (int i = 0; i < temp_size1; i++) {

                                temp_string1.append("0");
                            }


                        }

                        if (binary_second_octate_size < 8) {

                            temp_size2 = 8 - binary_second_octate_size;
                            for (int i = 0; i < temp_size2; i++) {

                                temp_string2.append("0");
                            }


                        }

                        if (binary_third_octate_size < 8) {

                            temp_size3 = 8 - binary_third_octate_size;
                            for (int i = 0; i < temp_size3; i++) {

                                temp_string3.append("0");
                            }


                        }

                        if (binary_fourth_octate_size < 8) {

                            temp_size4 = 8 - binary_fourth_octate_size;
                            for (int i = 0; i < temp_size4; i++) {

                                temp_string4.append("0");
                            }


                        }


                        temp_size1 = 0;
                        temp_size2 = 0;
                        temp_size3 = 0;
                        temp_size4 = 0;


                        for (int j = 0; j < cidr_value_integer; j++) {

                            cidr_srring.append("1");

                        }

                        for (int k = cidr_value_integer; k < 32; k++) {

                            cidr_srring.append("0");

                        }


                        s = cidr_srring.toString();


                        binary_first_part = s.substring(0, 8);
                        binary_second_part = s.substring(8, 16);
                        binary_third_part = s.substring(16, 24);
                        binary_fourth_part = s.substring(24, 32);


                        binary_subnet_mask.setText(binary_first_part + "." + binary_second_part + "." +
                                binary_third_part + "." + binary_fourth_part);

                        decimal_first_part = Integer.parseInt(binary_first_part, 2);
                        decimal_second_part = Integer.parseInt(binary_second_part, 2);
                        decimal_third_part = Integer.parseInt(binary_third_part, 2);
                        decimal_fourth_part = Integer.parseInt(binary_fourth_part, 2);

                        decimal_subnet_mask.setText(decimal_first_part + "." + decimal_second_part + "." +
                                decimal_third_part + "." + decimal_fourth_part);


                        if (decimal_first_part > 0 && decimal_first_part < 255) {

                            m = 256 - decimal_first_part;
                            int temp_h = first_octate_value / m;
                            h = temp_h * m;
                            b = (m + h) - 1;

                            decimal_network.setText(String.valueOf(h) + ".0.0.0");
                            decimal_first_host.setText(String.valueOf(h) + ".0.0.1");
                            decimal_last_host.setText(String.valueOf(b) + ".255.255.254");
                            decimal_broadcast.setText(String.valueOf(b) + ".255.255.255");


                            binary_h = Integer.toBinaryString(h);
                            binary_b = Integer.toBinaryString(b);

                            if (binary_h.length() < 8) {
                                for (int a = binary_h.length(); a < 8; a++) {

                                    extra_h.append("0");
                                }
                            }

                            if (binary_b.length() < 8) {
                                for (int a = binary_b.length(); a < 8; a++) {

                                    extra_b.append("0");
                                }
                            }


                            binary_network.setText(extra_h + binary_h + ".00000000.00000000.00000000");
                            binary_first_host.setText(extra_h + binary_h + ".00000000.00000000.00000001");
                            binary_last_host.setText(extra_b + binary_b + ".11111111.11111111.11111110");
                            binary_broadcast.setText(extra_b + binary_b + ".11111111.11111111.11111111");

                            extra_b.setLength(0);
                            extra_h.setLength(0);
                            binary_h = "";
                            binary_b = "";


                        } else if (decimal_second_part > 0 && decimal_second_part < 255) {

                            m = 256 - decimal_second_part;
                            int temp_h = second_octate_value / m;
                            h = temp_h * m;
                            b = (m + h) - 1;

                            decimal_network.setText(first_octate.getText().toString() + "." + String.valueOf(h) + ".0.0");
                            decimal_first_host.setText(first_octate.getText().toString() + "." + String.valueOf(h) + ".0.1");
                            decimal_last_host.setText(first_octate.getText().toString() + "." + String.valueOf(b) + ".255.254");
                            decimal_broadcast.setText(first_octate.getText().toString() + "." + String.valueOf(b) + ".255.255");


                            binary_h = Integer.toBinaryString(h);
                            binary_b = Integer.toBinaryString(b);

                            if (binary_h.length() < 8) {

                                for (int a = binary_h.length(); a < 8; a++) {

                                    extra_h.append("0");
                                }
                            }

                            if (binary_b.length() < 8) {
                                for (int a = binary_b.length(); a < 8; a++) {

                                    extra_b.append("0");
                                }
                            }

                            binary_network.setText(temp_string1 + binary_first_octate + "." + extra_h + binary_h + ".00000000.00000000");
                            binary_first_host.setText(temp_string1 + binary_first_octate + "." + extra_h + binary_h + ".00000000.00000001");
                            binary_last_host.setText(temp_string1 + binary_first_octate + "." + extra_b + binary_b + ".11111111.11111110");
                            binary_broadcast.setText(temp_string1 + binary_first_octate + "." + extra_b + binary_b + ".11111111.11111111");


                            extra_b.setLength(0);
                            extra_h.setLength(0);
                            binary_h = "";
                            binary_b = "";
                            temp_string1.setLength(0);


                        } else if (decimal_third_part > 0 && decimal_third_part < 255) {


                            m = 256 - decimal_third_part;
                            int temp_h = third_octate_value / m;
                            h = temp_h * m;
                            b = (m + h) - 1;

                            decimal_network.setText(first_octate.getText().toString() + "." + second_octate.getText().toString() + "." +
                                    String.valueOf(h) + ".0");
                            decimal_first_host.setText(first_octate.getText().toString() + "." + second_octate.getText().toString() + "." +
                                    String.valueOf(h) + ".1");
                            decimal_last_host.setText(first_octate.getText().toString() + "." + second_octate.getText().toString() + "." +
                                    String.valueOf(b) + ".254");
                            decimal_broadcast.setText(first_octate.getText().toString() + "." + second_octate.getText().toString() + "." +
                                    String.valueOf(b) + ".255");


                            binary_h = Integer.toBinaryString(h);
                            binary_b = Integer.toBinaryString(b);

                            if (binary_h.length() < 8) {

                                for (int a = binary_h.length(); a < 8; a++) {

                                    extra_h.append("0");
                                }
                            }

                            if (binary_b.length() < 8) {


                                for (int a = binary_b.length(); a < 8; a++) {

                                    extra_b.append("0");
                                }
                            }

                            binary_network.setText(temp_string1 + binary_first_octate + "." + temp_string2 + binary_second_octate + "." + extra_h + binary_h + ".00000000");
                            binary_first_host.setText(temp_string1 + binary_first_octate + "." + temp_string2 + binary_second_octate + "." + extra_h + binary_h + ".00000001");
                            binary_last_host.setText(temp_string1 + binary_first_octate + "." + temp_string2 + binary_second_octate + "." + extra_b + binary_b + ".11111110");
                            binary_broadcast.setText(temp_string1 + binary_first_octate + "." + temp_string2 + binary_second_octate + "." + extra_b + binary_b + ".11111111");


                            extra_b.setLength(0);
                            extra_h.setLength(0);
                            binary_h = "";
                            binary_b = "";


                            temp_string1.setLength(0);
                            temp_string2.setLength(0);


                        } else if (decimal_fourth_part > 0 && decimal_fourth_part < 255) {

                            m = 256 - decimal_fourth_part;
                            int temp_h = fourth_octate_value / m;
                            h = temp_h * m;
                            b = (m + h) - 1;

                            int copy_h = h;
                            int copy_b = b;

                            decimal_network.setText(first_octate.getText().toString() + "." + second_octate.getText().toString() + "." +
                                    third_octate.getText().toString() + "." + String.valueOf(h));
                            decimal_first_host.setText(first_octate.getText().toString() + "." + second_octate.getText().toString() + "." +
                                    third_octate.getText().toString() + "." + String.valueOf(h + 1));
                            decimal_last_host.setText(first_octate.getText().toString() + "." + second_octate.getText().toString() + "." +
                                    third_octate.getText().toString() + "." + String.valueOf(b - 1));
                            decimal_broadcast.setText(first_octate.getText().toString() + "." + second_octate.getText().toString() + "." +
                                    third_octate.getText().toString() + "." + String.valueOf(b));


                            binary_h = Integer.toBinaryString(h);
                            binary_b = Integer.toBinaryString(b);


                            int sum_h = copy_h + 1;
                            int subtract_b = copy_b - 1;

                            String sum = Integer.toBinaryString(sum_h);
                            String subtract = Integer.toBinaryString(subtract_b);

                            StringBuffer extra_sum = new StringBuffer();
                            StringBuffer extra_subtract = new StringBuffer();

                            if (sum.length() < 8) {

                                for (int p = sum.length(); p < 8; p++) {

                                    extra_sum.append("0");

                                }
                            }


                            if (subtract.length() < 8) {

                                for (int p = subtract.length(); p < 8; p++) {

                                    extra_subtract.append("0");

                                }
                            }


                            if (binary_h.length() < 8) {
                                for (int a = binary_h.length(); a < 8; a++) {

                                    extra_h.append("0");
                                }
                            }

                            if (binary_b.length() < 8) {
                                for (int a = binary_b.length(); a < 8; a++) {

                                    extra_b.append("0");
                                }
                            }


                            sum = extra_sum + sum;
                            subtract = extra_subtract + subtract;


                            binary_network.setText(temp_string1 + binary_first_octate + "." + temp_string2 + binary_second_octate + "." +
                                    temp_string3 + binary_third_octate + "." + extra_h + binary_h);
                            binary_first_host.setText(temp_string1 + binary_first_octate + "." + temp_string2 + binary_second_octate + "." +
                                    temp_string3 + binary_third_octate + "." + sum);

                            binary_last_host.setText(temp_string1 + binary_first_octate + "." + temp_string2 + binary_second_octate + "." +
                                    temp_string3 + binary_third_octate + "." + subtract);

                            binary_broadcast.setText(temp_string1 + binary_first_octate + "." + temp_string2 + binary_second_octate + "." +
                                    temp_string3 + binary_third_octate + "." + extra_b + binary_b);


                            extra_b.setLength(0);
                            extra_h.setLength(0);
                            binary_h = "";
                            binary_b = "";
                            extra_sum.setLength(0);
                            extra_subtract.setLength(0);

                            temp_string1.setLength(0);
                            temp_string2.setLength(0);
                            temp_string3.setLength(0);


                        } else if (decimal_first_part == 255 && decimal_second_part == 255 && decimal_third_part == 255 && decimal_fourth_part == 255) {


                            decimal_network.setText(first_octate.getText().toString() + "." + second_octate.getText().toString() + "." +
                                    third_octate.getText().toString() + "." + fourth_octate.getText().toString());

                            decimal_subnet_mask.setText("255.255.255.255");
                            decimal_first_host.setText(first_octate.getText().toString() + "." + second_octate.getText().toString() + "." +
                                    third_octate.getText().toString() + "." + fourth_octate.getText().toString());

                            decimal_last_host.setText(first_octate.getText().toString() + "." + second_octate.getText().toString() + "." +
                                    third_octate.getText().toString() + "." + fourth_octate.getText().toString());

                            decimal_broadcast.setText(first_octate.getText().toString() + "." + second_octate.getText().toString() + "." +
                                    third_octate.getText().toString() + "." + fourth_octate.getText().toString());


                            binary_network.setText(temp_string1 + binary_first_octate + "." + temp_string2 + binary_second_octate + "." +
                                    temp_string3 + binary_third_octate + "." + temp_string4 + binary_fourth_octate);

                            binary_first_host.setText(temp_string1 + binary_first_octate + "." + temp_string2 + binary_second_octate + "." +
                                    temp_string3 + binary_third_octate + "." + temp_string4 + binary_fourth_octate);

                            binary_last_host.setText(temp_string1 + binary_first_octate + "." + temp_string2 + binary_second_octate + "." +
                                    temp_string3 + binary_third_octate + "." + temp_string4 + binary_fourth_octate);

                            binary_broadcast.setText(temp_string1 + binary_first_octate + "." + temp_string2 + binary_second_octate + "." +
                                    temp_string3 + binary_third_octate + "." + temp_string4 + binary_fourth_octate);


                            temp_string1.setLength(0);
                            temp_string2.setLength(0);
                            temp_string3.setLength(0);
                            temp_string4.setLength(0);


                        }


                        cidr_srring.setLength(0);


                        temp_string1.setLength(0);
                        temp_string2.setLength(0);
                        temp_string3.setLength(0);
                        temp_string4.setLength(0);


                    }

                    if (cidr_value_integer == 0 || cidr_value_integer == 8 || cidr_value_integer == 16 || cidr_value_integer == 24) {


                        String binary_first_octate = Integer.toBinaryString(first_octate_value);
                        String binary_second_octate = Integer.toBinaryString(second_octate_value);
                        String binary_third_octate = Integer.toBinaryString(third_octate_value);
                        String binary_fourth_octate = Integer.toBinaryString(fourth_octate_value);


                        binary_first_octate_size = binary_first_octate.length();
                        binary_second_octate_size = binary_second_octate.length();
                        binary_third_octate_size = binary_third_octate.length();
                        binary_fourth_octate_size = binary_fourth_octate.length();

                        if (binary_first_octate_size < 8) {

                            temp_size1 = 8 - binary_first_octate_size;
                            for (int i = 0; i < temp_size1; i++) {

                                temp_string1.append("0");
                            }


                        }

                        if (binary_second_octate_size < 8) {

                            temp_size2 = 8 - binary_second_octate_size;
                            for (int i = 0; i < temp_size2; i++) {

                                temp_string2.append("0");
                            }


                        }

                        if (binary_third_octate_size < 8) {

                            temp_size3 = 8 - binary_third_octate_size;
                            for (int i = 0; i < temp_size3; i++) {

                                temp_string3.append("0");
                            }


                        }

                        if (binary_fourth_octate_size < 8) {

                            temp_size4 = 8 - binary_fourth_octate_size;
                            for (int i = 0; i < temp_size4; i++) {

                                temp_string4.append("0");
                            }


                        }


                        temp_size1 = 0;
                        temp_size2 = 0;
                        temp_size3 = 0;
                        temp_size4 = 0;


                        if (cidr_value_integer == 0) {

                            decimal_network.setText("0.0.0.0");
                            decimal_subnet_mask.setText("0.0.0.0");
                            decimal_first_host.setText("0.0.0.1");
                            decimal_last_host.setText("255.255.255.254");
                            decimal_broadcast.setText("255.255.255.255");

                            binary_network.setText("00000000.00000000.00000000.0000000");
                            binary_subnet_mask.setText("00000000.00000000.00000000.00000000");
                            binary_first_host.setText("00000000.00000000.00000000.00000001");
                            binary_last_host.setText("11111111.11111111.11111111.11111110");
                            binary_broadcast.setText("11111111.11111111.11111111.11111111");


                        } else if (cidr_value_integer == 8) {


                            decimal_network.setText(first_octate.getText().toString() + ".0.0.0");
                            decimal_subnet_mask.setText("255.0.0.0");
                            decimal_first_host.setText(first_octate.getText().toString() + ".0.0.1");
                            decimal_last_host.setText(first_octate.getText().toString() + ".255.255.254");
                            decimal_broadcast.setText(first_octate.getText().toString() + ".255.255.255");


                            binary_network.setText(temp_string1 + binary_first_octate + ".00000000.00000000.00000000");
                            binary_subnet_mask.setText("11111111.00000000.00000000.00000000");
                            binary_first_host.setText(temp_string1 + binary_first_octate + ".00000000.00000000.00000001");
                            binary_last_host.setText(temp_string1 + binary_first_octate + ".11111111.11111111.11111110");
                            binary_broadcast.setText(temp_string1 + binary_first_octate + ".11111111.11111111.11111111");

                            temp_string1.setLength(0);


                        } else if (cidr_value_integer == 16) {


                            decimal_network.setText(first_octate.getText().toString() + "."
                                    + second_octate.getText().toString() + ".0.0");
                            decimal_subnet_mask.setText("255.255.0.0");
                            decimal_first_host.setText(first_octate.getText().toString() + "." +
                                    second_octate.getText().toString() + "." + "0.1");
                            decimal_last_host.setText(first_octate.getText().toString() + "." +
                                    second_octate.getText().toString() + "." + "255.254");
                            decimal_broadcast.setText(first_octate.getText().toString() + "." +
                                    second_octate.getText().toString() + ".255.255");


                            binary_network.setText(temp_string1 + binary_first_octate + "." + temp_string2 +
                                    binary_second_octate + ".00000000.00000000");
                            binary_subnet_mask.setText("11111111.11111111.00000000.00000000");
                            binary_first_host.setText(temp_string1 + binary_first_octate + "." + temp_string2 +
                                    binary_second_octate + ".00000000.00000001");
                            binary_last_host.setText(temp_string1 + binary_first_octate + "." + temp_string2 +
                                    binary_second_octate + ".11111111.11111110");
                            binary_broadcast.setText(temp_string1 + binary_first_octate + "." + temp_string2 +
                                    binary_second_octate + ".11111111.11111111");

                            temp_string1.setLength(0);
                            temp_string2.setLength(0);


                        } else if (cidr_value_integer == 24) {


                            decimal_network.setText(first_octate.getText().toString() + "."
                                    + second_octate.getText().toString() + "." + third_octate.getText().toString() + ".0");
                            decimal_subnet_mask.setText("255.255.255.0");
                            decimal_first_host.setText(first_octate.getText().toString() + "." +
                                    second_octate.getText().toString() + "." + third_octate.getText().toString() + ".1");
                            decimal_last_host.setText(first_octate.getText().toString() + "." + second_octate.getText().toString() +
                                    "." + third_octate.getText().toString() + ".254");
                            decimal_broadcast.setText(first_octate.getText().toString() + "." + second_octate.getText().toString() +
                                    "." + third_octate.getText().toString() + ".255");


                            binary_network.setText(temp_string1 + binary_first_octate + "." + temp_string2 +
                                    binary_second_octate + "." + temp_string3 + binary_third_octate + ".00000000");
                            binary_subnet_mask.setText("11111111.11111111.11111111.00000000");
                            binary_first_host.setText(temp_string1 + binary_first_octate + "." + temp_string2 +
                                    binary_second_octate + "." + temp_string3 + binary_third_octate + ".00000001");
                            binary_last_host.setText(temp_string1 + binary_first_octate + "." + temp_string2 +
                                    binary_second_octate + "." + temp_string3 + binary_third_octate + ".11111110");
                            binary_broadcast.setText(temp_string1 + binary_first_octate + "." + temp_string2 +
                                    binary_second_octate + "." + temp_string3 + binary_third_octate + ".11111111");


                            temp_string1.setLength(0);
                            temp_string2.setLength(0);
                            temp_string3.setLength(0);

                        }

                    }


                }


            }


        }


        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);


    }



    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_for_all, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:

                onBackPressed();

            default:
                return super.onOptionsItemSelected(item);
        }


    }



    public void rateApp(MenuItem item) {

        rateApps();

    }


    public void shareApp(MenuItem item) {

        ApplicationInfo app = getApplicationContext().getApplicationInfo();
        String filePath = app.sourceDir;
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        intent.createChooser(intent,"IP Calculator");
        intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new File(filePath)));
        startActivity(Intent.createChooser(intent, "share IP Calculator using"));

    }





    public void moreApps(MenuItem item) {


        Intent intent;
        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/dev?id=6155570899607409709&hl"));
        startActivity(intent);

    }



    public void goToAboutActivity(MenuItem item) {


        startActivity(new Intent(HomeActivity.this, AboutMeActivity.class));
    }


    public void rateApps() {
        try
        {
            Intent rateIntent = rateIntentForUrl("market://details");
            startActivity(rateIntent);
        }
        catch (ActivityNotFoundException e)
        {
            Intent rateIntent = rateIntentForUrl("https://play.google.com/store/apps/details");
            startActivity(rateIntent);
        }
    }


    private Intent rateIntentForUrl(String url)
    {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(String.format("%s?id=%s", url, getPackageName())));
        int flags = Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_MULTIPLE_TASK;
        if (Build.VERSION.SDK_INT >= 21)
        {
            flags |= Intent.FLAG_ACTIVITY_NEW_DOCUMENT;
        }
        else
        {
            flags |= Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET;
        }
        intent.addFlags(flags);
        return intent;
    }


}
