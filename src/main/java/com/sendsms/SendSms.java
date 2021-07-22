package com.sendsms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import javax.net.ssl.HttpsURLConnection;

public class SendSms {

	public static void main(String[] args) {

		List<File> fList = listf(System.getProperty("user.dir"));
		File filePath = checkFile(fList, "config.properties");
		Properties p = null;
		try {
			FileReader reader = new FileReader(filePath.getAbsolutePath());
			p = new Properties();
			p.load(reader);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		Accounts acct = Accounts.valueOf("Varun");
		String apiKey = acct.getKey();
		String username = acct.getUseName();
		String to = p.getProperty("phoneNumber");
		String msg = "Check drip drip!!!";
		try {
			String messsage = URLEncoder.encode(msg, "UTF-8");
			String myUrl = "https://api-mapper.clicksend.com/http/v2/send.php?method=http&username=" + username + "&key=" + apiKey + "&to=" + to + "&message=" + messsage;

			URL url = new URL(myUrl);
			HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("User-Agent", "Mozilla/5.0");
			con.setRequestProperty("cache-control", "no-cache");
			System.out.println("Wait..............");

			int code = con.getResponseCode();
			System.out.println("Response code : " + code);

			StringBuffer response = new StringBuffer();
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

			while (true) {
				String line = br.readLine();
				if (line == null) {
					break;
				}
				response.append(line);
			}

			System.out.println(response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static List<File> listf(String directoryName) {
        File directory = new File(directoryName);

        List<File> resultList = new ArrayList<File>();

        // get all the files from a directory
        File[] fList = directory.listFiles();
        resultList.addAll(Arrays.asList(fList));
        for (File file : fList) {
            if (file.isFile()) {
                System.out.println(file.getAbsolutePath());
            } else if (file.isDirectory()) {
                resultList.addAll(listf(file.getAbsolutePath()));
            }
        }
        return resultList;
    }
	
	public static File checkFile(List<File> files,String fileName) {
		for(File file : files) {
			if (file.getName().equals(fileName)) {
				return file;
			}
		}
		return null;
	}

}
