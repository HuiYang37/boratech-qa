package hui_automation.api_pojos;

public class Education {

	public String _id;
	public String school;
	public String degree;
	public String fieldofstudy;
	public String from;
	public String to;
	public boolean current;
	public String description;

	public Education(String school, String degree, String fieldofstudy, String from, String to, boolean current,
			String description) {
		this.school = school;
		if (this.school == null)
			this.school = "";

		this.degree = degree;
		if (this.degree == null)
			this.degree = "";

		this.fieldofstudy = fieldofstudy;
		if (this.fieldofstudy == null)
			this.fieldofstudy = "";

		this.from = from;
		if (this.from == null)
			this.from = "";
		this.from = this.from.replaceAll("T.*Z", "");

		this.to = to;
		if (this.to == null)
			this.to = "";
		this.to = this.to.replaceAll("T.*Z", "");

		this.current = current;

		this.description = description;
		if (this.description == null)
			this.description = "";
	}

	public void formatDate() {
		if (this.from == null)
			this.from = "";
		this.from = this.from.replaceAll("T.*Z", "");

		if (this.to == null)
			this.to = "";
		this.to = this.to.replaceAll("T.*Z", "");
	}

	public boolean equals(Object obj) {
		if (obj instanceof Education) {
			Education that = (Education) obj;
			return this.school.equals(that.school) && this.degree.equals(that.degree)
					&& this.fieldofstudy.equals(that.fieldofstudy);
		}
		return false;
	}

}
