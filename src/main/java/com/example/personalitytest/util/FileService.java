package com.example.personalitytest.util;

import java.io.IOException;

import org.springframework.stereotype.Component;

@Component
public interface FileService {
	public String getResourceString(String path);
	public void saveToFile(String fileName, String content) throws IOException, FileExistsException;
	public boolean fileExists(String fileName);
}
