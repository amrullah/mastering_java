package com.company;
import java.util.ArrayList;

public class GroceryList {
    private ArrayList<String> groceryList = new ArrayList<String>();

    public void addGroceryItem(String item) {
        groceryList.add(item);
    }

    public void printGroceryList() {
        System.out.printf("You have %1$s items in your grocery list\n", groceryList.size());
        for (int i=0; i < groceryList.size(); i++) {
            System.out.printf("%1$s. %2$s\n", i+1, groceryList.get(i));
        }
    }

    public void modifyGroceryItem(int position, String newItem) {
        groceryList.set(position, newItem);
        System.out.printf("Grocery item %1$s has been modified\n", position+1);
    }

    public void removeGroceryItem(int position) {
        String item = groceryList.get(position);
        groceryList.remove(position);

    }

    public String findItem(String elementToSearch) {
        // inefficient code, but that's fine for learning purpose
        boolean exists = groceryList.contains(elementToSearch);
        int position = -1;
        if (exists) {  // no need to check existence first, indexOf returns -1 if the match was not found
            position = groceryList.indexOf(elementToSearch);
        }
        if (position >= 0)  {
            return groceryList.get(position);
        }
        return null;
    }
}
