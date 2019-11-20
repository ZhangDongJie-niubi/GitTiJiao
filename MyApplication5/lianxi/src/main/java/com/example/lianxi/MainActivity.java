package com.example.lianxi;

import android.Manifest;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.provider.Telephony;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import pub.devrel.easypermissions.EasyPermissions;
import pub.devrel.easypermissions.PermissionRequest;

import static android.Manifest.permission.READ_SMS;
import static android.Manifest.permission.WRITE_CONTACTS;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, EasyPermissions.PermissionCallbacks, EasyPermissions.RationaleCallbacks {
    private TextView tv;
    private Button tong;
    private Button duan;
    private Button tu;
    private Button shi;
    private Button yin;
    private Button da;
    String[] permission = new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.READ_CONTACTS,
            WRITE_CONTACTS,
            Manifest.permission.READ_PHONE_NUMBERS,
            READ_SMS};
    private int REQUEST_CODE = 67;
    private List<Phone> arr;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (EasyPermissions.hasPermissions(this, permission)) {
            con();
        } else {
            EasyPermissions.requestPermissions(
                    new PermissionRequest.Builder(this, REQUEST_CODE, permission)
                            .setRationale("请确认相关权限！！")
                            .setPositiveButtonText("ok")
                            .setNegativeButtonText("cancal")
                            .build());
        }
    }

    private void con() {
        da = findViewById(R.id.da);
        da.setOnClickListener(this);
        tong = findViewById(R.id.tong);
        tong.setOnClickListener(this);
        duan = findViewById(R.id.duan);
        duan.setOnClickListener(this);
        tu = findViewById(R.id.tu);
        tu.setOnClickListener(this);
        shi = findViewById(R.id.shi);
        shi.setOnClickListener(this);
        yin = findViewById(R.id.yin);
        yin.setOnClickListener(this);
        tv = findViewById(R.id.tv);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.da:
                Cursor query5 = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null,null);
                arr = new ArrayList<>();
                while(query5.moveToNext()){
                    String name = query5.getString(query5.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                    String phone = query5.getString(query5.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                    arr.add(new Phone(name,phone));
                }
                ListView lv = findViewById(R.id.lv);
                Shi shi = new Shi(arr,MainActivity.this);
                lv.setAdapter(shi);
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent();
                        Phone phone = arr.get(position);
                        intent.setData(Uri.parse("tel:"+phone.getPhone()));
                        intent.setAction(Intent.ACTION_CHOOSER);
                        startActivity(intent);
                    }
                });
                break;
            case R.id.tong:
                Cursor query = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
                StringBuilder stringBuilder7 = new StringBuilder();
                while (query.moveToNext()) {
                    String name = query.getString(query.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                    String phoneNumber = query.getString(query.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                    stringBuilder7.append(name + "--" + phoneNumber);
                }
                tv.setText(stringBuilder7.toString());
                break;
            case R.id.duan:
                Cursor query1 = getContentResolver().query(Telephony.Sms.CONTENT_URI, null, null, null, null);
                StringBuilder stringBuilder = new StringBuilder();
                while (query1.moveToNext()) {


                    String address = query1.getString(query1.getColumnIndex(Telephony.Sms.ADDRESS));
                    String content = query1.getString(query1.getColumnIndex(Telephony.Sms.BODY));

                    // 添加内容
                    stringBuilder.append(address + "==" + content + "\n");
                }
                tv.setText(stringBuilder);
                break;
            case R.id.tu:
                Cursor query4 = getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, null, null, null);

                StringBuilder stringBuilder3 = new StringBuilder();
                while (query4.moveToNext()) {

                    String name = query4.getString(query4.getColumnIndex(MediaStore.Images.Media.DISPLAY_NAME));
                    String data = query4.getString(query4.getColumnIndex(MediaStore.Images.Media.DATA));

                    stringBuilder3.append(name + "==" + data + "\n");

                }

                tv.setText(stringBuilder3.toString());
                break;
            case R.id.shi:
                Cursor query2 = getContentResolver().query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, null, null, null, null);
                StringBuilder stringBuilder1 = new StringBuilder();
                while (query2.moveToNext()) {

                    String path = query2.getString(query2.getColumnIndex(MediaStore.Video.Media.DATA));

                    stringBuilder1.append(path + "\n");
                }

                tv.setText(stringBuilder1);
                break;
            case R.id.yin:
                Cursor query3 = getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null, null, null, null);

                StringBuilder stringBuilder2 = new StringBuilder();
                while (query3.moveToNext()) {

                    // 获取音频文件的路径
                    String path = query3.getString(query3.getColumnIndex(MediaStore.Audio.Media.DATA));

                    stringBuilder2.append(path + "\n");
                }

                tv.setText(stringBuilder2.toString());
                break;
        }
    }

    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {
        con();
    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {

    }

    @Override
    public void onRationaleAccepted(int requestCode) {
            con();
    }

    @Override
    public void onRationaleDenied(int requestCode) {

    }
}