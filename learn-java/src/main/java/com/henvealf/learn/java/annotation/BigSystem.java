package com.henvealf.learn.java.annotation;

import com.henvealf.teach.annotation.an.LazyHuman;
import com.henvealf.teach.annotation.an.SmartRobot;
import com.henvealf.teach.annotation.an.WorldItem;

/**
 * Created by hongliang.yin/Henvealf on 2017/7/22.
 */
public class BigSystem {

    @SmartRobot()
    public void html() {
    }

    @SmartRobot()
    public void webService() {
    }

    @SmartRobot()
    public void statistical() {
    }

    @LazyHuman(name = "dt")
    public void sleep() {
    }

}
