package com.course.consumingrest.model;
import java.util.List;
public class ApiResult {
	private boolean success;
	private List<Haber> result;
	public List<Haber> getResult() {
		return result;
	}
	public void setResult(List<Haber> result) {
		this.result = result;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
}