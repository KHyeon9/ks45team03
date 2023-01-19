package ks45team03.rentravel.dto;


public class ProfitSearch {
	
	public ProfitSearch(String searchId, String searchYear ,String searchMonth, String searchDay) { 
		this.searchId = searchId;
		this.searchYear =searchYear;
		this.searchMonth = searchMonth;
		this.searchDay = searchDay;
		 }

	private String searchId;
	private String searchYear;
	private String searchMonth;
	private String searchDay;
	
	
	
	public String getSearchId() {
		return searchId;
	}
	
	public void setSearchId(String searchId) {
		this.searchId = searchId;
	}
	
	public String getSearchYear() {
		return searchYear;
	}
	public void setSearchYear(String searchYear) {
		this.searchYear = searchYear;
	}
	public String getSearchMonth() {
		return searchMonth;
	}
	public void setSearchMonth(String searchMonth) {
		this.searchMonth = searchMonth;
	}
	public String getSearchDay() {
		return searchDay;
	}
	public void setSearchDay(String searchDay) {
		this.searchDay = searchDay;
	}
	@Override
	public String toString() {
		return "ProfitSearch [searchId=" + searchId + ", searchYear=" + searchYear + ", searchMonth=" + searchMonth
				+ ", searchDay=" + searchDay + "]";
	}
	
	
	
	
}
