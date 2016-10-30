/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lzw.packer.dictionaries;

import lzw.packer.tools.HaTbl;

/**
 * This class is the packers dictionary.
 * @author Samuli Rouvinen
 * @version 0.5
 */
public class Dict {
    HaTbl<String, Short> comp;
    short last;
    
    /**
     * Constructor
     */
    public Dict(){
        this.comp = new HaTbl();
        this.last = 0;
    }
    
    /**
     * Method adds a string to the dictionary
     * @param toAdd String to be added
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
     * Method checks if the given key is in the dictionary
     * @param key The key to be checked
     * @return True if key is in dictionary.
     */
    public boolean hasKey(String key){
        return this.comp.containsKey(key);
    }

    /**
     * Initialises the 255 ASCII characters to the dictionary
     */
    public void init(){
    
        for(int j = 0; j < 255; j++){
            
            char a = (char) (j + 1);
            
            this.add(a + "");
            last = (short) a;
        }
    }
    
    /**
     * Fetches a certain String with a given key from the dictionary.
     * @param key Key to the string.
     * @return String to be returned.
     */
    public Short get(String key) {
        return this.comp.get(key);
    }
    
    /**
     * Clears the dictionary.
     */
    public void clear(){
        this.comp.clear();
    }
}
