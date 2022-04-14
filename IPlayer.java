package pyland;

/**
 * Mod�lise les joueurs.
 * Un joueur se d�place de salle en salle � la recherche de la sortie
 *  du labyrinthe.
 * @inv <pre>
 *     getLocation() == r ==> r.getVisitor() == this
 *     getHitPoints() >= 0
 *     isDead() <==> getHitPoints() == 0
 *     isDead() ==> hasLeft()
 *     getPowerLevel() >= 0 </pre>
 * @cons <pre>
 *     $DESC$ Un joueur qui n'est pas encore plac� dans une salle.
 *     $ARGS$ int hp
 *     $PRE$
 *         hp > 0
 *     $POST$
 *         getLocation() == null
 *         !hasLeft()
 *         getHitPoints() == hp
 *         getKey() == null
 *         getPowerLevel() == 0 </pre>
 */
public interface IPlayer {
    
    // REQUETES
    
    /**
     * Le nombre de points d'attaque de ce joueur.
     */
    int getHitPoints();
    
    /**
     * Donne la cl� du joueur.
     */
    Key getKey();
    
    /**
     * La salle dans laquelle se trouve le joueur.
     */
    IRoom getLocation();
    
    /**
     * La quantit� de superpouvoir du joueur.
     */
    int getPowerLevel();
    
    /**
     * Indique si le joueur est mort.
     */
    boolean isDead();
    
    /**
     * Indique si le joueur a arr�t� la partie.
     */
    boolean hasLeft();
    
    // COMMANDES
    
    /**
     * Fait s'arr�ter le joueur.
     * @pre <pre>
     *     !hasLeft() </pre>
     * @post <pre>
     *     hasLeft()
     *     getLocation() == old getLocation()
     *     getPowerLevel() == old getPowerLevel()
     *     getHitPoints() == old getHitPoints()
     *     getKey() == old getKey() </pre>
     */
    void leave();
    
    /**
     * Tue le joueur.
     * @pre
     *     !hasLeft()
     * @post <pre>
     *     getLocation() == old getLocation()
     *     getPowerLevel() == old getPowerLevel()
     *     isDead()
     *     getKey() == old getKey() </pre>
     */
    void kill();
    
    /**
     * Place le joueur dans la salle <code>r</code>.
     * @pre <pre>
     *     !hasLeft()
     *     getLocation() == null && r != null
     *     r.getVisitor() == null || r.getVisitor() == this </pre>
     * @post <pre>
     *     getLocation() == r
     *     l'�tat du joueur peut avoir chang� selon le type de r </pre>
     */
    void setLocation(IRoom r);
    
    /**
     * Transforme ce joueur en super h�ro pour q tours.
     * @pre <pre>
     *     q >= 0
     *     !hasLeft() </pre>
     * @post <pre>
     *     !hasLeft()
     *     getLocation() == old getLocation()
     *     getHitPoints() == old getHitPoints()
     *     getPowerLevel() == old getPowerLevel() + q
     *     getKey() == old getKey() </pre>
     */
    void setMorePowerful(int q);
    
    /**
     * Fait perdre des super pouvoirs au joueur.
     * @pre <pre>
     *     getPowerLevel() >= q >= 0
     *     !hasLeft() </pre>
     * @post <pre>
     *     !hasLeft()
     *     getLocation() == old getLocation()
     *     getHitPoints() == old getHitPoints()
     *     getPowerLevel() == old getPowerLevel() - q
     *     getKey() == old getKey() </pre>
     */
    void setLessPowerful(int q);
    
    /**
     * Augmente le nombre de points d'attaque de ce joueur.
     * @pre <pre>
     *     q >= 0
     *     !hasLeft() </pre>
     * @post <pre>
     *     !hasLeft()
     *     getLocation() == old getLocation()
     *     getPowerLevel() == old getPowerLevel()
     *     getHitPoints() == old getHitPoints() + q
     *     getKey() == old getKey() </pre>
     */
    void strengthen(int q);
    
    /**
     * Donne la cl� au joueur.
     * @pre <pre>
     *     !hasLeft()
     *     k != null </pre>
     * @post <pre>
     *     !hasLeft()
     *     getLocation() == old getLocation()
     *     getPowerLevel() == old getPowerLevel()
     *     getHitPoints() == old getHitPoints()
     *     getKey() == k </pre>
     */
    void pickUpKey(Key k);
    
    /**
     * Dissocie <code>getVisitor()</code> de cette salle.
     * @pre <pre>
     *     !hasLeft()
     *     getLocation() != null </pre>
     * @post <pre>
     *     getLocation() == null
     *     (old getLocation()).getVisitor() == null
     *     l'�tat du joueur peut avoir chang� selon le type de
     *      old getLocation() </pre>
     */
    void unsetLocation();
}
