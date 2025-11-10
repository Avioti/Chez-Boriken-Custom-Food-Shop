package com.pluralsight.products;

import com.pluralsight.inventory.Food;
import com.pluralsight.inventory.InventoryHandler;

import java.util.ArrayList;
import java.util.List;

public class EntreeBuilder {
    public static List<Entree> featuredEntrees = new ArrayList<>();


    public static void buildFeaturedEntrees(int id,String name, String food, String food1, String food2, String description) {
        featuredEntrees.add(new Entree(id,name, InventoryHandler.getItemByName(food), InventoryHandler.getItemByName(food1),
                InventoryHandler.getItemByName(food2), InventoryHandler.addItemsTogether(InventoryHandler.getItemByName(food), InventoryHandler.getItemByName(food1),
                InventoryHandler.getItemByName(food2))
                , description));

    }

    public static void defaultEntrees() {
        featuredEntrees.add(new Entree(1,
                "Pollo Guisado with Tostones & Malta",
                InventoryHandler.getItemByName("Pollo Guisado"),
                InventoryHandler.getItemByName("Tostones"),
                InventoryHandler.getItemByName("Malta"),
                InventoryHandler.addItemsTogether(
                        InventoryHandler.getItemByName("Pollo Guisado"),
                        InventoryHandler.getItemByName("Tostones"),
                        InventoryHandler.getItemByName("Malta")
                ),
                "Puerto Rican stewed chicken with peppers and onions served with crispy fried green plantains"
        ));

        featuredEntrees.add(new Entree(2,
                "Pernil with Maduros & Coco Rico",
                InventoryHandler.getItemByName("Pernil"),
                InventoryHandler.getItemByName("Maduros"),
                InventoryHandler.getItemByName("Coco Rico"),
                InventoryHandler.addItemsTogether(
                        InventoryHandler.getItemByName("Pernil"),
                        InventoryHandler.getItemByName("Maduros"),
                        InventoryHandler.getItemByName("Coco Rico")
                ),
                "Slow-roasted pork shoulder with crispy skin paired with sweet fried plantains"
        ));

        featuredEntrees.add(new Entree(3,
                "Griyo with Yuca Frita & Passion Fruit Juice",
                InventoryHandler.getItemByName("Griyo"),
                InventoryHandler.getItemByName("Yuca Frita"),
                InventoryHandler.getItemByName("Passion Fruit Juice"),
                InventoryHandler.addItemsTogether(
                        InventoryHandler.getItemByName("Griyo"),
                        InventoryHandler.getItemByName("Yuca Frita"),
                        InventoryHandler.getItemByName("Passion Fruit Juice")
                ),
                "Haitian fried marinated pork with citrus and spice served with crispy cassava root"
        ));



    }

}
