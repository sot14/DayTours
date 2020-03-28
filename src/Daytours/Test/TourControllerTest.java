package Daytours.Test;

import static org.junit.jupiter.api.Assertions.*;

import Daytours.Controller.TourController;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;


class TourControllerTest {
    private  TourController tester,testerNull;

    @Before
    public void setUp() {
        tester = new TourController();
        testerNull = new TourController();
    }

    @After
    public void tearDown() {
        tester = null;
        testerNull = null;
    }

    @Test
    public void searchReturnsTour() {
        assertNotNull(tester.searchTour("Fer"));

    }

    @Test
    public void searchReturnsNoTour() {
        assertNotNull(testerNull.searchTour("p"));
    }

    @Test
    public void searchInvalidParameter() {
        assertNotNull(testerNull.searchTour("$"));
    }


}