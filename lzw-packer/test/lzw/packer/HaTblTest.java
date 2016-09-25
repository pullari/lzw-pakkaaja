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
public class HaTblTest {
    
    public HaTblTest() {
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
     * Test of alusta method, of class HaTbl.
     */
    @Test
    public void testAlusta() {
        HaTbl instance = new HaTbl();
        instance.alusta();
        assertTrue(instance.ar.length == instance.size);
    }

    /**
     * Test of clear method, of class HaTbl.
     */
    @Test(expected=NullPointerException.class)
    public void testClear() {
        HaTbl instance = new HaTbl();
        instance.put(256, "moi");
        instance.clear();
        instance.get(256);
    }

    /**
     * Test of containsKey method, of class HaTbl.
     */
    @Test
    public void testContainsKey() {
        
        HaTbl instance = new HaTbl();
        instance.put("moi", 51433765);
        assertTrue(instance.containsKey("moi"));
    }

    /**
     * Test of put method, of class HaTbl.
     */
    @Test
    public void testPut() {
        HaTbl instance = new HaTbl();
        instance.put("moi", 41265);
        instance.put(52341,"test");
        assertEquals(41265,instance.get("moi"));
        assertEquals("test",instance.get(52341));
    }

    /**
     * Test of get method, of class HaTbl.
     */
    @Test
    public void testGet() {
        HaTbl instance = new HaTbl();
        instance.put("moi", 41265);
        instance.put(52341,"test");
        assertEquals(41265,instance.get("moi"));
        assertEquals("test",instance.get(52341));
    }

    /**
     * Test of calcHash method, of class HaTbl.
     */
    @Test
    public void testCalcHash() {
        String tama = "abc";
        HaTbl instance = new HaTbl();
        int result = instance.calcHash(tama);
        assertEquals(294, result);
    }
    
}
