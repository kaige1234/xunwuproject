package com.example.demo.base;

/**
 * @ClassName ApiResponse
 * @Description TODD
 * @Author Administrator
 * @Date 2018/10/30 0030 下午 4:19
 * @Version 1.0
 **/
public class ApiResponse {
    private int code;
    private String message;
    private Object data;
    private boolean more;

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isMore() {
        return more;
    }

    public void setMore(boolean more) {
        this.more = more;
    }


    public ApiResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ApiResponse() {
        this.code = Status.SUCCESS.getCode();
        this.message = Status.SUCCESS.getMessage();
    }

    public static ApiResponse ofMessage(){
        return new  ApiResponse(200,"成功了");
    }


    public enum Status{
        SUCCESS(200,"OK");

        Status(int code, String message) {
            this.code = code;
            this.message = message;
        }

        private int code;
        private String message;

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
}
