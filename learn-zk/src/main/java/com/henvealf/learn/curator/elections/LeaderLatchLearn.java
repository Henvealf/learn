package com.henvealf.learn.curator.elections;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;


/**
 *
 * leader 闩
 * @author hongliang.yin/Henvealf on 2018/12/5
 */
public class LeaderLatchLearn {

    public static void main(String[] args) throws Exception {

        String zkUrl = "localhost:2181";
        String path = "/henvealf/elections/leaderlatch";

        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);

        CuratorFramework cf = CuratorFrameworkFactory.newClient(zkUrl, retryPolicy);
        cf.start();

        cf.create().creatingParentsIfNeeded().forPath(path);
//
//        LeaderLatch leaderLatch = new LeaderLatch(cf, path);
//
//
//
//        leaderLatch.addListener(new LeaderLatchListener() {
//            @Override
//            public void isLeader() {
//                System.out.println("I am leader");
//            }
//
//            @Override
//            public void notLeader() {
//                System.out.println("I am not leader");
//            }
//        });
//
//
//        leaderLatch.start();
//
//
//        boolean hasLeadership = leaderLatch.hasLeadership();
//        System.out.println("hasLeadership:" + hasLeadership);
//
//        Participant leader = leaderLatch.getLeader();
//
//        System.out.println("leader.getId(): " + leader.getId());
//
//        System.out.println("leader.toString(): " + leader.toString());
//        System.out.println("leader.hashCode(): " + leader.hashCode());

//        Thread.sleep(1000 * 10);
//        leaderLatch.close();
        cf.close();

    }

}
