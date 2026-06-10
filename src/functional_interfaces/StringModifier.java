package functional_interfaces;

//Le functional interfaces possono avere un singolo metodo per essere tali
@FunctionalInterface
public interface StringModifier {
    String modify(String str);
}
