package practice.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleRegex {

	public static void main(String[] args) {
		/***** Plain Match ******/
		String patternString = "[a-z]*";
		Pattern pattern = Pattern.compile(patternString);
		String sourceString = "ablcl";
		Matcher matcher = pattern.matcher(sourceString);
		System.out.println(matcher.matches());
		
		/***** IP address Match ******/
		String patternForIpAddress = "^(?:[0-9]{1,3}\\.){3}[0-9]{1,3}$";
		Pattern ipAddressPattern = Pattern.compile(patternForIpAddress);
		String ipAddress = "120.111.250.169";
		Matcher ipAddressMatcher = ipAddressPattern.matcher(ipAddress);
		System.out.println(ipAddressMatcher.matches());
		
		/***** string match address Match ******/
		//String dotMatcher = "([a-zA-Z0-9!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]{3})"+"\\."+"([a-zA-Z0-9!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]{3})"+"\\."+"([a-zA-Z0-9!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]{3})"+"\\."+"([a-zA-Z0-9!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]{3})";
		String pattern2 =    "([a-zA-Z0-9!`@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,\\.<>\\/?]{0,3})\\.([a-zA-Z0-9!`@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,\\.<>\\/?]{3})\\.([a-zA-Z0-9!`@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,\\.<>\\/?]{3})\\.([a-zA-Z0-9!`@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,\\.<>\\/?]{3})";
		System.out.println(pattern2);
		Pattern dotMatcherPattern = Pattern.compile(pattern2);
		String dottedString = "...";
		Matcher dottedMatcher = dotMatcherPattern.matcher(dottedString);
		System.out.println(dottedMatcher.matches());
		
		
		/***** IP address Match ******/
		//String dotMatcher = "([a-zA-Z0-9!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]{3})"+"\\."+"([a-zA-Z0-9!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]{3})"+"\\."+"([a-zA-Z0-9!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]{3})"+"\\."+"([a-zA-Z0-9!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]{3})";
		String pattern3 =    "([a-zA-Z0-9!`@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]{0,3})\\.([a-zA-Z0-9!`@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]{0,3})\\.([a-zA-Z0-9!`@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]{0,3})\\.([a-zA-Z0-9!`@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]{0,3})";
		// System.out.println(pattern3);
		Pattern dotMatcherPattern2 = Pattern.compile(pattern3);
		String dottedString2 = "...";
		Matcher dottedMatcher2 = dotMatcherPattern2.matcher(dottedString2);
		System.out.println(dottedMatcher2.matches());
	}
}
