package kanode.steven.repositories.interfaces;
import java.util.List;

public interface ModelRepoInt {
	
		public <T> T getModel(int id);
		public <T> boolean addModel(T t);
		public <T> List<T> getAllModel();
		public <T> boolean updateModel(T change);
		public <T> boolean deleteModel(int id);
		
}
