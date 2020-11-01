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
    int mPosition;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPosition=-1;

        mBtnAlertDialog=findViewById(R.id.btnAlert);

        mBtnAlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context;
                final AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Bạn có thông báo mới!!!");
              //  builder.setMessage("Phiên bản đã có bản cập nhật mới!!!");
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setCancelable(false);
                // Singe Choice , multiple Choice
                final String[]  arrAnimals = {"Mèo","Chó","Voi","Gà","Khỉ","Heo"};
                final boolean[] arrSelected = {false,false,false,false,false,false};
               builder.setMultiChoiceItems(arrAnimals, arrSelected, new DialogInterface.OnMultiChoiceClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int position, boolean isChecked) {

                   }
               });
                builder.setPositiveButton("Ok!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String result = "";
                        for(int i=0;i < arrSelected.length;i++){
                            if(arrSelected[i]){
                                result += arrAnimals[i] +",";
                            }
                        }
                        result=result.substring(0,result.length() - 3);
                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();

                    }

                });
                builder.setNegativeButton("Cancel!", new DialogInterface.OnClickListener() {//Nút tiêu cực
                    @Override
                    public void onClick(DialogInterface dialog, int position) {
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