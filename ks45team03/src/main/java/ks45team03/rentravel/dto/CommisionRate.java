package ks45team03.rentravel.dto;

public class CommisionRate {

	private String commisionRateCode;
	private Float commisionRate;
	private int applyYear;
	private Boolean applyCheck;
	public String getCommisionRateCode() {
		return commisionRateCode;
	}
	public void setCommisionRateCode(String commisionRateCode) {
		this.commisionRateCode = commisionRateCode;
	}
	public Float getCommisionRate() {
		return commisionRate;
	}
	public void setCommisionRate(Float commisionRate) {
		this.commisionRate = commisionRate;
	}
	public int getApplyYear() {
		return applyYear;
	}
	public void setApplyYear(int applyYear) {
		this.applyYear = applyYear;
	}
	public Boolean getApplyCheck() {
		return applyCheck;
	}
	public void setApplyCheck(Boolean applyCheck) {
		this.applyCheck = applyCheck;
	}
	@Override
	public String toString() {
		return "CommisionRate [commisionRateCode=" + commisionRateCode + ", commisionRate=" + commisionRate
				+ ", applyYear=" + applyYear + ", applyCheck=" + applyCheck + "]";
	}
	
	
	
	
}
