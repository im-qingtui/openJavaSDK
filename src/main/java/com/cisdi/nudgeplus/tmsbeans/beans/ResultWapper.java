package com.cisdi.nudgeplus.tmsbeans.beans;

public class ResultWapper<T extends BaseResult> {

	private boolean isError = false;

	private T result;

	private ErrorResult errorResult;

	public boolean isError() {
		return isError;
	}

	public void setError(boolean isError) {
		this.isError = isError;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

	public ErrorResult getErrorResult() {
		return errorResult;
	}

	public void setErrorResult(ErrorResult errorResult) {
		this.errorResult = errorResult;
	}

}
