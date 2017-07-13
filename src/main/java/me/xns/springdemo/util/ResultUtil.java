package me.xns.springdemo.util;

import me.xns.springdemo.domain.Result;

/**
 * Created by xns on 2017/7/13.
 */
public class ResultUtil {

    public static <T> Result<T> success(T t) {
        Result<T> result = new Result<T>(Result.ResultState.SUCCESS, t);
        return result;
    }

    public static Result error(String msg, int errorCode) {
        Result result = new Result();
        result.setCode(errorCode);
        result.setMsg(msg);
        return result;
    }

}
