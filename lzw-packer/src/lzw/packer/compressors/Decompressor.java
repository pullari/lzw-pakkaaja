/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lzw.packer.compressors;
import lzw.packer.dictionaries.DecompDict;
import java.io.*;
/**
 * Tämä luokka toimii tiedoston purkajana. Se on hyvin samankaltainen pakkaajan kanssa, suurimpana erona algoritmin toteutus.
 * @author pullis
 * @version 0.1
 */
public class Decompressor {
    
    FileInputStream in;
    ObjectInputStream oin;
    FileWriter writer;
    DecompDict dict;
    
    /**
     * Purkajan konstruktori.
     * @param toDecomp Parametri, jolla määritetään, että mikä tiedosto puretaan.
     */
    public Decompressor(File toDecomp){
    
        try{
            this.in = new FileInputStream(toDecomp);
            this.oin = new ObjectInputStream(in);
            this.writer = new FileWriter(toDecomp.getPath() + "_decomp.txt");
            this.dict = new DecompDict();
            this.dict.init();
        }catch(Exception e){
            System.out.println("Tarkista onko tiedosto olemassa.");
        }
    }
    /**
     * Purkajan ainoa metodi. Se huolehtii purku algoritmin toteutuksesta ja käyttämisestä.
     * @return int palauttaa 1, jos onnistuu ja 0 jos epäonnistuu
     */
    public int decompress(){
    
        long timeBefDeComp = System.currentTimeMillis();
        
        short last = 0;
        short code = 0;
        
        try{
        
            last = oin.readShort();
            writer.write(dict.get(last));
            
            while((code = oin.readShort()) != -1){
                if(code == 00){
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
            
        }catch(Exception e){
            System.out.println("Virhe purettaessa tiedostoa");
            return 0;
        }
        
        long timeAfDeComp = System.currentTimeMillis();
        long time = (timeAfDeComp - timeBefDeComp);
        System.out.println("Purkamiseen Decompressor-luokassa kului: " + time + " millisekuntia eli " + (time/1000) + " sekuntia");
         
        return 1;
    }
}
