/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.automo;

import java.awt.TextField;
import java.util.function.BiConsumer;
import java.util.function.Function;
import lombok.Data;

/**
 *
 * @author ylltrazoaar, the always and everywhere
 */
@Data
public class InterestingField {

    private final Class<?> typeToken;
    private final String displayName;
    private final Function getter;
    private final BiConsumer setter;
    private final TextField textField;
}
