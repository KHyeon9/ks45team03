package ks45team03.rentravel.dto;

public class Block {

	private String blockCode;
	private String blockingUserId;
	private String blockedUserId;
	private String blockDate;
	public String getBlockCode() {
		return blockCode;
	}
	public void setBlockCode(String blockCode) {
		this.blockCode = blockCode;
	}
	public String getBlockingUserId() {
		return blockingUserId;
	}
	public void setBlockingUserId(String blockingUserId) {
		this.blockingUserId = blockingUserId;
	}
	public String getBlockedUserId() {
		return blockedUserId;
	}
	public void setBlockedUserId(String blockedUserId) {
		this.blockedUserId = blockedUserId;
	}
	public String getBlockDate() {
		return blockDate;
	}
	public void setBlockDate(String blockDate) {
		this.blockDate = blockDate;
	}
	@Override
	public String toString() {
		return "Block [blockCode=" + blockCode + ", blockingUserId=" + blockingUserId + ", blockedUserId="
				+ blockedUserId + ", blockDate=" + blockDate + "]";
	}
	
	
}
