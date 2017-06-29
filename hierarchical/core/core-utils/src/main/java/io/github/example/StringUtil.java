package io.github.example;

/**
 * Example utility class to be used as dependency by other modules in project.
 */
public interface StringUtil {
	
	static String reverse(String target) {
		return new StringBuilder(target).reverse().toString();
	}
	
}
