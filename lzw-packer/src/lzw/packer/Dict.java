/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lzw.packer;

/**
 * Tämä luokka toimii pakkausvaiheen pakkaajan sanakirjana.
 * @author pullis
 * @version 0.1
 */
public class Dict {
    HaTbl comp;
    short viimeinen;
    
    /**
     * Dict luokan konstruktori.
     */
    public Dict(){
        this.comp = new HaTbl();
        this.viimeinen = 0;
    }
    
    /**
     * Tämä metodi lisää sanakirjan käyttämään HashMap-toteutukseen tietyn objektin.
     * Se myös automaattisesti lisää sille koodin antamalla sen toiseksi pariksi shortin.
     * @param tama Tämä on lisättävä objekti
     */
    public void lisaa(Object tama){

        if(viimeinen == 32767){
            putsaa();
            viimeinen = 0;
            alusta();
        } 
        
        this.comp.put(tama, (short) this.viimeinen + 1);
        this.viimeinen++;
    }
    
    /**
     * Metodi tarkistaa löytyykö HashMap-toteutuksesta tiettyä avainta.
     * @param avain Tarkistettava avain;
     * @return Palauttaa true jos löytyy.
     */
    public boolean loytyykoAvain(Object avain){
        return this.comp.containsKey(avain);
    }

    /**
     * Tämä metodi alustaa sanakirjaan ASCII-aakkoston ensimmäiset 255 merkkiä.
     */
    public void alusta(){
    
        for(int j = 0; j < 255; j++){
            
            char a = (char) (j + 1);
            
            this.lisaa(a + "");
            viimeinen = (short) a;
        }
    }
    
    /**
     * Hakee ja palauttaa sanakirjan koodin/merkkijonon tietyllä avaimella.
     * @param avain Palautettavan asian avainpari.
     * @return Palauttaa avaimen takaa löytyvän objektin.
     */
    public Object hae(Object avain) {
        return this.comp.get(avain);
    }
    
    public void putsaa(){
        this.comp.clear();
    }
}
