package com.cluster.midware.service.base;

import com.cluster.midware.service.notify.PostgresNotifyService;
import com.cluster.midware.service.push.PushMsg2DoctorService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/**
 * @description: 所有业务线程管理器
 * @author: fuyl
 * @create: 2020-08-14 10:44
 **/
@Component
public class ServiceThreadManagerRunner {


    /**
     * 数据库XXX通知
     */
    @Autowired
    private PostgresNotifyService postgresNotifyService;
    @Autowired
    private PushMsg2DoctorService pushMsg2DoctorService;

//
//    @Autowired
//    private ModeServiceImpl modeService;

    //定义线程池
    @Autowired
    private ThreadPoolTaskExecutor executor;
//    private static ExecutorService executor = new ThreadPoolExecutor(2, 2, 0L,
//            TimeUnit.MILLISECONDS,
//            new LinkedBlockingQueue<>(10),
//            Executors.defaultThreadFactory(),
//            new ThreadPoolExecutor.AbortPolicy());

//    private static Map<ConsumerTaskRunner,ExecutorService> executorMap = new HashMap<>();

    public void submit(){

        //传过来是什么 在加入到线程管理器中 何时判断是否加入到线程池
//        ConsumerTaskRunner runner = SpringContextHolder.getBean("");
//        if(!executorMap.containsKey(runner)){
//            executorMap.put(runner,executor);
//        }
//        //遍历map 去 submit
//        Iterator<Map.Entry<ConsumerTaskRunner, ExecutorService>> iterator = executorMap.entrySet().iterator();
//        while(iterator.hasNext()){
//            Map.Entry<ConsumerTaskRunner, ExecutorService> next = iterator.next();
//            ConsumerTaskRunner key = next.getKey();
//            executor.submit(key);
//        }
        executor.execute(postgresNotifyService);
        executor.execute(pushMsg2DoctorService);
    }
}
