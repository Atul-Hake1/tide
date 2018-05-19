package com.tide.qa.utility;


import java.util.HashMap;

import com.tide.qa.common.GlobalVariables;


public class Configuration {


	private static Utilities util = new Utilities();


	public static String URL_INFO = null;
	// public static String PASSWORD= properties.getProperty("password");
	private static GlobalVariables glb = new GlobalVariables();



	public static String url, email1, password1, email2, password2, testusername, invalidusername;

	public static void setUrlInfoDataSet(HashMap<String, Object> basicURLinfo) {

		url = (String) basicURLinfo.get("url");
				
		email1 = (String) basicURLinfo.get("email1");
		password1 = (String) basicURLinfo.get("password1");

		email2 = (String) basicURLinfo.get("email2");
		password2 = (String) basicURLinfo.get("password2");

		testusername = (String) basicURLinfo.get("testUsername");
		invalidusername= (String) basicURLinfo.get("invalidUsername");
	}

	// ====================================================================================================
	// FunctionName : getURL
	// Description : Function to get all the URL information
	// Input Parameter : None
	// Return Value :
	// ====================================================================================================
	public static String getURL()
	{
		String Environment = util.getValue("Environment", "qa").trim();
		glb.setEnvironment(Environment);
		if(Environment.equalsIgnoreCase("qa"))
		{
			URL_INFO = "qa";

		}else if(Environment.equalsIgnoreCase("staging"))
		{
			URL_INFO = "staging";

		}
		return URL_INFO;
	}
}