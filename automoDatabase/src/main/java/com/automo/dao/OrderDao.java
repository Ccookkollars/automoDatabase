package com.automo.dao;

import com.automo.entity.JobOrder;

public class OrderDao extends BaseEntityDataAccessObject<JobOrder>{

    @Override
    Class<JobOrder> getTypeToken() {
        return JobOrder.class;
    }
}
