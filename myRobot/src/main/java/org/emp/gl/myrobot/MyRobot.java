/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.myrobot;

import org.emp.gl.actiondo.RobotAction;

/**
 *
 * @author berrg
 */
public class MyRobot implements RobotAction{
    
     public boolean[][] labyrinthe = {
        {false, false, false, false, false, false, false, false, false, false, false, false},
        {false, true, true, true, true, true, true, true, true, true, true, false},
        {false, true, true, true, true, true, true, true, true, true, true, false},
        {false, true, true, true, true, true, true, true, true, true, true, false},
        {false, true, true, true, true, true, true, true, true, true, true, false},
        {false, true, true, true, true, true, true, true, true, true, true, false},
        {false, true, true, true, true, true, true, true, true, true, true, false},
        {false, true, true, true, true, true, true, true, true, true, true, false},
        {false, true, true, true, true, true, true, true, true, true, true, false},
        {false, true, true, true, true, true, true, true, true, true, true, false},
        {false, true, true, true, true, true, true, true, true, true, true, false},
        {false, false, false, false, false, false, false, false, false, false, false, false}};
    /**
     * Position courante en x dans le labyrinthe.
     */
    public int x;

    /**
     * Position courante en y dans le labyrinthe.
     */
    public int y;

     
    public enum Direction {
        /**
         * Direction : vers la droite.
         */
        DROITE,
        /**
         * Direction : vers le bas.
         */
        BAS,
        /**
         * Direction : vers la gauche.
         */
        GAUCHE,
        /**
         * Direction : vers le haut.
         */
        HAUT
    }
    
    public void avancer() {

        switch (this.direction) {
            // Direction de déplacement : Droite.
            case DROITE:
                 // Case libre devant : déplacement selon la direction.
                if (this.x + 2 < this.labyrinthe[0].length) {
                    this.x++;
                }
                break;
            // Direction de déplacement : Bas.
            case BAS:
                // Case libre devant : déplacement selon la direction.
                if (this.y + 2 < this.labyrinthe.length) {
                    this.y++;
                }
                break;
            // Direction de déplacement : Gauche.
            case GAUCHE:
                // Case libre devant : déplacement selon la direction.
                 if (this.x - 1 > 0) {
                    this.x--;
                }
                break;
            // Direction de déplacement : Haut.
            case HAUT:
                // Case libre devant : déplacement selon la direction.
                if (this.y - 1 > 0) {
                    this.y--;
                }
                break;
            default:
                break;

        }
    }
    
   MovingState etat;
   Direction direction;
    public MyRobot() {
    }

    public MovingState getEtat() {
        return etat;
    }

    public void setEtat(MovingState etat) {
        this.etat = etat;
    }

    @Override
    public void goDown() {
etat.goDown();    }

    @Override
    public void goUp() {
etat.goUp();    }

    @Override
    public void doRight() {
        etat.doRight();
    }

    @Override
    public void goLeft() {
etat.goLeft();    }

    @Override
    public void move() {
etat.move();    }
   
    
    
    
}
