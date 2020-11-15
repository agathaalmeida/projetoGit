package br.org.project.personal.models;

public class Item {
    private String name;
    private String description;
    private int quantity;
    private boolean isBorrowed;
    private User owner;

    public Item() {}
    
    public Item(String name, String description, int quantity, boolean isBorrowed) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.isBorrowed = isBorrowed;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean isBorrowed) {
        this.isBorrowed = isBorrowed;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

}
