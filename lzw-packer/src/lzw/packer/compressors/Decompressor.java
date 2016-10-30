/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lzw.packer.compressors;
import lzw.packer.dictionaries.DecompDict;
import java.io.*;
/**
 * This class is the unpacker. It works almost identically to the compressos, but uses a unpacking algorithm
 * @author Samuli Rouvinen
 * @version 0.5
 */
public class Decompressor {
    
    FileInputStream in;
    ObjectInputStream oin;
    FileWriter writer;
    DecompDict dict;
    
    /**
     * Unpackers constructor
     * @param toDecomp The packed file to be unpacked
     */
    public Decompressor(File toDecomp){
    
        try{
            this.in = new FileInputStream(toDecomp);
            this.oin = new ObjectInputStream(in);
            this.writer = new FileWriter(toDecomp.getPath() + "_decomp.txt");
            this.dict = new DecompDict();
        }catch(Exception e){
            System.out.println("Tarkista onko tiedosto olemassa.");
        }
    }
    /**
     * Only method of the unpackers. Handles the unpacking with an algorithm
     * @return Returns 1 if succeeded, 0 if failed
     * @throws java.io.IOException
     */
    public int decompress() throws IOException {
    
        short last = 0;
        short code = 0;

        last = oin.readShort();
        writer.write(dict.get(last));
            
        while((code = oin.readShort()) != -1){
            if(oin.available() == 0){
                break;
            }
            
            String lastStr = dict.get(last);
            if(dict.hasKey(code)){
                
                String toAdd = dict.get(code);
                writer.write(toAdd);
                dict.add(lastStr + toAdd.charAt(0));
            }else{
                
                dict.add(lastStr + lastStr.charAt(0));
                writer.write(lastStr + lastStr.charAt(0));
            }
            last = code; 
        }
            
        in.close();
        oin.close();
        writer.close();
            
        return 1;
    }
}
