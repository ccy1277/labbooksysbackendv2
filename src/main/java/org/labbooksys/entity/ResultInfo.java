package org.labbooksys.entity;

import java.io.Serializable;

public class ResultInfo implements Serializable {
    // 后台返回结果正常为true, 发生异常为false
    private boolean flag;
    // 后端返回的数据
    private Object data;
    // 返回的提示信息
    private String returnInfo;

    public ResultInfo() {
    }

    /**
     * 有参构造方法
     * @param flag
     * @param data
     * @param returnInfo
     */
    public ResultInfo(boolean flag, Object data, String returnInfo) {
        this.flag = flag;
        this.data = data;
        this.returnInfo = returnInfo;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getReturnInfo() {
        return returnInfo;
    }

    public void setReturnInfo(String returnInfo) {
        this.returnInfo = returnInfo;
    }
}
