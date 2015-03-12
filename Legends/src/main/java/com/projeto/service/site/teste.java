package com.projeto.service.site;

import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.Charset;


public class teste {

		public static void main(String[] args) throws Exception {
				
			File files = new File("C:\\TFS\\201505 - Projeto Novo Endosso\\01 - Construção\\Scripts\\teste2");
			
			for (File file : files.listFiles()) {
				FileInputStream fis = new FileInputStream(file);
				
				int cont = 0;
				
				byte[] b = new byte[(int) file.length()];
				fis.read(b);
				fis.close();
				
				StringBuilder st = new StringBuilder();
				st.append(new String(b, Charset.forName("UTF_16LE")).substring(1) + "\n");
				
				if(st.toString().contains("USE MAPFRE_CONNECT")){
					System.out.println(file.getName());
				}
				
			}
		}  
}
