package com.coderscampus.teslaanalysis;

import java.io.IOException;

public class Application {

	public static void main(String[] args) throws IOException {
		FileService fileService = new FileService();
		fileService.readFile(fileService.MODEL3_FILE);
	}

}
