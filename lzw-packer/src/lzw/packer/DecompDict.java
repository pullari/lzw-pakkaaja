/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lzw.packer;

/**
 * Tämä luokka perii Dict-luokan ja korvaa siitä pelkästään lisaa-metodin toiminnallisuuden.
 * @author pullis
 * @version 0.1
 */
public class DecompDict extends Dict{
    /**
     * Lisää purku-sanakirjaan objektin tama. Lisäys tehdään toisinpäin, kuin tavallisessa Dict-luokassa.
     * @param tama Lisättävä objekti.
     */
    @Override
    public void lisaa(Object tama){
        
        if(viimeinen == 32767){
            putsaa();
            viimeinen = 0;
            alusta();
        }
        
        this.comp.put( (short)this.viimeinen + 1, tama);
        this.viimeinen++;
    }
}
