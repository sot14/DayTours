package Daytours.Test;

import static org.junit.jupiter.api.Assertions.*;

import Daytours.Controller.TourController;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;


class TourControllerTest {
    private  TourController tester;

    @Before
    public void setUp() {
        tester = new TourController();
    }

    @After
    public void tearDown() {
        tester = null;
    }

    @Test
    public void searchReturnsTour() {
        assertNotNull(tester.searchTour("Fer"));

    }

    @Test
    public void searchReturnsNoTour() {
        assertNull(tester.searchTour("p"));
    }

    @Test
    public void searchInvalidParameter() {
        assertNull(tester.searchTour("$"));
    }


}