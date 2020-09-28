/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.automo.dao;

import DBConnector.DBConnector;
import com.automo.entity.Vehicle;

/**
 *
 */
public class BasicDataAccessObject {
    
    protected final DBConnector connection;

    public BasicDataAccessObject() {
        connection = new DBConnector();
    }
}
