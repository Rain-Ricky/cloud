package com.dzqc.cloud.common;

import java.io.Serializable;

public class ResultObject implements Serializable {

	private static final long serialVersionUID = 1L;

	private String msg;
    private Boolean suc;
    private Object result;

    public ResultObject(String msg, Boolean suc, Object result) {
        this.msg = msg;
        this.suc = suc;
        this.result = result;
    }
    
    public static ResultObject success() {
    	return new ResultObject( "ok", true, null);
    }
    
    public static ResultObject success(Object result) {
    	return new ResultObject("ok", true, result);
    }
    
    public static ResultObject error(String msg) {
    	return new ResultObject(msg, false, null);
    }
    
    public static ResultObject error(String msg , Object result) {
    	return new ResultObject(msg, false, result);
    }
    

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Boolean getSuc() {
        return suc;
    }

    public void setSuc(Boolean suc) {
        this.suc = suc;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
