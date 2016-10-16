/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lzw.packer.tools;

/**
 * Tämä luokka on oma toteutukseni hajautustaulusta. 
 * Suurimpia puutteita siinä on se, että se toimii pelkästään parien (String, short) ja (short, String) kanssa. Myös fiksattu ylivuotolistan koko voi osoittautua ongelmaksi.
 * Se kuitenkin tekee LZW-pakkaajassa tehtävänsä.
 * @author pullis
 * @version 0.1.1
 */
public class HaTbl<K, V>{
    
    Object[] ar; 
    int size = 32768;
    /**
     * Hajautustaulun konstruktori.
     */
    public HaTbl(){
        this.ar = new Object[size];
        init();
    }
    /**
     * Tämä metodi alustaa uuteen hajautustaulun kaikki ylivuotolistat
     */
    public void init(){
        for (int i = 0; i < size; i++) {
            this.ar[i] = new Pair[10];
        }
    }
    /**
     * Tämä metodi "tyhjentää" listan luomalla uuden sen tilalle.
     */
    public void clear(){
        this.ar = new Object[size];
        init();
    }
    /**
     * Metodi tarkistaa löytyykö taulusta haluttu avain
     * @param key Etsittävä avain
     * @return Palauttaa true, jos löytyy ja false, jos ei
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
     * Metodi vastaa avain-arvo parien tauluun lisäämisestä
     * @param key Avain-arvo parin avain
     * @param val Avain-arvo parin arvo
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
     * Etsii vastaavan avain-arvo parin ja palauttaa sen arvon
     * @param key Avain, jolla etsitään.
     * @return Arvo, joka löytyy avaimen takaa.
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
     * Laskee hajautustaulun hajautusavaimen, mikäli sikäli avain on String
     * @param toHash String, jolle lasketaan hajautusavain
     * @return Palauttaa hajautusavaimen
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
    
    public Pair[] changeArraySize(Pair[] array, int newSize){
        Pair[] newArray = new Pair[newSize];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }
    
    public int testLenght(){
        return this.ar.length;
    }
    
    public Object[] getAr(){
        return this.ar;
    }
}
