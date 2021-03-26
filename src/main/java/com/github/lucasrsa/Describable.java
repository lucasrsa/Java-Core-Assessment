package com.github.lucasrsa;

public abstract class Describable {
    protected final String name;
    protected String description = "";

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        String objName;
        if (this.getClass() == o.getClass()){
            objName = ((Product) o).getName();
        }else if (o instanceof String){
            objName = (String) o;
        }else {
            return false;
        }
        return this.name.equalsIgnoreCase(objName);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    public Describable(String name){
        this.name = name;
    }
}
