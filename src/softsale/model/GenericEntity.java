package softsale.model;


public abstract class GenericEntity {
    
    public Long getId() {
		return null;
	}

    @Override
    public boolean equals(Object object) {
		GenericEntity entity = (GenericEntity) object;
        return (entity.getId() != null) && (entity.getId().equals(this.getId()));
    }
}
