/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lzw.packer;

import java.io.File;

/**
 * Tämä toimii Lempel-Ziv-Welch pakkaajan main-luokkana.
 * 
 * @author Samuli Rouvinen
 * @version 0.1
 */
public class LzwPacker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        File pakkaa = new File("src/lzw/packer/testiTiedosto.txt");
        File pura = new File("src/lzw/packer/testiTiedosto.txt.lzw");
        
        long timeBefComp = System.currentTimeMillis();
        
        Compressor pakkaaja = new Compressor(pakkaa);
        if(pakkaaja.compress() == 1){
            System.out.println("Pakattu!");
        }else{
            System.out.println("Pakkaus epäonnistui");
        }
        
        long timeAfComp = System.currentTimeMillis();
        long time = (timeAfComp - timeBefComp);
        System.out.println("Pakkaamiseen mainissa kului: " + time + " millisekuntia eli " + (time/1000) + " sekuntia");
        
        
        long timeBefDeComp = System.currentTimeMillis();
        
        Decompressor purkaja = new Decompressor(pura);
        if(purkaja.decompress() == 1){
            System.out.println("Purettu!");
        }else{
            System.out.println("Purkaminen epäonnistui");
        }  
        
        long timeAfDeComp = System.currentTimeMillis();
        long time2 = (timeAfDeComp - timeBefDeComp);
        System.out.println("Purkamiseen mainissa kului: " + time2 + " millisekuntia eli " + (time2/1000) + " sekuntia");
    }
}
