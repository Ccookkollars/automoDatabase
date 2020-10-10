/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.automo;

import com.automo.entity.Claim;

/**
 *
 * @author ylltrazoaar, the always and everywhere
 */
public class SingleClaimPanel extends SingleEntityPanel<Claim>{

    @Override
    String getPanelTitle() {
        return "Claim";
    }

    @Override
    void create(Claim e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void update(Claim e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    Class<Claim> getTypeToken() {
        return Claim.class;
    }

}
