/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventori_barang;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author amris
 */
public class FrmHistoriPermintaanTest {
    
    public FrmHistoriPermintaanTest() {
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
     * Test of sha1 method, of class FrmHistoriPermintaan.
     */
    @Test
    public void testSha1() throws Exception {
        System.out.println("sha1");
        String input = "";
        String expResult = "";
        String result = FrmHistoriPermintaan.sha1(input);
      
    }

    /**
     * Test of main method, of class FrmHistoriPermintaan.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        FrmHistoriPermintaan.main(args);
        // TODO review the generated test code and remove the default call to fail.

    }
    
}
