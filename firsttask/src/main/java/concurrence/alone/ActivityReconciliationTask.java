package concurrence.alone;

import java.util.HashMap;
import java.util.Map;


public class ActivityReconciliationTask {
    //@Scheduled(cron = "1 1 1 * * ?")
    public void expiredActivity() {
        for (int i = 0; i < 10; i++) {
            //按顺序执行任务
            Map<String, Object> bankInfo = new HashMap<String, Object>();
            bankInfo.put("activityBIllNo", "");
            bankInfo.put("listData", "");
            bankInfo.put("activityBillModel", "");

            String finalUrl = exportActivityBillOfBank(bankInfo);
        }
        for (int i = 0; i < 10; i++) {
            //按顺序执行任务
            Map<String, Object> bankInfo = new HashMap<String, Object>();
            bankInfo.put("activityBIllNo", "");
            bankInfo.put("listData", "");
            bankInfo.put("activityBillModel", "");

            String finalUrl = exportActivityBillOfBank(bankInfo);
        }
    }

    public String exportActivityBillOfBank(Map<String,Object> bankInfo) {
        return "";
    }

    public String exportActivityBillOfMerchant(Map<String,Object> merchantInfo) {
        return "";
    }
}
