package com.common.graph;

import com.alibaba.fastjson.JSONObject;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.Transaction;

import java.util.Map;

/**
 * Created by merit on 2018/2/8.
 */
public interface IGraphService {
    /**
     * 删除图谱数据
     *
     * @param removed
     * @param tx
     */
    void deleteGraphData(JSONObject removed, Transaction tx);

    /**
     * 增加图数据
     *
     * @param paramJSONObject
     * @param paramTransaction
     * @return
     */
    Map<String, Long> addGraphData(JSONObject paramJSONObject, Transaction paramTransaction);

    /***
     * 更新图数据
     *
     * @param paramJSONObject
     * @param paramTransaction
     */
    void updateGraphData(JSONObject paramJSONObject, Transaction paramTransaction);

    /**
     * 图谱增删改
     *
     * @param session
     * @param parse
     * @return
     */
    JSONObject saveGraphData(Session session, JSONObject parse);


}
