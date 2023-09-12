package hui_automation.utilities;

import hui_automation.api_pojos.Profile;

public class UtilsTester {

	public static void main(String[] args) {
		String token = BoraTechAPIs.login("hui-pretender@outlook.com", "Hui123456");
		Profile userProfile = BoraTechAPIs.getUserProfile(token);
		userProfile.print();
	}

}
