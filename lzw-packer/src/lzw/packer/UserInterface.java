package lzw.packer;


import java.io.File;
import java.util.Scanner;
import lzw.packer.compressors.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pullis
 */
public class UserInterface {
    
    String filename;
    int operation;
    Compressor comp;
    Decompressor decomp;
    Scanner scan;
    
    public UserInterface(){
    
        scan = new Scanner(System.in);
        askFileNameAndOp(scan);
    }
    
    public void askFileNameAndOp(Scanner scan){
        System.out.println("Give the name of the textfile: ");
        filename = scan.nextLine();
        System.out.println("Answer 1 for compression and 2 for decompression, -1 for quit: ");
        operation = scan.nextInt();
    }
    
    public void operate(){
    
        if(operation == 1){
            File pack = new File(filename);
            comp = new Compressor(pack);
            
            long timeBefComp = System.currentTimeMillis();
            
            if(comp.compress() == 1){
                long timeAfComp = System.currentTimeMillis();
                long time = (timeAfComp - timeBefComp);
                System.out.println("Packed!");
                System.out.println("Packing took: " + time + " milliseconds, " + (time/1000) + " seconds");
            }else{
                System.out.println("Packing failed");
            }
        }else if(operation == 2){
            File unpack = new File(filename);
            decomp = new Decompressor(unpack);
            
            long timeBefDeComp = System.currentTimeMillis();
            
            if(decomp.decompress() == 1){
                long timeAfDeComp = System.currentTimeMillis();
                long time = (timeAfDeComp - timeBefDeComp);
                System.out.println("Unpacked!");
                System.out.println("Unpacking took: " + time + " milliseconds, " + (time/1000) + " seconds");
            }else{
                System.out.println("Unpacking failed");
            }
        }
    }
}
