package cn.microboat.utils;

import cn.microboat.Constants;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zhouwei
 */
public class ThreadUtils {
    public static final ExecutorService THREAD_POOL = new ThreadPoolExecutor(Constants.THREAD_POOL_CORE_POOL_SIZE, Constants.THREAD_POOL_MAX_POOL_SIZE, Constants.THREAD_POOL_TIME_WAIT, TimeUnit.SECONDS, new ArrayBlockingQueue<>(Constants.THREAD_POOL_BLOCKING_QUEUE_SIZE), new ThreadFactoryBuilder().setNameFormat("Spring-Cloud-Thread-").build());
}
