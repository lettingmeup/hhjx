package com.hhjx.mage.bo;

import java.util.List;

public class TeamMateListBO extends ResultData{
	private List<TeamMateBO> list;

	public List<TeamMateBO> getList() {
		return list;
	}

	public void setList(List<TeamMateBO> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "TeamMateListBO [list=" + list + "]";
	}

}
