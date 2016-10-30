/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lzw.packer.compressors;
import lzw.packer.dictionaries.Dict;
import java.io.*;

/**
 * This class packs the file given to it
 * @author Samuli Rouvinen
 * @version 0.5
 */
public class Compressor {
    
    FileInputStream in;
    InputStreamReader inR;
    FileOutputStream out;
    ObjectOutputStream writer;
    Dict dict;
    
    /**
     * The packers constructor
     * @param toComp The file to be packed
     * 
     */
    public Compressor(File toComp){
    
        try{
            this.in = new FileInputStream(toComp);
            this.inR = new InputStreamReader(in, "utf-8");
            this.out = new FileOutputStream(toComp.getPath() + ".lzw");
            this.writer = new ObjectOutputStream(out);
            
            this.dict = new Dict();
            this.dict.init();
        }catch(Exception e){
            System.out.println("Tiedostoa ei löydetty");
        }
    }
    
    /**
     * The only method of the packer which uses the LZW algorithm to pack a file
     * @return returns 1 if succeeded, 0 if failed
     * @throws java.io.IOException
     */
    public int compress() throws IOException{
        
        String word;
        short code;
        
        word = (char) inR.read() + "";
            
        //InputSreamReader returns -1 when read
        while((code = (short) inR.read()) != -1){
                
            char c = (char) code;
                
            if(!this.dict.hasKey(word + c)){        
                String write = this.dict.get(word).toString();
                short addToFile = Short.parseShort(write);
                this.writer.writeShort(addToFile);
                    
                this.dict.add(word + c);
                word = "" + c;
            }else{
                word = word + c;
            }
        }

        short lastToBeAdded = Short.parseShort(this.dict.get(word).toString());
        this.writer.writeShort(lastToBeAdded);
        this.writer.writeShort(00);
            
        this.writer.close();
        inR.close();
        
        return 1;
    }
}
