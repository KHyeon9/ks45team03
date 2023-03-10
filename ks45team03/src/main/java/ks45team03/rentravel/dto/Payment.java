package ks45team03.rentravel.dto;

public class Payment {
	private String paymentCode;
	private String goodsCode;
	private String rentalCode;
	private String userId;
	private String regionSggCode;
	private String userAddrDesc;
	private String paymentAccountOrCardNumber;
	private String paymentAgency;
	private String paymentType;
	private int expectedPaymentAmount;
	private int goodsCommisionTotalPrice;
	private int mileageUsePrice;
	private int saveMileage;
	private int amountExcludingMileage;
	private int settlementAmount;
	private String paymentTime;
	private String tradeStatusCode;
	private String mileageSaveGroupCode;
	private String mileageUseGroupCode;
	
	public String getPaymentCode() {
		return paymentCode;
	}
	public void setPaymentCode(String paymentCode) {
		this.paymentCode = paymentCode;
	}
	public String getGoodsCode() {
		return goodsCode;
	}
	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}
	public String getRentalCode() {
		return rentalCode;
	}
	public void setRentalCode(String rentalCode) {
		this.rentalCode = rentalCode;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRegionSggCode() {
		return regionSggCode;
	}
	public void setRegionSggCode(String regionSggCode) {
		this.regionSggCode = regionSggCode;
	}
	public String getUserAddrDesc() {
		return userAddrDesc;
	}
	public void setUserAddrDesc(String userAddrDesc) {
		this.userAddrDesc = userAddrDesc;
	}
	public String getPaymentAccountOrCardNumber() {
		return paymentAccountOrCardNumber;
	}
	public void setPaymentAccountOrCardNumber(String paymentAccountOrCardNumber) {
		this.paymentAccountOrCardNumber = paymentAccountOrCardNumber;
	}
	public String getPaymentAgency() {
		return paymentAgency;
	}
	public void setPaymentAgency(String paymentAgency) {
		this.paymentAgency = paymentAgency;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public int getExpectedPaymentAmount() {
		return expectedPaymentAmount;
	}
	public void setExpectedPaymentAmount(int expectedPaymentAmount) {
		this.expectedPaymentAmount = expectedPaymentAmount;
	}
	public int getGoodsCommisionTotalPrice() {
		return goodsCommisionTotalPrice;
	}
	public void setGoodsCommisionTotalPrice(int goodsCommisionTotalPrice) {
		this.goodsCommisionTotalPrice = goodsCommisionTotalPrice;
	}
	public int getMileageUsePrice() {
		return mileageUsePrice;
	}
	public void setMileageUsePrice(int mileageUsePrice) {
		this.mileageUsePrice = mileageUsePrice;
	}
	public int getSaveMileage() {
		return saveMileage;
	}
	public void setSaveMileage(int saveMileage) {
		this.saveMileage = saveMileage;
	}
	public int getAmountExcludingMileage() {
		return amountExcludingMileage;
	}
	public void setAmountExcludingMileage(int amountExcludingMileage) {
		this.amountExcludingMileage = amountExcludingMileage;
	}
	public int getSettlementAmount() {
		return settlementAmount;
	}
	public void setSettlementAmount(int settlementAmount) {
		this.settlementAmount = settlementAmount;
	}
	public String getPaymentTime() {
		return paymentTime;
	}
	public void setPaymentTime(String paymentTime) {
		this.paymentTime = paymentTime;
	}
	public String getTradeStatusCode() {
		return tradeStatusCode;
	}
	public void setTradeStatusCode(String tradeStatusCode) {
		this.tradeStatusCode = tradeStatusCode;
	}
	public String getMileageSaveGroupCode() {
		return mileageSaveGroupCode;
	}
	public void setMileageSaveGroupCode(String mileageSaveGroupCode) {
		this.mileageSaveGroupCode = mileageSaveGroupCode;
	}
	public String getMileageUseGroupCode() {
		return mileageUseGroupCode;
	}
	public void setMileageUseGroupCode(String mileageUseGroupCode) {
		this.mileageUseGroupCode = mileageUseGroupCode;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Payment [paymentCode=");
		builder.append(paymentCode);
		builder.append(", goodsCode=");
		builder.append(goodsCode);
		builder.append(", rentalCode=");
		builder.append(rentalCode);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", regionSggCode=");
		builder.append(regionSggCode);
		builder.append(", userAddrDesc=");
		builder.append(userAddrDesc);
		builder.append(", paymentAccountOrCardNumber=");
		builder.append(paymentAccountOrCardNumber);
		builder.append(", paymentAgency=");
		builder.append(paymentAgency);
		builder.append(", paymentType=");
		builder.append(paymentType);
		builder.append(", expectedPaymentAmount=");
		builder.append(expectedPaymentAmount);
		builder.append(", goodsCommisionTotalPrice=");
		builder.append(goodsCommisionTotalPrice);
		builder.append(", mileageUsePrice=");
		builder.append(mileageUsePrice);
		builder.append(", saveMileage=");
		builder.append(saveMileage);
		builder.append(", amountExcludingMileage=");
		builder.append(amountExcludingMileage);
		builder.append(", settlementAmount=");
		builder.append(settlementAmount);
		builder.append(", paymentTime=");
		builder.append(paymentTime);
		builder.append(", tradeStatusCode=");
		builder.append(tradeStatusCode);
		builder.append(", mileageSaveGroupCode=");
		builder.append(mileageSaveGroupCode);
		builder.append(", mileageUseGroupCode=");
		builder.append(mileageUseGroupCode);
		builder.append("]");
		return builder.toString();
	}
	
	
}
