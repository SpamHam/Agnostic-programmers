/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DALC;

import BE.BEVehicle;
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
public class DALCVehicleTest implements IDALCVehicle {
    static ArrayList<BEVehicle> allVehicles = new ArrayList<>();
    public DALCVehicleTest() {  
    }
    
    @BeforeClass
    public static void setUpClass() {
       BEVehicle e = new BEVehicle("c7887", "toyota", "2", "Nice car");
       BEVehicle f = new BEVehicle("h4566", "nissan", "1", "another car");
       allVehicles.add(e);
       allVehicles.add(f);
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
     * Test of Create method, of class DALCVehicle.
     */
//    @Test
//    public void testCreate() throws Exception {
//        System.out.println("Create");
//        BEVehicle e = null;
//        DALCVehicle instance = new DALCVehicle();
//        instance.Create(e);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of read method, of class DALCVehicle.
     */
//    @Test
//    public void testRead() throws Exception {
//        System.out.println("read");
//        DALCVehicle instance = new DALCVehicle();
//        ArrayList<BEVehicle> expResult = null;
//        ArrayList<BEVehicle> result = instance.read();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of update method, of class DALCVehicle.
     */
//    @Test
//    public void testUpdate() throws Exception {
//        System.out.println("update");
//        BEVehicle u = null;
//        DALCVehicle instance = new DALCVehicle();
//        instance.update(u);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of Delete method, of class DALCVehicle.
     */
//    @Test
//    public void testDelete() throws Exception {
//        System.out.println("Delete");
//        BEVehicle e = null;
//        DALCVehicle instance = new DALCVehicle();
//        instance.Delete(e);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of VehicleCreatePerformed method, of class DALCVehicle.
     */
//    @Test
//    public void testVehicleCreatePerformed() {
//        System.out.println("VehicleCreatePerformed");
//        BEVehicle event = null;
//        DALCVehicle instance = new DALCVehicle();
//        instance.VehicleCreatePerformed(event);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of VehicleRemovePerformed method, of class DALCVehicle.
     */
//    @Test
//    public void testVehicleRemovePerformed() {
//        System.out.println("VehicleRemovePerformed");
//        BEVehicle event = null;
//        DALCVehicle instance = new DALCVehicle();
//        instance.VehicleRemovePerformed(event);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of VehicleUpdatePerformed method, of class DALCVehicle.
     */
//    @Test
//    public void testVehicleUpdatePerformed() {
//        System.out.println("VehicleUpdatePerformed");
//        BEVehicle event = null;
//        DALCVehicle instance = new DALCVehicle();
//        instance.VehicleUpdatePerformed(event);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of VehicleReadPerformed method, of class DALCVehicle.
     */
//    @Test
//    public void testVehicleReadPerformed() {
//        System.out.println("VehicleReadPerformed");
//        DALCVehicle instance = new DALCVehicle();
//        ArrayList<BEVehicle> expResult = null;
//        ArrayList<BEVehicle> result = instance.VehicleReadPerformed();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    @Test
    @Override
    public void VehicleCreatePerformed(BEVehicle event) {
        System.out.println("VehicleCreatePerformed");
        //BEVehicle v = null;
        //DALCVehicle instance = new DALCVehicle();
        int expResult = allVehicles.size() + 1;      
        allVehicles.add(event);
        int result = allVehicles.size();
        System.out.println("registerings: " + event.getM_registrationNr());
        System.out.println("Brand: " + event.getM_brand());
        System.out.println("Model: " + event.getM_model());
        System.out.println("Description: " + event.getM_description());
        assertEquals(expResult, result);
    }

    @Test
    @Override
    public void VehicleRemovePerformed(BEVehicle event) {
        System.out.println("VehicleRemovePerformed");
        System.out.println("registerings: " + event.getM_registrationNr());
        System.out.println("Brand: " + event.getM_brand());
        System.out.println("Model: " + event.getM_model());
        System.out.println("Description: " + event.getM_description());
         int expResult = allVehicles.size() - 1;
         allVehicles.remove(event);
         int result = allVehicles.size();
         assertEquals(expResult, result);
    }
    
    @Test
    @Override
    public void VehicleUpdatePerformed(BEVehicle event) {
        System.out.println("VehicleUpdatePerformed");
        int expResult = allVehicles.size();
        allVehicles.set(allVehicles.indexOf(event), event);
        int result = allVehicles.size();
        System.out.println("registerings: " + allVehicles.get(allVehicles.indexOf(event)).getM_registrationNr());
        System.out.println("Brand: " + allVehicles.get(allVehicles.indexOf(event)).getM_brand());
        System.out.println("Model: " + allVehicles.get(allVehicles.indexOf(event)).getM_model());
        System.out.println("Description: " + allVehicles.get(allVehicles.indexOf(event)).getM_description());
        assertEquals(expResult, result);
    }

    @Override
    public ArrayList<BEVehicle> VehicleReadPerformed() {
        return allVehicles;
    }
    
}
