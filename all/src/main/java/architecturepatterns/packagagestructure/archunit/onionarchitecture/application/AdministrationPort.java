package architecturepatterns.packagagestructure.archunit.onionarchitecture.application;

public interface AdministrationPort {
    <T> T getInstanceOf(Class<T> type);
}
