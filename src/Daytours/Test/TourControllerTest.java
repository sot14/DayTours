package Daytours.Test;

import static org.junit.jupiter.api.Assertions.*;

import Daytours.Controller.TourController;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TourControllerTest {
    private  TourController tester;

    @BeforeEach
    public void setUp() {
        tester = new TourController();
    }

    @AfterEach
    public void tearDown() {
        tester = null;
    }

    @Test
    public void searchReturnsTour() {
        assertNotNull(tester.searchTour("Fer"));
    }

    @Test
    public void searchReturnsNoTour() {
        assertEquals("[]",tester.searchTour("p").toString());
    }

    @Test
    public void searchReturnsRightTour() {
        assertEquals("Around the Golden Circle",tester.searchTour("Around the Golden Circle").get(0).toString()); //getName
    }

    @Test
    public void searchInvalidParameter() {
        assertEquals("[]",tester.searchTour("$").toString());
    }


}