package exercices;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class LexicograficOrder {
    
	final static String regex = "[0-9]+";

	static Comparator<String> comparator = new Comparator<String>() {
		@Override
		public int compare(String i1, String i2) {
			String metadata1 = i1.substring(i1.indexOf(" "), i1.length());
			String metadata2 = i2.substring(i1.indexOf(" "), i2.length());
			// makes lexicographically compare strings
			int value = metadata1.compareTo(metadata2);
			if (value == 0) {
				// if comparison of string ties, the ID should be used as a backup sort
				int subValue1 = Integer.parseInt(i1.substring(0, i1.indexOf(" ")));
				int subValue2 = Integer.parseInt(i2.substring(0, i2.indexOf(" ")));

				return subValue1 - subValue2;
			} else {
				// if string is lexicographically bigger or smaller, we sorted the string
				return value;
			}
		}
	};
	
    public static List<String> orderJavaStream(String[] documentList) {
		Locale ENGLISH = Locale.forLanguageTag("en");
		
		//Separate newIdentifiers
		List<String> newIdentifiers = Arrays.asList(documentList).stream()
				.filter(f -> f.substring(0, f.indexOf(" ")).matches(regex)
						&& f.equals(f.toLowerCase(ENGLISH)))
				.sorted(comparator)
				.collect(Collectors.toList());
		
		//Separate oldIdentifiers
		List<String> oldIdentifiers = Arrays.asList(documentList).stream()
				.filter(f -> !f.substring(0, f.indexOf(" ")).matches(regex)
						&& f.equals(f.toLowerCase(ENGLISH)))
				.collect(Collectors.toList());
		
		newIdentifiers.addAll(oldIdentifiers);
		return newIdentifiers;
	}

    public static void main(String[] args) {
    	String[] documentList = {"zld 93 12", "fp alpha xls", "125 echo doc", "17g 122252", "563 alpha omx", "120 echo doc"};
        System.out.println(orderJavaStream(documentList));
    }
}
