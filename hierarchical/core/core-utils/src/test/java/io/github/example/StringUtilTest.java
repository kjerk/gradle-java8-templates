package io.github.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringUtilTest {
	
	@Test
	public void reverse_correctResult() {
		Assertions.assertEquals("!dlroW olleH", StringUtil.reverse("Hello World!"));
		
		Assertions.assertEquals("racecar", StringUtil.reverse("racecar"));
	}
	
}
