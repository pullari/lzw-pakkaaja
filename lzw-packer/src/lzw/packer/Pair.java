/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lzw.packer;

/**
 * Tämä luokka toimii oman HashTaulu toteutukseni standardina säilöntämuotona. Se siis sisältää avain-arvo parin.
 * @author pullis
 * @version 0.1
 */
public class Pair {
    
    Object key;
    Object value;
    /**
     * Pari luokan konstruktori
     * @param a avain
     * @param b arvo
     */
    public Pair(Object a, Object b){
        this.key = a;
        this.value = b;
    }
    /**
     * Metodi palauttaa parin avaimen
     * @return avain objekti
     */
    public Object getKey(){
        return this.key;
    }
    /**
     * Metodi palauttaa parin arvon
     * @return arvo objekti
     */
    public Object getVal(){
        return this.value;
    }
}
