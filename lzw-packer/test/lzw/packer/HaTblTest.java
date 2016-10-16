/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lzw.packer;

import lzw.packer.tools.Pair;
import lzw.packer.tools.HaTbl;
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
        HaTbl<String, Short> instance = new HaTbl();
        instance.init();
        assertTrue(instance.getAr().length == 32768);
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
     * Test of changeArraySize method, of class HaTbl
     */
    
    @Test
    public void testChangeArraySize() {
        
        HaTbl instance = new HaTbl();
        Pair[] array = (Pair[]) instance.getAr()[2];
        array = instance.changeArraySize(array, array.length * 2);
        assertTrue(array.length == 20);
    }
    /**
     * Test that array is copied correctly
     */
    @Test
    public void testChangeArraySizeCopy() {
        
        HaTbl instance = new HaTbl();
        Pair[] array = (Pair[]) instance.getAr()[2];
        Pair fir = new Pair(1,2);
        Pair sec = new Pair(2,1);
        array[0] = fir;
        array[1] = sec;
        array = instance.changeArraySize(array, array.length * 2);
        assertTrue(array[0] == fir);
        assertTrue(array[1] == sec);
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
        instance.put("moi", 6);
        instance.put(8,"test");
        assertEquals(6,instance.get("moi"));
        assertEquals("test",instance.get(8));
    }

    /**
     * Test of get method, of class HaTbl.
     */
    @Test
    public void testGet() {
        HaTbl instance = new HaTbl();
        instance.put("moi", 6);
        instance.put(7,"test");
        assertEquals(6,instance.get("moi"));
        assertEquals("test",instance.get(7));
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
