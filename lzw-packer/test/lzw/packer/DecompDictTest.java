/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lzw.packer;

import lzw.packer.dictionaries.DecompDict;
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
public class DecompDictTest {
    
    public DecompDictTest() {
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
     * Test of lisaa method, of class DecompDict.
     */
    @Test
    public void testLisaa() {
        String tama = "Miten Menee";
        DecompDict instance = new DecompDict();
        instance.add(tama);
        assertTrue("Löytyy myös decompista", instance.hasKey((short)1));
    }
    
}
