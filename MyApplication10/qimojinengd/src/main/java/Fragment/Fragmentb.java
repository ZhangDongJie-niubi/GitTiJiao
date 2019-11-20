package Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.qimojinengd.R;

import java.util.List;

import Adpter.RecycleAdpter;
import Util.Utils;
import bean.Foods;

public class Fragmentb extends Fragment {
    private int a;
    private Foods foods;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.five, null);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        TextView tv3 = inflate.findViewById(R.id.tv3);
        Foods foods = new Foods();
        List<Foods> qurry = Utils.getutils().qurry(foods);

        tv3.setText(qurry + "");

    }
}
