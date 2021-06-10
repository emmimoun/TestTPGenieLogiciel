/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.myrobot;

/**
 *
 * @author berrg
 */
public class MovingLeftState extends MovingState {

    public MovingLeftState(MyRobot myRobot) {
        super(myRobot);
    }

    @Override
    public void goDown() {
        myRobot.setEtat(new MovingDownState(myRobot));
    }

    @Override
    public void goUp() {
        myRobot.setEtat(new MovingUpState(myRobot));
    }

    @Override
    public void move() {

        if (this.myRobot.x - 1 > 0) {
            this.myRobot.x--;
        }
    }

}
