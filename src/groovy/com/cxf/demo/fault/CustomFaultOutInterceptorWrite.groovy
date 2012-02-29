package com.cxf.demo.fault

import org.apache.cxf.binding.soap.SoapMessage
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor
import org.apache.cxf.interceptor.Fault
import org.apache.cxf.phase.Phase

/**
 */
class CustomFaultOutInterceptorWrite extends AbstractSoapInterceptor {

    public CustomFaultOutInterceptorWrite() {
        super(Phase.WRITE)
    }

    public void handleMessage(SoapMessage message) throws Fault {
        println "WRITE"
        Fault fault = (Fault) message?.getContent(Exception.class)
        fault?.printStackTrace()
        println fault?.message
    }
}
