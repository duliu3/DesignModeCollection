package cn.eternal.designmode;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cn.eternal.designmode.mediator.Accountant;
import cn.eternal.designmode.mediator.HR;
import cn.eternal.designmode.mediator.Mediator;
import cn.eternal.designmode.mediator.Productor;
import cn.eternal.designmode.mediator.StarManager;
import cn.eternal.designmode.state.DrunkState;
import cn.eternal.designmode.state.NormalState;
import cn.eternal.designmode.state.QiaoFeng;
import cn.eternal.designmode.visitor.CEO;
import cn.eternal.designmode.visitor.CTO;
import cn.eternal.designmode.visitor.Engineer;
import cn.eternal.designmode.visitor.Manager;
import cn.eternal.designmode.visitor.Staff;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private List<String> mDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        String[] arrays = {"访问者模式", "模板模式", "装饰者模式","状态模式","中介者模式"};
        mDatas = Arrays.asList(arrays);
        ListView list = findViewById(R.id.list);
        ClassifyAdapter classifyAdapter = new ClassifyAdapter();
        list.setAdapter(classifyAdapter);
        list.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String s = mDatas.get(i);
        switch (s) {
            case "访问者模式":
                visit();
                break;
            case "模板模式":

                break;
            case "中介者模式":
                mediator();
                break;
            case "装饰者模式":
                break;
            case "状态模式":
                stateMode();
                break;

            default:
                break;
        }
    }

    private void mediator() {
        Mediator manager = new StarManager();
        manager.setAccountant(new Accountant(manager));
        manager.setHR(new HR(manager));
        manager.setProductor(new Productor(manager));

        manager.manage();
    }

    private void stateMode() {
        QiaoFeng qiaoFeng = new QiaoFeng();
        qiaoFeng.setState(new NormalState());
        System.out.println("---乔峰进入普通状态---");
        qiaoFeng.daGou();
        qiaoFeng.xiangLong();

        qiaoFeng.setState(new DrunkState());
        System.out.println("---乔峰进入醉酒状态---");
        qiaoFeng.daGou();
        qiaoFeng.xiangLong();
    }

    /**
     * 适用元素结构相对稳定
     */
    private void visit() {

        Engineer engineer = new Engineer();
        engineer.name = "小红";
        engineer.salary = "薪水 10000";
        engineer.skill = "制造火箭";

        Engineer engineer2 = new Engineer();
        engineer2.name = "小明";
        engineer2.salary = "薪水 15000";
        engineer2.skill = "制造原子弹";

        Manager manager = new Manager();
        manager.name = "大王";
        manager.demand = "扩招人手";
        manager.progress = "项目进度：30%";

        Manager manager2 = new Manager();
        manager2.name = "二王";
        manager2.demand = "团建";
        manager2.progress = "项目进度：60%";

        ArrayList<Staff> staffs = new ArrayList<>();
        staffs.add(engineer);
        staffs.add(engineer2);
        staffs.add(manager);
        staffs.add(manager2);

        System.out.println("————————CEO 视察员工————————");
        for (int i=0;i<staffs.size();i++) {
            Staff staff = staffs.get(i);
            staff.accept(new CEO());
        }

        System.out.println("————————CTO 视察员工————————");
        for (int i=0;i<staffs.size();i++) {
            Staff staff = staffs.get(i);
            staff.accept(new CTO());
        }

    }

    public class ClassifyAdapter
            extends BaseAdapter

    {
        @Override
        public int getCount() {
            if (mDatas != null) {
                return mDatas.size();
            }
            return 0;
        }

        @Override
        public Object getItem(int position) {
            if (mDatas != null) {
                return mDatas.get(position);
            }
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView == null) {
                convertView = View.inflate(MainActivity.this, R.layout.item_mode, null);
                holder = new ViewHolder();
                convertView.setTag(holder);
                //findviewbyid
                holder.tvTitle = (TextView) convertView.findViewById(R.id.item_tv);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            //设置数据
            holder.tvTitle.setText(mDatas.get(position));
            return convertView;
        }
    }

    private static class ViewHolder {
        TextView tvTitle;
    }

}
