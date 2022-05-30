import java.lang.reflect.InvocationTargetException;

public class FabriqueConnectable implements IFabriqueConnectable {
	public IConnectable creer(String nomConnectable) {
		IConnectable connectable = null;
		try {
			Class<?> classeConnectable = Class.forName(nomConnectable);
			connectable = (IConnectable) classeConnectable.getDeclaredConstructor().newInstance();
		} catch (ClassNotFoundException | NoClassDefFoundError  e) {
			System.out.println("Cette classe n'existe pas");
		} catch (ClassCastException  e) {
			System.out.println("Cette classe n'est pas connectable");
		} catch (InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
			e.printStackTrace();
		}
		return connectable;
	}
}

