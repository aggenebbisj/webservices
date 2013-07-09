package nl.ordina.jtechnologies.wscursus.rest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Client {

	public static void main(String[] args) {
		try {
			final URL url = new URL(
					"http://localhost:8080/Opdracht6/services/hello/henk");
			final HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setRequestMethod("GET");
			final int httpResponseCode = connection.getResponseCode();
			if (HttpURLConnection.HTTP_OK == httpResponseCode) {
				final BufferedReader in = new BufferedReader(
						new InputStreamReader(connection.getInputStream()));
				String line = null;
				while ((line = in.readLine()) != null) {
					System.out.println(line);
				}
			}
			connection.disconnect();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
