package no.tellu;



import org.kevoree.annotation.*;

@ComponentType
public class ChatServer {

    
    @KevoreeInject
    org.kevoree.api.Context context;

    @Output
    org.kevoree.api.Port chatClients;

    @Input
    public void in(Object chatMessage) {
        String msg = chatMessage+" from "+context.getInstanceName()+"@"+context.getNodeName();
        System.out.println(msg);
        chatClients.send(msg, null);
    }

    @Start
    public void start() {}

    @Stop
    public void stop() {}

    @Update
    public void update() {System.out.println("Param updated!");}

}

