package automation.hui.practices.api.rest_assured.tests;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import automation.hui.utilities.BoraTechAPIs;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PrintProfileJson {

	public static void main(String[] args) {
		String email = "hui-pretender@outlook.com";
		String password = "Hui123456";
		try {
			String token = BoraTechAPIs.login(email, password);
			String endpoint = "/api/profile/me";
			RestAssured.baseURI = "https://boratech-practice-app.onrender.com";
			RequestSpecification request = RestAssured.given();

			// setting a request
			request.header("X-Auth-Token", token);

			// return a response
			Response response = request.get(endpoint);

			System.out.println(response.statusLine());

			String profile = response.body().asPrettyString();
			System.out.println(profile);

			if (response.getStatusCode() == 200) {
				File fileObj = new File("target/hui_profile.json");
				FileWriter fw = new FileWriter(fileObj);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(profile);
				bw.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
