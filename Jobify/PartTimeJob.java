/*
Class Name: PartTimeJob.java
Author: Justin Shi
Date: 06/09/2020
Purpose: This class file keeps track of the partial information(hourly wage and the minimum work hours required per week)
 of the job, if the type of job is a part time

*/
public class PartTimeJob extends Job {
	private double hourlyEarning;
	private int minWorkHourPerWeek;

	// accessor and mutator
	public double getHourlyEarning() {
		return hourlyEarning;
	}

	public void setHourlyEarning(double hourlyEarning) {
		this.hourlyEarning = hourlyEarning;
	}

	public int getMinWorkHourPerWeek() {
		return minWorkHourPerWeek;
	}

	public void setMinWorkHourPerWeek(int minWorkHourPerWeek) {
		this.minWorkHourPerWeek = minWorkHourPerWeek;
	}

	// constructor
	public PartTimeJob(int id, String title, int location, int industry, int companySize, int eduBackground,
			int workExp, char gender, double hourlyEarning, int minWorkHourPerWeek) {
		super(id, title, location, industry, companySize, eduBackground, workExp, gender);
		this.hourlyEarning = hourlyEarning;
		this.minWorkHourPerWeek = minWorkHourPerWeek;
	}

	// equals method
	public boolean equals(PartTimeJob other) {
		if (other != null && super.equals((Job) other) && hourlyEarning == other.hourlyEarning
				&& minWorkHourPerWeek == other.minWorkHourPerWeek) {
			return true;
		} else {
			return false;
		}
	}

	// Prints the information in the object after the parent object
	public String toString() {
		String s = super.toString();
		s += "\nHourly Earning: $" + hourlyEarning;
		s += "\nMinimum Work Per Week (h): " + minWorkHourPerWeek + " h";

		return s;
	}
}
