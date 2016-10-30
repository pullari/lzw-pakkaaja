/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lzw.packer.tools;

/**
 * This class is a HashMap implementation 
 * @author Samuli Rouvinen
 * @version 0.5
 */
public class HaTbl<K, V>{
    
    Object[] ar; 
    int size = 32768;
    /**
     * The constructor of the HashMap
     */
    public HaTbl(){
        this.ar = new Object[size];
        init();
    }
    /**
     * This method initialises the overflow arrays of the HashMap
     */
    public void init(){
        for (int i = 0; i < size; i++) {
            this.ar[i] = new Pair[10];
        }
    }
    /**
     * This method clears the HashMap and initialises it again.
     */
    public void clear(){
        this.ar = new Object[size];
        init();
    }
    /**
     * Method checks if the key given is contained in the HashMap
     * @param key Key to be looked for
     * @return True if found, false otherwise.
     */
    public boolean containsKey(K key){
    
        int hash = 0;
        
        if(key instanceof Short){
            hash = Short.parseShort(key.toString());
        }else{
            hash = calcHash(key.toString());
        }
        
        Pair[] area = (Pair[]) this.ar[hash];
        
        for (int i = 0; i < area.length; i++) {
            if(area[i] == null){
                return false;
            }else if(area[i].getKey().equals(key)){
                return true;
            }
        }
        return false;
    }
    /**
     * Method adds a key-value pair to the HashMap
     * @param key Key of the pair
     * @param val Value of the pair
     */
    public void put(K key, V val){
        
        int hash = 0;
        if(key instanceof Short){
            hash = Short.parseShort(key.toString());
        }else{
            hash = calcHash(key.toString());
        }
        
        Pair<K,V> pair = new Pair(key, val);
        
        Pair[] area = (Pair[]) this.ar[hash];
        
        for (int i = 0; i < area.length; i++) {
            if(area[i] == null){
                area[i] = pair;
                break;
            }
            if(i == area.length - 1){
                area = changeArraySize(area, area.length * 2);
                this.ar[hash] = area;
            }
        } 
    }
    /**
     * Finds a key-value pair and returns the value
     * @param key The key to be searched for.
     * @return Value of the key-value pair
     */
    public V get(K key){
        
        int hash = 0;
        if(key instanceof Short){
            hash = Short.parseShort(key.toString());
        }else{
            hash = calcHash(key.toString());
        }
        
        Pair[] area = (Pair[]) this.ar[hash];
        
        for (int i = 0; i < area.length; i++) {
            if(area[i].getKey().equals(key)){
                return (V) area[i].getVal();
            }
        }
        return null;
    }
    /**
     * Calculates the hash for a String key
     * @param toHash String, to be used
     * @return The hash value
     */
    public int calcHash(String toHash){
        
        char[] array = toHash.toCharArray();

        int hash = 0;
        for (int i = 0; i < array.length; i++) {
            hash = hash*31 + array[i];
        }
        int ret = hash % 32768;
        if(ret < 0)return -1*ret;
        return ret;
    }
    
    /**
     * Dynamically allocates space for a full overflow array
     * @param array array to be added to
     * @param newSize The new size of the array
     * @return Returns the new array
     */
    
    public Pair[] changeArraySize(Pair[] array, int newSize){
        Pair[] newArray = new Pair[newSize];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }
    
    /**
     * Method used only in tests. Returns an arrays length
     * @return Arrays length
     */
    
    public int testLenght(){
        return this.ar.length;
    }
    
    /**
     * Used only in tests. Returns the array
     * @return array
     */
    
    public Object[] getAr(){
        return this.ar;
    }
}
