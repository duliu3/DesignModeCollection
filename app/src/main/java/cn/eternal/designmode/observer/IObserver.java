package cn.eternal.designmode.observer;

public interface IObserver {

    /**
     * 接收服务端返回的数据
     * @param response 服务端响应数据
     * @param code 请求协议号
     */
    void receiveResponse(int code, String response);

}
