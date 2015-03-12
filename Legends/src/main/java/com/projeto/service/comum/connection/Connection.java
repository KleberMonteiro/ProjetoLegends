package com.projeto.service.comum.connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.projeto.service.comum.enums.URLType;

public class Connection {

	public BufferedReader getResponse(String urlConsumer, URLType type) {

		BufferedReader br = null;

		try {
			URL url = new URL(urlConsumer);

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod(type.getKey());
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			//conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

		return br;
	}
}
