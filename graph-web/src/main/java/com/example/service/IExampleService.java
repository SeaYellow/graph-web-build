package com.example.service;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by merit on 2018/2/7.
 */
public interface IExampleService {
    /**
     * 增加节点
     *
     * @return
     */
    JSONObject addNode();

    /**
     * 根据labels查询数据节点
     *
     * @param label
     * @return
     */
    JSONObject queryNodesByLabel(String label);

}
