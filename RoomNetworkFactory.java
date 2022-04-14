package pyland;

/**
 * Fabrique du r�seau des salles.
 * Cette classe est non instanciable car c'est une fabrique.
 * Elle est dot�e d'une m�thode statique qui donne acc�s � l'instance de
 *  IRoomNetwork n�cessaire au jeu sans que l'on ait connaissance de la classe
 *  de cette instance.
 */
public final class RoomNetworkFactory {
    
    // CONSTANTES
    
    private static final IRoomNetwork NETWORK = new RoomNetwork();
    
    // CONSTRUCTEURS
    
    private RoomNetworkFactory() {
        // pas d'instanciation possible
    }
    
    public static IRoomNetwork get() {
        return NETWORK;
    }
}
