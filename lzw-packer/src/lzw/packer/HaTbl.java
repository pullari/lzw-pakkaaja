/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lzw.packer;

/**
 * Tämä luokka on oma toteutukseni hajautustaulusta. 
 * Suurimpia puutteita siinä on se, että se toimii pelkästään parien (String, short) ja (short, String) kanssa. Myös fiksattu ylivuotolistan koko voi osoittautua ongelmaksi.
 * Se kuitenkin tekee LZW-pakkaajassa tehtävänsä.
 * @author pullis
 * @version 0.1.1
 */
public class HaTbl {
    
    Object[] ar; 
    int size = 81703;
    /**
     * Hajautustaulun konstruktori.
     */
    public HaTbl(){
        this.ar = new Object[size];
        alusta();
    }
    /**
     * Tämä metodi alustaa uuteen hajautustaulun kaikki ylivuotolistat
     */
    public void alusta(){
        for (int i = 0; i < size; i++) {
            this.ar[i] = new Pair[10];
        }
    }
    /**
     * Tämä metodi "tyhjentää" listan luomalla uuden sen tilalle.
     */
    public void clear(){
        this.ar = new Object[size];
        alusta();
    }
    /**
     * Metodi tarkistaa löytyykö taulusta haluttu avain
     * @param key Etsittävä avain
     * @return Palauttaa true, jos löytyy ja false, jos ei
     */
    public boolean containsKey(Object key){
    
        int hash = 0;
        try{
            hash = calcHash((String)key);
        }catch(Exception e){
            hash = (int) key;
        }
        Pair[] alue = (Pair[]) this.ar[hash];
        
        for (int i = 0; i < alue.length; i++) {
            if(alue[i] == null){
                return false;
            }else if(alue[i].getKey().equals(key)){
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
    public void put(Object key, Object val){
        
        int hash = 0;
        try{
            hash = calcHash((String)key);
        }catch(Exception e){
            hash = (int) key;
        }
        Pair pari = new Pair(key, val);
        
        Pair[] alue = (Pair[]) this.ar[hash];
        
        for (int i = 0; i < alue.length; i++) {
            if(alue[i] == null){
                alue[i] = pari;
                break;
            }
        }
    }
    /**
     * Etsii vastaavan avain-arvo parin ja palauttaa sen arvon
     * @param key Avain, jolla etsitään.
     * @return Arvo, joka löytyy avaimen takaa.
     */
    public Object get(Object key){
        
        int hash = 0;
        try{
            hash = calcHash((String)key);
        }catch(Exception e){
            hash = (int) key;
        }
        
        Pair[] alue = (Pair[]) this.ar[hash];
        
        for (int i = 0; i < alue.length; i++) {
            if(alue[i].getKey().equals(key)){
                return alue[i].getVal();
            }
        }
        return null;
    }
    /**
     * Laskee hajautustaulun hajautusavaimen, mikäli sikäli avain on String
     * @param tama String, jolle lasketaan hajautusavain
     * @return Palauttaa hajautusavaimen
     */
    int calcHash(String tama){
        
        char[] array = tama.toCharArray();
        short asc = 0;
        
        for (int i = 0; i < array.length; i++) {
            
            asc += (short) array[i];
        }
        
        return asc % 81703;
    }
}
