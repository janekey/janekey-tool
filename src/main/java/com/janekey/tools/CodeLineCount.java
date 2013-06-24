package com.janekey.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;

/**
 * 查询文件夹中代码的总行数
 * 
 * @author Zheng.Qi
 * 
 */
public class CodeLineCount {

	public static long lineCount = 0;
	
	public static void main(String[] arg) {
//		noRecursive("G:/workspace_eclipse/cisp/src");
//		noRecursive("G:/workspace_eclipse/cisp/common");
		
		recursive("G:/workspace_eclipse/cisp/src");
		recursive("G:/workspace_eclipse/cisp/common");
		System.out.println("总行数:"+lineCount);
	}

	/**
	 * 无递归方法
	 * TODO
	 */
	public static void noRecursive(String path) {
		LinkedList<File> list = new LinkedList<File>();
		File dir = new File(path);
		File file[] = dir.listFiles();
		for (int i = 0; i < file.length; i++) {
			if (file[i].isDirectory())
				list.add(file[i]);
			else
				try {
					lineCount(file[i]);
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		File tmp;
		while (!list.isEmpty()) {
			tmp = list.removeFirst();
			if (tmp.isDirectory()) {
				file = tmp.listFiles();
				if (file == null)
					continue;
				for (int i = 0; i < file.length; i++) {
					if (file[i].isDirectory())
						list.add(file[i]);
					else
						try {
							lineCount(file[i]);
						} catch (IOException e) {
							e.printStackTrace();
						}
				}
			} else {
				try {
					lineCount(tmp);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 递归方法
	 * @param path
	 * @return
	 */
	public static void recursive(String strPath) {
		File file = new File(strPath);
		if(file.isDirectory()) {
			File[] listfiles = file.listFiles();
			for(File f : listfiles) {
				if(f.isDirectory()) {
					recursive(f.getAbsolutePath());
				} else {
					try {
						lineCount(f);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		} else {
			try {
				lineCount(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 计算文件行数
	 * @param file
	 * @throws java.io.IOException
	 */
	public static void lineCount(File file) throws IOException {
		FileInputStream fis = new FileInputStream(file);
		int b = 0;
		while((b = fis.read()) != -1) {
			if(b == 10) {
				lineCount++;
			}
		}
	}
}
