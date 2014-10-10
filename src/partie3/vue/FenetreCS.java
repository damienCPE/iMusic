package partie3.vue;

import partie2.vueGraphique.Fenetre;

public class FenetreCS extends Fenetre {

    MenuBarreCS mbcs;
    
    public FenetreCS() {
        super();
        mbcs = new MenuBarreCS(this);
    }

    public MenuBarreCS getMenuBarreCS() {
        return this.mbcs;
    }
}
