import java.io.*;

public class RainfallProgram {
	public static void main(String[] args) throws IOException {
		BufferedReader keyboard = new BufferedReader(
			new InputStreamReader(System.in)
		);
		
		RainfallStats stats = new RainfallStats();
		System.out.println("Enter rainfall measurements (in mm), or \"end\" to stop.");
		
		while(true) {
			System.out.print("> ");
			String line = keyboard.readLine();
			if("end".equals(line)) {
				System.out.println(stats.getCount() + " measurements entered.");
				break;
			}
			// TODO: parse the measurement and add it to stats
			try {
				double measurement = Double.parseDouble(line);
				stats.addMeasurement(measurement);
			} catch (InvalidRainfallException e){
				System.out.println("Measurement must not be negative.");
			} catch(NumberFormatException e){
				System.out.println("Invalid number (enter \"end\" to stop).");
			}

			
			// TODO: print a message if the measurement is negative
			
			// TODO: print a message if the measurement cannot be parsed
		}
		
		System.out.println(stats.getCount() + " measurement(s) entered.");
		
		// TODO: prevent the exception when no measurements have been entered.
		if (stats.getCount() == 0){
			try {
				stats.addMeasurement(0);
			} catch (InvalidRainfallException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Mean rainfall: " + stats.getMean() + " mm");
		System.out.println("Maximum rainfall: " + stats.getMax() + " mm");
	}
}
