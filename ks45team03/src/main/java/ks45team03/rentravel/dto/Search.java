package ks45team03.rentravel.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Search {
	
	 public Search(String searchKey, String searchValue) { 
		 this.searchKey = searchKey; 
		 this.searchValue = searchValue; 
		 }
	 
	private String searchKey;
	private String searchValue;
}
