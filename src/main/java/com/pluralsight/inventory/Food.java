package com.pluralsight.inventory;

public abstract class Food {
    int quantity;
    public String itemName;
    String category,description;
    double basePrice;

    public Food(int quantity, String category,String itemName,String description, double basePrice) {
        this.basePrice = basePrice;
        this.category = category;
        this.itemName = itemName;
        this.quantity = quantity;
        this.description=description;
    }

    public boolean isAvailable(){
        return quantity > 0;
    }

    public double getBasePrice(){
        return basePrice;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public void reduceQuantity(int amount){
        quantity-=amount;
    }

    public void increaseQuantity(int amount){
        quantity+=amount;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Food{" +
                "quantity=" + quantity +
                ", itemName='" + itemName + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", basePrice=" + basePrice +
                '}';
    }
}
