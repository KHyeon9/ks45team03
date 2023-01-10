package ks45team03.rentravel.dto;

public class Profit {

	private String profitCode;
	private String userId;
	private String paymentCode;
	private int profitAmountSave;
	private int profitTotal;
	private String profitSaveTime;
	private String profitDayGroup;
	private ProfitDay profitDay;
	
	public ProfitDay getProfitDay() {
		return profitDay;
	}
	public void setProfitDay(ProfitDay profitDay) {
		this.profitDay = profitDay;
	}
	public String getProfitCode() {
		return profitCode;
	}
	public void setProfitCode(String profitCode) {
		this.profitCode = profitCode;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPaymentCode() {
		return paymentCode;
	}
	public void setPaymentCode(String paymentCode) {
		this.paymentCode = paymentCode;
	}
	public int getProfitAmountSave() {
		return profitAmountSave;
	}
	public void setProfitAmountSave(int profitAmountSave) {
		this.profitAmountSave = profitAmountSave;
	}
	public int getProfitTotal() {
		return profitTotal;
	}
	public void setProfitTotal(int profitTotal) {
		this.profitTotal = profitTotal;
	}
	public String getProfitSaveTime() {
		return profitSaveTime;
	}
	public void setProfitSaveTime(String profitSaveTime) {
		this.profitSaveTime = profitSaveTime;
	}
	public String getProfitDayGroup() {
		return profitDayGroup;
	}
	public void setProfitDayGroup(String profitDayGroup) {
		this.profitDayGroup = profitDayGroup;
	}
	@Override
	public String toString() {
		return "Profit [profitCode=" + profitCode + ", userId=" + userId + ", paymentCode=" + paymentCode
				+ ", profitAmountSave=" + profitAmountSave + ", profitTotal=" + profitTotal + ", profitSaveTime="
				+ profitSaveTime + ", profitDayGroup=" + profitDayGroup + ", profitDay=" + profitDay + "]";
	}
	
	
	
	
}
