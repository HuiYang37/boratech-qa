package automation.hui.pojos.api;

import java.util.List;

public class Profile {

	public List<String> skills;
	public String _id;
	public User user;
	public int __v;
	public String bio;
	public String company;
	public String githubusername;
	public String location;
	public String status;
	public String website;
	public String date;
	// no plural for api request
	public List<Education> education;
	public List<Experience> experience;

	public void print() {
		System.out.println("UserID: " + user._id);
	}

}
