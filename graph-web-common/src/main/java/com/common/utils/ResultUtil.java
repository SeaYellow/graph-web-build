package com.common.utils;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by merit on 2018/2/7.
 */
public class ResultUtil {
    /**
     * 设置成功返回结果
     *
     * @return
     */
    public static JSONObject setSuccessResult() {
        JSONObject res = new JSONObject();
        res.put(ConstantUtil.STATUS, ResponseStatus.OK.value());
        res.put(ConstantUtil.MSG, ConstantUtil.SUCCESS);
        return res;
    }


    /**
     * 设置成功返回结果
     *
     * @param res
     * @return
     */
    public static JSONObject setSuccessResult(JSONObject res) {
        res.put(ConstantUtil.STATUS, ResponseStatus.OK.value());
        res.put(ConstantUtil.MSG, ConstantUtil.SUCCESS);
        return res;
    }

    /**
     * 设置失败返回结果
     *
     * @return
     */
    public static JSONObject setFailureResult(String errorMsg) {
        JSONObject res = new JSONObject();
        res.put(ConstantUtil.STATUS, ResponseStatus.FAILURE.value());
        res.put(ConstantUtil.MSG, errorMsg);
        return res;
    }


    /**
     * 设置失败返回结果
     *
     * @param res
     * @return
     */
    public static JSONObject setFailureResult(JSONObject res, String errorMsg) {
        res.put(ConstantUtil.STATUS, ResponseStatus.FAILURE.value());
        res.put(ConstantUtil.MSG, errorMsg);
        return res;
    }
}
