package pyland;

public class NormalRoom extends Room implements INormalRoom {
    
    // CONTRUCTEURS
    
    public NormalRoom() {
        super();
    }
    
    // COMMANDES
    
    public void setVisitor(IPlayer v) {
        super.setVisitor(v);
        if (v.getPowerLevel() > 0) {
            v.setLessPowerful(POWER_LOSS);
        }
    }
    
    protected String computeFengShuiEffect() {
        return "Il n'y a rien de spécial ici...";
    }
}
