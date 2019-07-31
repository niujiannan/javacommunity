package cn.j2blog.javacommunity.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class Result implements Serializable {



    private static final Integer SUCCESS_STATUS = 200;
    private static final Integer ERROR_STATUS = 500;
    private Integer status;
    private String message;

    public Result() {
    }

    public Result(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public static Result success() {
        return new Result(SUCCESS_STATUS, "成功");
    }

    public static Result success(String message) {
        return new Result(SUCCESS_STATUS, message);
    }

    public static Result error() {
        return new Result(ERROR_STATUS, "失败");
    }
    public static Result error(String message) {
        return new Result(ERROR_STATUS, message);
    }

}
