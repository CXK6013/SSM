package org.example.ioc;

import java.util.*;

/**
 * @author XingKe
 * @date 2021-02-14 11:03
 */
public class CollectionDemo {
    private List<String> list;
    private String[] arrayString;
    private Set<String> set;
    private Map<String, Object> map;
    private Properties properties;

    public CollectionDemo() {

    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public String[] getArrayString() {
        return arrayString;
    }

    public void setArrayString(String[] arrayString) {
        this.arrayString = arrayString;
    }

    public Set<String> getSet() {
        return set;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "CollectionDemo{" +
                "list=" + list +
                ", arrayString=" + Arrays.toString(arrayString) +
                ", set=" + set +
                ", map=" + map +
                ", properties=" + properties +
                '}';
    }
}
