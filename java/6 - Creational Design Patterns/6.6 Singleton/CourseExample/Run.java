
public class Run {

	public static void main(String[] args) {
		// Eager
		EagerRegistry eager1 = EagerRegistry.getInstance();
		EagerRegistry eager2 = EagerRegistry.getInstance();
		System.out.println(eager1 == eager2);

		// Lazy DCL
		LazyRegistryWithDCL dcl1 = LazyRegistryWithDCL.getInstance();
		LazyRegistryWithDCL dcl2 = LazyRegistryWithDCL.getInstance();
		System.out.println(dcl1 == dcl2);

		// Lazy IODH
		LazyRegistryIODH iodh1;
		System.out.println("class ctor not called");
		iodh1 = LazyRegistryIODH.getInstance();
		LazyRegistryIODH iodh2 = LazyRegistryIODH.getInstance();
		System.out.println(iodh1 == iodh2);

		// Enum
		RegistryEnum.INSTANCE.someMethod();
	}

}
