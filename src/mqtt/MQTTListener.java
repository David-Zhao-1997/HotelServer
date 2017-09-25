package mqtt;


import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.util.UUID;

import entity.DataPoint;
import entity.SharedValues;


public class MQTTListener
{
    static final String broker = "ssl://hotel.mqtt.iot.gz.baidubce.com:1884";
    static final String clientId = "test_mqtt_java_" + UUID.randomUUID().toString();
    static final String username = "hotel/server";
    static final String password = "u5U4uJFaJhDMPyswUcPfxZX8JWgNKkqNq+HxeP60kDw=";

    static final String topic = "tpc_nodeMCU_001";
    static final String serverTopic = "serverTopic";
    private static MqttClient client;

    //    MqttClient client;

    static int count = 0;
    private static MqttConnectOptions options;
    private static String[] topic1;
    private static int[] qos;

    public static class PushCallback implements MqttCallback
    {

        @Override
        public void connectionLost(Throwable cause)
        {
            try
            {
                client.connect(options);
                client.subscribe(topic1, qos);
            }
            catch (MqttException e)
            {
                e.printStackTrace();
            }
        }

        @Override
        public void messageArrived(String topic, MqttMessage message) throws Exception
        {
//            if (!"-----".equals(message.toString()))
            {
                System.out.println("MQTT message received: " + (count++) + " " + message.toString());
//                System.out.println(Thread.currentThread().getName());
                JsonParser jsonParser = new JsonParser();
                JsonObject jsonObject = (JsonObject) jsonParser.parse(message.toString());
                DataPoint dp = new DataPoint();
                dp.setVoc(jsonObject.get("VOC").getAsInt());
                dp.setCarbonMonoxide(jsonObject.get("Carbon_Monoxide").getAsInt());
                dp.setTemperature(jsonObject.get("Temperature").getAsInt());
                dp.setHumidity(jsonObject.get("Humidity").getAsInt());
                dp.setCo2(jsonObject.get("CO2").getAsInt());
                dp.setPm2(jsonObject.get("PM2").getAsInt());
                dp.setId(jsonObject.get("id").getAsString());
                SharedValues.sensorData.put(jsonObject.get("id").getAsString(), dp);
//                System.out.println(SharedValues.sensorData);
            }
        }

        @Override
        public void deliveryComplete(IMqttDeliveryToken token)
        {

        }
    }

    public static void start()
    {
        try
        {
            System.out.println("Connecting to broker: " + broker);
            client = new MqttClient(broker, clientId);
            options = new MqttConnectOptions();
            options.setCleanSession(true);
            options.setUserName(username);
            options.setPassword(password.toCharArray());
            // 设置超时时间
            options.setConnectionTimeout(10);
            // 设置会话心跳时间
            options.setKeepAliveInterval(20);
            client.setCallback(new PushCallback());
//            MqttTopic mqttTopic = client.getTopic(topic);
//            options.setWill(false);
            client.connect(options);
//            client.connect(connOpts);
            System.out.println("Connected. Client id is " + clientId);
//            client.subscribe(topic, new MqttReceiver());

//            MqttMessage message = new MqttMessage(content.getBytes());
//            client.publish(topic, message);
//            System.out.println("Published message: " + content);
            topic1 = new String[]{topic};
            qos = new int[]{1};
            client.subscribe(topic1, qos);
            System.out.println("Subscribed to topic: " + topic);
//            Thread.sleep(Long.MAX_VALUE);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

    }

    public static boolean sendMessage(String msg)
    {
        MqttMessage message = new MqttMessage(msg.getBytes());
        try
        {
            client.publish(serverTopic, message);
            System.out.println("Published message: " + msg);
            return true;
        }
        catch (MqttException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args)
    {
        MQTTListener.start();
    }
}