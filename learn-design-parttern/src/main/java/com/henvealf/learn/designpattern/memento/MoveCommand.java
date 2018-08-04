package com.henvealf.learn.designpattern.memento;<<<<<<< HEAD
package com.henvealf.learn.design.memento;

/**
 * 代表一个 改变命令
 * Created by Henvealf on 2017/11/12.
 */
public class MoveCommand {

    private Graphic graphic;
    private Point delta;
    private PointMemento pointMemento = null;

    public MoveCommand(Graphic graphic, Point delta) {
        this.graphic = graphic;
        this.delta = delta;
    }

    public void execute() {
        Point afterPoint = graphic.getPoint();
        pointMemento = new PointMemento(afterPoint);
        graphic.move(delta);
    }

    // 撤销
    public void unExecute() {
        if (pointMemento == null) {
            return;
        }
        Point point = pointMemento.getPoint();
        graphic.move(point);
    }
}
=======
package com.henvealf.learn.design.memento;

/**
 * 代表一个改变命令
 * Created by Henvealf on 2017/11/12.
 */
public class MoveCommand {

    private Graphic graphic;
    private Point delta;

    public MoveCommand(Graphic graphic, Point delta) {
        this.graphic = graphic;
        this.delta = delta;
    }

    public void execute() {
        graphic.move(delta);
    }

    public void unExecute() {

    }
}
>>>>>>> ebe284990ac53d43dc755980adfc2975c4f85b02
