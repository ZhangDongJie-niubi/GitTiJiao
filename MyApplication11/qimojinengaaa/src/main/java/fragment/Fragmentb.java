package fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.qimojinengaaa.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import bean.He;
import service.Homeservice;

public class Fragmentb extends Fragment {

    private ProgressBar pb;
    private TextView tv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fore, container, false);
        EventBus.getDefault().register(this);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        pb = inflate.findViewById(R.id.pb);
        tv = inflate.findViewById(R.id.tv1);
        Button but = inflate.findViewById(R.id.but);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Homeservice.class);
                getActivity().startService(intent);
            }
        });

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getDate(He he) {
        long a = he.getA();
        long l = he.getL();
        pb.setProgress((int) a);
        pb.setMax((int) l);
        tv.setText(100 * a / l + "%");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        Intent intent = new Intent(getContext(), Homeservice.class);
        getActivity().stopService(intent);
    }
}
