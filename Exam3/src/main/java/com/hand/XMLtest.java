package com.hand;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * Hello world!
 *
 */
public class XMLtest 
{
    public static void main( String[] args )
    {
    	new ReadByGets().start();
    }
}
class ReadByGets extends Thread{
	@Override
	public void run(){
		try {
			URL url = new URL("http://hq.sinajs.cn/list=sz300170");
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			connection.addRequestProperty("encoding", "UTF-8");
			connection.setDoInput(true);
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
			OutputStream os =connection.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw=new BufferedWriter(osw);
			bw.write("keyform=JKXY-test&key=343166845&type=data&doctype=xml&version=1.0&encoding=UTF-8");
			//bw.flush;
			InputStream is = connection.getInputStream();
			InputStreamReader isr= new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String line;
			StringBuilder builder = new StringBuilder();
			while((line = br.readLine())!=null){
				builder.append(line);
			}
			bw.close();
			osw.close();
			os.close();
			br.close();
			isr.close();
			is.close();
			System.out.println(builder.toString());
		} catch (MalformedURLException e1){
			e1.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
	}
}
//class createjson {
//	JsonObject object = new JsonObject();
//	object.addProperty("cat","it");
//	JsonArray array = new JsonArray();
//	
//}


