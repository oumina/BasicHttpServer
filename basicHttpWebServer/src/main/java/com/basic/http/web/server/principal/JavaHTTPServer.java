package com.basic.http.web.server.principal;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class JavaHTTPServer {
	/**
	 * Server's configuration
	 */
	static final File WEB_ROOT = new File(".");
	static final String DEFAULT_FILE = "index.html";
	static final String FILE_NOT_FOUND = "404.html";
	static final String METHOD_NOT_SUPPORTED = "not_supported.html";
	/**
	 * port to listen connection :
	 */
	static final int PORT = 8080;
	/**
	 * Verbose mode
	 */
	static final boolean verbose = true;
	
	/**
	 * Client connection via Socket class
	 */
	private Socket socket ;
	
	
	public JavaHTTPServer(Socket socket) {
		super();
		this.socket = socket;
	}

	

	public static void main(String[] args) {
		try {
			ServerSocket serverConnect = new ServerSocket(PORT);
			System.out.println("Server strted .\nListening for connections  on port "+PORT + "....\n");
		//we listening
		} catch (IOException e) {
			System.err.println("Server Connection error : "+ e.getMessage());
			e.printStackTrace();
		}
	}
}