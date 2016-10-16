/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lzw.packer.tools;

/**
 * Tämä luokka toimii oman HashTaulu toteutukseni standardina säilöntämuotona. Se siis sisältää avain-arvo parin.
 * @author pullis
 * @version 0.1
 * @param <K>
 * @param <V>
 */
public class Pair<K, V> {
    
     K key;
     V value;
    /**
     * Pari luokan konstruktori
     * @param a avain
     * @param b arvo
     */
    public Pair(K a, V b){
        this.key = a;
        this.value = b;
    }
    /**
     * Metodi palauttaa parin avaimen
     * @return avain objekti
     */
    public K getKey(){
        return this.key;
    }
    /**
     * Metodi palauttaa parin arvon
     * @return arvo objekti
     */
    public V getVal(){
        return this.value;
    }
    
}
