package com.example.personalitytest.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class FileService {
	public String getResourceString(String path) {
		String contents = null;
		try (InputStream in = getResourceAsStream(path);
		BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
		contents = br.lines().collect(Collectors.joining(System.lineSeparator()));
		} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		return contents;
	}
	
	private InputStream getResourceAsStream(String resource) {
		final InputStream in = getContextClassLoader().getResourceAsStream(resource);
		return in == null ? getClass().getResourceAsStream(resource) : in;
	}

	private ClassLoader getContextClassLoader() {
		return Thread.currentThread().getContextClassLoader();
	}

	public void saveToFile(String fileName, String content) throws IOException {
		File f = new File(fileName);
		if(f.exists() && !f.isDirectory()) { 
		    System.out.println("File exists.");
		}
	    BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
	    writer.write(content);
	    writer.close();
	}
}
