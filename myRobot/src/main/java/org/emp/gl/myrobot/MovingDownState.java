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
public class MovingDownState extends MovingState {

    public MovingDownState(MyRobot mr) {
        super(mr);
    }

    @Override
    public void doRight() {
        myRobot.setEtat(new MovingRightState(myRobot));
    }

    @Override
    public void goLeft() {
        myRobot.setEtat(new MovingLeftState(myRobot));
    }

    @Override
    public void move() {
        if (this.myRobot.y + 2 < this.myRobot.labyrinthe.length ) {
            this.myRobot.y++;
        }
    }

}
