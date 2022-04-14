package pyland;

public class DoomRoom extends Room implements IDoomRoom {
    
    // CONSTRUCTEURS
    
    public DoomRoom() {
        super();
    }
    
    // COMMANDES
    
    public void setVisitor(IPlayer v) {
        super.setVisitor(v);
        int powerLvl = v.getPowerLevel();
        if (powerLvl == 0) {
            v.kill();
        } else {
            v.setLessPowerful(powerLvl);
        }
    }
    
    protected String computeFengShuiEffect() {
        if (getVisitor().getPowerLevel() == 0) {
            return "Vous mourrez dans d'atroces souffrances.";
        } else {
            return "Vous sentez que seul un super héros pourra sortir d'ici.";
        }
    }
}