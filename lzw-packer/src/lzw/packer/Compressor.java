/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lzw.packer;
import java.io.*;

/**
 * Tämä luokka vastaa sille annetun tekstitiedoston pakkaamisesta Lempel-Ziv-Welch algoritmilla.
 * @author pullis
 * @version 0.1
 */
public class Compressor {
    
    FileInputStream in;
    InputStreamReader inR;
    FileOutputStream out;
    ObjectOutputStream writer;
    Dict dict;
    
    /**
     * Pakkaajan konstruktori.
     * @param toComp Parametrina konstruktorille injektoitava tiedosto, joka pakataan.
     * 
     */
    public Compressor(File toComp){
    
        try{
            this.in = new FileInputStream(toComp);
            this.inR = new InputStreamReader(in, "utf-8");
            this.out = new FileOutputStream(toComp.getPath() + ".lzw");
            this.writer = new ObjectOutputStream(out);
            
            this.dict = new Dict();
            this.dict.alusta();
        }catch(Exception e){
            System.out.println("Tiedostoa ei löydetty");
        }
    }
    
    /**
     * Pakkaajan ainoa metodi, joka pakkaajan alustamisen jälkeen vastaa itse purkualgoritmin toteuttamisesta ja käyttämisestä.
     * @return int palauttaa 1, jos onnistuu ja 0 jos epäonnistuu
     */
    public int compress(){
    
        String sana;
        short koodi;
        
        try{
            sana = (char) inR.read() + "";
            
            //InputSreamReader palauttaa -1 kun tiedosto on luettu
            while((koodi = (short) inR.read()) != -1){
                
                char c = (char) koodi;
                if(!this.dict.loytyykoAvain(sana + c)){
                    
                    short tiedostoonLisattava = Short.parseShort(this.dict.hae(sana).toString());
                    this.writer.writeShort(tiedostoonLisattava);
                    
                    this.dict.lisaa(sana + c);
                    sana = "" + c;
                }else{
                    sana = sana + c;
                }
            }

            short viimeinenLisattava = Short.parseShort(this.dict.hae(sana).toString());
            this.writer.writeShort(viimeinenLisattava);
            this.writer.writeShort(00);

            this.writer.close();
            inR.close();
        }catch(Exception e){
            System.out.println("Ongelma pakatessa tiedostoa. Tiedostoa ei ehkä voitu lukea.");
            return 0;
        }
        
        return 1;
    }
}
