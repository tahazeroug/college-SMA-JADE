import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class RecepteurAgent extends Agent {
    protected void setup() {
        System.out.println("Agent " + getLocalName() + " est prêt.");

        addBehaviour(new CyclicBehaviour() {
            public void action() {
                ACLMessage msg = receive();
                if (msg != null) {
                    System.out.println("Message reçu de " + msg.getSender().getLocalName() + " : " + msg.getContent());

                    // Delay 5 seconds before replying
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    ACLMessage reply = msg.createReply();
                    reply.setPerformative(ACLMessage.INFORM);
                    reply.setContent("Bien reçu !");
                    send(reply);
                    System.out.println("Réponse envoyée après 5 sec.");
                } else {
                    block();
                }
            }

        });
    }
}