package range;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.runner.RunWith;


@Suite
@SelectClasses({
	CombineTest.class,
	ConstrainsTest.class,
	ConstructorTest.class,
	ContainsTest.class,
	EqualsTest.class,
	ExpandTest.class,
	ExpandToIncludeTest.class,
	GetBoundsTest.class,
	GetCentralValueTest.class,
	GetLengthTest.class,
	IntersectsTest.class,
	ShiftTest.class,
	ToStringTest.class
})
public class ThoroughSuite {

}
