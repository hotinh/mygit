package impatient4java8.chapter01;

import java.io.*;
import java.util.*;
import java.util.Arrays;

public class Unit00 {

	public static void main(String[] args) {
		
		File f = new File("E:\\test");
		System.out.println(f.getName());
		
		// java 8 before
		File[] fs1 = f.listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				if (pathname.isDirectory()) 
					return true;
				else
					return false;
			}
		});
		Arrays.asList(fs1).forEach(System.out :: println);
		
		// java8 after
		File[] fs2 = f.listFiles((File pathname) -> pathname.isDirectory());
//		File[] fs2 = f.listFiles(e -> e.isDirectory());
//		File[] fs2 = f.listFiles(File :: isDirectory);
		
		Arrays.asList(fs2).forEach(System.out :: println);
		
		
		String[] ss1 = f.list(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				if (dir.getName().equals("test") && name.endsWith(".txt"))
					return true;
				else
					return false;
			}
		});
		Arrays.asList(ss1).forEach(System.out :: println);
		
		String[] ss2 = f.list((File dir, String name) -> dir.getName().equals("") && name.endsWith(".txt"));
	}

}
