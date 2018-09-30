package com.core;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipOutputStream;

import com.common.Helper;

public class ZipFileCreate {
	public static String creteZipFile() throws IOException {
	String zipfile="Zipfile"+".zip";
	FileOutputStream fos = new FileOutputStream(zipfile);
	ZipOutputStream zos = new ZipOutputStream(fos);
	String file1="./test-output/emailable-report.html";
	String file2= "./Log4j/log4j-application.log";
	String file3= "./test-output/html/index.html";
	String file4= "./test-output/html/suites.html";
	String file5= "./test-output/html/overview.html";
	Helper.addToZipFile(file1, zos);
	Helper.addToZipFile(file2, zos);
	Helper.addToZipFile(file3, zos);
	Helper.addToZipFile(file4, zos);
	Helper.addToZipFile(file5, zos);
	zos.close();
	fos.close();
	return zipfile;
	}

}
