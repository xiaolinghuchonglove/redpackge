package com.zh.Ob;

public class JsonResult {
    private Status Status;
    private ProcessType ProcessType;
    String msg;
    private Object date;
    public JsonResult(com.zh.Ob.Status status, com.zh.Ob.ProcessType processType, String msg, Object date) {
        Status = status;
        ProcessType = processType;
        this.msg = msg;
        this.date = date;
    }

    public com.zh.Ob.Status getStatus() {
        return Status;
    }

    public com.zh.Ob.ProcessType getProcessType() {
        return ProcessType;
    }

    public String getMsg() {
        return msg;
    }

    public Object getDate() {
        return date;
    }

    public void setStatus(com.zh.Ob.Status status) {
        Status = status;
    }

    public void setProcessType(com.zh.Ob.ProcessType processType) {
        ProcessType = processType;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setDate(Object date) {
        this.date = date;
    }
}