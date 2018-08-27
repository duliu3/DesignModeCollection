package cn.eternal.designmode.adapter;

import android.util.SparseArray;
import android.view.View;

/**
 * Created by Administrator on 2018/1/30.
 */

public final class ViewHolder {

    private View parent;

    SparseArray<View> sparseArray = new SparseArray<>();

    public View getRootView(){
        return parent;
    }

    ViewHolder(View parent) {
        this.parent = parent;
    }

    public <T extends View> T findByIdView(int id) {
        View child = sparseArray.get(id);
        if (child == null) {
            child = parent.findViewById(id);
            sparseArray.put(id, child);
        }

        return (T)child;
    }
}
