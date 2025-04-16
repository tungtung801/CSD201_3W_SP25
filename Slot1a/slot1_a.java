/*

    CLASS NÀY HỌC 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Slot1a;

import java.util.Scanner;
import jdk.nashorn.internal.parser.Lexer;

/**
 *
 * @author TungTung
 */
public class slot1_a {
    
    
    public static void main(String[] args) {
        // Array 
        int n = 3;
        int[] array = new int[n];
        
        Scanner sc = new Scanner(System.in);
        
        for(int i = 0; i < n; i++){
            try{
            System.out.print("Input a[" + i + "] = ");
            array[i] = sc.nextInt();
            }catch(Exception e){
                
            }
        }
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
            array[i] = 1;
        }
        System.out.println("0");
               
        // Dươc dung nhieu hon
        for (int i : array) {
            System.out.print(i + " ");
            i = 1;
        }
        System.out.println("");
        
        // soluong
        System.out.println("Soluong: " + array.length);
        
        String str = "Chao mung ban tro lai voi CSD201 :D";
        System.out.println(str.length());
    }
}
