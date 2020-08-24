/*
Class Name: FullTimeJob.java
Author: Justin Shi
Date: 06/09/2020
Purpose: This class file keeps track of the partial information(benefit, sick days,monthly earnings and breaks)
 of the job, if the type of job is a full time

*/
public class FullTimeJob extends Job {
	private double monthlyEarning;
	private char benefit;
	private char sickDays;
	private char breaks;
	
	//getters and setters
	public double getMonthlyEarning() {
		return monthlyEarning;
	}
	public void setMonthlyEarning(double monthlyEarning) {
		this.monthlyEarning = monthlyEarning;
	}
	public char getBenefit() {
		return benefit;
	}
	public void setBenefit(char benefit) {
		this.benefit = benefit;
	}
	public char getSickDays() {
		return sickDays;
	}
	public void setSickDays(char sickDays) {
		this.sickDays = sickDays;
	}
	public char getBreaks() {
		return breaks;
	}
	public void setBreaks(char breaks) {
		this.breaks = breaks;
	}
	
	//constructor
	public FullTimeJob(int id,String title,int location, int industry, int companySize, int eduBackground, int workExp, char gender, double monthlyEarning, char benefit, char sickDays, char breaks) {
		super(id,title,location, industry, companySize, eduBackground, workExp, gender);
		this.monthlyEarning = monthlyEarning;
		this.benefit = benefit;
		this.sickDays = sickDays;
		this.breaks = breaks;
	}
	// equals method
   public boolean equals(FullTimeJob other){
      if (other!=null && super.equals((Job)other) && monthlyEarning == other.monthlyEarning && benefit == other.benefit && sickDays == other.sickDays && breaks == other.breaks){
           return true;
      } else {
         return false;
      }
   }

	public String toString() {
      String s = super.toString();
		s += "\nMonthly Earning: $" + monthlyEarning;
		s += "\nBenefit: " + benefit;
		s += "\nSick Days: " + sickDays;
		s += "\nBreaks: " + breaks;
		
		return s;
	}
}
