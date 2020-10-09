/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.automo;

import java.awt.TextField;
import java.lang.reflect.Method;
import lombok.Data;

/**
 *
 * @author ylltrazoaar, the always and everywhere
 */
@Data
public class InterestingField {

    private final String displayName;
    private final Method getter;
    private final Method setter;
    private final TextField textField;
}
