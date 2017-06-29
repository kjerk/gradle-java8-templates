package io.github.example;

import java.util.HashMap;
import java.util.Map;

import jodd.json.JsonSerializer;

/**
 * Example application composing together multiple flexible dependency sources.
 */
public class ExampleApp {
	
	public static void main(String[] args) {
		final String msg = "Hello World!";
		final Map<String, String> messageMap = new HashMap<>();
		
		messageMap.put(msg, StringUtil.reverse(msg)); // Utility from core-utils
		
		System.out.println(
			new JsonSerializer().serialize(messageMap) // Utility from flat jar
		);
	}
	
}
