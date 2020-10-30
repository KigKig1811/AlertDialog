package com.kig2.alertdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.nio.IntBuffer;

public class MainActivity extends AppCompatActivity {
    Button mBtnAlertDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnAlertDialog=findViewById(R.id.btnAlert);

        mBtnAlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context;
                AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Bạn có thông báo mới!!!");
              //  builder.setMessage("Phiên bản đã có bản cập nhật mới!!!");
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setCancelable(false);
                // Singe Choice , multiple Choice
                final String[]  arrAnimals = {"Mèo","Chó","Voi","Gà","Khỉ","Heo"};
                builder.setSingleChoiceItems(arrAnimals, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int position) {
                        Toast.makeText(getApplicationContext(), arrAnimals[position], Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setPositiveButton("Ok!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();//tắt dialog
                    }
                });
                builder.setNegativeButton("Cancel!", new DialogInterface.OnClickListener() {//Nút tiêu cực
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish(); //kill 1 activity
                        //task Lần xử lý
                        //stack lưu trữ lại ngăn xếp

                    }
                });
                builder.setNeutralButton("Exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"Exit",Toast.LENGTH_LONG).show();
                    }
                });
                builder.show();


            }
        });
    }
}