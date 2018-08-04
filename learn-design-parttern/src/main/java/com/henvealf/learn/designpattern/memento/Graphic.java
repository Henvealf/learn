package com.henvealf.learn.designpattern.memento;

<<<<<<< HEAD
package com.henvealf.learn.design.memento;

import java.security.cert.PolicyNode;

/**
 * 一个图形
 * Created by Henvealf on 2017/11/12.
 */
public class Graphic {

    private Point point;


    public Graphic(Point point) {
        this.point = point.getClone();
    }

    public Graphic(int x, int y) {
        this.point = new Point(x, y);
    }

    public void move(Point point){
        this.point = point.getClone();
    }

    public Point getPoint(){
        return point;
    }

    @Override
    public String toString() {
        return point.getX() + ", " + point.getY();
    }
}
=======
package com.henvealf.learn.design.memento;

import java.security.cert.PolicyNode;

/**
 * 一个图形
 * Created by Henvealf on 2017/11/12.
 */
public class Graphic {

    private Point point;


    public Graphic(Point point) {
        this.point = point.getClone();
    }

    public Graphic(int x, int y) {
        this.point = new Point(x, y);
    }



    public void move(Point point){
        this.point = point.getClone();
    }



}
>>>>>>> ebe284990ac53d43dc755980adfc2975c4f85b02
