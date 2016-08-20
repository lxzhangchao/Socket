package com.hand;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.io.FileUtils;
import org.apache.http.auth.MalformedChallengeException;

/**
 * Hello world!
 *
 */
public class Get 
{
    public static void main( String[] args )
    {
        new ReadByGet().start();
    }
}
class ReadByGet extends Thread{
	@Override
	public void run(){
		try {
			URL url = new URL("http://files.saas.hand-china.com/java/target.pdf");
			URLConnection connection = url.openConnection();
			InputStream is = connection.getInputStream();
			InputStreamReader isr= new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String line;
			StringBuilder builder = new StringBuilder();
			while((line = br.readLine())!=null){
				builder.append(line);
			}
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