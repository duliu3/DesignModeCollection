/**
 * Copyright(c) 2014 ShenZhen Gowild Intelligent Technology Co., Ltd.
 * All rights reserved.
 * Created on  2014-2-24  下午3:39:44
 */
package cn.eternal.designmode.flyweight;


import android.util.Log;

import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;

public final class TcpMessage {
    private static final String TAG = TcpMessage.class.getSimpleName();
    /**
     * 包括：协议体的头部，协议长度 ,协议号,playerId
     */
    public static final short HEAD_SIZE = 7;

    /**
     * 包的标识 32766
     */
    public static final short HEADER = 0x7ffe;
    private static final int QUENEMAXSIZE = 20;

    /**
     * 类型
     */
    private static final byte TYPE = 1;

    private static AtomicInteger sQueneSize = new AtomicInteger(0);

    /**
     * 协议号
     */
    private short code;

    /**
     * 包体数据
     */
    private byte[] bodyData = null;

    /**
     * 超时时间
     */
    //    public long timeoutTime;

    public boolean ignoreTimeout;

    /**
     * 响应码
     */
    short respCode;


    public long time;

    public String desc;

    private static TcpMessage front;
    private static TcpMessage rear;

    private TcpMessage next;

    public TcpMessage(short code, short respCode) {
        this(code);
        this.respCode = respCode;
    }

    public byte[] convertToByteArray() {
        return null;
    }

    public static TcpMessage byteArrayConvertToMessage(byte[] data) {
        return null;
    }

    private final static Object lock = new Object();

    private TcpMessage() {
        time = System.currentTimeMillis();
    }

    /**
     * 私有构造方法，只能build中使用
     */
    private TcpMessage(short code) {
        this.code = code;
        time = System.currentTimeMillis();
    }


    /**
     * 将一个消息清空后追加到队列的尾部
     */
    public static void recycle(TcpMessage msg) {
        synchronized (lock) {
            Log.d(TAG, "回收消息后消息池数量："+ sQueneSize);
            if (sQueneSize.get() > QUENEMAXSIZE) {
                Log.d(TAG, "recycle MAXSIZE");
                sQueneSize.set(sQueneSize.get() - 1);
                return;
            }
            //如果队列是空的不添加
            if (rear == null) {
                Log.d(TAG, "recycle NULL");
               return;
            } else {
                msg.code = -1;
                msg.bodyData = null;
                msg.respCode = -1;
                msg.next = null;
                rear.next = msg;
                rear = msg;
            }
        }
    }




    /**
     * 从队列中取出消息
     *
     * @param code 协议号
     */
    public static TcpMessage obtain(final short code) {
        synchronized (lock) {
            if (front == null) {
                System.out.println("创建并返回消息 " + code);
                front = new TcpMessage(code);
                rear = new TcpMessage(code);
                front.next = rear;
                sQueneSize.set(sQueneSize.get() + 1);
                return front;
            }


            final TcpMessage msg = front;
            msg.code = code;
            if (front.next == null) {
                System.out.println("创建消息 " + code);
                rear = new TcpMessage(code);
                front.next = rear;
                sQueneSize.set(sQueneSize.get() + 1);
            }
            front = front.next;
            System.out.println("使用缓存消息" + code + " 消息池数量" + sQueneSize);
            return msg;
        }
    }



    /**
     * 由字节构建包体
     *
     * @param dataBytes 这个数组中，第一个short是整个包的长度，第二个short是协议编号
     * @return
     */
    public static TcpMessage parse(final byte[] dataBytes) {

        if (dataBytes.length < HEAD_SIZE) {
            return null;
        }
        TcpMessage msg = new TcpMessage();
        ByteBuffer byteBuffer = ByteBuffer.wrap(dataBytes);
        byteBuffer.position(4);//跳过包头标识和包长度
        msg.code = byteBuffer.getShort();
        byteBuffer.get();//跳过包类型标识

        if (dataBytes.length - HEAD_SIZE > 0) { // 如果包含包体就读取出来
            msg.bodyData = new byte[dataBytes.length - HEAD_SIZE];
            byteBuffer.get(msg.bodyData);
        }
        return msg;
    }

    /**
     * 数据包转换为ByteBuffer，包括包头和包体。
     *
     * @return
     */
    public ByteBuffer toByteBuffer() {
        short len = TcpMessage.HEAD_SIZE;
        if (this.bodyData != null) {
            len += (short) this.bodyData.length;
        }
        if (len <= 0) {
            throw new IllegalArgumentException(String.format(
                    "发送协议号为[%d]的包,长度小于等于0[%d]，长度=包头长度[10]+body长度[%d]",
                    this.code, len, (short) this.bodyData.length));
        }
        ByteBuffer buff = ByteBuffer.allocate(len);
        // 插入包头
        buff.putShort(TcpMessage.HEADER);
        // 插入长度
        buff.putShort(len);
        // 协议码
        buff.putShort(code);
        // 类型
        buff.put(TYPE);

        if (bodyData != null) {
            buff.put(bodyData);
        }
        buff.flip();
        return buff;
    }


    /**
     * 获取包体，包体允许为null。
     *
     * @return
     */
    public byte[] getBody() {
        return bodyData;
    }

    /**
     * 设置包体，包体允许为null。
     *
     * @param bytes
     */
    public TcpMessage setBody(final byte[] bytes) {
        this.bodyData = bytes;
        return this;
    }

    /**
     * @return the code
     */
    public short getCode() {
        return code;
    }

    /**
     * @return
     */
    public int getBodyLength() {
        if (bodyData != null) {
            return bodyData.length;
        }
        return 0;
    }


    public short getRespCode() {
        return respCode;
    }
}
