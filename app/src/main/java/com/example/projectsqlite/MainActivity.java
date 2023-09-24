package com.example.projectsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.projectsqlite.db.MyDbManager;

public class MainActivity extends AppCompatActivity {
    private MyDbManager myDbManager;
    private EditText Title, Discription;
    private TextView tvtext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDbManager = new MyDbManager(this);

        Title = findViewById(R.id.titleText);
        Discription = findViewById(R.id.discriptonText);
        tvtext = findViewById(R.id.TvText);
    }

    @Override
    protected void onResume() {
        super.onResume();
        myDbManager.OpenDb();

        for(String title : myDbManager.getFromDb()){
            tvtext.append(title);
            tvtext.append("\n");
        }
    }

    public void OnClickSave(View view){
        tvtext.setText("");
        myDbManager.insertToDb(Title.getText().toString(), Discription.getText().toString());
        for(String title : myDbManager.getFromDb()){
            tvtext.append(title);
            tvtext.append("\n");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myDbManager.closeDb();
    }
}