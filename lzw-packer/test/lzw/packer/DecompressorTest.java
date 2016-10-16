/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lzw.packer;

import lzw.packer.compressors.Decompressor;
import java.io.File;
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
public class DecompressorTest {
    
    public DecompressorTest() {
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
     * Test of decompress method, of class Decompressor.
     */
    @Test
    public void testDecompress() {
        File tied = new File("test/lzw/packer/testitiedosto.txt.lzw");
        Decompressor instance = new Decompressor(tied);
        assertEquals(1, instance.decompress());
    }
    
}
