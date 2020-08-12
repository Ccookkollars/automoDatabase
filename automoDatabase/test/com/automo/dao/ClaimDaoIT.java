/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.automo.dao;

import java.util.Random;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;

/**
 *
 * @author netbeans, I just did the clicky
 */
@ExtendWith(ClaimDaoIT.TestMod.class)
public class ClaimDaoIT {
    
    
    private static ClaimDao instance;
    
    public ClaimDaoIT() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        instance = new ClaimDao();
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of findClaim method, of class ClaimDao.
     */
    @Test
    public void testFindClaim() throws Exception {
        String firstName = "Lizeth";
        String vehicleYear = "2013";
        String vehicleMake = "honda";
        String vehicleModel = "accord";
        int[] expResult = new int[]{1, 1, 3};
        int[] result = instance.findClaim(firstName, vehicleYear, vehicleMake, vehicleModel);
        assertArrayEquals(expResult, result);
    }
    /**
     * Test of findClaim method, of class ClaimDao.
     */
    @Test
    public void testFindClaim_garbage() {
        Random rand = new Random(1l);
        String firstName = UUID.randomUUID().toString();
        String vehicleYear = rand.nextInt(99999) +"";
        String vehicleMake = UUID.randomUUID().toString();
        String vehicleModel = UUID.randomUUID().toString();
        assertThrows(RuntimeException.class, () -> 
                instance.findClaim(firstName, vehicleYear, vehicleMake, vehicleModel));
    }

    public static class TestMod implements BeforeTestExecutionCallback, AfterTestExecutionCallback{
        private static final Logger LOG = Logger.getLogger(TestMod.class.getSimpleName());
                
        final String flatString = "____________";
        @Override
        public void beforeTestExecution(ExtensionContext context) throws Exception {
            context.getTestMethod().ifPresent(m-> LOG.log(Level.INFO,flatString + "{}" + flatString, m.getName()));
        }

        @Override
        public void afterTestExecution(ExtensionContext context) throws Exception {
            LOG.info(" " + flatString);
        }
        
    }
}
