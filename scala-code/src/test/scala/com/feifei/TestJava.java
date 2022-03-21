package com.feifei;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * @Description:
 * @ClassName: TestJava
 * @Author chengfei
 * @DateTime 2021/4/8 15:51
 *
 *  "sdfa"->"val"
 *       ,"sdfa"->"val2"
 *       ,"sdfa2"->"val"
 *       ,"sdfa4"->"val"
 *       ,"sdfa3"->"val"
 **/
public class TestJava {
    public static void main(String[] args) {
//        Map<String, Object> map = new Hashtable<>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("sdfa","val");
        map.put("sdfa","val2");
        map.put("sdfa2","val");
        map.put("sdfa4","val");
        map.put("sdfa3","val");

        System.out.println(map.get("sdfa"));
        System.out.println("****************");
        for(String k:map.keySet()){
            System.out.println(k);
            System.out.println(map.get(k));
        }
    }
}
