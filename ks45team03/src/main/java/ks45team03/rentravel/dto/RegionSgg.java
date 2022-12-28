package ks45team03.rentravel.dto;

public class RegionSgg {
	
	private String regionSggCode;
	private String regionSidoCode;
	private String regionSggName;
	
	
	public String getRegionSggCode() {
		return regionSggCode;
	}
	public void setRegionSggCode(String regionSggCode) {
		this.regionSggCode = regionSggCode;
	}
	public String getRegionSidoCode() {
		return regionSidoCode;
	}
	public void setRegionSidoCode(String regionSidoCode) {
		this.regionSidoCode = regionSidoCode;
	}
	public String getRegionSggName() {
		return regionSggName;
	}
	public void setRegionSggName(String regionSggName) {
		this.regionSggName = regionSggName;
	}
	@Override
	public String toString() {
		return "RegionSgg [regionSggCode=" + regionSggCode + ", regionSidoCode=" + regionSidoCode + ", regionSggName="
				+ regionSggName + "]";
	}
}
