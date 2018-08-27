package cn.eternal.designmode.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;


public abstract class MyBaseAdapter<T> extends BaseAdapter {

    protected List<T> mList;


    public MyBaseAdapter(List<T> list) {
        this.mList = list;
    }

    /**
     * 设置数据
     * @param list
     */
    public void setData(List<T> list) {
        if (mList != null) {
            mList.clear();
        }

        mList = list;
        notifyDataSetChanged();
    }

    /**
     * 绑定View
     * @param holder
     * @param position
     */
    protected abstract void bindView(ViewHolder holder, int position);

    /**
     * 创建View
     * @param parent
     * @param position
     * @return
     */
    protected abstract View createView(View parent, int position);

    @Override
    public final int getCount() {
        return mList != null ? mList.size() : 0;
    }

    @Override
    public final T getItem(int position) {
        return mList.get(position);
    }

    @Override
    public final long getItemId(int position) {
        return position;
    }

    @Override
    public final View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = createView(parent, position);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        bindView(holder, position);

        return convertView;
    }

    public List<T> getData() {
        return mList;
    }

}
