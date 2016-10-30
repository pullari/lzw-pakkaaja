/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lzw.packer.tools;

/**
 * This is the pair implementation used int the HashMap
 * @author Samuli Rouvinen
 * @version 0.5
 * @param <K> Type of the key
 * @param <V> Type of the value
 */
public class Pair<K, V> {
    
     K key;
     V value;
    /**
     * Constructor of the pair-class
     * @param a key
     * @param b value
     */
    public Pair(K a, V b){
        this.key = a;
        this.value = b;
    }
    /**
     * Returns the key of the pair
     * @return key object
     */
    public K getKey(){
        return this.key;
    }
    /**
     * Returns the value of the pair
     * @return value object
     */
    public V getVal(){
        return this.value;
    }
    
}
