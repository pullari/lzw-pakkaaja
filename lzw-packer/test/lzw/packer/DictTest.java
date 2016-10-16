/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lzw.packer;

import lzw.packer.dictionaries.Dict;
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
        instance.add(tama);
        assertTrue("Lisätty objekti löytyy",instance.get(tama) != null);
    }

    /**
     * Test of loytyykoAvain method, of class Dict.
     */
    @Test
    public void testLoytyykoAvain() {
        String avain = "hei";
        Dict instance = new Dict();
        instance.add(avain);
        assertTrue("Avain löytyi", instance.hasKey(avain));
    }

    /**
     * Test of alusta method, of class Dict.
     */
    @Test
    public void testAlusta() {
        Dict instance = new Dict();
        instance.init();
        assertTrue("Löytyy", instance.hasKey("a"));
    }

    /**
     * Test of hae method, of class Dict.
     */
    @Test
    public void testHae() {
        Dict instance = new Dict();
        instance.init();
        instance.add("jotain");
        int result = (int) instance.get("jotain");
        assertTrue("Hakeminen toimii", result == 255);
    }
}
