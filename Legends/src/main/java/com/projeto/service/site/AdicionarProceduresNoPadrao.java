package com.projeto.service.site;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class AdicionarProceduresNoPadrao {

public static void main(String[] args) throws Exception{
		
		StringBuilder inicio = new StringBuilder();
		
		inicio.append("USE MAPFRE_CONNECT \r\n");
		inicio.append("BEGIN TRAN \r\n");
		inicio.append("GO \r\n");
		inicio.append("SET NUMERIC_ROUNDABORT OFF \r\n");
		inicio.append("GO \r\n");
		inicio.append("SET XACT_ABORT OFF \r\n");
		inicio.append("GO \r\n");
		inicio.append("SELECT GETDATE(),DB_NAME(),USER_NAME(), SUSER_NAME(), @@SERVERNAME \r\n");
		inicio.append("GO \r\n");
		inicio.append("IF EXISTS (SELECT 1 FROM sysobjects WHERE name = '*&*' AND xtype = 'P') \r\n");
		inicio.append("BEGIN \r\n");
		inicio.append("PRINT 'INICIO - Drop Procedure ''dbo.*&*''' \r\n");
		inicio.append("DROP PROCEDURE dbo.*&* \r\n");
		inicio.append("PRINT 'FINAL - Drop Procedure ''dbo.*&*'' ' \r\n");
		inicio.append("END \r\n");
		inicio.append("ELSE \r\n");
		inicio.append("PRINT 'Nao existe a procedure ''dbo.*&*'' na base de dados.' \r\n");
		inicio.append("GO \r\n");
		inicio.append("PRINT 'INICIO - Criacao da procedure ''dbo.*&*'' na base de dados.' \r\n");
		inicio.append("GO \r\n");
		inicio.append("\r\n");
		
		StringBuilder fim = new StringBuilder();
		fim.append("SET NOCOUNT OFF \r\n");
		fim.append("GO \r\n");
		fim.append("PRINT 'FINAL - Criacao da procedure ''dbo.*&*'' na base de dados.' \r\n");
		fim.append("GO \r\n");
		fim.append("COMMIT TRAN \r\n");
		fim.append("GO \r\n");
		fim.append("IF @@trancount <> 0 \r\n");
		fim.append("BEGIN \r\n");
		fim.append("DECLARE @MENSAGEM VARCHAR(100) \r\n");
		fim.append("SET @MENSAGEM = 'ERRO DE TRANSACOES - EXISTE(M) ' + CAST(@@TRANCOUNT AS VARCHAR(9))+ ' BEGIN(S) A MAIS NO SCRIPT' \r\n");
		fim.append("ROLLBACK TRAN \r\n");
		fim.append("RAISERROR( @MENSAGEM, 16, 1) \r\n");
		fim.append("END \r\n");
		fim.append("ELSE \r\n");
		fim.append("SELECT GETDATE(),DB_NAME(),USER_NAME(), SUSER_NAME(), @@SERVERNAME \r\n");
		
		
		
		NumberFormat numberFormat = new DecimalFormat("0");
		numberFormat.setMinimumIntegerDigits(4);
		
    File f = new File("C:\\TFS\\201505 - Projeto Novo Endosso\\01 - Construção\\Scripts\\teste2");
		int indice = 1;
		
		for (String fn: f.list()) {

			File fnm = new File("C:\\TFS\\201505 - Projeto Novo Endosso\\01 - Construção\\Scripts\\teste2\\" + fn);
			FileInputStream fis = new FileInputStream(fnm);
			
			byte[] b = new byte[(int) fnm.length()];
			fis.read(b);
			fis.close();
			
			String a = inicio.toString().replace("*&*",fn.substring(0, fn.length() -4));
			
			StringBuilder st = new StringBuilder();
			st.append(new String(b, Charset.forName("UTF_16LE")).substring(1) + "\n");
			
		 	String c = fim.toString().replace("*&*",fn.substring(0, fn.length() -4));
		 	
		 	
		 	String numeroFormatado = numberFormat.format(indice);
		 	
		 	if(!st.toString().contains("USE MAPFRE_CONNECT")){
		 	
		 	FileOutputStream fos = new FileOutputStream(new File("C:\\TFS\\201505 - Projeto Novo Endosso\\01 - Construção\\Scripts\\teste3\\FBR18195306_" + numeroFormatado +"_"+ fn)); 
		 	
		 	fos.write(a.getBytes());
		 	fos.write(st.toString().getBytes());
		 	fos.write(c.getBytes());
		 	fos.close();
		 	
		 	
		 	
		 	}else{
		 		
		 		FileOutputStream fos = new FileOutputStream(new File("C:\\TFS\\201505 - Projeto Novo Endosso\\01 - Construção\\Scripts\\padrao\\FBR18195306_" + numeroFormatado +"_"+ fn)); 
			 	
			 	fos.write(st.toString().getBytes());
		 	}
		 	
		 	indice++;
		}  
	}
}
