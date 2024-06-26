package Components.drawer;

import Main.Panels.AdminRentedCars;
import Main.Panels.AdminCarPanel;
import Utils.CurrentFormHolder;
import Main.MainForms.Main;
import raven.drawer.Drawer;
import raven.drawer.component.SimpleDrawerBuilder;
import raven.drawer.component.footer.SimpleFooterData;
import raven.drawer.component.header.SimpleHeader;
import raven.drawer.component.header.SimpleHeaderData;
import raven.drawer.component.menu.*;
import raven.swing.AvatarIcon;
import Components.tabbed.WindowsTabbed;

public class AdminDrawerBuilder extends SimpleDrawerBuilder{
    
    @Override
    public SimpleHeaderData getSimpleHeaderData() {
        return new SimpleHeaderData()
                .setIcon(new AvatarIcon(getClass().getResource("/icons/icons8-user-24.png"), 60, 60, 999))
                .setTitle("Unknown")
                .setDescription("Unknown");
    }
    
    public void updateHeaderData(String username, String email) {
         SimpleHeaderData newHeaderData = new SimpleHeaderData()
            .setIcon(new AvatarIcon(getClass().getResource("/icons/icons8-user-24.png"), 60, 60, 999))
            .setTitle(username)
            .setDescription(email);
        
        // Get the header from the Drawer
        SimpleHeader header = (SimpleHeader) Drawer.getInstance().getDrawerPanel().getDrawerBuilder().getHeader();
        header.setSimpleHeaderData(newHeaderData);   // Set the new header data
    }
    
    public SimpleMenuOption getSimpleMenuOption() {
       
          String menus[][] = {
            {"~MANAGE CARS~"},
            {"Car","Rented Cars"},
            {"Logout"}};

         String icons[] = {
            "dashboard.svg",
            "logout.svg"};
         
        return new SimpleMenuOption()
                  .setMenus(menus)
                  .setIcons(icons)
                  .setBaseIconPath("svg")
                  .setIconScale(0.45f)
                  .addMenuEvent(new MenuEvent() {
                    @Override
                    public void selected(MenuAction action, int index, int subIndex) {
                        
                        if(index == 0){                
                            if(index == 0 && subIndex == 1)
                             WindowsTabbed.getInstance().addTab("Rented Card", new AdminRentedCars());
                            else
                             WindowsTabbed.getInstance().addTab("Cars", new AdminCarPanel(CurrentFormHolder.getInstance().getCurrentForm()));            
                        }else if(index == 1){
                            CurrentFormHolder.getInstance().closeCurrentForm(); // Close current form
                            Main main = new Main();
                            main.setVisible(true);
                        }
                    }
                 });
       }

    @Override
    public SimpleFooterData getSimpleFooterData() {
        return new SimpleFooterData()
                   .setTitle("PagZone Inc.")
                   .setDescription("Version 1.1.0");
    }    
}