import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;


public class mqttPub {

  MqttClient client;
  
  public mqttPub() {}

  public static void main(String[] args) {
    new mqttPub().doDemo();
  }

  public void doDemo() {
    try {
      client = new MqttClient("tcp://127.0.0.1:1883", "pahomqttPublish1");
      client.connect();
      MqttMessage message = new MqttMessage();
      message.setPayload("A single message".getBytes());
      
      while(true){
    	  client.publish("TEST", message);
    	  System.out.println("--Pub: "+message.toString());
    	  try{
    		  	Thread.sleep(3000);//1000ms = 1sec  		  	
    	  }catch(InterruptedException e){
    			System.err.println("Interrupted");
    	  }
      }     
//      client.disconnect();   
//      System.out.println("Hello");
    
    } catch (MqttException e) {
      e.printStackTrace();
      System.out.println("World");
    }
  }
}