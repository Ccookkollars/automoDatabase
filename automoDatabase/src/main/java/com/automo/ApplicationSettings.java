/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.automo;

import com.automo.entity.Claim;
import com.automo.entity.Contact;
import com.automo.entity.Vehicle;
import java.awt.TextField;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import javax.persistence.Column;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 */
public class ApplicationSettings {
    private static final Logger LOG = LogManager.getLogger(ApplicationSettings.class);
    Boolean isReallyNice = true;
    Map<Class, List<String>> fieldNames = new HashMap<>();
    Map<Class, List<String>> fieldIgnores = new HashMap<>();
    
    public ApplicationSettings() {
        configureFields();
    }
    
    /*
    * Explicitly define the expected fields for each entity
    * Explicitly define the fields we want to ignore on each entity
    */
    private void configureFields(){

        fieldIgnores.put(Contact.class, Arrays.asList("id"));
        fieldNames.put(Contact.class, Arrays.asList(
            "firstName",
            "lastName",
            "phoneNumber",
            "emailAddress",
            "streetAddress"));
        
        fieldIgnores.put(Vehicle.class, Arrays.asList("id"));
        fieldNames.put(Vehicle.class, Arrays.asList(
            "plate",
            "make",
            "model",
            "yearManufactured",
            "color",
            "vin"));

        fieldIgnores.put(Claim.class, Arrays.asList("id"));
        fieldNames.put(Claim.class, Arrays.asList(
            "claimStatus",
            "claimNumber",
            "dateClaimIn",
            "dateClaimOut",
            "dateRentalCarStart",
            "dateRentalCarEnd"));

    }

    public List<InterestingField> getInterestingFieldsFor(Class clazz){
        List<InterestingField> result = new ArrayList<>();
        List<InterestingField> inspected = useReflectionBullshit(clazz);
        List<String> configured = fieldNames.getOrDefault(clazz, new ArrayList<>());
        List<String> ignored = fieldIgnores.getOrDefault(clazz, new ArrayList<>());
        
        // Remove fields that are to be ignored, even though we found them through reflection voodoo
        for (String name : ignored) {
            inspected.removeIf(ifield -> ifield.getDisplayName().equalsIgnoreCase(name));
        }
        
        // Use the list of expected fields, by filling up the result list
        a: for (String name : configured) {
            for (InterestingField i : inspected) {
                if (i.getDisplayName().equalsIgnoreCase(name)) {
                    result.add(i);
                    inspected.remove(i);
                    continue a;
                }
            }
            // this means the expected field was not present by reflection
            throw new IllegalStateException("Could not inspect InterestingField for configured property " + name);
        }
        
        // a nice reminder that you haven't configured all fields yet
        for (InterestingField i : inspected) {
            LOG.warn("Property {} not successfully configured for class {}", i.getDisplayName(), clazz.getSimpleName());
        }
        
        return result;
    }

    public List<InterestingField> useReflectionBullshit(Class clazz){
        
        Set<InterestingField> interestingFields = new HashSet<>();
        while (clazz != null) {
            // Search fields for column annotations
            for (Field field : clazz.getDeclaredFields()) {
                if (!field.isAnnotationPresent(Column.class)) {
                    continue;
                }
                // Search methods for matching getter name
                Method getter = getGetter(field.getName(), clazz);
                Method setter = getSetter(field.getName(), clazz);
                if (getter != null && setter   != null) {
                    interestingFields.add(new InterestingField(field.getName(), getter, setter, new TextField()));
                }
                
            }
            clazz = clazz.getSuperclass();
        }
        return new ArrayList<>(interestingFields);
    }
    
    Method getGetter(String fieldName, Class clazz){
        for (Method m : clazz.getDeclaredMethods()) {
            if (m.getName().toLowerCase().contains("get")
                    && m.getName().toLowerCase().contains(fieldName.toLowerCase())) {
                return m;
            }
        }
        return null;
    }

    Method getSetter(String fieldName, Class clazz){
        for (Method m : clazz.getDeclaredMethods()) {
            if (m.getName().toLowerCase().contains("set")
                    && m.getName().toLowerCase().contains(fieldName.toLowerCase())) {
                return m;
            }
        }
        return null;
    }

}
