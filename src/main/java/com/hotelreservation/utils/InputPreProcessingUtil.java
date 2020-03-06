package com.hotelreservation.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.hotelreservation.models.enumeration.CostumerType;

public class InputPreProcessingUtil {

	static public CostumerType extractCostumerType(String input) {
		if (input == null)
			return null;
		String[] separatedString = input.split(":");

		return separatedString.length == 0 ? null
				: Arrays.asList(CostumerType.values()).stream()
						.filter((value) -> value.name().equalsIgnoreCase(separatedString[0])).findFirst().orElse(null);
	}

	static public List<LocalDate> extractListOfDays(String input) {
		List<LocalDate> dateList = new ArrayList<LocalDate>();

		if (input == null)
			return null;
		String[] separatedString = input.split(":");
		if (separatedString.length > 1) {
			String[] dates = separatedString[1].split(",");

			dateList = Arrays.asList(dates).stream().map((value) -> {
				String[] separetadValue = value.split("\\(");
				return stringToLocalDate(separetadValue[0]);
			}).collect(Collectors.toList());
		}

		return dateList;
	}

	public static LocalDate stringToLocalDate(String stringDate) {
		Pattern numberPattern = Pattern.compile("\\d+");
		Matcher numberMatcher = numberPattern.matcher(stringDate);
		Pattern stringPattern = Pattern.compile("[a-zA-Z]+");
		Matcher stringMatcher = stringPattern.matcher(stringDate);
		
		List<String> numbers = new ArrayList<String>();
		String mounth = stringMatcher.find() ? stringMatcher.group() : null;
		while (numberMatcher.find()) {
			numbers.add(numberMatcher.group());
		}

		return LocalDate.of(Integer.valueOf(numbers.get(1)), getMounthIndex(mounth), Integer.valueOf(numbers.get(0)));
	}

	public static Integer getMounthIndex(String mouth) {
		String[] mounths = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Set", "Oct", "Nov", "Dec" };
		OptionalInt index = IntStream.range(0, mounths.length-1)
				.filter(i -> mouth.equalsIgnoreCase(mounths[i]))
				.findFirst();

		return index.isPresent() ? index.getAsInt() + 1 : null;
	}
	
	public static String getMounthName(Integer mouth) {
		String[] mounths = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Set", "Oct", "Nov", "Dec" };
		return mounths[mouth];
	}
}
