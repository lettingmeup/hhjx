package com.hhjx.mage.bo;

public class ResultData {
   private String  backCode;
   private String backDesc;
public String getBackCode() {
	return backCode;
}
public void setBackCode(String backCode) {
	this.backCode = backCode;
}
public String getBackDesc() {
	return backDesc;
}
public void setBackDesc(String backDesc) {
	this.backDesc = backDesc;
}
@Override
public String toString() {
	return "ResultData [backCode=" + backCode + ", backDesc=" + backDesc + "]";
}
   
}
