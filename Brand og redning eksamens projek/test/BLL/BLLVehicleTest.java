/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BLL;

import BE.BEVehicle;
import DALC.DALCVehicleTest;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author peter bærbar
 */
public class BLLVehicleTest {
   // BLLVehicle m_bllVehicle;
    
    public BLLVehicleTest() {
   //  m_bllVehicle = new BLLVehicle(new DALCVehicleTest());   
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
     * Test of VehicleCreatePerformed method, of class BLLVehicle.
     */
    @Test
    public void testVehicleCreatePerformed() {
        System.out.println("VehicleCreatePerformed");
        BLLVehicle m_bllVehicle = new BLLVehicle(new DALCVehicleTest()); 
        BEVehicle event1 = new BEVehicle("c7887", "toyota", "2", "Nice car");
        BEVehicle event2 = new BEVehicle("h4566", "nissan", "1", "another car");
    
        m_bllVehicle.VehicleCreatePerformed(event1);
        m_bllVehicle.VehicleCreatePerformed(event2);
        
        assertEquals(m_bllVehicle.VehicleReadPerformed().get(0).getM_registrationNr(), "c7887");
        assertEquals(m_bllVehicle.VehicleReadPerformed().get(0).getM_brand(), "toyota");
        assertEquals(m_bllVehicle.VehicleReadPerformed().get(0).getM_model(), "2");
        assertEquals(m_bllVehicle.VehicleReadPerformed().get(0).getM_description(), "Nice car");
        
    }

    /**
     * Test of VehicleRemovePerformed method, of class BLLVehicle.
     */
    @Test
    public void testVehicleRemovePerformed() {
        System.out.println("VehicleRemovePerformed");
        BLLVehicle m_bllVehicle = new BLLVehicle(new DALCVehicleTest());
        BEVehicle event1 = new BEVehicle("c7887", "toyota", "2", "Nice car");
        BEVehicle event2 = new BEVehicle("h4566", "nissan", "1", "another car");
        
        m_bllVehicle.VehicleCreatePerformed(event1);
        m_bllVehicle.VehicleCreatePerformed(event2);
        
        m_bllVehicle.VehicleRemovePerformed(event2);
        int expResult = 1;
        int result = m_bllVehicle.VehicleReadPerformed().size();
        
        assertEquals(expResult,result);
        
    }
    

    /**
     * Test of VehicleUpdatePerformed method, of class BLLVehicle.
     */
    @Test
    public void testVehicleUpdatePerformed() {
        System.out.println("VehicleUpdatePerformed");
        BLLVehicle m_bllVehicle = new BLLVehicle(new DALCVehicleTest()); 
        BEVehicle event1 = new BEVehicle("c7887", "toyota", "2", "Nice car");
        BEVehicle updateEvent1 = new BEVehicle("k8977", "toyota", "2", "Nice car");
    
        m_bllVehicle.VehicleCreatePerformed(event1);
        
        m_bllVehicle.VehicleUpdatePerformed(updateEvent1);
        
        assertEquals(m_bllVehicle.VehicleReadPerformed().get(0).getM_registrationNr(), "k8977");
    }

    /**
     * Test of VehicleReadPerformed method, of class BLLVehicle.
     */
    @Test
    public void testVehicleReadPerformed() {

    }
    
}
