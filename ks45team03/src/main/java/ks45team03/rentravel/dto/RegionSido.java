package ks45team03.rentravel.dto;

public class RegionSido {
	
	private String regionSidoCode;
	private String regionSidoName;
	private String regionPlus;
	
	private RegionSgg regionSgg;
	
	public String getRegionSidoCode() {
		return regionSidoCode;
	}
	public void setRegionSidoCode(String regionSidoCode) {
		this.regionSidoCode = regionSidoCode;
	}
	public String getRegionSidoName() {
		return regionSidoName;
	}
	public void setRegionSidoName(String regionSidoName) {
		this.regionSidoName = regionSidoName;
	}
	
	public RegionSgg getRegionSgg() {
		return regionSgg;
	}
	public void setRegionSgg(RegionSgg regionSgg) {
		this.regionSgg = regionSgg;
	}
	public String getRegionPlus() {
		return regionPlus;
	}
	public void setRegionPlus(String regionPlus) {
		this.regionPlus = regionPlus;
	}
	@Override
	public String toString() {
		return "RegionSido [regionSidoCode=" + regionSidoCode + ", regionSidoName=" + regionSidoName + ", regionPlus="
				+ regionPlus + ", regionSgg=" + regionSgg + "]";
	}
	
}
