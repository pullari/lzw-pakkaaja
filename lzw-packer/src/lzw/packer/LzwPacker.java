/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lzw.packer;

import lzw.packer.compressors.Compressor;
import lzw.packer.compressors.Decompressor;
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
        UserInterface UI = new UserInterface();
        UI.operate();
    } 
}
