package com.hannt.learning.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RegexTest {
    @Test
    public void asteriskPackage(){
        final String packageStr = getClass().getPackage().getName();

        Assertions.assertTrue(packageStr.matches("com.hannt.*.string$"));
    }
}
