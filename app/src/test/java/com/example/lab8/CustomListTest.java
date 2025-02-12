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
        City city1 = new City("Test1", "Test2");
        list.addCity(city1);
        assertTrue(list.hasCity(city1));
    }

    @Test
    public void testDeleteCity() {
        list = MockCityList();
        City city2 = new City("City2", "Province2");
        list.addCity(city2);
        assertTrue(list.hasCity(city2)); // City2 should exist before deletion
        list.deleteCity(city2);
        assertFalse(list.hasCity(city2)); // City2 should not exist after deletion
    }

    @Test
    public void testCityCount(){
        list = MockCityList();
        assertEquals(0, list.countCities());
        list.addCity(new City("City2", "Province2"));
        list.addCity(new City("City1", "Province1"));
        assertEquals(2, list.countCities());
    }

}
