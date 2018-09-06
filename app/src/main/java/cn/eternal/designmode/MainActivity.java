package cn.eternal.designmode;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import cn.eternal.designmode.adapter.MyBaseAdapter;
import cn.eternal.libannotation.AnnotationProvider;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private List<DesignMode> mDatas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        HashSet<DesignMode> designs = new HashSet<>();
        AnnotationProvider.getDesigns(designs);
        for (DesignMode design : designs) {
            mDatas.add(design);
        }

        ListView list = findViewById(R.id.list);
        DesignAdapter classifyAdapter = new DesignAdapter(mDatas);
        list.setAdapter(classifyAdapter);
        list.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        try {
            mDatas.get(i).process();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public class DesignAdapter
            extends MyBaseAdapter<DesignMode> {

        public DesignAdapter(List<DesignMode> list) {
            super(list);
        }

        @Override
        protected void bindView(cn.eternal.designmode.adapter.ViewHolder holder, int position) {
            TextView tv = holder.findByIdView(R.id.item_tv);
            tv.setText(mDatas.get(position).getName());
        }

        @Override
        protected View createView(View parent, int position) {
            return View.inflate(MainActivity.this, R.layout.item_mode, null);
        }
    }

}
