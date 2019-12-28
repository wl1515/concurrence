package concurrence.many.modle;


import java.util.Map;
import java.util.concurrent.Callable;

public class ActivityBillOfMerchant implements Callable {


    public void setMerchantInfo(Map<String, Object> merchantInfo) {
        this.merchantInfo = merchantInfo;
    }

    private  Map<String,Object> merchantInfo = null;


    public String exportActivityBillOfMerchant(Map<String,Object> merchantInfo) {
        return "";

    }

    //@Override
    public Object call() throws Exception {
        String finalUrl =  exportActivityBillOfMerchant(merchantInfo);
        return finalUrl;
    }
}
