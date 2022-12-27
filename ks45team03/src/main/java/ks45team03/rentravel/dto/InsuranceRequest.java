package ks45team03.rentravel.dto;

public class InsuranceRequest {
	private String insuranceRequestCode;
	private String insuranceCode;
	private String userId;
	private String goodsCode;
	private String paymentCode;
	private String accidentCode;
	private String accidentType;
	private String accidentContent;
	private String insuranceEvidence;
	private String bankName;
	private String accountHolder;
	private String accountNumber;
	private String requestDate;
	
	public String getInsuranceRequestCode() {
		return insuranceRequestCode;
	}
	public void setInsuranceRequestCode(String insuranceRequestCode) {
		this.insuranceRequestCode = insuranceRequestCode;
	}
	public String getInsuranceCode() {
		return insuranceCode;
	}
	public void setInsuranceCode(String insuranceCode) {
		this.insuranceCode = insuranceCode;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getGoodsCode() {
		return goodsCode;
	}
	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}
	public String getPaymentCode() {
		return paymentCode;
	}
	public void setPaymentCode(String paymentCode) {
		this.paymentCode = paymentCode;
	}
	public String getAccidentCode() {
		return accidentCode;
	}
	public void setAccidentCode(String accidentCode) {
		this.accidentCode = accidentCode;
	}
	public String getAccidentType() {
		return accidentType;
	}
	public void setAccidentType(String accidentType) {
		this.accidentType = accidentType;
	}
	public String getAccidentContent() {
		return accidentContent;
	}
	public void setAccidentContent(String accidentContent) {
		this.accidentContent = accidentContent;
	}
	public String getInsuranceEvidence() {
		return insuranceEvidence;
	}
	public void setInsuranceEvidence(String insuranceEvidence) {
		this.insuranceEvidence = insuranceEvidence;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getAccountHolder() {
		return accountHolder;
	}
	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}
	@Override
	public String toString() {
		return "InsuranceRequest [insuranceRequestCode=" + insuranceRequestCode + ", insuranceCode=" + insuranceCode
				+ ", userId=" + userId + ", goodsCode=" + goodsCode + ", paymentCode=" + paymentCode + ", accidentCode="
				+ accidentCode + ", accidentType=" + accidentType + ", accidentContent=" + accidentContent
				+ ", insuranceEvidence=" + insuranceEvidence + ", bankName=" + bankName + ", accountHolder="
				+ accountHolder + ", accountNumber=" + accountNumber + ", requestDate=" + requestDate + "]";
	}
	
	
}
