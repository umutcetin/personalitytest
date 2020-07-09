package com.example.personalitytest.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class FileServiceImpl implements FileService {
	public String getResourceString(String path) {
		String contents = null;
		try (InputStream in = getResourceAsStream(path);
		BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
		contents = br.lines().collect(Collectors.joining(System.lineSeparator()));
		} catch (IOException e) {
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

	public void saveToFile(String fileName, String content) throws IOException, FileExistsException {
	    BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
	    writer.write(content);
	    writer.close();
	}
	
	public boolean fileExists(String fileName) {
		File f = new File(fileName);
		if(f.exists() && !f.isDirectory()) { 
		    return true;
		}
		return false;
	}
}
