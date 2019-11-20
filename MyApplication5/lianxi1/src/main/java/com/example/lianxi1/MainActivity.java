package com.example.lianxi1;

import android.Manifest;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import pub.devrel.easypermissions.EasyPermissions;
import pub.devrel.easypermissions.PermissionRequest;

import static android.Manifest.permission.READ_SMS;
import static android.Manifest.permission.WRITE_CONTACTS;

public class MainActivity extends AppCompatActivity implements EasyPermissions.PermissionCallbacks, EasyPermissions.RationaleCallbacks {


    String[] permission = new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.READ_CONTACTS,
            WRITE_CONTACTS,
            Manifest.permission.READ_PHONE_NUMBERS,
            READ_SMS};
    private List<Phone> arr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (EasyPermissions.hasPermissions(this, permission)) {
            con();
        } else {
            EasyPermissions.requestPermissions(
                    new PermissionRequest.Builder(this, 67, permission)
                            .setRationale("请确认相关权限！！")
                            .setPositiveButtonText("ok")
                            .setNegativeButtonText("cancal")
                            .build());
        }
    }

    private void con() {
        Cursor query = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
        arr = new ArrayList<>();
        while (query.moveToNext()) {
            String name = query.getString(query.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String phone = query.getString(query.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            arr.add(new Phone(name, phone));
        }
        ListView lv = findViewById(R.id.lv);
        Shi shi = new Shi(arr, MainActivity.this);
        lv.setAdapter(shi);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                Phone phone = arr.get(position);
                intent.setData(Uri.parse("tel:" + phone.getPhone()));
                intent.setAction(Intent.ACTION_DIAL);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);

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
