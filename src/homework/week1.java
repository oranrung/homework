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
                   hMap.put(obj.no, obj);
                   lMap.put(obj.no, obj);
                   tMap.put(obj.no, obj);
                }
                br.close();
        } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
        
        int[] num = {20,3000,12000,30000,45000,60000,67000,800000};
        
         System.out.println("================compare hash================");
        for (int i = 0; i < num.length; i++) {
            
            try {
                System.out.println("find : "+num[i]);
                        
                long start = System.nanoTime();
                week1 hm = hMap.get(num[i]);
                long end = System.nanoTime();
                long elapsedTime = end - start;
                double second = (double)elapsedTime / 1_000_000_000.0;
                System.out.print("HashMap Time= "+new DecimalFormat("#.##########").format(second)+" second");
                long start2 = System.nanoTime();
                week1 lm = lMap.get(num[i]);
                long end2 = System.nanoTime();
                long elapsedTime2 = end2 - start2;
                double second2 = (double)elapsedTime2 / 1_000_000_000.0;
                System.out.print(", LinkedHashMap  Time= "+new DecimalFormat("#.##########").format(second2)+" second");
                
                long start3 = System.nanoTime();
                week1 tm = tMap.get(num[i]);
                long end3 = System.nanoTime();
                long elapsedTime3 = end3 - start3;
                double second3 = (double)elapsedTime3 / 1_000_000_000.0;
                System.out.print(", TreeMap Time= "+new DecimalFormat("#.##########").format(second3)+" second");
                System.out.println("");
                     
            } catch (Exception e) {
             
                System.out.println("Not found : id="+num[i]);
            }
        }
        
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



