/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lzw.packer.dictionaries;

import lzw.packer.tools.HaTbl;

/**
 * Tämä luokka toimii pakkausvaiheen pakkaajan sanakirjana.
 * @author pullis
 * @version 0.1
 */
public class Dict {
    HaTbl<String, Short> comp;
    short last;
    
    /**
     * Dict luokan konstruktori.
     */
    public Dict(){
        this.comp = new HaTbl();
        this.last = 0;
    }
    
    /**
     * Tämä metodi lisää sanakirjan käyttämään HashMap-toteutukseen tietyn objektin.
     * Se myös automaattisesti lisää sille koodin antamalla sen toiseksi pariksi shortin.
     * @param toAdd Tämä on lisättävä objekti
     */
    public void add(String toAdd){

        if(last == 32767){
            clear();
            last = 0;
            init();
        } 
        
        this.comp.put(toAdd, this.last);
        this.last++;
    }
    
    /**
     * Metodi tarkistaa löytyykö HashMap-toteutuksesta tiettyä avainta.
     * @param key Tarkistettava avain;
     * @return Palauttaa true jos löytyy.
     */
    public boolean hasKey(String key){
        return this.comp.containsKey(key);
    }

    /**
     * Tämä metodi alustaa sanakirjaan ASCII-aakkoston ensimmäiset 255 merkkiä.
     */
    public void init(){
    
        for(int j = 0; j < 255; j++){
            
            char a = (char) (j + 1);
            
            this.add(a + "");
            last = (short) a;
        }
    }
    
    /**
     * Hakee ja palauttaa sanakirjan koodin/merkkijonon tietyllä avaimella.
     * @param key Palautettavan asian avainpari.
     * @return Palauttaa avaimen takaa löytyvän objektin.
     */
    public Short get(String key) {
        return this.comp.get(key);
    }
    
    public void clear(){
        this.comp.clear();
    }
}
