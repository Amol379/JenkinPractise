package OOPS;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo {
public static void main(String[] args) {
	Set<String> treeSet = new TreeSet<>(Comparator.comparing(String::length));
	treeSet.addAll((Collection<? extends String>) Arrays.asList("amol","sanjay","ram"));
	System.out.println(treeSet);
}
}
