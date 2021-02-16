interface dogInterface {

    boolean ladrar(boolean debeLadrar);
    int volumenLadrido(String tipoPerro);
}

class ChowChowDog implements dogInterface{

    @Override
    public boolean ladrar(boolean debeLadrar) {
        return false;
    }

    @Override
    public int volumenLadrido(String tipoPerro) {
        return 0;
    }

    public List<Object> getListOfEmployees(int id) {
        return null;
    }
    public List<Object> getListOfEmployees(int id, int age) {
        return null;
    }

}


public class Main {
}
