package SharedMemory;
import java.util.*;

public interface ICamera {
	
	IVectorDefinition getMovementVector();
	IVectorDefinition getPositionUnitVector();	
	List<IObject> getVisibleObject();
	
}
