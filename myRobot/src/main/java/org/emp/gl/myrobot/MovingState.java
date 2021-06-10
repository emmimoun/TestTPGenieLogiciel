/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.myrobot;

import org.emp.gl.actiondo.RobotAction;;


/**
 *
 * @author berrg
 */
public abstract class MovingState implements RobotAction{

    public MovingState(MyRobot myRobot) {
        this.myRobot = myRobot;
    }
       MyRobot myRobot;
       
       
       
    @Override
    public void goDown() {  }

    @Override
    public void goUp() {
    }

    @Override
    public void doRight() {
    }

    @Override
    public void goLeft() {
    }

    @Override
    public void move() {
    }
       
    
}
