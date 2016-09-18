/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lzw.packer;

/**
 * Tämä luokka toimii sanakirjana purkajalle. Se käyttää muuten samoja metodeja kuin pakkaaja, mutta se lisää avaimeksi koodin ja pariksi merkkijonon.
 * @author pullis
 * @version 0.1
 */
public class DecompDict extends Dict {
    
    /**
     * Metodi ylikirjoittaa Dict-luokan lisäys metodin kääntäen sen niin, että short-koodi on avain ja merkkijono sen pari.
     * @param tama Lisättävä merkkijono.
     */
    @Override
    public void lisaa(Object tama){
        this.comp.put( (short)this.viimeinen + 1, tama);
        this.viimeinen++;
    }
}
