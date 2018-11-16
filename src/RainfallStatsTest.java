import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

public class RainfallStatsTest {
	private final RainfallStats stats = new RainfallStats();
	
	/*
	 * The count should initially be 0.
	 */
	@Test
	public void testInitialState() {
		assertEquals(0, stats.getCount());
	}
	
	/*
	 * If no measurements have been added, the getMean method
	 * should throw an IllegalStateException.
	 */
	@Test
	public void testMeanOfNoMeasurements() throws InvalidRainfallException {
		stats.addMeasurement(10);
		stats.addMeasurement(20);
		stats.addMeasurement(30);
		assertEquals(20, stats.getMean(), 0);
	}
	
	/*
	 * If no measurements have been added, the getMax method
	 * should throw an IllegalStateException.
	 */
	@Test
	public void testMaxOfNoMeasurements() throws InvalidRainfallException {
		stats.addMeasurement(1);
		stats.addMeasurement(10);
		stats.addMeasurement(5);
		stats.addMeasurement(20);
		assertEquals(20, stats.getMax(), 0);
	}
	
	/*
	 * If one measurement is added, the count should be one,
	 * and the mean and max should equal that measurement.
	 */
	@Test
	public void testAddMeasurement() throws InvalidRainfallException {
		stats.addMeasurement(4.0);
		assertEquals(1, stats.getCount());
		assertEquals(4.0, stats.getMean(), 0);
		assertEquals(4.0, stats.getMax(), 0);
	}
	
	/*
	 * The addMeasurement method should throw an InvalidRainfallException
	 * if the measurement is negative.
	 */

	@Test(expected = InvalidRainfallException.class)
	public void testAddInvalidMeasurement() throws InvalidRainfallException{
		// TODO: write unit test
		stats.addMeasurement(-1);
	}
	
	/*
	 * After three measurements are added, the count should be 3.
	 */
	@Test
	public void testCount() throws InvalidRainfallException {
		stats.addMeasurement(3.0);
		stats.addMeasurement(5.0);
		stats.addMeasurement(4.0);
		assertEquals(3, stats.getCount());
	}
	
	/*
	 * Test the mean of three measurements.
	 */
	@Test
	public void testMean() throws InvalidRainfallException {
		stats.addMeasurement(3.0);
		stats.addMeasurement(5.0);
		stats.addMeasurement(4.0);
		assertEquals(4.0, stats.getMean(), 0);
	}
	
	/*
	 * Test the max of three measurements.
	 */
	@Test
	public void testMax() throws InvalidRainfallException {
		stats.addMeasurement(3.0);
		stats.addMeasurement(5.0);
		stats.addMeasurement(4.0);
		assertEquals(5.0, stats.getMax(), 0);
	}
}
