import jade.core.Agent;
import jade.core.AID;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

public class EmetteurAgent extends Agent {
    protected void setup() {
        addBehaviour(new OneShotBehaviour() {
            public void action() {
                ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
                msg.addReceiver(new AID("Alice", AID.ISLOCALNAME));
                msg.setContent("Hello, es-tu là ?");
                send(msg);
                System.out.println("Message envoyé à Alice.");
            }
        });
    }
}