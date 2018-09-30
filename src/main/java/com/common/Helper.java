package com.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Helper {
	 public  static void deleteFile(String dirPath, int days, String fileExtension) {
		 
	        File folder = new File(dirPath);
	 
	        if (folder.exists()) {
	 
	            File[] listFiles = folder.listFiles();
	 
	           long eligibleForDeletion = System.currentTimeMillis() -
	               (days * 24 * 60 * 60 * 1000L);
	 
	            for (File listFile: listFiles) {
	 
	                if (listFile.getName().endsWith(fileExtension)&&listFile.lastModified()<eligibleForDeletion) {
	 
	                    if (!listFile.delete()) {
	 
	                        System.out.println("Sorry Unable to Delete Files..");
	 
	                    }
	                }
	            }
	        }
	    }
	 
		public static void addToZipFile(String fileName, ZipOutputStream zos) throws FileNotFoundException, IOException {

			File file = new File(fileName);
			FileInputStream fis = new FileInputStream(file);
			ZipEntry zipEntry = new ZipEntry(fileName);
			zos.putNextEntry(zipEntry);

			byte[] bytes = new byte[1024];
			int length;
			while ((length = fis.read(bytes)) >= 0) {
				zos.write(bytes, 0, length);
			}

			zos.closeEntry();
			fis.close();
		}

}
