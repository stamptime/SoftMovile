package co.edu.unibosque.softmovil;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class TestJSONVentas {
	
	private static URL url;
	private static String sitio = "http://localhost:5000/";
	
	public static int postJSON(Ventas ventas) throws IOException {

		url = new URL(sitio + "ventas/guardar");
		HttpURLConnection http;
		http = (HttpURLConnection) url.openConnection();

		try {
			http.setRequestMethod("POST");
		} catch (ProtocolException e) {
			e.printStackTrace();
		}

		http.setDoOutput(true);
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Content-Type", "application/json");

		String data = "{" 
						  + "\"id_venta\":\""
						  + "\",\"codigo_venta\": \"" + ventas.getCodigo_venta()
						  + "\",\"cedula_cliente\": \"" + ventas.getCedula_cliente()
						  + "\",\"cedula_usuario\": \"" + ventas.getCedula_usuario()
						  + "\",\"iva_venta\":\"" + ventas.getIva_venta()
						  + "\",\"total_venta\":\"" + ventas.getTotal_venta()
						  + "\",\"valor_venta\":\"" + ventas.getValor_venta()
						  + "\"}";
			
		
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);

		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}
	
	public static ArrayList<Ventas> getJSON() throws IOException, ParseException {

		url = new URL(sitio + "ventas/listar");
		HttpURLConnection http = (HttpURLConnection) url.openConnection();
		System.out.println(url);
		http.setRequestMethod("GET");
		http.setRequestProperty("Accept", "application/json");

		InputStream respuesta = http.getInputStream();
		byte[] inp = respuesta.readAllBytes();
		String json = "";

		for (int i = 0; i < inp.length; i++) {
			json += (char) inp[i];
		}

		ArrayList<Ventas> lista = new ArrayList<Ventas>();
		lista = parsingVentas(json);
		http.disconnect();
		return lista;
	}
	
	
	public static ArrayList<Ventas> parsingVentas(String json) throws ParseException {
		JSONParser jsonParser = new JSONParser();
		ArrayList<Ventas> lista = new ArrayList<Ventas>();
		JSONArray ventas = (JSONArray) jsonParser.parse(json);
		Iterator i = ventas.iterator();
		
		while (i.hasNext()) {
			JSONObject innerObj = (JSONObject) i.next();
			Ventas venta = new Ventas();
			venta.setId_venta(Long.parseLong(innerObj.get("id_venta").toString()));
			venta.setCodigo_venta(Long.parseLong(innerObj.get("codigo_venta").toString()));
			venta.setCedula_cliente(Long.parseLong(innerObj.get("cedula_cliente").toString()));
			venta.setCedula_usuario(Long.parseLong(innerObj.get("cedula_usuario").toString()));
			venta.setIva_venta(Double.parseDouble(innerObj.get("iva_venta").toString()));
			venta.setTotal_venta(Double.parseDouble(innerObj.get("total_venta").toString()));
			venta.setValor_venta(Double.parseDouble(innerObj.get("valor_venta").toString()));
			lista.add(venta);

		}
		return lista;

	}


}
