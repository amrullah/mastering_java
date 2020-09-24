package com.company;

public class Main {
    private static StockList stockList = new StockList();

    public static void main(String[] args) {
        procureStock();
        System.out.println(stockList);

        Basket myBasket = new Basket("Amrullah");
        sellItem(myBasket, "Car", 1);
        sellItem(myBasket, "Car", 1);
        sellItem(myBasket, "knife", 1);
        sellItem(myBasket, "Cup", 12);
        sellItem(myBasket, "Juice", 4);
        sellItem(myBasket, "Bread", 1);

        System.out.println(myBasket);

    }

    public static int sellItem(Basket basket, String item, int quantity) {
        // retrieve the item from stock list
        StockItem stockItem = stockList.get(item);
        if (stockItem == null) {
            System.out.printf("We don't sell %s\n", item);
            return 0;
        }
        if (stockList.sellStock(item, quantity) != 0) {
            basket.addToBasket(stockItem, quantity);
            return quantity;
        }
        return 0;
    }
    private static void procureStock() {
        stockList.addStock(new StockItem("Bread", 0.86, 100));
        stockList.addStock(new StockItem("Cake", 1.10, 7));
        stockList.addStock(new StockItem("Car", 120.10, 2));
        stockList.addStock(new StockItem("Chair", 62.0, 10));
        stockList.addStock(new StockItem("Cup", 0.5, 200));
        stockList.addStock(new StockItem("Door", 72.95, 4));
        stockList.addStock(new StockItem("Juice", 2.5, 36));
        stockList.addStock(new StockItem("Phone", 96.99, 35));
        stockList.addStock(new StockItem("Towel", 2.4, 80));
        stockList.addStock(new StockItem("Vase", 8.76, 7));
    }
}
