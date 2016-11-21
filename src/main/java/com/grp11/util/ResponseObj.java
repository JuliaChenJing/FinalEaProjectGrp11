package com.grp11.util;

public class ResponseObj {
	private boolean success;
	private boolean isValid;
	private String description;
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public boolean isValid() {
		return isValid;
	}
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "ResponseObj [success=" + success + ", isValid=" + isValid + ", description=" + description + "]";
	}
}
