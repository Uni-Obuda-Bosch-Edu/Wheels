package Test.UnitTest;

import static org.junit.Assert.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.junit.runners.model.TestTimedOutException;

import Common.I2DPoint;
import Implementation.VectorDefinition;

public class VectorDefinitionTest {
	private static final double NoDifferenceAllowed = 0.0;
	private static final double TestInitX1 = 0.0;
	private static final double TestInitY1 = 0.0;
	private static final double TestInitX2 = 1.0;
	private static final double TestInitY2 = 1.0;
	private static final double TestInitLength = Math.sqrt(2.0);
	private static final double TestNewLength = 2.0 * TestInitLength;
	private static final double TestScale = 2.0;
	private static final double TestShiftedX2 = -1.0;
	private static final double TestShiftedY2 = -1.0;
	private static final double TestShiftValue = 7.8;
	private static final double TestRotation = Math.toRadians(45.0);
	private static final double TestRotatedX = 0.0;
	private static final double TestRotatedY = Math.sqrt(2.0);
	private static final double TestRotationAllowedDifference = Math.pow(10, -10);
	private static final double TestNewX1 = 3.0;
	private static final double TestNewY1 = 4.0;
	private static final double TestNewX2 = 5.0;
	private static final double TestNewY2 = 6.0;
	private VectorDefinition vectorDefinition;
	
	@Before
	public void setUp() // do not catch these, successful reflection must be successful to be able to test
			throws NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Constructor<VectorDefinition> constructor =
				VectorDefinition.class.getDeclaredConstructor(double.class, double.class, double.class, double.class);
		constructor.setAccessible(true);
		vectorDefinition = (VectorDefinition)constructor.newInstance(TestInitX1, TestInitY1, TestInitX2, TestInitY2);
	}

	@Test
	public final void testGetLength() {
		assertEquals(TestInitLength, vectorDefinition.getLength(), NoDifferenceAllowed);
	}

	@Test
	public final void testAppendLength() {
		vectorDefinition.AppendLength(TestInitLength);
		assertEquals(TestNewLength, vectorDefinition.getLength(), NoDifferenceAllowed);
	}

	@Test
	public final void testScale() {
		vectorDefinition.Scale(TestScale);
		assertEquals(TestInitX2 * TestScale, vectorDefinition.getX2(), NoDifferenceAllowed);
		assertEquals(TestInitY2 * TestScale, vectorDefinition.getY2(), NoDifferenceAllowed);
	}

	@Test
	public final void testSetLength() {
		vectorDefinition.setLength(TestNewLength);
		assertEquals(TestNewLength, vectorDefinition.getLength(), NoDifferenceAllowed);
	}

	@Test
	public final void testShiftOrigin() {
		vectorDefinition.shiftOrigin();
		assertEquals(TestShiftedX2, vectorDefinition.getX2(), NoDifferenceAllowed);
		assertEquals(TestShiftedY2, vectorDefinition.getY2(), NoDifferenceAllowed);
	}

	@Test
	public final void testShiftOnArrow() {
		
		vectorDefinition.shiftOnArrow(TestShiftValue);
		assertEquals(TestInitX2 - TestInitX1, vectorDefinition.getX2() - vectorDefinition.getX1(), NoDifferenceAllowed);
		assertEquals(TestInitY2 - TestInitY1, vectorDefinition.getY2() - vectorDefinition.getY1(), NoDifferenceAllowed);
	}

	@Test
	public final void testRotate() {
		vectorDefinition.Rotate(TestRotation);
		assertEquals(TestRotatedX, vectorDefinition.getX2(), TestRotationAllowedDifference);
		assertEquals(TestRotatedY, vectorDefinition.getY2(), TestRotationAllowedDifference);
	}

	@Test
	public final void testGetX1() {
		assertEquals(TestInitX1, vectorDefinition.getX1(), NoDifferenceAllowed);
	}

	@Test
	public final void testSetX1() {
		vectorDefinition.setX1(TestNewX1);
		assertEquals(TestNewX1, vectorDefinition.getX1(), NoDifferenceAllowed);
	}

	@Test
	public final void testGetY1() {
		assertEquals(TestInitY1, vectorDefinition.getY1(), NoDifferenceAllowed);
	}

	@Test
	public final void testSetY1() {
		vectorDefinition.setY1(TestNewY1);
		assertEquals(TestNewY1, vectorDefinition.getY1(), NoDifferenceAllowed);
	}

	@Test
	public final void testGetX2() {
		assertEquals(TestInitX2, vectorDefinition.getX2(), NoDifferenceAllowed);
	}

	@Test
	public final void testSetX2() {
		vectorDefinition.setX2(TestNewX2);
		assertEquals(TestNewX2, vectorDefinition.getX2(), NoDifferenceAllowed);
	}

	@Test
	public final void testGetY2() {
		assertEquals(TestInitY2, vectorDefinition.getY2(), NoDifferenceAllowed);
	}

	@Test
	public final void testSetY2() {
		vectorDefinition.setY2(TestNewY2);
		assertEquals(TestNewY2, vectorDefinition.getY2(), NoDifferenceAllowed);
	}

	@Test
	public final void testGetPointStart() {
		I2DPoint resultPoint = vectorDefinition.getPointStart();
		assertEquals(TestInitX1, resultPoint.getX(), NoDifferenceAllowed);
		assertEquals(TestInitY1, resultPoint.getY(), NoDifferenceAllowed);
	}

	@Test
	public final void testGetPointEnd() {
		I2DPoint resultPoint = vectorDefinition.getPointEnd();
		assertEquals(TestInitX2, resultPoint.getX(), NoDifferenceAllowed);
		assertEquals(TestInitY2, resultPoint.getY(), NoDifferenceAllowed);
	}
}
