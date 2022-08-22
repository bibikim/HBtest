package api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONArray;
import org.json.JSONObject;


	public class accident {

		public static String m1() {
			
			String serviceKey = "1bYcGDEwh81BJx5E4lJXOhR5aFY6NfZZ9o2Esn3khsPIZIM8uzs61raBrbdv2xPCWXzlmw0n6QJwVXUhmoT9Jg==";
			StringBuilder urlsb = new StringBuilder();
			
			try {
				
				urlsb.append("http://apis.data.go.kr/B552061/AccidentDeath/getRestTrafficAccidentDeath");
				urlsb.append("?ServiceKey=").append(URLEncoder.encode(serviceKey, "UTF-8"));
				urlsb.append("&searchYear=2021");
				urlsb.append("&siDo=1100");
				urlsb.append("&guGun=1125");
				urlsb.append("&numOfRows=10");
				urlsb.append("&pageNo=1");
				urlsb.append("&type=json");
				
				
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			
			String apiURL = urlsb.toString();
			
			HttpURLConnection con = null;
			
			try {
				
				URL url = new URL(apiURL);
				con = (HttpURLConnection)url.openConnection();
				con.setRequestMethod("GET");
				con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
				
			} catch(MalformedURLException e) {
				e.printStackTrace();
			} catch(IOException e) {
				e.printStackTrace();
			}
			
			BufferedReader rd = null;
			StringBuilder sb = new StringBuilder();
			
			try {
				
				if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
					rd = new BufferedReader(new InputStreamReader(con.getInputStream()));
				} else {
					rd = new BufferedReader(new InputStreamReader(con.getErrorStream()));
				}
				
				String line = null;
				while((line = rd.readLine()) != null) {
					sb.append(line + "\n");
				}
				
				rd.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			String response = sb.toString();
			File file = new File("d:\\storage", "accident.json");

			try {
				
				BufferedWriter bw = new BufferedWriter(new FileWriter(file));
				bw.write(response);
				bw.close();
			
			} catch (IOException e) {
				e.printStackTrace();
			}
			return response;
		}
		
		public static void m2() {	
			
			

			
			try {

				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				FileWriter fw = new FileWriter("d:\\storage\\accident.txt");
				
				JSONObject obj = new JSONObject(m1());
				
				JSONArray dataList = obj.getJSONObject("items")
										.getJSONArray("item");
				for(int i = 0; i < dataList.length(); i++) {
					JSONObject acci = dataList.getJSONObject(i);
					String str = "발생일자 " + acci.getInt("occrrnc_dt") + " " + acci.getInt("occrrnc_day_cd") + "요일" + " 사망자 수 " + acci.getInt("dth_dnv_cnt") + "명, 부상자 수 " + acci.getInt("injpsn_cnt") + "명 \n" ;
					String[] week = { "", "일", "월", "화", "수", "목", "금", "토"};
					for(int j =1; j < week.length; j++) {
						String.valueOf(week[j]);
						Integer.toString(acci.getInt("occrrnc_day_cd"));
						//occrrnc_day_cd = String.valueOf(acci.getInt(occrrnc_day_cd));

						
					}
						
				
					fw.write(str);
				}
				
				br.close();
				fw.close();
			
			
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		}
			
			
			
		
		public static void main(String[] args) {
			m2();
		}
	}
	
	
	

