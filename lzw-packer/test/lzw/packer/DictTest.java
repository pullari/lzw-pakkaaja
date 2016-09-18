/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lzw.packer;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pullis
 */
public class DictTest {
    
    public DictTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of lisaa method, of class Dict.
     */
    @Test
    public void testLisaa() {
        String tama = "hei";
        Dict instance = new Dict();
        instance.lisaa(tama);
        assertTrue("Lisätty objekti löytyy",instance.hae(tama) != null);
    }

    /**
     * Test of loytyykoAvain method, of class Dict.
     */
    @Test
    public void testLoytyykoAvain() {
        String avain = "hei";
        Dict instance = new Dict();
        instance.lisaa(avain);
        assertTrue("Avain löytyi", instance.loytyykoAvain(avain));
    }

    /**
     * Test of alusta method, of class Dict.
     */
    @Test
    public void testAlusta() {
        Dict instance = new Dict();
        instance.alusta();
        assertTrue("Löytyy", instance.loytyykoAvain("a"));
    }

    /**
     * Test of hae method, of class Dict.
     */
    @Test
    public void testHae() {
        Dict instance = new Dict();
        instance.alusta();
        instance.lisaa("jotain");
        int result = (int) instance.hae("jotain");
        assertTrue("Hakeminen toimii", result == 256);
    }
    
}
