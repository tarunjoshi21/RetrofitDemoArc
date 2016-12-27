package com.retrofitdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.retrofitdemo.bean.BaseBean;
import com.retrofitdemo.http.request.MainActivityRequest;
import com.retrofitdemo.http.serviceCallback.MainActivityCallback;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        (findViewById(R.id.check_api)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // call Request class
                MainActivityRequest mainActivityRequest = MainActivityRequest.getInstance();
                mainActivityRequest.callApi("67", 1, new MainActivityCallback() {
                    @Override
                    public void onSuccess(BaseBean baseBean) {
                        Toast.makeText(MainActivity.this, baseBean.getStatus_message(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(String error) {
                        Toast.makeText(MainActivity.this, error, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
