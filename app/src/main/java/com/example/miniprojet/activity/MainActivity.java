package com.example.miniprojet.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.miniprojet.R;
import com.example.miniprojet.network.Api;
import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private EditText username, password;
    private Button log;
    private Button logi;

    private ProgressDialog processDialog;
    private OkHttpClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        log = (Button) findViewById(R.id.loginbtn);
        logi = (Button) findViewById(R.id.user);

        processDialog = new ProgressDialog(this);



        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getService();

            }
        });

        logi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent accueilIntent = new Intent(MainActivity.this, UserActivity.class);
                startActivity(accueilIntent);
            }
        });

    }

    public void getService() {
        processDialog.setMessage("................Please Wait.............");
        processDialog.setTitle("Authentificate");
        processDialog.show();

        client = new OkHttpClient();
        String url = Api.ENDPOINT_AUTHENTICATE;
        String json;

        HashMap<String, Object> user = new HashMap();
        user.put("nom", username.getText().toString());
        user.put("password", password.getText().toString());

        json = new Gson().toJson(user);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);

        final Request request = new Request.Builder().url(url).post(requestBody).build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                System.out.println("onFailure");
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                if (response.isSuccessful()) {
                    try {
                        String res = response.body().string();
                        HashMap body = new Gson().fromJson(res, HashMap.class);
                        String nom = (String) body.get("nom");
                        System.out.println(nom);

                        if (nom != null) {
                            System.out.println("kengne");
                            Intent accueilIntent = new Intent(MainActivity.this, Menu_principal.class);
                            startActivity(accueilIntent);
                            System.out.println("test");
                            finish();
                        } else {
                            if (nom == null) {
                                Intent accueilIntent = new Intent(MainActivity.this, MainActivity.class);
                                startActivity(accueilIntent);
                                System.out.println("test");
                                System.out.println("FOKOUA");
                                // byte[] encodedBytes = Base64.getEncoder().encode("Test".getBytes());
                                // System.out.println("encodedBytes " + new String(encodedBytes));
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    processDialog.dismiss();
                    System.out.println("tresor");

                }
            }
        });
    }
}