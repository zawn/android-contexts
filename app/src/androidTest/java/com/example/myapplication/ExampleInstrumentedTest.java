package com.example.myapplication;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.net.HttpCookie;

import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        System.out.println("ExampleInstrumentedTest.useAppContext");
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        System.out.println("Main.main");
        boolean matches = HttpCookie.domainMatches("google.com", "www.google.com");
        System.out.println(matches);

        assertEquals("com.example.myapplication", appContext.getPackageName());
    }
}
