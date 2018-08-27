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
import java.util.List;

import cn.eternal.designmode.adapter.AdapterMode;
import cn.eternal.designmode.adapter.MyBaseAdapter;
import cn.eternal.designmode.mediator.MediatorMode;
import cn.eternal.designmode.observer.ObserverMode;
import cn.eternal.designmode.proxy.ProxyMode;
import cn.eternal.designmode.state.StateMode;
import cn.eternal.designmode.visitor.VisitMode;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private List<DesignMode> mDatas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        mDatas.add(new VisitMode());
        mDatas.add(new StateMode());
        mDatas.add(new ProxyMode());
        mDatas.add(new MediatorMode());
        mDatas.add(new AdapterMode());
        mDatas.add(new ObserverMode());

        ListView list = findViewById(R.id.list);
        DesignAdapter classifyAdapter = new DesignAdapter(mDatas);
        list.setAdapter(classifyAdapter);
        list.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        mDatas.get(i).process();
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
