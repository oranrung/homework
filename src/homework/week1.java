/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class week1 {
    

    public int no;
    public String sale;
    public String detail;
    
    public static void main(String[] args) {
      
        // TODO code application logic here
        String path = "file/Sale.txt";
        File file = new File(path);
        HashMap<Integer,week1> hMap = new HashMap<>() ;
        LinkedHashMap<Integer,week1> lMap = new LinkedHashMap<>();
        TreeMap<Integer,week1> tMap = new TreeMap<>();
        try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;                
                while ((line = br.readLine()) != null) {
                   week1 obj = new week1();
                   String[] arr = line.replaceAll("[\\(\\)\\'\\;]", "").split(",", 3); 
                           
                   obj.no = Integer.parseInt(arr[0]);
                   obj.sale = arr[1];
                   obj.detail = arr[2];
                  // obj.sale = arr[1].replaceAll("[\\'\\;]", "");
                   //obj.detail = arr[2].replaceAll("[\\'\\;]", "");
                   hMap.put(obj.no, obj);
                   lMap.put(obj.no, obj);
                   tMap.put(obj.no, obj);
                }
                br.close();
        } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
        
        int[] num = {20,3000,12000,30000,45000,60000,67000};
        System.out.println("================HashMap================");
        for (int i = 0; i < num.length; i++) {
            long start = System.nanoTime();
            try {
                week1 hm = hMap.get(num[i]);
                long end = System.nanoTime();
                long elapsedTime = end - start;
                double second = (double)elapsedTime / 1_000_000_000.0;
                System.out.println("HashMap find: id="+hm.no+", sale_id="+hm.sale+", data="+hm.detail+", Time= "+new DecimalFormat("#.##########").format(second)+" second");

            } catch (Exception e) {
                long end = System.nanoTime();
                long elapsedTime = end - start;
                double second = (double)elapsedTime / 1_000_000_000.0;
                System.out.println("HashMap Not found : id="+num[i]+ " Time= "+new DecimalFormat("#.##########").format(second)+" second");
            }
        }
        System.out.println("\n=============LinkedHashMap=============");
         for (int i = 0; i < num.length; i++) {
             long start = System.nanoTime();
             try {
                 
                week1 hm = lMap.get(num[i]);
                long end = System.nanoTime();
                long elapsedTime = end - start;
                double second = (double)elapsedTime / 1_000_000_000.0;
                System.out.println("LinkedHashMap find: id="+hm.no+", sale_id="+hm.sale+", data="+hm.detail+", Time= "+new DecimalFormat("#.##########").format(second)+" second");

             } catch (Exception e) {
                long end = System.nanoTime();
                long elapsedTime = end - start;
                double second = (double)elapsedTime / 1_000_000_000.0;
                System.out.println("LinkedHashMap Not found : id="+num[i]+ " Time= "+new DecimalFormat("#.##########").format(second)+" second");
            }
            
        }
         System.out.println("\n================TreeMap================");
         for (int i = 0; i < num.length; i++) {
             long start = System.nanoTime();
             try {
                
                week1 hm = tMap.get(num[i]);
                long end = System.nanoTime();
                long elapsedTime = end - start;
                double second = (double)elapsedTime / 1_000_000_000.0;
                System.out.println("TreeMap find: id="+hm.no+", sale_id="+hm.sale+", data="+hm.detail+", Time= "+new DecimalFormat("#.##########").format(second)+" second");

             } catch (Exception e) {
                long end = System.nanoTime();
                long elapsedTime = end - start;
                double second = (double)elapsedTime / 1_000_000_000.0;
                System.out.println("TreeMap Not found : id="+num[i]+ " Time= "+new DecimalFormat("#.##########").format(second)+" second");
             }
            
        }
                
    }
}



