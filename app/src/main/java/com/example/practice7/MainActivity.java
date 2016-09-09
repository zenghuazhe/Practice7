package com.example.practice7;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) this.findViewById(R.id.AlertDialogButton);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("这是一个普通的对话框")//显示的消息内容
                        .setTitle("对话框");//对话框标题

                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "用户按下了确认按钮", Toast.LENGTH_LONG).show();

                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "用户按下了取消按钮", Toast.LENGTH_LONG).show();

                    }
                });
                builder.setNeutralButton("忽略", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "用户按下了忽略按钮", Toast.LENGTH_LONG).show();

                    }

                });
                builder.show();
            }
        });

        Button button = (Button) findViewById(R.id.LogInButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                // Get the layout inflater
                LayoutInflater inflater = getLayoutInflater();
                final LinearLayout login = (LinearLayout) inflater.inflate(R.layout.login_dialog, null);
                final EditText editTextUserId = (EditText) login.findViewById(R.id.editTextUserId);
                final EditText editTextPwd = (EditText) login.findViewById(R.id.editTextPwd);

                builder.setView(login)
                        .setTitle("Login")
                        // Add action buttons
                        .setPositiveButton("登录", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {


                                String id1 = editTextUserId.getText().toString();
                                String password = editTextPwd.getText().toString();
                                if (id1.equals("abc") && password.equals("123")) {
                                    Toast.makeText(MainActivity.this, "login successful",
                                            Toast.LENGTH_LONG).show();
                                } else {
                                    Toast.makeText(MainActivity.this, "error",
                                            Toast.LENGTH_SHORT).show();
                                    // login
                                }
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //cancel
                            }
                        });
                builder.show();
            }
        });
    }

}




