/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex05_cha_sorinoks;

/**
 *
 * @author Kiley
 */
import java.util.*;

public class Store {
  private String name;
  private double earnings;
  private ArrayList<Item> itemList;
  private static ArrayList<Store> storeList = new ArrayList();

  public Store(String name){
      this.name = name;
      earnings = 0;
      this.itemList = new ArrayList<Item>();
      storeList.add(this);
      
      
    // Initialize name to parameter and earnings to zero
    // Initialize itemList as a new ArrayList
    // add 'this' store to storeList
  }

  public String getName(){
    return name;
  }
  public double getEarnings(){
    return earnings;
  }
  
   public void addItem(Item i){
       itemList.add(i);
       System.out.printf("'%s' - New Item Added!\n", i.getName());
    // add Item i to store's itemList
  }
  
  public void sellItem(int index){
          if (itemList.size() > index){
              Item i = itemList.get(index);
              earnings += i.getCost();
              System.out.printf("%s was sold for %.2f%n", i.getName(), i.getCost());

          }
              else {
               System.out.printf("We're sorry but we only have have %d items in the store\n", itemList.size());       
          }
          
      }
      
 
    // check if index is within the size of the itemList (if not, print statement that there are only x items in the store)
    // get Item at index from itemList and add its cost to earnings
    // print statement indicating the sale

  public void sellItem(String name){
      for(Item i : itemList){
          if(i.getName().equals(name)){
              earnings += i.getCost();
              System.out.printf("%s was sold for %.2f%n", i.getName(), i.getCost());
              return;
          }   
        }
      System.out.printf("I'm sorry but this item '%s' is not in our store\n", name);
      
    // check if Item with given name is in the itemList (you will need to loop over itemList) (if not, print statement that the store doesn't sell it)
    // get Item from itemList and add its cost to earnings
    // print statement indicating the sale
  }
  public void sellItem(Item i){
        int item = itemList.indexOf(i);
        if(item != -1){
              earnings += i.getCost();
              System.out.printf("%s was sold for %.2f%n", i.getName(), i.getCost());

          }
       else {
          System.out.println("I'm sorry but this item is not in our store");
              }
  

      
    // check if Item i exists in the store (there is a method that can help with this) (if not, print statement that the store doesn't sell it)
    // get Item i from itemList and add its cost to earnings
    // print statement indicating the sale
  }
 
  public void filterType(String type){
      for(Item i : itemList){
           if(i.getType().equals(type)){
               System.out.println(i.getName());
           }
       }
    // loop over itemList and print all items with the specified type
  }
  public void filterCheap(double maxCost){
       for(Item i : itemList){
           if(i.getCost() <= maxCost){
               System.out.println(i.getName());
           }
       }
    // loop over itemList and print all items with a cost lower than or equal to the specified value
  }
  public void filterExpensive(double minCost){
      for(Item i : itemList){
           if(i.getCost() >= minCost){
               System.out.println(i.getName());
           }
       }      
    // loop over itemList and print all items with a cost higher than or equal to the specified value
  }
  public static void printStats(){
    // loop over storeList and print the name and the earnings'Store.java'
        for(Store i : storeList){
            System.out.printf("Store: %s | Earnings: %.2f\n",i.name, i.earnings);
            
        }
  }
}
