package com.basic.http.web.server.principal;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.StringTokenizer;
/**
 * 
 * @author oumina el hassane
 *
 */
public class JavaHTTPServer  implements Runnable{  
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
	private Socket connect ;
	
	public JavaHTTPServer(Socket connect) {
		super();
		this.connect = connect;
	}


	public static void main(String[] args) {
		try {
			ServerSocket serverConnect = new ServerSocket(PORT);
			System.out.println("Server strted .\nListening for connections  on port "+PORT + "....\n");
		//we listening until the user halths the server 
			while(true){
				JavaHTTPServer myServer = new JavaHTTPServer(serverConnect.accept());
				
				if(verbose){
					System.out.println("Connection is opened "+ new Date()+" ");
				}
				
				//Created dedacted thread to manage a client connections
				Thread thread = new  Thread(myServer) ;
				thread.start();
				
			}
		} catch (IOException e) {
			System.err.println("Server Connection error : "+ e.getMessage());
			e.printStackTrace();
		}
	}



	@Override
	public void run() {
		// we manage our particular client connection
				BufferedReader in = null;
				PrintWriter out = null;
				BufferedOutputStream dataOut = null;
				String fileRequested = null;
				
					// we read characters from the client via input stream on the socket
					try {
						// we read characters from the client via input stream on the socket
						in = new BufferedReader(new InputStreamReader(connect.getInputStream()));
						// we get [character output] stream to client (for headers)
						out = new PrintWriter(connect.getOutputStream());
						// get [binary output] stream to client (for requested data)
						dataOut = new BufferedOutputStream(connect.getOutputStream());
						
						// get first line of the request from the client
						String input = in.readLine();
						
						// we parse the request with a string tokenizer
						StringTokenizer parse = new StringTokenizer(input);
						String method = parse.nextToken().toUpperCase(); // we get the HTTP method of the client
						// we get file requested
						fileRequested = parse.nextToken().toLowerCase();
						
						// we support only GET and HEAD methods, we check
						if (!method.equals("GET")  &&  !method.equals("HEAD")) {
							if (verbose) {
								System.out.println("501 Not Implemented : " + method + " method.");
							}
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
		
	}
}