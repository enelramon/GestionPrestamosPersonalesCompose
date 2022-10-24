package com.sagrd.prestamosapp

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.sagrd.prestamosapp", appContext.packageName)
    }


}

@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest2 {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun Componet_test() {
        /*composeTestRule.setContent {
            MyContent()
        }
        composeTestRule.onNodeWithTag("First Button").performClick()
        composeTestRule.onNodeWithTag("Second Button").assertIsDisplayed()*/
    }
}

/*

@RunWith(AndroidJUnit4::class)
class CounterTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun counter_initially_zero(){
        val text = composeTestRule.activity.getString(R.string.count_is, 0)
        composeTestRule.onNodeWithText(text).assertExists()
    }

    @Test
    fun click_incrementsCounter(){
        val incrementCountText = composeTestRule.activity.getString(R.string.increment_count)
        composeTestRule.onNodeWithText(incrementCountText).performClick()

        val text = composeTestRule.activity.getString(R.string.count_is, 1)
        composeTestRule.onNodeWithText(text ).assertExists()
    }

}*/
