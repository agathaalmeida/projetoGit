package br.org.project.personal.models;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String password;
    private String realName;
    private List<Item> myItems = new ArrayList<Item>();

    public User() {}

    public User(String name, String password, String realName) {
        this.name = name;
        this.password = password;
        this.realName = realName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public List<Item> getMyItems() {
        return myItems;
    }

    public void setMyItems(List<Item> myItems) {
        this.myItems = myItems;
    }
    
    public void addItem(Item item) {
        if(this.myItems.contains(item)) return;
        this.myItems.add(item);
        item.setOwner(this);
    }

}
