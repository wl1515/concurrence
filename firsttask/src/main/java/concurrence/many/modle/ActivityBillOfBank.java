package concurrence.many.modle;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public class ActivityBillOfBank implements Callable {

    public void setBankInfo(Map<String, Object> bankInfo) {
        this.bankInfo = bankInfo;
    }

    private  Map<String,Object> bankInfo = null;


    public String exportActivityBillOfBank(Map<String,Object> bankInfo) {
        return "";

    }

    //@Override
    public Object call() throws Exception {
       String finalUrl =  exportActivityBillOfBank(bankInfo);
        return finalUrl;
    }
}
