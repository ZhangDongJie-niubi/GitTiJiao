package com.example.zongheti2;

import android.Manifest;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import pub.devrel.easypermissions.EasyPermissions;
import pub.devrel.easypermissions.PermissionRequest;

public class Fragmentd extends Fragment implements EasyPermissions.RationaleCallbacks,EasyPermissions.PermissionCallbacks{
    String [] strings=new String[]{
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.READ_CONTACTS,
        Manifest.permission.WRITE_CONTACTS,
        Manifest.permission.READ_SMS
    };
    private List<Phone> arr;
    private View inflate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.twlove, container, false);
        init(inflate);
        return inflate;
    }

    private void init(View inflate) {
        if (EasyPermissions.hasPermissions(getActivity(),strings)){
          con();
        }else{
            EasyPermissions.requestPermissions(
                    new PermissionRequest.Builder(getActivity(),67,strings)
                    .setRationale("请设置相关权限")
                    .setNegativeButtonText("ok")
                    .setPositiveButtonText("no")
                    .build()
            );
        }
    }

    private void con() {
        Cursor query = getActivity().getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
        arr = new ArrayList<>();
        while(query.moveToNext()){
            String name = query.getString(query.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String phone = query.getString(query.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            arr.add(new Phone(name,phone));
        }
        ListView lv = inflate.findViewById(R.id.lv);
        Shi4 shi4 = new Shi4(arr, getActivity());
        lv.setAdapter(shi4);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Phone phone = arr.get(position);
                Intent intent = new Intent();
                intent.setData(Uri.parse("tel:"+phone.getPhone()));
                intent.setAction(Intent.ACTION_DIAL);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode,permissions,grantResults,getActivity());
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
