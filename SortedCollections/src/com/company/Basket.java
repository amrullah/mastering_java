package com.company;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Basket {
    private final String name;
    private final Map<StockItem, Integer> list;

    public Basket(String name) {
        this.name = name;
        this.list = new TreeMap<>();
    }

    public  int addToBasket(StockItem item, int quantity) {
        if ((item != null) && (quantity > 0)) {
            int inBasket = list.getOrDefault(item, 0);
            list.put(item, inBasket + quantity);
            return inBasket;
        }
        return 0;
    }
    public Map<StockItem, Integer> Items() {
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder(String.format("\nShopping basket of %s, contains %s item(s)\n",
                name, list.size()));

        double totalCost = 0.0;
        s.append("---------------------------------------------------\n");
        for (Map.Entry<StockItem, Integer> item : list.entrySet()) {
            StockItem stockItem = item.getKey();
            int quantity = item.getValue();

            s.append(String.format("%s | quantity: %2s |   Value: %7.2f\n",
                    stockItem, quantity, stockItem.getPrice()*quantity));

            totalCost += item.getKey().getPrice() * item.getValue();
        }
        s.append("---------------------------------------------------\n");
        s.append(String.format("Total Cost: %38.2f$", totalCost));
        return s.toString();
    }
}
