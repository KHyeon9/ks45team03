package ks45team03.rentravel.dto;

public class ProfitDay {

	private String profitDayCode;
	private String userId;
	private String profitSaveYearMonth;
	private int profitDayTotal;
	private String profitDayGroup;
	private String profitMonthGroup;
	public String getProfitDayCode() {
		return profitDayCode;
	}
	public void setProfitDayCode(String profitDayCode) {
		this.profitDayCode = profitDayCode;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getProfitSaveYearMonth() {
		return profitSaveYearMonth;
	}
	public void setProfitSaveYearMonth(String profitSaveYearMonth) {
		this.profitSaveYearMonth = profitSaveYearMonth;
	}
	public int getProfitDayTotal() {
		return profitDayTotal;
	}
	public void setProfitDayTotal(int profitDayTotal) {
		this.profitDayTotal = profitDayTotal;
	}
	public String getProfitDayGroup() {
		return profitDayGroup;
	}
	public void setProfitDayGroup(String profitDayGroup) {
		this.profitDayGroup = profitDayGroup;
	}
	public String getProfitMonthGroup() {
		return profitMonthGroup;
	}
	public void setProfitMonthGroup(String profitMonthGroup) {
		this.profitMonthGroup = profitMonthGroup;
	}
	@Override
	public String toString() {
		return "ProfitDay [profitDayCode=" + profitDayCode + ", userId=" + userId + ", profitSaveYearMonth="
				+ profitSaveYearMonth + ", profitDayTotal=" + profitDayTotal + ", profitDayGroup=" + profitDayGroup
				+ ", profitMonthGroup=" + profitMonthGroup + "]";
	}
	
	
}
