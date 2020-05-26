/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.automo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 */
public class SingleCustomerPanel extends SingleEntityPanel<Customer> {

    @Override
    public String getPanelTitle() {
        return "Customer";
    }
    @Override
    public Set<String> getFieldNames() {
        return new HashSet<>(Arrays.asList("fieldName1", "fieldTwoName"));
    }
}
