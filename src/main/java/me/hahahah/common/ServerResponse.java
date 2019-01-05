package me.hahahah.common;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;

@JsonSerialize(include = JsonSerialize. Inclusion.NON_NULL)
public class ServerResponse<T> implements Serializable {
    private int status;
    private String msg;
    private T data;

    private ServerResponse(int status) {
        this.status = status;
    }

    private ServerResponse(int status,String msg) {
        this.status = status;
        this.msg = msg;
    }

    private ServerResponse(int status,T data) {
        this.status = status;
        this.data = data;
    }

    private ServerResponse(int status,String msg,T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    @JsonIgnore
    public int getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    /**
     * 判断状态是不是成功
     * @return boolean
     */
    public boolean isSuccess() {
        return this.status == ResponseCode.SUCCESS.getCode();
    }

    public static<T> ServerResponse<T> createBySuccess() {
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode());
    }

    public static<T> ServerResponse<T> createBySuccess(String msg) {
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),msg);
    }

    public static<T> ServerResponse<T> createBySuccess(T data) {
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),data);
    }

    public static<T> ServerResponse<T> createBySuccess(String msg,T data) {
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),msg,data);
    }

    /**
     * 默认情况下使用ResponseCode.ERROR来描述错误
     * @param <T>
     * @return ERROR(1,"ERROR")
     */
    public static<T> ServerResponse<T> createByError() {
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getDesc());
    }

    /**
     * 自定义错误信息
     * @param errorMessage 自定义的错误消息
     * @param <T> String
     * @return 返回一个包含ERROR CODE和自定义错误消息的ServerResponse类
     */
    public static<T> ServerResponse<T> createByErrorMessage(String errorMessage) {
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(),errorMessage);
    }

    /**
     * 自定义错误code和错误消息的方法
     * @param errorCode 自定义的错误code
     * @param errorMessage 自定义的错误消息
     * @param <T>
     * @return 返回一个包含自定义的ERROR CODE和自定义错误消息的ServerResponse类
     */
    public static<T> ServerResponse<T> createByErrorCodeMessage(int errorCode,String errorMessage) {
        return new ServerResponse<T>(errorCode,errorMessage);
    }






}
