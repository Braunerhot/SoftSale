package softsale.model;


public abstract class GenericEntity {
    
    public abstract Long getId();
    public abstract void setId(Long id);

    @Override
    public boolean equals(Object object) {
		GenericEntity entity = (GenericEntity) object;
        return (entity.getId() != null) && (entity.getId().equals(this.getId()));
    }
}
