/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.automo.dao;

import com.automo.entity.Claim;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    private static final Logger LOG = LogManager.getLogger(ClaimDaoIT.class);

    private static ClaimDao instance;

    public ClaimDaoIT() {
        instance = new ClaimDao();
    }

    @BeforeAll
    public static void setUpClass() {
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
        String vehicleYear = "2011";
        String vehicleMake = "honda";
        String vehicleModel = "accord";
        int[] expResult = new int[]{3, 1, 1};
        Object[] result = instance.findClaim(firstName, vehicleYear, vehicleMake, vehicleModel);
        assertTrue(result != null);
    }

    /**
     * Test of findClaim method, of class ClaimDao.
     */
    @Test
    public void testFindClaim_garbage() throws Exception {
        Random rand = new Random(1l);
        String firstName = UUID.randomUUID().toString();
        String vehicleYear = rand.nextInt(99999) + "";
        String vehicleMake = UUID.randomUUID().toString();
        String vehicleModel = UUID.randomUUID().toString();
        assert(null == instance.findClaim(firstName, vehicleYear, vehicleMake, vehicleModel));
    }

    /**
     * Test of findClaim method, of class ClaimDao.
     */
    @Test
    public void testFindClaim_1() {
        Claim claim = instance.findById(3);
        assert(claim != null);
    }

    /**
     * Test of findClaim method, of class ClaimDao.
     */
    @Test
    public void testFindClaims_() {
        List<Claim> claims = instance.findAll();
        assert(!claims.isEmpty());
        LOG.info(String.join(":", Lists.transform(claims, Claim::toString)));
    }
    
    public static class TestMod implements BeforeTestExecutionCallback, AfterTestExecutionCallback {

        private static final Logger LOG = LogManager.getLogger(TestMod.class);

        final String flatString = "____________";

        @Override
        public void beforeTestExecution(ExtensionContext context) throws Exception {
            context.getTestMethod().ifPresent(m -> LOG.info(flatString + "{}" + flatString, m.getName()));
        }

        @Override
        public void afterTestExecution(ExtensionContext context) throws Exception {
            LOG.info(" " + flatString);
        }
    }

}
