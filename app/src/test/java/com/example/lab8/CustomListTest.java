package com.example.lab8;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


//import org.junit.Before;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {


    private CustomList list;

    @Before
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }
    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     plus one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    @Test
    public void testHasCity() {
        list = MockCityList();
        assertFalse(list.hasCity("Estevan")); // Initially, the list should not have the city
        list.addCity(new City("Estevan", "SK"));
        assertTrue(list.hasCity("Estevan")); // After adding, the list should have the city
    }

    @Test
    public void testDeleteCity() {
        list.addCity(new City("Estevan", "SK"));
        assertTrue(list.hasCity("Estevan"));
        list.deleteCity("Estevan");
        assertFalse(list.hasCity("Estevan"));
    }


}
