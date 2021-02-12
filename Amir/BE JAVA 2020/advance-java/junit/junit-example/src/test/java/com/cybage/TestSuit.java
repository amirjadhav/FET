package com.cybage;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.ExcludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages("com.cybage")
@ExcludeTags("PROD")   //exclude prod tag test cases
public class TestSuit {

}
