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
 * The main class of the Lempel-Ziv-Welch packing
 * 
 * @author Samuli Rouvinen
 * @version 0.5
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
