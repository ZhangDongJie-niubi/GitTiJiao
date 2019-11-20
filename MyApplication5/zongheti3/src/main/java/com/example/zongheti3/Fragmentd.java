package com.example.zongheti3;

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

public class Fragmentd extends Fragment implements EasyPermissions.PermissionCallbacks, EasyPermissions.RationaleCallbacks {
    private View inflate;
    String[] strings = new String[]{
            Manifest.permission.WRITE_CONTACTS,
            Manifest.permission.READ_SMS,
            Manifest.permission.READ_CONTACTS,
            Manifest.permission.READ_EXTERNAL_STORAGE
    };
    private List<Phone> arr;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.shiyi, null);
        init(inflate);
        return inflate;
    }

    private void init(View inflate) {
        if (EasyPermissions.hasPermissions(getActivity(), strings)) {
            con();
        }
    }

    private void con() {
        Cursor query = getActivity().getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
        arr = new ArrayList<>();
        while (query.moveToNext()) {
            String string = query.getString(query.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String string1 = query.getString(query.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            arr.add(new Phone(string, string1));
        }
        ListView lv = inflate.findViewById(R.id.lv);
        Shi4 shi4 = new Shi4(arr,getActivity());
        lv.setAdapter(shi4);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Phone phone = arr.get(position);
                Intent intent = new Intent();
                intent.setData(Uri.parse("tel:" + phone));
                intent.setAction(Intent.ACTION_DIAL);
                startActivity(intent);
            }
        });
    }


    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {

    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {

    }

    @Override
    public void onRationaleAccepted(int requestCode) {

    }

    @Override
    public void onRationaleDenied(int requestCode) {

    }
}
