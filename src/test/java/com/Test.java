package com;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
	
	public static void main(String...s) {
		List<Integer> li=new ArrayList<>();
		li.add(1);
		li.add(2);
		li.add(3);

	//String listString = String.join(", ", li);
	String listString = li.stream().map(Object::toString)
            .collect(Collectors.joining(", "));
	System.out.println(li.toString());
	System.out.println(listString);

}
}