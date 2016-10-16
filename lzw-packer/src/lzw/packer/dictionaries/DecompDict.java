/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lzw.packer.dictionaries;

import lzw.packer.tools.HaTbl;

/**
 * Tämä luokka perii Dict-luokan ja korvaa siitä pelkästään lisaa-metodin toiminnallisuuden.
 * @author pullis
 * @version 0.1
 */
public class DecompDict {
    /**
     * Lisää purku-sanakirjaan objektin tama. Lisäys tehdään toisinpäin, kuin tavallisessa Dict-luokassa.
     * @param tama Lisättävä objekti.
     */
    
    HaTbl<Short,String> comp;
    short last;
    
    public DecompDict(){
        this.comp = new HaTbl();
        this.last = 0;
        init();
        System.out.println("");
    }
    
    public void add(String toAdd){
        
        if(last == 32767){
            clear();
            last = 0;
            init();
        }
        this.comp.put(last, toAdd);
        this.last++;
    }
    
    /**
     * Metodi tarkistaa löytyykö HashMap-toteutuksesta tiettyä avainta.
     * @param key Tarkistettava avain;
     * @return Palauttaa true jos löytyy.
     */
    public boolean hasKey(short key){
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
    public String get(short key) {
        return this.comp.get(key);
    }
    
    public void clear(){
        this.comp.clear();
    }
}
