package pyland.util.cmd;

import pyland.IPlayer;
import pyland.IRoom;
import pyland.IRoomNetwork;
import pyland.RoomNetworkFactory;
import pyland.util.Direction;

/**
 * @inv <pre>
 *     argsNb() == 1
 *     getArgument(0) instanceof Direction </pre>
 */
class GoCommand extends Command {
    
    // CONSTANTES
    
    private static final String INDENT = "     ";
    
    // CONSTRUCTEURS
    
    /**
     * @pre <pre>
     *     args != null </pre>
     * @post <pre>
     *     args.length == 0 ==> getArgument(0) == null
     *     args.length > 0  ==> getArgument(0) == Direction.valueOf(args[0])
     * </pre>
     */
    GoCommand(String[] args) {
        super(convertArgs(args));
    }
    
    // COMMANDES

    public void executeFor(IPlayer p) {
        if (p == null) {
            throw new AssertionError();
        }
        
        // Essayer de quitter la pi�ce courante.
        Direction dir = (Direction) getArgument(0);
        if (dir == null) {
            setDescription(
                    "Aller... oui, mais o� ? Ce n'est pas une direction !"
            );
        } else {
            IRoomNetwork net = RoomNetworkFactory.get();
            IRoom crtRoom = p.getLocation();
            if (!net.canExit(crtRoom, dir)) {
                // il n'y a pas de passage
                IRoom r = net.getRoom(crtRoom, dir);
                if (r == null) {
                    setDescription("A�e ! Il n'y a pas de passage par l� !");
                } else {
                    setDescription("A�e ! La porte est ferm�e � cl� !");
                }
            } else {
                // il y a un passage
                crtRoom = net.getRoom(crtRoom, dir);
                p.unsetLocation();
                p.setLocation(crtRoom);
                String desc = crtRoom.fengShuiEffect();
                setDescription(indent(desc));
            }
        }
    }
    
    // OUTILS
    
    private static String indent(String message) {
        String result = "Vous avez chang� de pi�ce.";
        String[] parts = message.split("\n");
        for (int i = 0; i < parts.length; i++) {
            String s = parts[i].trim();
            if (!s.equals("")) {
                result += "\n" + INDENT + s;
            }
        }
        return result;
    }
    
    private static Object[] convertArgs(String[] args) {
        if (args == null) {
            throw new IllegalArgumentException();
        }
        
        if (args.length == 0) {
            return new Object[] { null };
        } else {
            return new Object[] { Direction.valueOf(args[0]) };
        }
    }
}
