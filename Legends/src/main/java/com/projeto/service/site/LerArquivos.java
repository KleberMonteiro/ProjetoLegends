package com.projeto.service.site;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class LerArquivos {

	
	public static void main(String[] args) {
		
		File files = new File("C:\\TFS\\201411 - V.Novembro - RE_Scripts\\FBR17856769\\01 - Construção\\Scripts\\02 - Procedures");
		File log = new File("C:\\TFS\\201411 - V.Novembro - RE_Scripts\\FBR17856769\\01 - Construção\\Scripts\\02 - Procedures\\log.txt");
		
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		DataInputStream dis = null;
		
		for (File file : files.listFiles()) {
		System.out.println(file.getName());
			try {
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				dis = new DataInputStream(bis);
	 
				while (dis.available() != 0) {
					String a = dis.readLine();
					
					System.out.println("===================>" + a);
					
					if(a.contains("1651403") || a.contains("1651404") || a.contains("100427")){
						
						System.out.println("===================>" + file.getName());
						if (!log.exists()) {
							log.createNewFile();
						}
			 
						FileWriter fw = new FileWriter(log.getAbsoluteFile());
						BufferedWriter bw = new BufferedWriter(fw);
						bw.write(file.getName());
						bw.close();
						
					}
				}
	 
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					fis.close();
					bis.close();
					dis.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			
		}
	}
	}
}
