/*
 * Fichier : LabyrintheGraphique.java
 * Créé le : 10 février 2007.
 * Modifié : 15 avril 2012.
 * Auteurs : Sébastien ESTIENNE.
 * SiteWeb : http://www.prog-info.org/
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package org.emp.gl.uiclock;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;

import javax.swing.JFrame;
import javax.swing.Timer;
import org.emp.gl.core.lookup.Lookup;
import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.myrobot.*;

/*
 * 
 * Classe affichant le parcours de labyrinthes
 *
 * @author Sébastien ESTIENNE.
 */
public class LabyrintheGraphique extends JFrame implements TimerChangeListener {

    
    MyRobot robot=Lookup.getInstance().getService(MyRobot.class);
    /**
     * <p>
     * Serial version UID.</p>
     */
    private static final long serialVersionUID = 1L;

    /**
     * La minuterie pour l'affichage des disques.
     */
    /**
     * Le labyrinthe.
     */
    /*   private boolean[][] labyrinthe = {
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
    {false, false, false, false, false, false, false, false, false, false, false, false}};*/
    /**
     * Le labyrinthe.
     */
    /* private boolean[][] labyrinthe1 = {
    {false, false, false, false, false, false, false, false, false, false, false, false},
    {false, true, true, true, false, true, true, true, true, true, true, false},
    {true, true, false, true, false, true, false, false, false, false, true, false},
    {false, false, false, true, false, true, true, true, true, false, true, false},
    {false, true, true, true, true, false, false, false, true, false, true, true},
    {false, false, false, false, true, false, true, false, true, false, true, false},
    {false, true, true, false, true, false, true, false, true, false, true, false},
    {false, false, true, false, true, false, true, false, true, false, true, false},
    {false, true, true, true, true, true, true, true, true, false, true, false},
    {false, false, false, false, false, false, true, false, false, false, true, false},
    {false, true, true, true, true, true, true, false, true, true, true, false},
    {false, false, false, false, false, false, false, false, false, false, false, false}};*/
    /**
     * Position courante en x dans le labyrinthe.
     */
   // private int x;

    /**
     * Position courante en y dans le labyrinthe.
     */
   // private int y;

    /**
     * Position de départ en x dans le labyrinthe.
     */
  //  private final int xd = 1;

    /**
     * Position de départ en y dans le labyrinthe.
     */
  //  private final int yd = 5;

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        if (evt.getPropertyName() == SECONDE_PROP) {
            robot.move();
            repaint(DEC_GAUCHE + (this.robot.x - 1) * TAILLE_CASE, DEC_HAUT + (this.robot.y - 1) * TAILLE_CASE,
                    3 * TAILLE_CASE, 3 * TAILLE_CASE);
        }
    }

    /**
     * Énumération pour la direction.
     */
   // public enum Direction {
        /**
         * Direction : vers la droite.
         */
        //DROITE,
        /**
         * Direction : vers le bas.
         */
      //  BAS,
        /**
         * Direction : vers la gauche.
         */
   //     GAUCHE,
        /**
         * Direction : vers le haut.
         */
    //    HAUT
    //}

    /**
     * La direction courante.
     */
    
    
    
    /*
    private Direction direction;
    
    public Direction getDirection() {
    return direction;
    }
    
    public void setDirection(Direction direction) {
    this.direction = direction;
    }*/

    /**
     * Taille du pion se déplaçant dans le labyrinthe.
     */
    private static final int TAILLE_PION = 18;

    /**
     * Taille des cases du labyrinthe.
     */
    private static final int TAILLE_CASE = 20;

    /**
     * Taille du décalage à gauche du labyrinthe.
     */
    private static final int DEC_GAUCHE = 25;

    /**
     * Taille du décalage en haut du labyrinthe.
     */
    private static final int DEC_HAUT = 50;

    /**
     * <p>
     * Constructeur initialisant la fenêtre.</p>
     */
    public LabyrintheGraphique() {
        super("Labyrinthe graphique");

        // Initialisation du labyrinthe.
        this.robot.x = 2;
        this.robot.y = 2;
      //  this.direction = Direction.GAUCHE;
        robot.setEtat(new MovingRightState(robot));

        // Propriétés de la fenêtre.
        setLocation(50, 50);
        setSize(295, 315);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * <p>
     * Algorithme permettant d'avancer dans le labyrinthe.</p>
     */
    /*  public void avancer1() {
    // Vérification de terminaison.
    if (this.x == this.xd && this.y == this.yd || this.x > 0 && this.y > 0
    && this.x < this.labyrinthe[0].length && this.y < this.labyrinthe.length) {
    switch (this.direction) {
    // Direction de déplacement : Droite.
    case DROITE:
    // Pas de mur sur la droite : dans un angle.
    if (this.y + 1 < this.labyrinthe.length && this.labyrinthe[this.y + 1][this.x]) {
    this.direction = Direction.BAS;
    this.y++;
    } // Un mur selon la direction de déplacement.
    else if (this.x + 1 < this.labyrinthe[0].length && !this.labyrinthe[this.y][this.x + 1]) {
    // Changement de direction suivant le mur.
    if (this.y - 1 >= 0 && this.labyrinthe[this.y - 1][this.x]) {
    this.direction = Direction.HAUT;
    this.y--;
    } // Impasse : demi-tour.
    else {
    this.direction = Direction.GAUCHE;
    this.x--;
    }
    } // Case libre devant : déplacement selon la direction.
    else if (this.x + 1 < this.labyrinthe[0].length) {
    this.x++;
    } else {
    //this.minuterie.stop();
    }
    break;
    // Direction de déplacement : Bas.
    case BAS:
    // Pas de mur sur la droite : dans un angle.
    if (this.x - 1 >= 0 && this.labyrinthe[this.y][this.x - 1]) {
    this.direction = Direction.GAUCHE;
    this.x--;
    } // Un mur selon la direction de déplacement.
    else if (this.y + 1 < this.labyrinthe.length && !this.labyrinthe[this.y + 1][this.x]) {
    // Changement de direction suivant le mur.
    if (this.x + 1 < this.labyrinthe[0].length && this.labyrinthe[this.y][this.x + 1]) {
    this.direction = Direction.DROITE;
    this.x++;
    } // Impasse : demi-tour.
    else {
    this.direction = Direction.HAUT;
    this.y--;
    }
    } // Case libre devant : déplacement selon la direction.
    else if (this.y + 1 < this.labyrinthe.length) {
    this.y++;
    } else {
    //this.minuterie.stop();
    }
    break;
    // Direction de déplacement : Gauche.
    case GAUCHE:
    // Pas de mur sur la droite : dans un angle.
    if (this.y - 1 >= 0 && this.labyrinthe[this.y - 1][this.x]) {
    this.direction = Direction.HAUT;
    this.y--;
    } // Un mur selon la direction de déplacement.
    else if (this.x - 1 >= 0 && !this.labyrinthe[this.y][this.x - 1]) {
    // Changement de direction suivant le mur.
    if (this.y + 1 < this.labyrinthe[0].length && this.labyrinthe[this.y + 1][this.x]) {
    this.direction = Direction.BAS;
    this.y++;
    } // Impasse : demi-tour.
    else {
    this.direction = Direction.DROITE;
    this.x++;
    }
    } // Case libre devant : déplacement selon la direction.
    else if (this.x - 1 >= 0) {
    this.x--;
    } else {
    //this.minuterie.stop();
    }
    break;
    // Direction de déplacement : Haut.
    case HAUT:
    // Pas de mur sur la droite : dans un angle.
    if (this.x + 1 < this.labyrinthe.length && this.labyrinthe[this.y][this.x + 1]) {
    this.direction = Direction.DROITE;
    this.x++;
    } // Un mur selon la direction de déplacement.
    else if (this.y - 1 >= 0 && !this.labyrinthe[this.y - 1][this.x]) {
    // Changement de direction suivant le mur.
    if (this.x - 1 >= 0 && this.labyrinthe[this.y][this.x - 1]) {
    this.direction = Direction.GAUCHE;
    this.x--;
    } // Impasse : demi-tour.
    else {
    this.direction = Direction.BAS;
    this.y++;
    }
    } // Case libre devant : déplacement selon la direction.
    else if (this.y - 1 >= 0) {
    this.y--;
    } else {
    //this.minuterie.stop();
    }
    break;
    default:
    break;
    }
    }
    }*/
    /*   public void avancer() {
    
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
    }*/
    /**
     * <p>
     * Dessine la fenêtre.</p>
     *
     * @param g Le contexte graphique utilisé pour dessiner.
     */
    @Override
    public void paint(Graphics g) {
        // Parcourt le labyrinthe.
        for (int i = 0; i < this.robot.labyrinthe.length; i++) {
            for (int j = 0; j < this.robot.labyrinthe.length; j++) {
                // Case libre.
                if (this.robot.labyrinthe[i][j]) {
                    g.setColor(Color.WHITE);
                    g.fillRect(DEC_GAUCHE + j * TAILLE_CASE, DEC_HAUT + i * TAILLE_CASE,
                            TAILLE_CASE, TAILLE_CASE);
                    g.setColor(Color.LIGHT_GRAY);
                    g.drawRect(DEC_GAUCHE + j * TAILLE_CASE, DEC_HAUT + i * TAILLE_CASE,
                            TAILLE_CASE, TAILLE_CASE);
                } // Mur.
                else {
                    g.setColor(Color.BLUE);
                    g.fillRect(DEC_GAUCHE + j * TAILLE_CASE, DEC_HAUT + i * TAILLE_CASE,
                            TAILLE_CASE, TAILLE_CASE);
                }
            }
        }

        // Position courante dans le labyrinthe.
        g.setColor(Color.RED);
        g.fillOval(DEC_GAUCHE + 1 + this.robot.x * TAILLE_CASE, DEC_HAUT + 1 + this.robot.y * TAILLE_CASE,
                TAILLE_PION, TAILLE_PION);
    }

    
    /**
     * <p>
     * Commence l'exécution du programme.</p>
     *
     * @param args Les paramètres de la ligne de commande.
     */
    public static void main(String[] args) {
        new LabyrintheGraphique();
    }
}
