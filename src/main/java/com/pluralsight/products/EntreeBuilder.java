package com.pluralsight.products;


import com.pluralsight.constants.ConsoleColors;
import com.pluralsight.constants.PlateOptions;
import com.pluralsight.constants.Size;
import com.pluralsight.inventory.InventoryHandler;
import com.pluralsight.utility.InputHandler;

import java.util.ArrayList;
import java.util.List;

import static com.pluralsight.products.CustomPlate.*;
import static com.pluralsight.ui.HomeScreen.comingSoon;
import static com.pluralsight.ui.OrderScreen.showSizeMenu;

public class EntreeBuilder {
    public static List<Entree> featuredEntrees = new ArrayList<>();


    public static void buildFeaturedEntrees(int id, String name, String food, String food1, String food2, String description, Size size) {
        featuredEntrees.add(new Entree(id,name, InventoryHandler.getItemByName(food), InventoryHandler.getItemByName(food1),
                InventoryHandler.getItemByName(food2), InventoryHandler.addItemsTogether(InventoryHandler.getItemByName(food), InventoryHandler.getItemByName(food1),
                InventoryHandler.getItemByName(food2))
                , description,size));

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
        ,size));

        featuredEntrees.add(new Entree(2,
                "Pernil with Maduros & Coco Rico",
                InventoryHandler.getItemByName("Pernil"),
                InventoryHandler.getItemByName("Platano Maduros"),
                InventoryHandler.getItemByName("Coco Rico"),
                InventoryHandler.addItemsTogether(
                        InventoryHandler.getItemByName("Pernil"),
                        InventoryHandler.getItemByName("Platano Maduros"),
                        InventoryHandler.getItemByName("Coco Rico")
                ),
                "Slow-roasted pork shoulder with crispy skin paired with sweet fried plantains"
                ,size));

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
                ,size));



    }





}
