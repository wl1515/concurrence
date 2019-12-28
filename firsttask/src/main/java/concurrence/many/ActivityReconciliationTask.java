package concurrence.many;




import com.google.common.util.concurrent.ThreadFactoryBuilder;
import concurrence.many.modle.ActivityBillOfBank;
import concurrence.many.modle.ActivityBillOfMerchant;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;


public class ActivityReconciliationTask {

    public void expiredActivityBank() {
        //创建线程池
        ThreadPoolExecutor executor = createTreadPoolExecutor();
        for (int i = 0; i < 10; i++) {
            //添加任务
            Map<String, Object> bankInfo = new HashMap<String, Object>();
            bankInfo.put("activityBIllNo", "");
            bankInfo.put("listData", "");
            bankInfo.put("activityBillModel", "");

            ActivityBillOfBank activityBillOfBank = new ActivityBillOfBank();
            activityBillOfBank.setBankInfo(bankInfo);
            Callable worker = activityBillOfBank;
            Future future = executor.submit(worker);
            String finalUrl = "";
            try {
                finalUrl = (String) future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        //销毁线程池
        executor.shutdown();

        while (!executor.isTerminated()){  System.out.println("没有结束"); }
        System.out.println("Good Bye!");
    }


    //@Scheduled(cron = "1 1 1 * * ?")
    public void expiredActivityMerchant() {
        //创建线程池
        ThreadPoolExecutor executor = createTreadPoolExecutor();
        for (int i = 0; i < 10; i++) {
            //添加任务
            Map<String, Object> merchantInfo = new HashMap<String, Object>();
            merchantInfo.put("activityBIllNo", "");
            merchantInfo.put("listData", "");
            merchantInfo.put("activityBillModel", "");

            ActivityBillOfMerchant activityBillOfMerchant = new ActivityBillOfMerchant();
            activityBillOfMerchant.setMerchantInfo(merchantInfo);
            Callable worker = activityBillOfMerchant;
            Future future = executor.submit(worker);
            String finalUrl = "";
            try {
                finalUrl = (String) future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

        }
        //销毁线程池
        executor.shutdown();

        while (!executor.isTerminated()){  System.out.println("没有结束"); }
        System.out.println("Good Bye!");

    }


    /**
     * 创建线程池
     */
    public ThreadPoolExecutor createTreadPoolExecutor() {
        int corePoolSize = 2;
        int maximumPoolSizeSize = 5;
        long keepAliveTime = 1;
        ArrayBlockingQueue workQueue = new ArrayBlockingQueue(10);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                corePoolSize,
                maximumPoolSizeSize,
                keepAliveTime,
                TimeUnit.SECONDS,
                workQueue,
                new ThreadFactoryBuilder().setNameFormat("XX-task-%d").build());

        return executor;

    }
}

