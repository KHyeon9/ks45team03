package ks45team03.rentravel.dto;

public class ProfitMonth {
	
	private String profitMonthCode;
	private String userId;
	private String profitSaveYearMonth;
	private String profitMonthGroup;
	private int profitMonthTotal;
	public String getProfitMonthCode() {
		return profitMonthCode;
	}
	public void setProfitMonthCode(String profitMonthCode) {
		this.profitMonthCode = profitMonthCode;
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
	public String getProfitMonthGroup() {
		return profitMonthGroup;
	}
	public void setProfitMonthGroup(String profitMonthGroup) {
		this.profitMonthGroup = profitMonthGroup;
	}
	public int getProfitMonthTotal() {
		return profitMonthTotal;
	}
	public void setProfitMonthTotal(int profitMonthTotal) {
		this.profitMonthTotal = profitMonthTotal;
	}
	@Override
	public String toString() {
		return "ProfitMonth [profitMonthCode=" + profitMonthCode + ", userId=" + userId + ", profitSaveYearMonth="
				+ profitSaveYearMonth + ", profitMonthGroup=" + profitMonthGroup + ", profitMonthTotal="
				+ profitMonthTotal + "]";
	}
	
	
	

}
