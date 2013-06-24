package com.janekey.tools;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FindCode {

	public static List<File> pomFiles = new ArrayList<File>();
	
	public static void main(String[] args) {
		recursive("E:/dajie/trunk");
		
		try {
			for (File f : pomFiles) {
				System.out.println(f.getAbsolutePath());
//				BufferedReader br = new BufferedReader(new FileReader(f));
//				
//				PrintWriter pw = new PrintWriter(new FileWriter(new File("E:/log.log"), false));
//				System.out.println(f.getAbsolutePath() + " reading");
////				pw.println(f.getAbsolutePath());
//				String line = null;
//				int count = 0;
//				while ((line = br.readLine()) != null) {
//					count++;
////					if(line.contains("1.9.5")) {
//					if(line.contains("tb_user_detail")) {
//						pw.println(f.getAbsolutePath() + "===================================" + count);
//						System.out.println(f.getAbsolutePath() + "===================================" + count);
//					}
//				}
//				
//				br.close();
//				pw.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void recursive(String strPath) {
		File file = new File(strPath);
		if(file.isDirectory() && !file.getName().equals(".svn")) {
			File[] listfiles = file.listFiles();
			for(File f : listfiles) {
				recursive(f.getAbsolutePath());
			}
		} else if (file.isFile() && (file.getName().contains("Jedis") 
									|| file.getName().contains("jedis")
									|| file.getName().contains("Redis")
									|| file.getName().contains("redis"))
									&& file.getName().endsWith("java")) {
			pomFiles.add(file);
		}
	}
	
}
