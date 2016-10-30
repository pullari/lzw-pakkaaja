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
 *  This class works as the commandline based UI
 * 
 * @author Samuli Rouvinen
 * @version 0.5
 */
public class UserInterface {
    
    String filename;
    int operation;
    Compressor comp;
    Decompressor decomp;
    Scanner scan;
    
    /**
     * Constructor of the UI class
     */
    
    public UserInterface(){
    
        scan = new Scanner(System.in);
        askFileNameAndOp(scan);
    }
    
    /**
     * Method which asks the needed information for packing/unpacking
     * @param scan Scanner to be used to scan the answers
     */
    
    public void askFileNameAndOp(Scanner scan){
        System.out.println("Give the filepath of the textfile: ");
        filename = scan.nextLine();
        System.out.println("Answer 1 for compression and 2 for decompression, -1 for quit: ");
        operation = scan.nextInt();
    }
    /**
     * This method evaluates the users input and operates the program accordingly
     */
    public void operate(){
    
        if(operation == 1){
            File pack = new File(filename);
            comp = new Compressor(pack);
            
            long timeBefComp = System.currentTimeMillis();
            try{
                if(comp.compress() == 1){
                    long timeAfComp = System.currentTimeMillis();
                    long time = (timeAfComp - timeBefComp);
                    System.out.println("Packed!");
                    System.out.println("Packing took: " + time + " milliseconds, " + (time/1000) + " seconds");
                }
            }catch(Exception e){
                System.out.println("Packing failed");
            }
        }else if(operation == 2){
            File unpack = new File(filename);
            decomp = new Decompressor(unpack);
            
            long timeBefDeComp = System.currentTimeMillis();
            try{
                if(decomp.decompress() == 1){
                    long timeAfDeComp = System.currentTimeMillis();
                    long time = (timeAfDeComp - timeBefDeComp);
                    System.out.println("Unpacked!");
                    System.out.println("Unpacking took: " + time + " milliseconds, " + (time/1000) + " seconds");
                }
            }catch(Exception e){
                System.out.println("Unpacking failed");
            }
        }
    }
}
