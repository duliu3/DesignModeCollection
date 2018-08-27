package cn.eternal.designmode.MementoMode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liudu
 * @version 1.0a
 * <p><strong>Features draft description.主要功能介绍</strong></p>
 * @since 2018/8/27 19:21
 */
public class SaveManager {

    public Map<String, ISave> getSaves() {
        return mSaves;
    }

    public Map<String, ISave> mSaves = new HashMap<>();

    public void addSave(String name, ISave save) {
        mSaves.put(name, save);
    }

    public ISave getSave(String name) {
       return mSaves.get(name);
    }

}
