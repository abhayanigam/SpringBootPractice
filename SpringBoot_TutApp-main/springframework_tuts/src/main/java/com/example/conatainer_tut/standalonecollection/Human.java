package com.example.conatainer_tut.standalonecollection;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Human {
    private List<String> friends;
    private Map<String,Integer> feestructure;
    private Properties properties;

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Map<String, Integer> getFeestructure() {
        return feestructure;
    }

    public void setFeestructure(Map<String, Integer> feestructure) {
        this.feestructure = feestructure;
    }

    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }

    @Override
    public String toString() {
        return "Human{" +
                "friends=" + friends +
                ", feestructure=" + feestructure +
                ", properties=" + properties +
                '}';
    }
}
