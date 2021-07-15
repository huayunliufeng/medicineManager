package com.zhong.utils;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @author 华韵流风
 */
public class BeanUtil {

    public static <T> T toBean(Map<String, String[]> map, Class<T> clazz) {
        try {
            //实例化Bean类型的对象
            T obj = clazz.newInstance();
            //得到Bean类型的所有属性
            PropertyDescriptor[] pds = Introspector.getBeanInfo(clazz).getPropertyDescriptors();
            //把map中的参数名与bean中的属性名进行匹配，如果匹配上了，就把参数值封装到bean中
            for (PropertyDescriptor pd : pds) {
                String pName = pd.getName();
                //检查map中是否有与属性名相同的key。
                if (map.containsKey(pName)) {
                    //进行数据的封装，依据属性的类型分别进行处理
                    //因为map中所有的value都是String
                    if (pd.getPropertyType() == Integer.class) {
                        //调用Bean的set方法把数据写到bean中
                        pd.getWriteMethod().invoke(obj, Integer.valueOf(map.get(pName)[0]));
                    } else if (pd.getPropertyType() == Long.class) {
                        pd.getWriteMethod().invoke(obj, Long.valueOf(map.get(pName)[0]));
                    } else if (pd.getPropertyType() == String.class) {
                        pd.getWriteMethod().invoke(obj, map.get(pName)[0].trim());
                    } else if (pd.getPropertyType() == Date.class) {
                        pd.getWriteMethod().invoke(obj, new SimpleDateFormat("yyyy-MM-dd").parse(map.get(pName)[0]));
                    } else if (pd.getPropertyType() == String[].class) {
                        pd.getWriteMethod().invoke(obj, (Object) map.get(pName));
                    } else if (pd.getPropertyType() == Double.class) {
                        pd.getWriteMethod().invoke(obj, Double.valueOf(map.get(pName)[0]));
                    }
                }
            }
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
