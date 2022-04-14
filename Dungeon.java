package pyland;

public class Dungeon extends NormalRoom implements IDungeon {
    
    // ATTRIBUTS
    
    private boolean isPrincessCaptive;
    
    // CONSTRUCTEUR
    
    public Dungeon() {
        super();
        isPrincessCaptive = true;
    }
    
    // REQUETES

    public boolean isPrincessCaptive() {
        return isPrincessCaptive;
    }

    // COMMANDES

    public void setVisitor(IPlayer v) {
        super.setVisitor(v);
        isPrincessCaptive = false;
    }
    
    protected String computeFengShuiEffect() {
        return "Vous avez libéré la princesse !";
    }
}
