package exercices;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class LexicograficOrder {
	
	final static String regex = ".*[0-9].*";
	
	static Comparator<String> comparator = new Comparator<String>() {
		@Override
		public int compare(String i1, String i2) {
			//makes lexicographically compare strings
			int value = i1.compareTo(i2);
			if (value == 0) {
				// if comparison of string ties, the ID should be used as a backup sort
	        	int subValue1 =  Integer.parseInt(i1.substring(0, i1.indexOf(" ")));
	        	int subValue2 =  Integer.parseInt(i2.substring(0, i2.indexOf(" ")));
	        	
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
	
//	public static List<String> stringCompare(String[] documentList) {
//		List<String> strWithValues = new ArrayList<>();
//		List<String> strWithoutValues = new ArrayList<>();
//		for(String value: Arrays.asList(documentList)) {
//			String substringValue = value.substring(0, value.indexOf(" "));
//			if(substringValue.matches(regex)){
//				System.out.println("The String contains an int");  
//				strWithValues.add(value);
//			}else {
//				System.out.println("The String dont contains an int");  
//				strWithoutValues.add(value);
//			}
//		}
//		strWithValues.stream().sorted().collect(Collectors.toList());
//		strWithoutValues.stream().sorted().collect(Collectors.toList());
//		
//		strWithValues.addAll(strWithoutValues);
//		return strWithValues;
//	}
//	
//	private static List<String> orderDocuments(String[] documentList){
//		for (int i = 0; i < documentList.length - 1; i++) {
//            for (int j = i + 1; j < documentList.length; j++) {
//            	int value = documentList[i].compareTo(documentList[j]);
//            	// if string is bigger, swap the string positions
//                if (value > 0) {
////                	System.out.println("str1 is greater than str2");
//                	
//                    // if our outer string is lexicographically bigger, swap the string positions
//                    String swap = documentList[i];
//                    documentList[i] = documentList[j];
//                    documentList[j] = swap;
//                }
//				else if (value == 0) {
//					System.out.println("str1 is equal to str2");
//				}
//            }
//        }
//		
//		return Arrays.asList(documentList);
//    }

    public static void main(String[] args) {
//        String[] documentList = {"zld 93 12", "fp alpha xls", "125 echo doc", "17g 122252", "563 alpha omx", "120 echo doc"};
    	String[] documentList = {"zld 93 12", "fp alpha xls", "125 echo doc", "17g 122252", "563 alpha omx", "120 echo doc"};
//        System.out.println(orderDocuments(documentList));
        System.out.println(orderJavaStream(documentList));
    }
}
