package com.permit;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509ExtendedTrustManager;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookieStore;
import java.net.Socket;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;

/**
 * Created by stonse on 5/24/17.
 */
public class HttpHelper {

	private static final String USER_AGENT = "Mozilla/5.0";
	private static String csrfToken = "foo";
	private static boolean bypassHttpsCheck = false;

	public HttpHelper() {
	}

	public String request(String uri, String type, String body, Map<String, String> cookies, Map<String, String> requestProperty) {
		if (bypassHttpsCheck) {
			try {
				bypassHttpsCheck();
			} catch (Exception ex) {
			}
		}
		try {

			URL url = new URL(uri);

			/*

			CookieManager manager = new CookieManager();
			CookieHandler.setDefault(manager);
			CookieStore cookieStore = manager.getCookieStore();

			HttpCookie cookie = new HttpCookie("csrftoken", csrfToken);
			cookie.setPath("/");

			cookieStore.add(url.toURI(), cookie);
			System.out.println("Added cookie to URL:" + url.toURI());
			*/

			//Opening Connection
			HttpsURLConnection httpConnection = (HttpsURLConnection) url.openConnection();
			//HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
			httpConnection.setRequestProperty("User-Agent", USER_AGENT);
			httpConnection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
			httpConnection.setRequestProperty("X-CsrfToken", csrfToken);

			if (type.equals("POST")) {
				httpConnection.setRequestMethod("POST");
				httpConnection.setRequestProperty("Content-Type", "application/json");
				httpConnection.setDoOutput(true);
				DataOutputStream wr = new DataOutputStream(httpConnection.getOutputStream());
				wr.writeBytes(body);
				wr.flush();
				wr.close();
			} else {
				httpConnection.setRequestMethod("GET");
			}

			//httpConnection.connect();
			System.out.println("Connect");

			InputStreamReader in = new InputStreamReader((InputStream) httpConnection.getContent());
			BufferedReader buff = new BufferedReader(in);
			System.out.println("Reading");
			StringBuilder text = new StringBuilder();
			String line = buff.readLine();
			while (line != null) {
				text.append(line + "\n");
				line = buff.readLine();
			}

			/*
			do {
				line = buff.readLine();


			} while (line != null);
			*/
			return text.toString();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return "";
	}


	private void bypassHttpsCheck() throws Exception {
		TrustManager[] trustAllCerts = new TrustManager[]{
				new X509ExtendedTrustManager() {
					@Override
					public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
					}

					@Override
					public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
					}

					@Override
					public X509Certificate[] getAcceptedIssuers() {
						return null;
					}

					@Override
					public void checkClientTrusted(X509Certificate[] x509Certificates, String s, Socket socket) throws CertificateException {
					}

					@Override
					public void checkServerTrusted(X509Certificate[] x509Certificates, String s, Socket socket) throws CertificateException {
					}

					@Override
					public void checkClientTrusted(X509Certificate[] x509Certificates, String s, SSLEngine sslEngine) throws CertificateException {
					}

					@Override
					public void checkServerTrusted(X509Certificate[] x509Certificates, String s, SSLEngine sslEngine) throws CertificateException {
					}
				}
		};
		SSLContext sslContext = SSLContext.getInstance("SSL");
		sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
		HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());
	}
}
