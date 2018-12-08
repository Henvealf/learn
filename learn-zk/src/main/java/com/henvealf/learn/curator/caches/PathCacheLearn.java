package com.henvealf.learn.curator.caches;

import com.henvealf.learn.curator.CuratorConstants;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.*;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.log4j.net.SyslogAppender;
import org.junit.Test;

import java.lang.reflect.ParameterizedType;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * <p>
 *
 * <p>
 *
 * @author hongliang.yin/Henvealf on 2018/12/8
 */
public class PathCacheLearn {


    public static final String PATH = "/henvealf/caches/path";

    public static void main(String[] args) throws Exception {

        CuratorFramework cf = CuratorFrameworkFactory.newClient(CuratorConstants.ZK_URL, new ExponentialBackoffRetry(1000, 3));
        cf.start();

        if (cf.checkExists().forPath(PATH) == null) {
            cf.create().creatingParentsIfNeeded().forPath(PATH);

//            for (int i = 0; i < 3; i ++) {
//                cf.create().forPath(PATH + "/cache-"+i, (" i ma cache data " + i).getBytes(StandardCharsets.UTF_8));
//            }

        }


        PathChildrenCache pathChildrenCache = new PathChildrenCache(cf, PATH, true);


        pathChildrenCache.getListenable().addListener((curatorFramework, pathChildrenCacheEvent) -> {
            switch (pathChildrenCacheEvent.getType()) {
                case INITIALIZED:
                    System.out.println(" path cache have INITIALIZED event");

                    List<ChildData> currentDatas = pathChildrenCache.getCurrentData();
//
//                    for (ChildData childData: currentDatas) {
//                        System.out.println("childData.getPath(): " + childData.getPath());
//                        System.out.println("childData.getData(): " + new String(childData.getData()));
//                        System.out.println("childData.getStat(): " + childData.getStat().toString());
//                    }
                    System.out.println("child size in INITIALIZED listener: " + currentDatas.size());


                    break;
                case CHILD_ADDED:
                    System.out.println(" path child has add");

                    currentDatas = pathChildrenCache.getCurrentData();
//
//                    for (ChildData childData: currentDatas) {
//                        System.out.println("childData.getPath(): " + childData.getPath());
//                        System.out.println("childData.getData(): " + new String(childData.getData()));
//                        System.out.println("childData.getStat(): " + childData.getStat().toString());
//                    }
                    System.out.println("child size in CHILD_ADDED listener: " + currentDatas.size());

                    break;
                case CHILD_REMOVED:
                    System.out.println(" path child has remove");
                    break;
                case CHILD_UPDATED:
                    System.out.println(" path child has update");
                    break;
            }
        });

        pathChildrenCache.start(PathChildrenCache.StartMode.NORMAL);


        List<ChildData> currentDatas = pathChildrenCache.getCurrentData();

        for (ChildData childData: currentDatas) {
            System.out.println("childData.getPath(): " + childData.getPath());
            System.out.println("childData.getData(): " + new String(childData.getData()));
            System.out.println("childData.getStat(): " + childData.getStat().toString());
        }
        System.out.println("child size: " + currentDatas.size());

        // 开始cache 并手动添加新的节点。

        System.out.println("begin sleep..");
//        System.out.println("begin add..");
//        cf.create().forPath(PATH + "/cache-" + System.currentTimeMillis(), ("i am new " + System.currentTimeMillis()).getBytes());
//        System.out.println("end add..");
        Thread.sleep(1000);

        pathChildrenCache.close();
        cf.close();

    }

}
