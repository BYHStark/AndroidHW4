package com.example.gym;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SignUp extends AppCompatActivity {
    private String request_account,request_password,request_name;
    private EditText usrname_field,pwd_field,name_field;
    private List<UserBean> list;
    final OkHttpClient client = new OkHttpClient();

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if(msg.what==1) {
                String ReturnMessage = (String) msg.obj;
                Log.i("Get message back from server", ReturnMessage);
                JsonParser parser=new JsonParser();
                JsonObject j_obj=(JsonObject) parser.parse(ReturnMessage);
//                final UserBean userBean = new Gson().fromJson(ReturnMessage, UserBean.class);
                if(j_obj.get("status").getAsString().equals("OK")) {
                    Intent intent = new Intent(SignUp.this,MainActivity.class);

                    startActivity(intent);
                    Toast.makeText(SignUp.this,"Successfully registered",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(SignUp.this,"Username is already been registed",Toast.LENGTH_SHORT).show();
                }
            }
        }
    };

    private void postRequest() {
        RequestBody formBody = new FormBody.Builder()
                .add("username",request_account)
                .add("password",request_password)
                .build();
        final Request request = new Request.Builder()
                .url("http://172.30.95.236:8000/signup")
                .post(formBody)
                .build();
        new Thread(new Runnable() {
            @Override
            public void run() {
                Response response = null;
                try {
                    response = client.newCall(request).execute();
                    if(response.isSuccessful()) {
                        mHandler.obtainMessage(1, response.body().string()).sendToTarget();
                    }
                    else {
                        throw new IOException("Unexpected code:" + response);
                    }
                }

                catch (IOException e){
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        usrname_field = (EditText) findViewById(R.id.signup_id_1) ;
        pwd_field = (EditText) findViewById(R.id.signup_pw_1) ;
        Button signupbt2 = (Button) findViewById(R.id.signup_bt_2);
        signupbt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                request_account = usrname_field.getText().toString().trim();
                request_password = pwd_field.getText().toString().trim();
                postRequest();
            }
        });
    }
}
