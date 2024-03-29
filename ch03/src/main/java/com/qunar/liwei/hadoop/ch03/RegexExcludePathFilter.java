package com.qunar.liwei.hadoop.ch03;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.PathFilter;

public class RegexExcludePathFilter implements PathFilter {
	
	private final String regex;
	
	public RegexExcludePathFilter(String regex) {
		this.regex = regex;
	}
	
	public boolean accept(Path path) {
		return !path.toString().matches(regex);
	}
}
