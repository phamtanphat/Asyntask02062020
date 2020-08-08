package com.example.asyntask02062020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTv = findViewById(R.id.textview);
        MyAsyntask myAsyntask = new MyAsyntask();
        myAsyntask.execute();
    }
    class MyAsyntask extends AsyncTask<Void,Integer,String>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mTv.append("Bắt đầu thực thi " + "\n");
        }

        @Override
        protected String doInBackground(Void... strings) {
            for (int i = 1 ; i <= 5 ; i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress(i);
            }
            return "Công việc kết thúc : Thread finish" + "\n";
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            mTv.append("Thread start " + values[0] + "\n");
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String s) {
            mTv.append(s);
            super.onPostExecute(s);
        }
    }
}