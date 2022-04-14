package pyland.util.cmd;

import pyland.IPlayer;

/**
 * Mod�lise les commandes.
 *
 * @inv <pre>
 *    argsNb() >= 0
 *    describeLastAction() != null
 *    (getName() != null) && !getName().equals("") </pre>
 * @cons <pre>
 * $DESC$
 *     Une commande munie d'une s�quence d'arguments dont la repr�sentation
 *      textuelle se trouve dans args.
 * $ARGS$
 *     String[] args
 * $PRE$
 *     args != null
 * $POST$
 *     Soit min ::= min(argsNb(), args.length)
 *         forall i:[0 .. min[ :
 *             getArgument(i) est l'objet que repr�sente la cha�ne args[i]
 *         forall i:[min + 1 .. argsNb() - 1] :
 *             getArgument(i) == null
 *     describeLastAction().equals("") </pre>
 */
public interface ICommand {
    
    // REQUETES
    
    /**
     * Le nombre d'arguments de cette commande.
     */
    int argsNb();
    
    /**
     * D�crit le r�sultat de la derni�re ex�cution de cette commande.
     */
    String describeLastAction();
    
    /**
     * Le i�me argument de cette commande.
     * @pre <pre>
     *     0 <= i < argsNb() </pre>
     */
    Object getArgument(int i);
    
    /**
     * Le nom de cette commande (extrait du nom de la classe).
     */
    String getName();
    
    // COMMANDES
    
    /**
     * Ex�cute cette commande pour le joueur <code>p</code>.
     * Il se peut que l'ex�cution de cette commande ait modifi� un ou plusieurs
     *  arguments de la commande...
     * @pre <pre>
     *     p != null </pre>
     * @post <pre>
     *     p a �t� modifi� en accord avec l'ex�cution de la commande
     *     describeLastAction() refl�te l'ex�cution de cette commande
     *     getName() == old getName()
     *     argsNb() == old argsNb() </pre>
     */
    void executeFor(IPlayer p);
}
