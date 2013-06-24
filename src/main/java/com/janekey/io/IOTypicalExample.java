package com.janekey.io;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.*;

public class IOTypicalExample {
	
	/**
	 * Read file, Buffered input file
	 * @param fileName
	 * @return The contents of this file.
	 */
	public static String read(String fileName) throws IOException {
		
		// Reading input.
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		
		String s;
		StringBuilder sb = new StringBuilder();
		while((s = br.readLine()) != null) {
			sb.append(s);
			sb.append("\n");
		}
		br.close();
		return sb.toString();
	}
	
	/**
	 * Read binary file.
	 */
	public static byte[] read(File file) throws IOException {
		
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
		byte[] data = new byte[bis.available()];
		bis.read(data);
		
		return data;
	}
	
	/**
	 * Basic file output: Write a string to a file.
	 * @param fileName
	 * @param outputString
	 */
	public static void write(String fileName, String outputString) throws IOException {
		
		// Write.
		PrintWriter pw = new PrintWriter(fileName);
		
		pw.print(outputString);
		
		pw.close();
	}
	
	/**
	 * Storing and recovering date.
	 * @param fileName
	 */
	public static void storingAndRecoveringData(String fileName) throws IOException {
		
		// DataOutputStream
		DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)));
		
		out.writeDouble(3.14159);
		out.writeUTF("Some string");
		out.writeDouble(1.111);
		out.writeUTF("new String");
		out.close();
		
		// DataInputStream
		DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(fileName)));
		System.out.println(in.readDouble());
		System.out.println(in.readUTF());
		System.out.println(in.readDouble());
		System.out.println(in.readUTF());
		in.close();
	}
	
	/**
	 * Random access file(reading and writing)
	 * @param fileName
	 */
	public static void RandomAccess(String fileName) throws IOException {
		RandomAccessFile rf = new RandomAccessFile(fileName, "rw");
		for(int i=0; i<7; i++) {
			rf.writeDouble(i*1.1414);
		}
		rf.writeUTF("end write");
		rf.close();
		
		RandomAccessFile rf2 = new RandomAccessFile(fileName, "rw");
		rf2.seek(5*8);
		rf2.writeDouble(4.343);
		rf2.close();
		
		// Display
		
	}
	
	/**
	 * Simple compression with GZIP. one file to GZIP.
	 */
	public static void gzipCompress(String fileName) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		BufferedOutputStream out = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream("test.gz")));
		System.out.println("writting file");
		int c;
		while((c = br.read()) != -1)
			out.write(c);
		br.close();
		out.close();
		System.out.println("Write over");
		
		System.out.println("Reading file");
		BufferedReader br2 = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream("test.gz"))));
		String s;
		while((s = br2.readLine()) != null)
			System.out.println(s);
		
	}
	
	public static void zipCompress(String[] fileNames) throws IOException {
		FileOutputStream f = new FileOutputStream("test.zip");
		
		CheckedOutputStream csum = new CheckedOutputStream(f, new Adler32());
		ZipOutputStream zos = new ZipOutputStream(csum);
		BufferedOutputStream out = new BufferedOutputStream(zos);
		
		zos.setComment("a test ");
		for(String fileName : fileNames) {
			System.out.println("writing file : " + fileName);
			
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			zos.putNextEntry(new ZipEntry(fileName));
			int c;
			while((c = br.read()) != -1)
				out.write(c);
			br.close();
			out.flush();
		}
		out.close();
		
		
		FileInputStream fis = new FileInputStream("test.zip");
		CheckedInputStream csumi = new CheckedInputStream(fis, new Adler32());
		ZipInputStream in = new ZipInputStream(csumi);
		BufferedInputStream bis = new BufferedInputStream(in);
		ZipEntry ze;
		while((ze = in.getNextEntry()) != null) {
			int x;
			while((x = bis.read()) != -1)
				System.out.write(x);
			System.out.println("file:" + ze);
		}
		
		bis.close();
		
		ZipFile zf = new ZipFile("test.zip");
		Enumeration<?> e = zf.entries();
		while(e.hasMoreElements()) {
			ZipEntry ze2 = (ZipEntry)e.nextElement();
			System.out.println("file:" + ze2);
			//....
		}
		
	}

}
