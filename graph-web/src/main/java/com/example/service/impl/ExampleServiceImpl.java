package com.example.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.service.IExampleService;
import org.springframework.stereotype.Service;

/**
 * Created by merit on 2018/2/7.
 */
@Service
public class ExampleServiceImpl implements IExampleService {
    @Override
    public JSONObject addNode() {
        return null;
    }

    @Override
    public JSONObject queryNodesByLabel(String label) {
        return null;
    }
//    @Autowired
//    GraphDataBaseDriver graphDataBaseDriver;

//    @Override
//    public JSONObject addNode() {
//        JSONObject res = new JSONObject();
//        Session session = graphDataBaseDriver.getSession();
//        JSONObject parameter = new JSONObject();
//        JSONObject properties = new JSONObject();
//        properties.put("NAME", "节点增加测试");
//        properties.put(ConstantUtil.GRAPH_UUID, UUID.randomUUID().toString());
//        parameter.put("properties", properties);
//        String addNodeCypher = "WITH {properties} AS properties CREATE(N:ADD_EXAMPLE) SET N = properties RETURN ID(N) AS ID";
//        StatementResult result = session.run(addNodeCypher, parameter);
//        while (result.hasNext()) {
//            Record record = result.next();
//            long id = record.get("ID").asLong();
//            res.put("graphId", id);
//        }
//
//        return ResultUtil.setSuccessResult(res);
//    }
//
//    @Override
//    public JSONObject queryNodesByLabel(String label) {
//        Session session = graphDataBaseDriver.getSession();
//        String queryCql = "MATCH(N:" + label + ") RETURN N";
//        StatementResult result = session.run(queryCql);
//
//        JSONObject res = new JSONObject();
//        JSONArray nodes = new JSONArray();
//        while (result.hasNext()) {
//            Record record = result.next();
//            JSONObject node = new JSONObject();
//            Node n = record.get("N").asNode();
//            node.put("properties", n.asMap());
//            node.put("id", n.id());
//            nodes.add(node);
//        }
//        SAXReader saxReader = new SAXReader();
//        res.put("data", nodes);
//        return ResultUtil.setSuccessResult(res);
//    }
}
