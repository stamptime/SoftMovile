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

public class TestJSONDetalleVenta {
	
	private static URL url;
	private static String sitio = "http://localhost:5000/";
	
	public static int postJSON(Detalle_Venta detalle_venta) throws IOException {

		url = new URL(sitio + "detalle_venta/guardar");
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
							+ "\"codigo_detalle_venta\":\""// + String.valueOf(detalle_venta.getCodigo_detalle_venta()) 
							+ "\",\"cantidad_producto\": \""+ String.valueOf(detalle_venta.getCantidad_producto()) 
							+ "\",\"codigo_producto\": \"" + String.valueOf(detalle_venta.getCodigo_producto()) 
							+ "\",\"codigo_venta\":\"" + String.valueOf(detalle_venta.getCodigo_venta()) 
							+ "\",\"valor_total\":\"" + String.valueOf(detalle_venta.getValor_total()) 
							+ "\",\"valor_venta\":\"" + String.valueOf(detalle_venta.getValor_venta()) 
							+ "\",\"valor_iva\":\"" + String.valueOf(detalle_venta.getValor_iva()) 
							+ "\",\"descripcion_producto\":\"" + detalle_venta.getDescripcion_producto()
							+ "\",\"precio_producto\":\"" + detalle_venta.getPrecio_producto()
				+ "\"}";
		
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);

		int respuesta = http.getResponseCode();
		System.out.println(respuesta);
		http.disconnect();
		return respuesta;
	}
	
	public static ArrayList<Detalle_Venta> getJSON() throws IOException, ParseException {

		url = new URL(sitio + "detalle_venta/listar");
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

		ArrayList<Detalle_Venta> lista = new ArrayList<Detalle_Venta>();
		lista = parsingDetalle_venta(json);
		http.disconnect();
		return lista;
	}
	
	
	public static ArrayList<Detalle_Venta> parsingDetalle_venta(String json) throws ParseException {
		JSONParser jsonParser = new JSONParser();
		ArrayList<Detalle_Venta> lista = new ArrayList<Detalle_Venta>();
		JSONArray detalle_ventas = (JSONArray) jsonParser.parse(json);
		Iterator i = detalle_ventas.iterator();
		while (i.hasNext()) {
			JSONObject innerObj = (JSONObject) i.next();
			Detalle_Venta detalle_venta = new Detalle_Venta();
			detalle_venta.setCodigo_detalle_venta(Integer.parseInt(innerObj.get("codigo_detalle_venta").toString()));
			detalle_venta.setCantidad_producto(Integer.parseInt(innerObj.get("cantidad_producto").toString()));
			detalle_venta.setCodigo_producto(Long.parseLong(innerObj.get("codigo_producto").toString()));
			detalle_venta.setDescripcion_producto(innerObj.get("descripcion_producto").toString());
			detalle_venta.setCodigo_venta(Long.parseLong(innerObj.get("codigo_venta").toString()));
			detalle_venta.setValor_total(Double.parseDouble(innerObj.get("valor_total").toString()));
			detalle_venta.setValor_venta(Double.parseDouble(innerObj.get("valor_venta").toString()));
			detalle_venta.setValor_iva(Double.parseDouble(innerObj.get("valor_iva").toString()));
			detalle_venta.setPrecio_producto(Double.parseDouble(innerObj.get("precio_producto").toString()));
			lista.add(detalle_venta);

		}
		return lista;

	}


}
