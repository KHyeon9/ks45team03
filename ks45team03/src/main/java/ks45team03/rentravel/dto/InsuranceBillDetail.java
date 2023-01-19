package ks45team03.rentravel.dto;

public class InsuranceBillDetail {
	private String insuranceBillDetailCode;
	private String insuranceCode;
	private String userId;
	private String goodsCode;
	private String paymentCode;
	private String accidentDate;
	private String accidentType;
	private String accidentContent;
	private String insuranceEvidence;
	private String bankName;
	private String accountHolder;
	private String accountNumber;
	private String requestDate;
	
	User user;
	Goods goods;
	InsuranceBill insuranceBill;
	InsuranceBillState insuranceBillState;
	
	public InsuranceBillState getInsuranceBillState() {
		return insuranceBillState;
	}
	public void setInsuranceBillState(InsuranceBillState insuranceBillState) {
		this.insuranceBillState = insuranceBillState;
	}
	
	public InsuranceBill getInsuranceBill() {
		return insuranceBill;
	}
	public void setInsuranceBill(InsuranceBill insuranceBill) {
		this.insuranceBill = insuranceBill;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	
	public String getInsuranceBillDetailCode() {
		return insuranceBillDetailCode;
	}
	public void setInsuranceBillDetailCode(String insuranceBillDetailCode) {
		this.insuranceBillDetailCode = insuranceBillDetailCode;
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
	public String getAccidentDate() {
		return accidentDate;
	}
	public void setAccidentDate(String accidentDate) {
		this.accidentDate = accidentDate;
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
		return "InsuranceBillDetail [insuranceBillDetailCode=" + insuranceBillDetailCode + ", insuranceCode="
				+ insuranceCode + ", userId=" + userId + ", goodsCode=" + goodsCode + ", paymentCode=" + paymentCode
				+ ", accidentDate=" + accidentDate + ", accidentType=" + accidentType + ", accidentContent="
				+ accidentContent + ", insuranceEvidence=" + insuranceEvidence + ", bankName=" + bankName
				+ ", accountHolder=" + accountHolder + ", accountNumber=" + accountNumber + ", requestDate="
				+ requestDate + ", user=" + user + ", goods=" + goods + ", insuranceBill=" + insuranceBill + "]";
	}
	
	
}
