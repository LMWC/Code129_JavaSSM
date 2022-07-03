package com.itheima;


import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpringApplicationContext {

    private String fileName;
    //声明beanMaps用来模拟Spring的IOC容器
    private Map<String,Object> beanMaps = new HashMap<String, Object>();

    //提供有参构造，用来在创建该对象的时候，传入所需要加载的配置文件名称
    public SpringApplicationContext(String fileName){
        this.fileName = fileName;
        parseXml();
    }

    public void parseXml(){
        try{
            //1.创建SAXReader对象
            SAXReader saxReader = new SAXReader();
            //2.根据文件名称获取文件的输入流
            InputStream in = this.getClass().getClassLoader().getResourceAsStream(fileName);
            //3.读取文件获取Document对象
            Document xmlDom = saxReader.read(in);
            //4.获取文档的根节点<beans>
            Element rootElement = xmlDom.getRootElement();
            //5.获取根节点下的所有<bean>节点
            List<Element> beanList = rootElement.elements();
            if(beanList!=null && beanList.size()>0){
                for (Element bean : beanList) {
                    //6.获取bean标签的id和class属性
                    String id = bean.attributeValue("id");
                    String className = bean.attributeValue("class");
                    //7.通过反射加载类对象
                    Class<?> clz = Class.forName(className);
                    Object obj = clz.newInstance();
                    //8.获取bean标签下的所有property标签
                    List<Element> propertyList = bean.elements();
                    if(propertyList!=null && propertyList.size()>0){
                        for (Element property : propertyList) {
                            //9.获取<property>标签的name属性
                            String name = property.attributeValue("name");
                            //10.根据name获取类中的属性值
                            Field field = clz.getDeclaredField(name);
                            field.setAccessible(true);
                            //11.获取<property>标签的value属性
                            String value = property.attributeValue("value");
                            if(value!=null && !"".equals(value)){
                                //12.为属性设置值
                                field.set(obj,value);
                            }
                        }
                    }
                    //13.将获取的bean对象存入到Map集合中
                    beanMaps.put(id,obj);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 根据beanId从Map集合中获取bean对象
     * @param beanId
     * @param <T>
     * @return
     */
    public <T>T getBean(String beanId){
        return (T)beanMaps.get(beanId);
    }
}
