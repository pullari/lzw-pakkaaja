/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lzw.packer;
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
            this.dict.alusta();
        }catch(Exception e){
            System.out.println("Tarkista onko tiedosto olemassa.");
        }
    }
    /**
     * Purkajan ainoa metodi. Se huolehtii purku algoritmin toteutuksesta ja käyttämisestä.
     * @return int palauttaa 1, jos onnistuu ja 0 jos epäonnistuu
     */
    public int decompress(){
    
        short edellinen = 0;
        short koodi = 0;
        
        try{
        
            edellinen = oin.readShort();
            writer.write((String)dict.hae((int)edellinen));
            
            while((koodi = oin.readShort()) != -1){
                if(koodi == 00){
                    break;
                }
            
                String edellinenstr = dict.hae((int)edellinen).toString();
                if(dict.loytyykoAvain((int)koodi)){
                    
                    String lisattava = dict.hae((int)koodi).toString();
                    writer.write(lisattava);
                    dict.lisaa(edellinenstr + lisattava.charAt(0));
                }else{
                
                    dict.lisaa(edellinenstr + edellinenstr.charAt(0));
                    writer.write(edellinenstr + edellinenstr.charAt(0));
                }
                edellinen = koodi; 
            }
            
            in.close();
            oin.close();
            writer.close();
            
        }catch(Exception e){
            System.out.println("Virhe purettaessa tiedostoa");
            return 0;
        }
        return 1;
    }
}
