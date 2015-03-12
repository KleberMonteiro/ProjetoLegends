package com.projeto.service.site;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;

public class EncodingConverter {
	
	private static final char BYTE_ORDER_MARK = '\uFEFF';

	  public static void main(String[] args) throws IOException {
		  
	    Charset windows1252 = Charset.forName("cp1252");
	    Charset utf8 = Charset.forName("UTF8");
	    
	    
	    File files = new File("C:\\TFS\\201505 - Projeto Novo Endosso\\01 - Construção\\Scripts\\teste2");
	    
	    
	    for (File file : files.listFiles()) {
	    	
	    	InputStream in = new FileInputStream(file);
	    	Reader reader = new InputStreamReader(in, windows1252);
	    	
	    	OutputStream out = new FileOutputStream("C:\\TFS\\201505 - Projeto Novo Endosso\\01 - Construção\\Scripts\\teste3\\" + file.getName());
	    	Writer writer = new OutputStreamWriter(out, windows1252);
	    	writer.write(BYTE_ORDER_MARK);
	    	
	    	char[] buffer = new char[1024];
	    	int read;
	    	while ((read = reader.read(buffer)) != -1) {
	    		writer.write(buffer);
	    		writer.flush();
	    	}
	    }
	  }
}
