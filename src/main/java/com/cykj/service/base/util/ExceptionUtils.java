package com.cykj.service.base.util;

/**
 * @author yangsq
 * @date 2018/6/6 16:44.
 */
public class ExceptionUtils {

    protected ExceptionUtils(){}

    /**
     * 获取错误信息
     * @param e = Exception
     * ExceptionUtils.getErrorInfo(ExceptionUtils.getThread().getStackTrace(), e)
     */
    public static String getErrorInfo(Exception e){
        StackTraceElement[] stackTraceElement = e.getStackTrace();
        String errCont = "";
        if(e!=null){
            errCont += "异常信息："+e+"\n";
        }
        if(stackTraceElement!=null&&stackTraceElement.length>1){
            errCont += "异常位置：";
            for(int i=0;i<stackTraceElement.length;i++){
                if(stackTraceElement[i].toString().indexOf("Unknown Source")<0){
                    errCont += stackTraceElement[i];
                    break;
                }
            }
        }
        return errCont;
    }

}
