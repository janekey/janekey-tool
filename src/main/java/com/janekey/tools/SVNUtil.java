package com.janekey.tools;

import java.io.File;

public class SVNUtil {
	
	public static void main(String[] args) {
		
		String path = "G:/order";
//		String path = "G:/12321";
		
		
//		File f = new File(path);
//		if(f.canWrite()) {
//			System.out.println("can write");
//		}
//		if(f.getAbsoluteFile().delete()) {
//			System.out.println("delete success");
//		} else {
//			System.out.println("delete faild");
//		}
		
		deleteSVNFolder(new File(path));
		
	}
	
	public static void deleteSVNFolder(File file) {
		
		if(!file.exists()) {
			System.out.println("no file : " + file.getAbsolutePath());
			return;
		}
		
		if(!file.isDirectory()) {
//			System.out.println("not directory : " + file.getAbsolutePath());
			return;
		}
		
//		System.out.println("name" + file.getName());
		if(file.getName().equals(".svn")) {
//			System.out.println("deleting folder " + file.getAbsolutePath());
			if(deleteFolder(file)) {
				System.out.println("delete folder : " + file.getAbsolutePath());
			}
		} else {
			File[] children = file.listFiles();
			if(children != null && children.length > 0) {
				for(File child : children) {
					deleteSVNFolder(child);
				}
			}
		}
	}
	
	public static boolean deleteFolder(File file) {
		boolean returnValue = true;
		
		if(!file.exists()) {
			System.out.println("file not exist : " + file.getAbsolutePath());
			returnValue = false;
		}
		
		if(file.isFile()) {
			if(!file.delete()) {
				returnValue = false;
			}
		} else {
			File[] children = file.listFiles();
			if(children != null && children.length > 0) {
				for(File child : children) {
					deleteFolder(child);
				}
			}
			
			if(!file.delete()) {
				returnValue = false;
			}
		}
		
		return returnValue;
		
	}

}
