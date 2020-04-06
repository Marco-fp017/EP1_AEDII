package entities;

import services.PilhaDinamica;

public class Localidades extends PilhaDinamica{
    private int coordenada_x;
    private int coordenada_y;
    PilhaDinamica pilha = new PilhaDinamica();
    
    public Localidades(int coordenada_x, int coordenada_y) {
        this.coordenada_x = coordenada_x;
        this.coordenada_y = coordenada_y;
    }

    public int getCoordenada_x() {
        return coordenada_x;
    }

    public int getCoordenada_y() {
        return coordenada_y;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.coordenada_x;
        hash = 71 * hash + this.coordenada_y;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Localidades other = (Localidades) obj;
        if (this.coordenada_x != other.coordenada_x) {
            return false;
        }
        if (this.coordenada_y != other.coordenada_y) {
            return false;
        }
        return true;
    }
}
