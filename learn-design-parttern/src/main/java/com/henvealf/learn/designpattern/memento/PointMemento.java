package com.henvealf.learn.designpattern.memento;<<<<<<< HEAD
package com.henvealf.learn.design.memento;

/**
 * 一个备忘录
 * Created by Henvealf on 2017/11/12.
 */
public class PointMemento {

    private Point point;

    public PointMemento(Point point) {
        this.point = point.getClone();
    }

    public Point getPoint() {
        return point;
    }
}
=======
package com.henvealf.learn.design.memento;

/**
 * 一个备忘录
 * Created by Henvealf on 2017/11/12.
 */
public class PointMemento {


    public PointMemento() {
        
    }

}
>>>>>>> ebe284990ac53d43dc755980adfc2975c4f85b02
