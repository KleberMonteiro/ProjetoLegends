package com.projeto.service.rest.impl;

import com.google.gson.Gson;
import com.projeto.service.comum.connection.Connection;

public class GenericRESTImpl {
	
	protected Connection connectionFromServer = new Connection();
	protected Gson jsonParser = new Gson();
	
	public Connection getConnectioFromServer() {
		return connectionFromServer;
	}
	public void setConnectioFromServer(Connection connectioFromServer) {
		this.connectionFromServer = connectioFromServer;
	}
	public Gson getJsonParser() {
		return jsonParser;
	}
	public void setJsonParser(Gson jsonParser) {
		this.jsonParser = jsonParser;
	}
}
