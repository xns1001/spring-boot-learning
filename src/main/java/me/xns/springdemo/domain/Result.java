package me.xns.springdemo.domain;

/**
 * Created by xns on 2017/7/13.
 */
public class Result<T> {
    private int code;
    private String msg;
    private T data;

    public Result(){}


    public Result(ResultState state, T t) {
        code = state.code;
        msg = state.msg;
        data = t;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public enum ResultState {
        SUCCESS(0, "success"),
        UNKNOWN_ERROR(-1, "unknown fail");

        int code;
        String msg;

        ResultState(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

    }
}
