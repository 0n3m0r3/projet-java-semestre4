package pyland;

public class ExitRoom extends NormalRoom implements INormalRoom {
    
    // CONSTRUCTEURS
    
    public ExitRoom() {
        super();
    }
    
    // COMMANDES
    
    public void setVisitor(IPlayer v) {
        super.setVisitor(v);
        v.leave();
    }
    
    protected String computeFengShuiEffect() {
        return "Vous êtes sorti des griffes de PY le maléfique !";
    }
}