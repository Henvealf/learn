package com.henvealf.learn.designpattern.visiter;

import com.henvealf.learn.design.visiter.ele.ChineseTeacher;
import com.henvealf.learn.design.visiter.ele.MathTeacher;
import com.henvealf.learn.design.visiter.ele.Teacher;
import com.henvealf.learn.design.visiter.visitor.ActionVisitor;
import com.henvealf.learn.design.visiter.visitor.BadActionVisitor;
import com.henvealf.learn.design.visiter.visitor.GoodActionVisitor;

/**
 * Created by hongliang.yin/Henvealf on 2017/11/16.
 */
public class Client {

    public static void main(String[] args) {
        ActionVisitor visitor = new BadActionVisitor();
        School school = new School();
        school.beginTeach(visitor);
    }
}
