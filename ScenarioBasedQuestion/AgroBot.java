abstract class IrrigationUnit {
    protected double calibrationFactor;

  
    protected IrrigationUnit(double calibrationFactor) {
        this.calibrationFactor = calibrationFactor;
    }


    public void startWatering() {
        System.out.println("Starting watering with a calibration factor of: " + calibrationFactor);
      
    }

  
    abstract public void stopWatering();

   
    public double getCalibrationFactor() {
        return calibrationFactor;
    }

    protected void setCalibrationFactor(double calibrationFactor) {
        this.calibrationFactor = calibrationFactor;
    }
}

class Sprinkler extends IrrigationUnit {
    private double sprayRadius;

    
    public Sprinkler(double calibrationFactor, double sprayRadius) {
        super(calibrationFactor);
        this.sprayRadius = sprayRadius;
    }

    @Override
    public void startWatering() {
        super.startWatering();
        System.out.println("Sprinkler is watering with a spray radius of: " + sprayRadius);
      
    }

    @Override
    public void stopWatering() {
        System.out.println("Sprinkler has stopped watering.");
        
    }
}

class DripSystem extends IrrigationUnit {
    private double dripRate;

 
    public DripSystem(double calibrationFactor, double dripRate) {
        super(calibrationFactor);
        this.dripRate = dripRate;
    }

    @Override
    public void startWatering() {
        super.startWatering();
        System.out.println("Drip system is watering with a drip rate of: " + dripRate);
       
    }

    @Override
    public void stopWatering() {
        System.out.println("Drip system has stopped watering.");
       
    }
}
interface SensorReadable {
    void integrateSensorData(double sensorData);
}


class SmartSprinkler extends Sprinkler implements SensorReadable {
    private double sensorData;

    public SmartSprinkler(double calibrationFactor, double sprayRadius, double sensorData) {
        super(calibrationFactor, sprayRadius);
        this.sensorData = sensorData;
    }

    @Override
    public void integrateSensorData(double sensorData) {
        this.sensorData = sensorData;
       
        System.out.println("Integrated sensor data: " + sensorData);
    }

    @Override
    public void startWatering() {
        super.startWatering();
       
        System.out.println("Smart sprinkler is watering with integrated sensor data: " + sensorData);
    }
}


class SmartDripSystem extends DripSystem implements SensorReadable {
    private double sensorData;

   
    public SmartDripSystem(double calibrationFactor, double dripRate, double sensorData) {
        super(calibrationFactor, dripRate);
        this.sensorData = sensorData;
    }

   
    @Override
    public void integrateSensorData(double sensorData) {
        this.sensorData = sensorData;
        
        System.out.println("Integrated sensor data: " + sensorData);
    }

    @Override
    public void startWatering() {
        super.startWatering(); 
       
        System.out.println("Smart drip system is watering with integrated sensor data: " + sensorData);
    }
}


public class AgroBot {
    public static void main(String[] args) {
        
        SmartSprinkler sssd = new SmartSprinkler(0.95, 10.0, 20.5);
        SmartDripSystem sd = new SmartDripSystem(0.90, 2.0, 15.3);

        sssd.startWatering();
        sssd.stopWatering();
        sd.startWatering();
        sd.stopWatering();

        sssd.integrateSensorData(30.2);
        sd.integrateSensorData(18.4);
    }
}
