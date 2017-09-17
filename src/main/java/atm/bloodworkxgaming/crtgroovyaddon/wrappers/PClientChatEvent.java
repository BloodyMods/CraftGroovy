package atm.bloodworkxgaming.crtgroovyaddon.wrappers;

import net.minecraftforge.client.event.ClientChatEvent;

public class PClientChatEvent {

    public String message;

    public PClientChatEvent(ClientChatEvent e){
        this.message = e.getMessage();
    }
}
