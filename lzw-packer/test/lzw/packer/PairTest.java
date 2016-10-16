/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lzw.packer;

import lzw.packer.tools.Pair;
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
public class PairTest {
    
    public PairTest() {
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
     * Test of getKey method, of class Pair.
     */
    @Test
    public void testGetKey() {
        Pair inst = new Pair(123, "moi");
        assertEquals(123, inst.getKey());
    }

    /**
     * Test of getVal method, of class Pair.
     */
    @Test
    public void testGetVal() {
        Pair inst = new Pair(123, "moi");
        assertEquals("moi", inst.getVal());
    }
    
}
