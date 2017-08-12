package com.sebcarss.home;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

/**
 * Created by sebcarss on 12/08/2017.
 */
@RunWith(JUnit4.class)
public class HomepageTest {

    public static final String SEBCARSS_COM = "sebcarss.com";
    private Homepage homepage;

    @Before
    public void setUp() {
        homepage = new Homepage();
    }

    @Test
    public void givenHomepageIsAccessedThenShowTitleAsSebCarssDotCom() {
        String title = homepage.home();
        assertEquals(SEBCARSS_COM, title);
    }
}
