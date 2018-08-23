package com.common;

import java.io.File;

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

}
