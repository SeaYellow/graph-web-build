//package com.handler.controller;
//
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//import com.common.utils.Util;
//import org.neo4j.driver.v1.*;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Map;
//
///**
// * Created by merit on 2018/2/8.
// */
//@RestController
//public class GraphNetworkRestController {
//    private Logger logger = LoggerFactory.getLogger(getClass());
//
//
//    public JSONObject saveGraphData(Session session, JSONObject parse) {
//        JSONObject resJson = new JSONObject();
//        try {
//            Transaction tx = session.beginTransaction();
//            Throwable localThrowable3 = null;
//            try {
//                logger.info("Parse Json : " + parse);
//
//                JSONObject removed = parse.getJSONObject("removed");
//
//                JSONArray rNodes = removed.getJSONArray("nodes");
//                if ((rNodes != null) && (rNodes.size() > 0)) {
//                    deleteGraphNodesData(rNodes, tx);
//                }
//                JSONArray rLinks = removed.getJSONArray("links");
//                if ((rLinks != null) && (rLinks.size() > 0)) {
//                    deleteGraphEdgesData(rLinks, tx);
//                }
//
//                JSONObject added = parse.getJSONObject("added");
//                Map addGraphData = addGraphData(added, tx);
//
//                JSONObject updated = parse.getJSONObject("updated");
//                updateGraphData(updated, tx);
//
//                tx.success();
//
//                resJson.put("data", addGraphData);
//                Util.setSuccessResult(resJson);
//            } catch (Throwable localThrowable1) {
//                localThrowable3 = localThrowable1;
//                throw localThrowable1;
//            } finally {
//                if (tx != null) if (localThrowable3 != null) try {
//                    tx.close();
//                } catch (Throwable localThrowable2) {
//                    localThrowable3.addSuppressed(localThrowable2);
//                }
//                else tx.close();
//            }
//        } catch (Exception e) {
//            this.logger.error("saveGraphData exception : ", e);
//            Util.setFailResult(resJson, e.getMessage());
//        }
//        return resJson;
//    }
//
//    /**
//     * 删除节点
//     *
//     * @param nodes
//     * @param tx
//     */
//    public void deleteGraphNodesData(JSONArray nodes, Transaction tx) {
//        JSONObject parameter = new JSONObject();
//        parameter.put("nodes", getIdsData(nodes));
//
//        String delEdgesCql = "WITH {nodes} AS nodes UNWIND nodes AS node MATCH(N)-[R]-() WHERE ID(N) = toInteger(node.id) DELETE R";
//
//        tx.run(delEdgesCql, parameter);
//
//        String delNodesCql = "WITH {nodes} AS nodes UNWIND nodes AS node MATCH(N) WHERE ID(N) = toInteger(node.id) DELETE N";
//        tx.run(delNodesCql, parameter);
//    }
//
//    public void deleteGraphEdgesData(JSONArray links, Transaction tx) {
//        JSONObject parameter = new JSONObject();
//        parameter.put("links", getIdsData(links));
//
//        String delRelCql = "WITH {links} AS links UNWIND links AS link MATCH()-[R]-() WHERE ID(R) = toInteger(link.id) DELETE R";
//        this.logger.info("CQL : " + delRelCql);
//
//        tx.run(delRelCql, parameter);
//    }
//
//    private JSONArray getIdsData(JSONArray nodes) {
//        Iterator iterator = nodes.iterator();
//        JSONArray idArray = new JSONArray();
//        while (iterator.hasNext()) {
//            JSONObject jsonObject = new JSONObject();
//            Object next = iterator.next();
//            jsonObject.put("id", next.toString());
//            idArray.add(jsonObject);
//        }
//        return idArray;
//    }
//
//    public Map<String, Long> addGraphData(JSONObject added, Transaction tx) {
//        Map idUuidMap = new HashMap();
//
//        JSONArray nodes = added.getJSONArray("nodes");
//        Iterator iterator = nodes.iterator();
//
//        Map<String, JSONArray> nodeLabelMap = new HashMap();
//        JSONObject node;
//        while (iterator.hasNext()) {
//            node = (JSONObject) iterator.next();
//            String className = node.getString("className");
//            JSONObject data = node.getJSONObject("data");
//            data.put("GRAPH_UUID", node.getString("id"));
//            node.put("data", data);
//            if (":".equals(className)) {
//                throw new RuntimeException("ClassName properties is empty.");
//            }
//
//            setLabelMap(nodeLabelMap, node, className);
//        }
//
//        for (Map.Entry<String, JSONArray> entry : nodeLabelMap.entrySet()) {
//            String className = (String) entry.getKey();
//            JSONArray nodeArray = (JSONArray) entry.getValue();
//            Map parameter = new HashMap();
//            parameter.put("nodes", nodeArray);
//            String addNodeCql = "WITH {nodes} AS nodes UNWIND nodes AS node CREATE(N" + className + ") SET N = node.data RETURN ID(N) AS ID,N." + "GRAPH_UUID" + " AS UUID";
//            StatementResult statementResult = tx.run(addNodeCql, parameter);
//            setReturnMap(idUuidMap, statementResult);
//        }
//
//        Map<String, JSONArray> linkLabelMap = new HashMap();
//        JSONArray links = added.getJSONArray("links");
//        Iterator linkIterator = links.iterator();
//        JSONObject link;
//        while (linkIterator.hasNext()) {
//            link = (JSONObject) linkIterator.next();
//            JSONObject data = link.getJSONObject("data");
//            data.put("GRAPH_UUID", link.getString("id"));
//            link.put("data", data);
//
//            String from = link.getString("from");
//            String to = link.getString("to");
//            if (idUuidMap.get(from) == null)
//                link.put("from", Long.valueOf(Long.parseLong(from)));
//            else {
//                link.put("from", idUuidMap.get(from));
//            }
//            if (idUuidMap.get(to) == null)
//                link.put("to", Long.valueOf(Long.parseLong(to)));
//            else {
//                link.put("to", idUuidMap.get(to));
//            }
//
//            String className = link.getString("className");
//            if (Util.isEmpty(className)) {
//                throw new RuntimeException("className properties is empty.");
//            }
//
//            setLabelMap(linkLabelMap, link, className);
//        }
//
//        for (Map.Entry<String, JSONArray> entry : linkLabelMap.entrySet()) {
//            String className = (String) entry.getKey();
//            JSONArray linkArray = (JSONArray) entry.getValue();
//            Map parameter = new HashMap();
//            parameter.put("links", linkArray);
//            String addLinkCql = "WITH {links} AS links UNWIND links AS link MATCH(S),(E) WHERE ID(S) = link.from AND ID(E) = link.to CREATE(S)-[R" + className + "]->(E) SET R = link.data RETURN ID(R) AS ID,R." + "GRAPH_UUID" + " AS UUID";
//            StatementResult statementResult = tx.run(addLinkCql, parameter);
//            setReturnMap(idUuidMap, statementResult);
//        }
//        return idUuidMap;
//    }
//
//    private void setReturnMap(Map<String, Long> idUuidMap, StatementResult statementResult) {
//        while (statementResult.hasNext()) {
//            Record record = statementResult.next();
//
//            Value id = record.get("ID");
//            Value uuId = record.get("UUID");
//
//            idUuidMap.put(uuId.asString(), Long.valueOf(id.asLong()));
//        }
//    }
//
//    private void setLabelMap(Map<String, JSONArray> labelMap, JSONObject data, String className) {
//        if (labelMap.get(className) == null) {
//            JSONArray array = new JSONArray();
//            array.add(data);
//            labelMap.put(className, array);
//        } else {
//            ((JSONArray) labelMap.get(className)).add(data);
//        }
//    }
//
//    public void updateGraphData(JSONObject updated, Transaction tx) {
//        HashMap nodeParameter = new HashMap();
//
//        JSONArray nodes = updated.getJSONArray("nodes");
//
//        if (nodes.size() != 0) {
//            nodeParameter.put("nodes", nodes);
//            String updateNodeCql = "WITH {nodes} AS nodes UNWIND nodes AS node MATCH(N) WHERE ID(N) = toInteger(node.id) SET N = node.data";
//            tx.run(updateNodeCql, nodeParameter);
//        }
//
//        HashMap linkParameter = new HashMap();
//        JSONArray links = updated.getJSONArray("links");
//
//        if (links.size() != 0) {
//            linkParameter.put("links", links);
//            String updateLinkCql = "WITH {links} AS links UNWIND links AS link MATCH()-[R]-() WHERE ID(R) = toInteger(link.id) SET R = link.data";
//            tx.run(updateLinkCql, linkParameter);
//        }
//    }
//
//}
