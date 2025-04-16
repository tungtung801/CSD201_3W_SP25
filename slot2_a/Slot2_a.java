/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slot2_a;

import java.util.ArrayList;

/**
 *
 * @author TungTung
 */
public class Slot2_a {

    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<Integer>();

        list1.add(5);
        list1.add(10);
        for (int i = 0; i < 10; i++) {
            list1.add(i);
        }

        // remove first
        list1.remove(0);
        System.out.println("");

        //remove last
        list1.remove(list1.size() - 1);

        //get first
        list1.get(0);

        // get last
        list1.get(list1.size() - 1);

        // get next
//        for (int i = 0; i < 10; i++) {
//            list1.get(i + 1);
//        }

        //add fisrt
        list1.add(0, -1);

        //add last
        list1.add(list1.size() - 1, -100);
        
        //find
        list1.indexOf(5); // vitri
        
        Integer value = list1.get(list1.indexOf(5));
        System.out.println("Value at index is: " + value);
        

        for (Integer integer : list1) {
            System.out.print(integer + " ");
        }
        
        System.out.println("Soluong: " + list1.size());
    }
}
