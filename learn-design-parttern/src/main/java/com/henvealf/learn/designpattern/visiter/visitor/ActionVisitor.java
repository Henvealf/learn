package com.henvealf.learn.designpattern.visiter.visitor;

import com.henvealf.learn.design.visiter.ele.ChineseTeacher;
import com.henvealf.learn.design.visiter.ele.MathTeacher;

/**
 * 一个 Visitor
 * Created by hongliang.yin/Henvealf on 2017/11/16.
 */
public interface ActionVisitor {
    // 计算数学公式
    public int getMathResult(MathTeacher teacher);
    // 朗读文章
    public void readTheText(ChineseTeacher teacher);
}
