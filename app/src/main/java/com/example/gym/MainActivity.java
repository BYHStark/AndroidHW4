package com.example.gym;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;


import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.util.List;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity{
    private String request_account,request_password;
    private EditText account_text, pw_text;
    private List<UserBean>list;
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


                try {

                    if(j_obj.get("status").getAsString().equals("OK")) {
                        JsonArray trainer_arr = j_obj.get("trainers").getAsJsonArray();
                        String target_trainers[] = new String[trainer_arr.size()];
                        for(int i=0;i<trainer_arr.size();i++) {
                            JsonObject temp = trainer_arr.get(i).getAsJsonObject();
                            target_trainers[i] = temp.get("trainer_name").getAsString();
                        }
                        Intent get_in_main = new Intent(MainActivity.this,MainUI.class);
                        get_in_main.putExtra("account",request_account);
                        get_in_main.putExtra("trainers_list",target_trainers);
                        Log.i("www", target_trainers[0]);
                        startActivity(get_in_main);
                    }
                    else {
                        Log.i("dbad", "handleMessage: adadadasa");
                        Toast.makeText(MainActivity.this,"Please check your username or password",Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
    };

    private void postRequest(String username, String password) {
        RequestBody formBody = new FormBody.Builder()
                .add("username",request_account)
                .add("password",request_password)
                .build();
        final Request request = new Request.Builder()
                .url("http://172.30.95.236:8000/login")
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
        setContentView(R.layout.login_activity);

        account_text = (EditText) findViewById(R.id.account_text_1);
        pw_text = (EditText) findViewById(R.id.pw_text_1);
        Button login_bt = (Button) findViewById(R.id.login_bt_1);
        login_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent test = new Intent(MainActivity.this,MainUI.class);
                startActivity(test);
            }
        });

        Button signupbt = (Button) findViewById(R.id.signup_bt_1);
        signupbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent test = new Intent(MainActivity.this,SignUp.class);
                startActivity(test);
            }
        });
    }
}
