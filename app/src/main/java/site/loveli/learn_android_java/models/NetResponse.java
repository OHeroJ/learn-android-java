package site.loveli.learn_android_java.models;

public class NetResponse<T>{
    String message;
    int code;
    T data;

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
