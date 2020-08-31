package com.company;
import java.util.ArrayList;

public class GroceryList {
    private final ArrayList<String> groceryList = new ArrayList<>();

    public void addGroceryItem(String item) {
        groceryList.add(item);
    }

    public ArrayList<String> getGroceryList() {
        return groceryList;
    }

    public void printGroceryList() {
        System.out.printf("You have %1$s items in your grocery list\n", groceryList.size());
        for (int i=0; i < groceryList.size(); i++) {
            System.out.printf("%1$s. %2$s\n", i+1, groceryList.get(i));
        }
    }

    public void modifyGroceryItem(String currentItem, String newItem) {
        int position = findItem(currentItem);
        if (position >= 0) {
            modifyGroceryItem(position, newItem);
        }
    }
    public void removeGroceryItem(String item) {
        int position = findItem(item);
        if (position > 0) {
            removeGroceryItem(position);
        }
    }

    public boolean exists(String item) {
        int position = findItem(item);
        return position >= 0;
    }
    private void modifyGroceryItem(int position, String newItem) {
        groceryList.set(position, newItem);
        System.out.printf("Grocery item %1$s has been modified\n", position+1);
    }
    private void removeGroceryItem(int position) {
        groceryList.remove(position);
    }

    private int findItem(String elementToSearch) {
        return groceryList.indexOf(elementToSearch);

//        // inefficient code, but that's fine for learning purpose
//        boolean exists = groceryList.contains(elementToSearch);
//        int position = -1;
//        if (exists) {  // no need to check existence first, indexOf returns -1 if the match was not found
//            position = groceryList.indexOf(elementToSearch);
//        }
//        if (position >= 0)  {
//            return groceryList.get(position);
//        }
//        return null;
    }
}
