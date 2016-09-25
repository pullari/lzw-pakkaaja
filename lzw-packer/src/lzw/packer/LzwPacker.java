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
        
        Compressor pakkaaja = new Compressor(pakkaa);
        pakkaaja.compress();
        System.out.println("Pakattu!");
        Decompressor purkaja = new Decompressor(pura);
        purkaja.decompress();
        System.out.println("Purettu!!!"); 
    }
}
